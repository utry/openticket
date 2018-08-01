package com.utry.openticket.model;

/**
 * @author : LVDING
 * @version : 1.0
 * @Description : 自定义值表
 * @date : 2018-07-31
 */
public class TicketValueDO {

    private Integer id;
    private Integer fieldId;
    private Integer ticketId;
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

    public Integer getTicketId() {
        return ticketId;
    }

    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "TicketValueDO{" +
                "id=" + id +
                ", fieldId=" + fieldId +
                ", ticketId=" + ticketId +
                ", value='" + value + '\'' +
                '}';
    }
}
