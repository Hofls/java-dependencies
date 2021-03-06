package hofls.com.github;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Profile("!dev-profile")
public class NonDevBean {

    // ":" means its optional
    @Value("${spring.profiles.active:}")
    private String activeProfile;

    @Value("${redefined-property}")
    private String redefinedProperty;

    @Value("${common-property}")
    private String commonProperty;

    @PostConstruct
    public void init() {
        System.out.println("NonDevBean init");
        System.out.println("NonDevBean.activeProfile = " + activeProfile);
        System.out.println("NonDevBean.redefinedProperty = " + redefinedProperty);
        System.out.println("NonDevBean.commonProperty = " + commonProperty);
    }

}
