package com.utry.openticket.model;

/**
 * @Description : 工单类型表
 * @author : LVDING
 * @version : 1.0
 * @date : 2018/07/26
 */

import java.io.Serializable;

public class TicketTypeDO implements Serializable {
    private Integer id;
    private String name;

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
}
