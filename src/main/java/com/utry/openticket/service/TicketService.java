package com.utry.openticket.service;

import com.utry.openticket.dao.ITicketDAO;
import com.utry.openticket.dto.TicketDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description : 工单service
 * @author : LVDING
 * @version : 1.0
 * @date : 2018/07/26
 */

@Service
public class TicketService {

    @Autowired
    private ITicketDAO ticketDao;

    /**
     *
     * 功能描述 : 根据工单类型获得工单基础信息
     *
     * @param : String ticketType 工单类型
     * @return : List<TicketDTO> 工单基础信息
     * @auther : LVDING
     * @date : 2018-07-26
     */
    public List<TicketDTO> getTicketList(String ticketType){

        List<TicketDTO> ticketList = ticketDao.getTicketList(ticketType);
        return ticketList;

    };

}