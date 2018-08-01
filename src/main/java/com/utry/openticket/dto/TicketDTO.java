package com.utry.openticket.dto;

/**
 * @Description : 工单DTO
 * @author : LVDING
 * @version : 1.0
 * @date : 2018/07/26
 */

import com.fasterxml.jackson.annotation.JsonFormat;
import com.utry.openticket.model.TicketValueDO;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class TicketDTO implements Serializable {
    private Integer id;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createTime;
    private String createUser;
    private String  ticketType;
    private List<TicketValueDO> ticketValueList;

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

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public List<TicketValueDO> getTicketValueList() {
        return ticketValueList;
    }

    public void setTicketValueList(List<TicketValueDO> ticketValueList) {
        this.ticketValueList = ticketValueList;
    }
}
