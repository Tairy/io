package com.sqkb.aop.config;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

/**
 * package: com.sqkb.aop.config
 *
 * @author <tairy> gengrui@qury.org
 * @date 2020/12/11 下午1:50
 */
@Configuration
//@SpringBootConfiguration
@EnableAutoConfiguration
public class WebConfiguration {

    @EventListener(WebServerInitializedEvent.class)
    public void onWebServerReady(WebServerInitializedEvent event) {
        System.out.println("当前 WebServer 实现为:" + event.getWebServer().getClass().getName());
    }

    @Bean
    public ApplicationRunner runner(BeanFactory beanFactory) {
        return args -> {
            System.out.println("当前 WebConfiguration Bean 的实现类为:" + beanFactory.getBean(WebConfiguration.class).getClass().getName());
        };
    }
}