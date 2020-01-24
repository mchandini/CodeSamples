package com.example.demo;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

//@EnableWs enables SOAP Web Service features in this Spring Boot application
//WsConfigurerAdapter base class configures the annotation-driven Spring-WS programming model.

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter{
	
	@Bean
	public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
		MessageDispatcherServlet servlet = new MessageDispatcherServlet();
		servlet.setApplicationContext(applicationContext);
		servlet.setTransformWsdlLocations(true);
		return new ServletRegistrationBean(servlet, "/ws/*");
	}
	
	// wsdl service takes the bean name
	//returns standardized wsdl
	@Bean(name = "countries")
	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema serviceSchema) {	
	    DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
	    //porttype will bind all the operations of the service
	    //can provide any name
	    wsdl11Definition.setPortTypeName("Port");
	    wsdl11Definition.setLocationUri("/ws");
	    //default targetNamespace will be the tns defined in xsd
	    //wsdl11Definition.setTargetNamespace("http://www.webservice.com/mine");
	    wsdl11Definition.setSchema(serviceSchema);
	    return wsdl11Definition;
	}
	
	
	@Bean
	public XsdSchema serviceSchema() {
	    return new SimpleXsdSchema(new ClassPathResource("webService.xsd"));
	}

}
