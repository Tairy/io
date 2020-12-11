package com.sqkb.ioc.factory;

import java.util.HashMap;

/**
 * package: com.sqkb.ioc.factory
 *
 * @author <tairy> gengrui@qury.org
 * @date 2020/12/11 下午8:47
 * <p>
 * 真正的 bean 容器
 */
public abstract class AbstractBeanFactory implements BeanFactory {
    /**
     * 容器
     */
    private HashMap<String, BeanDefinition> map = new HashMap<>();

    @Override
    public Object getBean(String name) throws Exception {
        BeanDefinition beanDefinition = map.get(name);
        if (null == beanDefinition) {
            throw new IllegalArgumentException("No bean found:" + name);
        }

        Object bean = beanDefinition.getBean();

        if (null == bean) {
            bean = doCreate(beanDefinition);
        }

        return bean;
    }

    @Override
    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) throws Exception {
        Object bean = doCreate(beanDefinition);
        beanDefinition.setBean(bean);
        map.put(name, beanDefinition);
    }

    /**
     * 创建一个 bean
     *
     * @param beanDefinition
     * @return
     * @throws Exception
     */
    abstract Object doCreate(BeanDefinition beanDefinition) throws Exception;
}