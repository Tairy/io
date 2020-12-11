package com.sqkb.aop.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * package: com.sqkb.aop.config
 *
 * @author <tairy> gengrui@qury.org
 * @date 2020/12/11 下午2:08
 */
@Configuration
@Import(WebConfiguration.class)
public class WebAutoConfiguration {
}