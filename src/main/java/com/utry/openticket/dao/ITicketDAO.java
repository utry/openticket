package com.utry.openticket.dao;

/**
 * @Description : 工单表DAO
 * @author : LVDING
 * @version : 1.0
 * @date : 2018/07/26
 */

import com.utry.openticket.dto.TicketDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface ITicketDAO {

    /**
     *
     * 功能描述 : 根据工单类型获得工单基础信息
     *
     * @param : String ticketType 工单类型
     * @return : List<TicketDTO> 工单基础信息
     * @auther : LVDING
     * @date : 2018-07-26
     */
    List<TicketDTO> getTicketList(String ticketType);

}
