package daggerok.config;

import daggerok.WsApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
@ComponentScan(basePackageClasses = WsApplication.class)
public class WsConfig extends WsConfigurerAdapter {

    @Bean
    public ServletRegistrationBean dispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(servlet, "/v1/*");
    }

    @Bean(name = "daggerok")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema eightballSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("daggerokPort");
        wsdl11Definition.setLocationUri("http://github.com/daggerok/ws");
        wsdl11Definition.setTargetNamespace("http://github.com/daggerok/ws/v1");
        wsdl11Definition.setSchema(eightballSchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema daggerokSchema() {
        return new SimpleXsdSchema(new ClassPathResource("schema/daggerok.xsd"));
    }
}
