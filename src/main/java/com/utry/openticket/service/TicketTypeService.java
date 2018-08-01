package com.utry.openticket.service;

/**
 * @Description : 工单类型service
 * @author : LVDING
 * @version : 1.0
 * @date : 2018/07/26
 */

import com.utry.openticket.dao.ITicketTypeDAO;
import com.utry.openticket.model.TicketTypeDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketTypeService {
    @Autowired
    private ITicketTypeDAO ticketTypeDAO;

    /**
     *
     * 功能描述 : 获得工单类型
     *
     * @param :
     * @return : List<TicketTypeDO> 工单类型
     * @auther : LVDING
     * @date : 2018-07-26
     */
    public List<TicketTypeDO> getTicketTypeList(){
        List<TicketTypeDO> list = ticketTypeDAO.getTicketTypeList();

        return list;
    }

}
