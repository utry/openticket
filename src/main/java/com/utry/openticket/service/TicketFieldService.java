package com.utry.openticket.service;

/**
 * @Description : 自定义列的信息service
 * @author : LVDING
 * @version : 1.0
 * @date : 2018/07/26
 */


import com.utry.openticket.dao.IFieldTypeValueDAO;
import com.utry.openticket.dao.ITicketFieldDAO;
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
    private ITicketFieldDAO ticketFieldDao;
    @Autowired
    private IFieldTypeValueDAO fieldTypeValueDao;

    /**
     *
     * 功能描述 : 保存自选框类新自定义列
     *
     * @param : TicketFieldDTO 自定义列
     * @return :
     * @auther : LVDING
     * @date : 2018-07-26
     */
    public void saveTicketField(TicketFieldDTO ticketFieldDTO){

        ticketFieldDao.saveTicketField(ticketFieldDTO);
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
        ticketFieldDao.saveTicketField(ticketFieldDTO);
        int id  = ticketFieldDTO.getId();
        for(FieldTypeValueDO fieldTypeValueDO:fieldTypeValuelist){
            fieldTypeValueDO.setFieldId(id);
        }
        fieldTypeValueDao.saveFieldTypeValue(fieldTypeValuelist);
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
    public List<TicketFieldDO> getColumn(String ticketType){
        List<TicketFieldDO> ticketFieldList = ticketFieldDao.getColumn(ticketType);
        return ticketFieldList;
    }

}
