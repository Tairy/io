package com.sqkb.ioc.factory;

import com.sqkb.ioc.PropertyValues;

/**
 * package: com.sqkb.ioc.factory
 *
 * @author <tairy> gengrui@qury.org
 * @date 2020/12/11 下午8:34
 * <p>
 * 对 bean 的一个封装
 */
public class BeanDefinition {

    private Object bean;

    private Class beanClass;

    private String className;

    private PropertyValues propertyValues = new PropertyValues();

    public Object getBean() {
        return this.bean;
    }

    public void setBean(Object bean) {
        this.bean = bean;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setClassName(String className) {
        this.className = className;

        try {
            this.beanClass = Class.forName(className);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }
}