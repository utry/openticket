package com.utry.openticket.model;

/**
 * @Description : 非文本框自定义列的选择值表
 * @author : LVDING
 * @version : 1.0
 * @date : 2018/07/26
 */

import java.io.Serializable;

public class FieldTypeValueDO implements Serializable {

    private Integer id;
    private Integer fieldId;
    private String value;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFieldId() {
        return fieldId;
    }

    public void setFieldId(Integer fieldId) {
        this.fieldId = fieldId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
