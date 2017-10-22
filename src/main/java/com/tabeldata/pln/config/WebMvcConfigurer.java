package com.tabeldata.pln.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.jasperreports.JasperReportsMultiFormatView;
import org.springframework.web.servlet.view.jasperreports.JasperReportsViewResolver;

@Configuration
public class WebMvcConfigurer extends WebMvcConfigurerAdapter {

    @Bean
    public JasperReportsViewResolver getJasperReportsViewResolver() {
        JasperReportsViewResolver resolver = new JasperReportsViewResolver();
        resolver.setPrefix("classpath:/jasper/");
        resolver.setSuffix(".jasper");
        resolver.setReportDataKey("datasource");
        resolver.setViewNames("Report_*");
        resolver.setViewClass(JasperReportsMultiFormatView.class);
        resolver.setOrder(1);
        return resolver;
    }

}
