package com.utry.openticket.controller;

import com.utry.openticket.dao.ITicketDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TicketController {

    @Autowired
    private ITicketDao ticketDao;

    @RequestMapping("test")
    @ResponseBody
    public String test(){
        ticketDao.insertTest();
        return "测试成功";
    }
}
