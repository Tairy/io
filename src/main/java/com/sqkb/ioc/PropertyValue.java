package com.sqkb.ioc;

/**
 * package: com.sqkb.ioc
 *
 * @author <tairy> gengrui@qury.org
 * @date 2020/12/11 下午8:38
 */
public class PropertyValue {

    private final String name;

    private final Object value;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }
}