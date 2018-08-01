package com.utry.openticket.dao;

import com.utry.openticket.dto.TicketValueDTO;
import com.utry.openticket.model.TicketValueDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author : LVDING
 * @version : 1.0
 * @Description : 自定义值dao
 * @date : 2018-07-31
 */
@Mapper
public interface ITicketValueDAO {

    /**
     *
     * 功能描述 : 添加自定义列value
     *
     * @param : List<FieldTypeValueDO> 自定义属性值list
     * @return :
     * @auther : LVDING
     * @date : 2018-07-31
     */
    int saveTicketValue(List<TicketValueDO> ticketValueList);

    /**
     *
     * 功能描述 : 获得自定义属性值
     *
     * @param : int ticketId工单编号
     * @return : List<TicketValueDTO> 自定义属性list
     * @auther : LVDING
     * @date : 2018-07-26
     */
    List<TicketValueDTO> getTicketValue(int ticketId);

    /**
     *
     * 功能描述 : 删除得自定义属性值
     *
     * @param : int ticketId工单编号
     * @return :
     * @auther : LVDING
     * @date : 2018-08-01
     */
    int deleteTicketValue(int ticketId);

    /**
     *
     * 功能描述 : 修改自定义属性值
     *
     * @param : List<TicketValueDO> ticketValueList
     * @return :
     * @auther : LVDING
     * @date : 2018-08-01
     */
    int updateTicketValue(List<TicketValueDO> ticketValueList);

    /**
     *
     * 功能描述 : 保存空值到先有工单的自定义值表中
     *
     * @param : TicketFieldDTO 自定义列
     * @return :
     * @auther : LVDING
     * @date : 2018-08-01
     */
    int saveNullTicketValue(@Param("fieldId") int fieldId,@Param("ticketId") int ticketId);
}
