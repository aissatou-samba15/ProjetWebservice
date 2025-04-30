package web.unchk.gl.web.api.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class SoapWebServiceConfig {

    // ✅ Ce constructeur affiche un message au démarrage
    public SoapWebServiceConfig() {
        System.out.println("✅ SOAP Web Service Config chargée !");
    }

    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(org.springframework.context.ApplicationContext context) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(context);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean<>(servlet, "/ws/*");
    }

    @Bean(name = "reservationService")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema reservationSchema) {
        DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
        definition.setPortTypeName("ReservationPort");
        definition.setTargetNamespace("http://web.unchk.gl/web/api/soap");
        definition.setLocationUri("/ws");
        definition.setSchema(reservationSchema);
        return definition;
    }

    @Bean
    public XsdSchema reservationSchema() {
        return new SimpleXsdSchema(new ClassPathResource("wsdl/ReservationService.xsd"));
    }
}
