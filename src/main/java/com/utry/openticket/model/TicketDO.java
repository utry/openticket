package com.utry.openticket.model;

/**
 * @Description : 工单表
 * @author : LVDING
 * @version : 1.0
 * @date : 2018/07/26
 */

import java.io.Serializable;
import java.util.Date;

public class TicketDO implements Serializable {

    private Integer id;
    private Date createTime;
    private Integer createUserId;
    private Integer ticketTypeId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    public Integer getTicketTypeId() {
        return ticketTypeId;
    }

    public void setTicketTypeId(Integer ticketTypeId) {
        this.ticketTypeId = ticketTypeId;
    }
}
