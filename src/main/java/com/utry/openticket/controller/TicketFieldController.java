package com.utry.openticket.controller;

/**
 * @Description : 自定义列controller
 * @author : LVDING
 * @version : 1.0
 * @date : 2018/07/26
 */

import com.alibaba.fastjson.JSON;
import com.utry.openticket.constant.Constant;
import com.utry.openticket.dto.TicketFieldDTO;
import com.utry.openticket.model.FieldTypeDO;
import com.utry.openticket.model.FieldTypeValueDO;
import com.utry.openticket.model.TicketTypeDO;
import com.utry.openticket.service.FieldTypeService;
import com.utry.openticket.service.TicketFieldService;
import com.utry.openticket.service.TicketTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.DataTruncation;
import java.util.ArrayList;
import java.util.List;

@Controller
public class TicketFieldController {

    @Autowired
    private FieldTypeService fieldTypeService;
    @Autowired
    private TicketTypeService ticketTypeService;
    @Autowired
    private TicketFieldService ticketFieldService;

    /**
     *
     * 功能描述 : 跳转到添加自定义列页面
     *
     * @param : Model
     * @return :
     * @auther : LVDING
     * @date : 2018-07-26
     */
    @RequestMapping("addField")
    public String addFieldsPage(Model map){
        List<FieldTypeDO> fieldTypeDOList = fieldTypeService.getFieldTypeList();
        List<TicketTypeDO> ticketTypeDOList = ticketTypeService.getTicketTypeList();
        map.addAttribute("fieldTypeList", fieldTypeDOList);
        map.addAttribute("ticketTypeList", ticketTypeDOList);
        return "/add_field";
    }

    /**
     *
     * 功能描述 : 添加自定义列
     *
     * @param : jsonObj(TicketFieldDTO) 自定义列对象
     * @return : String 结果
     * @auther : LVDING
     * @date : 2018-07-26
     */
    @RequestMapping("saveField")
    @ResponseBody
    public String saveFields(@RequestBody String jsonObj){
        TicketFieldDTO ticketFieldDTO = (TicketFieldDTO)JSON.parseObject(jsonObj,TicketFieldDTO.class);

        //
        if(Constant.selectType.equals(ticketFieldDTO.getSelectType())){
            ticketFieldService.saveTicketField(ticketFieldDTO);
        }else{
            List<String> selectValuelist = ticketFieldDTO.getSelectValueList();
            List<FieldTypeValueDO> fieldTypeValueList = new ArrayList<>();
            for(String str:selectValuelist){
                FieldTypeValueDO fieldTypeValueDO = new FieldTypeValueDO();
                fieldTypeValueDO.setValue(str);
                fieldTypeValueList.add(fieldTypeValueDO);
            }
            ticketFieldService.saveTicketField(ticketFieldDTO,fieldTypeValueList);
        }

        return "success";
    }

}
