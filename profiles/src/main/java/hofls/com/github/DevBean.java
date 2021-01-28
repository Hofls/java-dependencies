package hofls.com.github;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Profile("dev-profile")
public class DevBean {

    // ":" means its optional
    @Value("${spring.profiles.active:}")
    private String activeProfile;

    @Value("${property-example}")
    private String propertyExample;

    @PostConstruct
    public void init() {
        System.out.println("DevBean init");
        System.out.println("DevBean.activeProfile = " + activeProfile);
        System.out.println("DevBean.propertyExample = " + propertyExample);
    }

}
