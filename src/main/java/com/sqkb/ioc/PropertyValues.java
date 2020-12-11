package com.sqkb.ioc;

import java.util.ArrayList;
import java.util.List;

/**
 * package: com.sqkb.ioc
 *
 * @author <tairy> gengrui@qury.org
 * @date 2020/12/11 下午8:38
 */
public class PropertyValues {

    private final List<PropertyValue> propertyValueList = new ArrayList<>();

    public PropertyValues() {
    }

    public void addProperValue(PropertyValue propertyValue) {
        this.propertyValueList.add(propertyValue);
    }

    public List<PropertyValue> getPropertyValueList() {
        return this.propertyValueList;
    }
}