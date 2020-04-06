package hofls.com.github.config;

import com.sun.xml.ws.transport.http.servlet.SpringBinding;
import com.sun.xml.ws.transport.http.servlet.WSSpringServlet;
import hofls.com.github.service.MessageServicePortTypeImpl;
import org.jvnet.jax_ws_commons.spring.SpringService;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SoapEndpointsConfig {

    private static final String SOAP_ENDPOINTS_DIR = "/soap";

    @Bean
    public SpringBinding messageEnpoint(MessageServicePortTypeImpl service) throws Exception {
        return createEndpoint(service, "/message");
    }

    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        return new ServletRegistrationBean(new WSSpringServlet(), SOAP_ENDPOINTS_DIR + "/*");
    }

    private SpringBinding createEndpoint(Object bean, String url) throws Exception {
        SpringService springService = new SpringService();
        springService.setBean(bean);
        SpringBinding binding = new SpringBinding();
        binding.setService(springService.getObject());
        binding.setUrl(SOAP_ENDPOINTS_DIR + url);
        return binding;
    }

}
