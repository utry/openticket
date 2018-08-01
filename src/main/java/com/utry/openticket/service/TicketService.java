package com.utry.openticket.service;

import com.utry.openticket.dao.ITicketDAO;
import com.utry.openticket.dao.ITicketValueDAO;
import com.utry.openticket.dto.TicketDTO;
import com.utry.openticket.model.TicketValueDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    private ITicketDAO ticketDAO;
    @Autowired
    private ITicketValueDAO ticketValueDAO;
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

        List<TicketDTO> ticketList = ticketDAO.getTicketList(ticketType);
        return ticketList;

    };

    /**
     *
     * 功能描述 : 保存新工单
     *
     * @param : TicketDTO 工单对象,List<FieldTypeValueDO> 自定义属性值list
     * @return :
     * @auther : LVDING
     * @date : 2018-07-31
     */
    @Transactional
    public void saveTicket(TicketDTO ticketDTO, List<TicketValueDO> ticketValueList){
        ticketDAO.saveTicket(ticketDTO);
        int ticketId = ticketDTO.getId();
        for(TicketValueDO ticketValue:ticketValueList){
            ticketValue.setTicketId(ticketId);
        }
        ticketValueDAO.saveTicketValue(ticketValueList);

    }

    /**
     *
     * 功能描述 : 删除工单
     *
     * @param : int id
     * @return :
     * @auther : LVDING
     * @date : 2018-07-26
     */
    @Transactional
    public void deleteTicket(int id){
        ticketValueDAO.deleteTicketValue(id);
        ticketDAO.deleteTicket(id);
    }

}
