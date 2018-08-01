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

    /**
     *
     * 功能描述 : 保存新工单
     *
     * @param : TicketDTO 工单对象
     * @return : int 添加后自增的id
     * @auther : LVDING
     * @date : 2018-07-26
     */
    int saveTicket(TicketDTO ticketDTO);

    /**
     *
     * 功能描述 : 删除工单
     *
     * @param : int id
     * @return : int 影响行数
     * @auther : LVDING
     * @date : 2018-07-26
     */
    int deleteTicket(int id);


    /**
     *
     * 功能描述 : 通过工单类型获得工单编号
     *
     * @param : String ticketType 工单类型
     * @return : List<Integer>工单编号List
     * @auther : LVDING
     * @date : 2018-08-01
     */
    List<Integer> getTicketIdByTicketType(String ticketType);
}
