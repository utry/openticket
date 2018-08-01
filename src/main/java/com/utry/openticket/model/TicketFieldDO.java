package com.utry.openticket.model;

/**
 * @Description : 自定义列的信息表
 * @author : LVDING
 * @version : 1.0
 * @date : 2018/07/26
 */

import java.io.Serializable;

public class TicketFieldDO implements Serializable {

    private Integer id;
    private Integer ticketTypeId;
    private String fieldName;
    private String name;
    private Integer required;
    private String defaultValue;
    private Integer selectId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTicketTypeId() {
        return ticketTypeId;
    }

    public void setTicketTypeId(Integer ticketTypeId) {
        this.ticketTypeId = ticketTypeId;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Integer getSelectId() {
        return selectId;
    }

    public void setSelectId(Integer selectId) {
        this.selectId = selectId;
    }

    @Override
    public String toString() {
        return "TicketFieldDO{" +
                "id=" + id +
                ", ticketTypeId=" + ticketTypeId +
                ", fieldName='" + fieldName + '\'' +
                ", name='" + name + '\'' +
                ", required=" + required +
                ", defaultValue='" + defaultValue + '\'' +
                ", selectId=" + selectId +
                '}';
    }
}
