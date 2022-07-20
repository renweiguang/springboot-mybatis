//package com.rwg.config;
//
//
//import com.alibaba.druid.pool.DruidDataSource;
//import com.alibaba.druid.support.http.StatViewServlet;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.web.servlet.ServletRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import javax.sql.DataSource;
//import java.util.HashMap;
//
//@Configuration
//public class DruidConfig {
//
//
//    @Bean
//    @ConfigurationProperties(prefix = "spring.datasource")
//    public DataSource druidDataSource() {
//        return new DruidDataSource();
//    }
//
//    //后台监控
//    @Bean
//    public ServletRegistrationBean statViewServlet() {
//        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<>(new StatViewServlet());
//
//        HashMap<String, String> map = new HashMap<>();
//
//        map.put("loginUsername", "admin");
//        map.put("loginPassword", "123456");
//        map.put("allow","");
//
//        bean.setInitParameters(map);
//        return bean;
//    }
//
//}
