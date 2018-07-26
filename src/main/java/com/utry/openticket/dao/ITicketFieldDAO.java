package com.utry.openticket.dao;

/**
 * @Description : 自定义列的信息表DAO
 * @author : LVDING
 * @version : 1.0
 * @date : 2018/07/26
 */

import com.utry.openticket.model.TicketFieldDO;
import com.utry.openticket.dto.TicketFieldDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ITicketFieldDAO {

    /**
     *
     * 功能描述 : 根据工单类型获得自定义列
     *
     * @param : String ticketType 工单类型
     * @return : List<TicketFieldDO> 自定义列
     * @auther : LVDING
     * @date : 2018-07-26
     */
    List<TicketFieldDO> getColumn(String ticketType);

    /**
     *
     * 功能描述 : 保存新自定义列并返回自增ID
     *
     * @param : TicketFieldDTO 自定义列
     * @return : int 添加后的自增Id
     * @auther : LVDING
     * @date : 2018-07-26
     */
    int saveTicketField(TicketFieldDTO ticketFieldsDTO);

}
