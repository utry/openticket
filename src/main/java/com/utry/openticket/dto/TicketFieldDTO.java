package com.utry.openticket.dto;

/**
 * @Description : 自定义列信息DTO
 * @author : LVDING
 * @version : 1.0
 * @date : 2018/07/26
 */

import java.io.Serializable;
import java.util.List;

public class TicketFieldDTO implements Serializable {
    private Integer id;
    private String name;
    private String fieldName;
    private String ticketType;
    private Integer required;
    private String defaultValue;
    private String selectType;
    private String value;
    private List<String> selectValueList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public Integer getRequired() {
        return required;
    }

    public void setRequired(Integer required) {
        this.required = required;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public String getSelectType() {
        return selectType;
    }

    public void setSelectType(String selectType) {
        this.selectType = selectType;
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public List<String> getSelectValueList() {
        return selectValueList;
    }

    public void setSelectValueList(List<String> selectValueList) {
        this.selectValueList = selectValueList;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "TicketFieldDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", fieldName='" + fieldName + '\'' +
                ", ticketType='" + ticketType + '\'' +
                ", required=" + required +
                ", defaultValue='" + defaultValue + '\'' +
                ", selectType='" + selectType + '\'' +
                ", selectValueList=" + selectValueList +
                '}';
    }
}
