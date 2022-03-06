package hofls.com.github;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;
import lombok.var;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class Demo {

    private final static String ENDPOINT = "http://84.205.141.123:8566";
    private final static String REGION = "us-east-1";

    @EventListener(ApplicationReadyEvent.class) // or @PostConstruct
    public void doSomethingAfterStartup() {
        S3();
        SNS();
    }

    public static void S3() {
        var configuration = new AwsClientBuilder.EndpointConfiguration(ENDPOINT, REGION);
        final AmazonS3 s3 = AmazonS3ClientBuilder.standard()
                .withEndpointConfiguration(configuration)
                .build();

        s3.createBucket("bucket-from-sdk");
        for (var bucket : s3.listBuckets()) {
            System.out.println("Bucket - " + bucket.getName());
        }
        s3.putObject("bucket-from-sdk", "greeting", "hello world!");
        var object = s3.getObjectAsString("bucket-from-sdk", "greeting");
        System.out.println("Object from bucket - " + object);
        s3.deleteObject("bucket-from-sdk", "greeting");
        s3.deleteBucket("bucket-from-sdk");
    }

    public static void SNS() {
        var configuration = new AwsClientBuilder.EndpointConfiguration(ENDPOINT, REGION);
        final AmazonSNS sns = AmazonSNSClientBuilder.standard()
                .withEndpointConfiguration(configuration)
                .build();
        sns.createTopic("topic-from-sdk");
        var topic = sns.listTopics().getTopics().get(0).toString();
        System.out.println("Topic - " + topic);
    }

}
