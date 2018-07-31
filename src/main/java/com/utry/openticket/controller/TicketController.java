package com.utry.openticket.controller;

/**
 * @Description : 工单controller
 * @author : LVDING
 * @version : 1.0
 * @date : 2018/07/26
 */

import com.alibaba.fastjson.JSON;
import com.utry.openticket.dto.TicketDTO;
import com.utry.openticket.model.TicketFieldDO;
import com.utry.openticket.model.TicketTypeDO;
import com.utry.openticket.service.TicketFieldService;
import com.utry.openticket.service.TicketService;
import com.utry.openticket.service.TicketTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
public class TicketController {

    @Autowired
    private TicketFieldService ticketFieldService;
    @Autowired
    private TicketService ticketService;
    @Autowired
    private TicketTypeService ticketTypeService;

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
    public @ResponseBody List<TicketFieldDO> getTicketColumn(@RequestParam String ticketType){
        List<TicketFieldDO> ticketFieldList = ticketFieldService.getColumn(ticketType);
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
    public @ResponseBody List<TicketDTO> getTicket(@RequestParam String ticketType){
        List<TicketDTO> ticketList = ticketService.getTicketList(ticketType);
        return ticketList;
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
    public String addFieldsPage(Model map){
        List<TicketTypeDO> ticketTypeDOList = ticketTypeService.getTicketTypeList();
        map.addAttribute("ticketTypeList", ticketTypeDOList);
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
        TicketDTO ticketDTO = (TicketDTO)JSON.parseObject(jsonObj,TicketDTO.class);
        ticketDTO.setCreateUser("张三");
        ticketService.saveTicket(ticketDTO);
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
}
