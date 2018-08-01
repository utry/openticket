package com.utry.openticket.service;

/**
 * @Description : 自定义列的信息service
 * @author : LVDING
 * @version : 1.0
 * @date : 2018/07/26
 */


import com.utry.openticket.dao.IFieldTypeValueDAO;
import com.utry.openticket.dao.ITicketDAO;
import com.utry.openticket.dao.ITicketFieldDAO;
import com.utry.openticket.dao.ITicketValueDAO;
import com.utry.openticket.model.FieldTypeValueDO;
import com.utry.openticket.dto.TicketFieldDTO;
import com.utry.openticket.model.TicketFieldDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class TicketFieldService {

    @Autowired
    private ITicketFieldDAO ticketFieldDAO;
    @Autowired
    private IFieldTypeValueDAO fieldTypeValueDAO;
    @Autowired
    private ITicketValueDAO ticketValueDAO;
    @Autowired
    private ITicketDAO ticketDAO;

    /**
     *
     * 功能描述 : 保存自选框类新自定义列
     *
     * @param : TicketFieldDTO 自定义列
     * @return :
     * @auther : LVDING
     * @date : 2018-07-26
     */
    @Transactional
    public void saveTicketField(TicketFieldDTO ticketFieldDTO){

            ticketFieldDAO.saveTicketField(ticketFieldDTO);
            saveNullTicketValue(ticketFieldDTO);
    }

    /**
     *
     * 功能描述 : 保存空值到先有工单的自定义值表中
     *
     * @param : TicketFieldDTO 自定义列
     * @return :
     * @auther : LVDING
     * @date : 2018-08-01
     */
    @Transactional
    public void saveNullTicketValue(TicketFieldDTO ticketFieldDTO){
        List<Integer> ticketIdList = ticketDAO.getTicketIdByTicketType(ticketFieldDTO.getTicketType());
        for(Integer i:ticketIdList){
            ticketValueDAO.saveNullTicketValue(ticketFieldDTO.getId(),i);
        }
    }

    /**
     *
     * 功能描述 : 保存非自选框类新自定义列
     *
     * @param : TicketFieldDTO 自定义列
     * @return :
     * @auther : LVDING
     * @date : 2018-07-26
     */
    @Transactional
    public void saveTicketField(TicketFieldDTO ticketFieldDTO,List<FieldTypeValueDO> fieldTypeValuelist){
        ticketFieldDAO.saveTicketField(ticketFieldDTO);
        int id  = ticketFieldDTO.getId();
        for(FieldTypeValueDO fieldTypeValueDO:fieldTypeValuelist){
            fieldTypeValueDO.setFieldId(id);
        }
        fieldTypeValueDAO.saveFieldTypeValue(fieldTypeValuelist);
        saveNullTicketValue(ticketFieldDTO);
    }

    /**
     *
     * 功能描述 : 根据工单类型获得自定义列
     *
     * @param : String ticketType 工单类型
     * @return : List<TicketFieldDO> 自定义列
     * @auther : LVDING
     * @date : 2018-07-26
     */
    public List<TicketFieldDTO> getColumn(String ticketType){
        List<TicketFieldDTO> ticketFieldList = ticketFieldDAO.getColumn(ticketType);
        return ticketFieldList;
    }

    /**
     *
     * 功能描述 : 根据工单类型,工单编号获得自定义列及数据
     *
     * @param : String ticketType 工单类型，int ticketId 工单编号
     * @return : List<TicketFieldDO> 自定义列
     * @auther : LVDING
     * @date : 2018-07-26
     */
    public List<TicketFieldDTO> getUpdateColumn(int ticketId,String ticketType){
        List<TicketFieldDTO> ticketFieldList = ticketFieldDAO.getUpdateColumn(ticketId,ticketType);
        return ticketFieldList;
    }

}
