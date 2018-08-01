package com.utry.openticket.controller;

/**
 * @Description : 工单controller
 * @author : LVDING
 * @version : 1.0
 * @date : 2018/07/26
 */

import com.alibaba.fastjson.JSON;
import com.utry.openticket.dto.TicketValueDTO;
import com.utry.openticket.dto.TicketDTO;
import com.utry.openticket.dto.TicketFieldDTO;
import com.utry.openticket.model.FieldTypeValueDO;
import com.utry.openticket.model.TicketTypeDO;
import com.utry.openticket.model.TicketValueDO;
import com.utry.openticket.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


@Controller
public class TicketController {

    @Autowired
    private TicketFieldService ticketFieldService;
    @Autowired
    private TicketService ticketService;
    @Autowired
    private TicketTypeService ticketTypeService;
    @Autowired
    private FieldTypeValueService fieldTypeValueService;
    @Autowired
    private TicketValueService ticketValueService;

    /**
     *
     * 功能描述 : 打开table_future页面
     *
     * @param : Model
     * @return :
     * @auther : LVDING
     * @date : 2018-07-26
     */
    @RequestMapping("index")
    public String index(Model model){
        List<TicketTypeDO> ticketTypeList = ticketTypeService.getTicketTypeList();
        model.addAttribute("ticketTypeList",ticketTypeList);
        return "/table_future";
    }

    /**
     *
     * 功能描述 : 获得工单的自定义列
     *
     * @param : String ticketType 工单类型
     * @return : List<TicketFieldDO> 自定义列List
     * @auther : LVDING
     * @date : 2018-07-26
     */
    @RequestMapping("getColumn")
    public @ResponseBody List<TicketFieldDTO> getTicketColumn(@RequestParam String ticketType){
        List<TicketFieldDTO> ticketFieldList = ticketFieldService.getColumn(ticketType);
        return ticketFieldList;
    }

    /**
     *
     * 功能描述 : 获得基础工单信息
     *
     * @param : String ticketType 工单类型
     * @return : List<TicketDTO> 基础工单List
     * @auther : LVDING
     * @date : 2018-07-26
     */
    @RequestMapping("getTicket")
    public @ResponseBody List<Map<String,String>> getTicket(@RequestParam String ticketType){
        List<TicketDTO> ticketList = ticketService.getTicketList(ticketType);
        List<Map<String,String>> result = new ArrayList<>();
        for(TicketDTO ticket:ticketList){
            Map<String,String> ticketMap = new LinkedHashMap<>();
            ticketMap.put("id",ticket.getId().toString());
            ticketMap.put("createTime",ticket.getCreateTime().toString());
            ticketMap.put("createUser",ticket.getCreateUser());
            ticketMap.put("ticketType",ticket.getTicketType());
            int ticketId = ticket.getId();
            List<TicketValueDTO> ticketValueList = ticketValueService.getTicketValueList(ticketId);
            for(TicketValueDTO ticketValue:ticketValueList){
                ticketMap.put(ticketValue.getFieldName(),ticketValue.getValue());
            }
            result.add(ticketMap);
        }
        return result;
    }

    /**
     *
     * 功能描述 : 跳转到添加工单页面
     *
     * @param : Model
     * @return :
     * @auther : LVDING
     * @date : 2018-07-26
     */
    @RequestMapping("addTicket")
    public String addFieldsPage(@RequestParam String ticketType,Model model){
        List<TicketFieldDTO> ticketFieldList = ticketFieldService.getColumn(ticketType);
        for(TicketFieldDTO t:ticketFieldList){
            t.setSelectValueList(fieldTypeValueService.getFieldTypeValue(t.getId()));
            //System.out.println(t);
        }
        model.addAttribute("ticketType",ticketType);
        model.addAttribute("ticketFieldList",ticketFieldList);
        return "/form_future";
    }

    /**
     *
     * 功能描述 : 添加工单
     *自定义列
     * @param : jsonObj(TicketDTO) 工单对象
     * @return : String 结果
     * @auther : LVDING
     * @date : 2018-07-26
     */
    @RequestMapping("saveTicket")
    @ResponseBody
    public String saveTicket(@RequestBody String jsonObj){
        TicketDTO ticket = (TicketDTO)JSON.parseObject(jsonObj,TicketDTO.class);
        String ticketType = ticket.getTicketType();
        ticket.setCreateUser("张三");
        List<TicketValueDO> ticketValueList = ticket.getTicketValueList();
        ticketService.saveTicket(ticket,ticketValueList);
        return "success";
    }

    /**
     *
     * 功能描述 : 删除工单
     *自定义列
     * @param : Integer id 工单编号
     * @return : String 结果
     * @auther : LVDING
     * @date : 2018-07-26
     */
    @RequestMapping("deleteTicket")
    @ResponseBody
    public String deleteTicket(@RequestParam Integer id){
        ticketService.deleteTicket(id);
        return "success";
    }

    /**
     *
     * 功能描述 : 跳转到编辑工单页面
     *
     * @param : Model
     * @return :
     * @auther : LVDING
     * @date : 2018-08-01
     */
    @RequestMapping("updateTicketPage")
    public String updateTicket(@RequestParam int id,@RequestParam String ticketType,Model model){
        List<TicketFieldDTO> ticketFieldList = ticketFieldService.getUpdateColumn(id,ticketType);
        for(TicketFieldDTO t:ticketFieldList){
            t.setSelectValueList(fieldTypeValueService.getFieldTypeValue(t.getId()));
            //System.out.println(t);
        }
        model.addAttribute("ticketId",id);
        model.addAttribute("ticketFieldList",ticketFieldList);
        return "/table_update";
    }

    /**
     *
     * 功能描述 : 添加工单
     *自定义列
     * @param : jsonObj(TicketDTO) 工单对象
     * @return : String 结果
     * @auther : LVDING
     * @date : 2018-08-01
     */
    @RequestMapping("updateTicket")
    @ResponseBody
    public String updateTicket(@RequestBody String jsonObj){
        TicketDTO ticket = (TicketDTO)JSON.parseObject(jsonObj,TicketDTO.class);
        int id = ticket.getId();
        List<TicketValueDO> ticketValueList = ticket.getTicketValueList();
        for(TicketValueDO ticketValue:ticketValueList){
            ticketValue.setTicketId(id);
        }
        ticketValueService.updateTicketValueList(ticketValueList);
        return "success";
    }
}
