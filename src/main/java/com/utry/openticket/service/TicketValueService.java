package com.utry.openticket.service;

import com.utry.openticket.dao.ITicketValueDAO;
import com.utry.openticket.dto.TicketValueDTO;
import com.utry.openticket.model.TicketValueDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : LVDING
 * @version : 1.0
 * @Description : 自定义值service
 * @date : 2018-08-01
 */
@Service
public class TicketValueService {

    @Autowired
    private ITicketValueDAO ticketValueDAO;

    /**
     *
     * 功能描述 : 获得自定义属性值
     *
     * @param : int ticketId工单编号
     * @return : List<TicketValueDTO> 自定义属性list
     * @auther : LVDING
     * @date : 2018-07-26
     */
    public List<TicketValueDTO> getTicketValueList(int ticketId){
        return ticketValueDAO.getTicketValue(ticketId);
    }

    /**
     *
     * 功能描述 : 修改自定义属性值
     *
     * @param : List<TicketValueDO> ticketValueList
     * @return :
     * @auther : LVDING
     * @date : 2018-08-01
     */
    public void updateTicketValueList(List<TicketValueDO> ticketValueList){
        ticketValueDAO.updateTicketValue(ticketValueList);
    }
}
