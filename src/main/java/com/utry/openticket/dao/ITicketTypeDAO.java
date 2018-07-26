package com.utry.openticket.dao;

/**
 * @Description : 工单类型表DAO
 * @author : LVDING
 * @version : 1.0
 * @date : 2018/07/26
 */

import com.utry.openticket.model.TicketTypeDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ITicketTypeDAO {

    /**
     *
     * 功能描述 : 获得工单类型
     *
     * @param :
     * @return : List<TicketTypeDO> 工单类型
     * @auther : LVDING
     * @date : 2018-07-26
     */
    List<TicketTypeDO> getTicketTypeList();

}
