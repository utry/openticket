package com.utry.openticket.dto;

import com.utry.openticket.model.FieldTypeValueDO;
import com.utry.openticket.model.TicketValueDO;

import java.io.Serializable;
import java.util.List;

/**
 * @author : LVDING
 * @version : 1.0
 * @Description : 自定义值DTO
 * @date : 2018-07-31
 */
public class TicketValueDTO implements Serializable {

    private Integer id;
    private Integer ticketId;
    private String fieldName;
    private String value;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTicketId() {
        return ticketId;
    }

    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
