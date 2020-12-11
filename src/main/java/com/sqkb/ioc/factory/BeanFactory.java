package com.sqkb.ioc.factory;

/**
 * package: com.sqkb.ioc.factory
 *
 * @author <tairy> gengrui@qury.org
 * @date 2020/12/11 下午8:32
 * <p>
 * IoC 容器接口, 所有的容器都要实现这个接口
 */
public interface BeanFactory {
    /**
     * 根据 bean name 获取 bean 对象
     *
     * @param name bean 名称
     * @return bean 对象
     * @throws Exception 异常
     */
    Object getBean(String name) throws Exception;

    /**
     * 注册 bean 对象
     *
     * @param name           bean name
     * @param beanDefinition bean 对象封装
     * @throws Exception 异常
     */
    void registerBeanDefinition(String name, BeanDefinition beanDefinition) throws Exception;
}