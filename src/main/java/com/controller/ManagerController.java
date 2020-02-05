package com.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.service.ManagerService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
@RequestMapping("/admin")
public class ManagerController {
    @Autowired
    private ManagerService managerService;

    ModelAndView mav = new ModelAndView();


    @RequestMapping("/jumpToUser4Active")
    public ModelAndView changeAuthToDo(HttpSession session, HttpServletRequest request) {
        String account = (String) session.getAttribute("account");
        managerService.changeAuthToOne(account);
        return mav;
    }

    @RequestMapping("/login")
    public ModelAndView login(HttpServletRequest request, HttpSession session) {
        String manager_no = request.getParameter("admin_username");
        session.setAttribute("manager_no", manager_no);
        String manager_password = request.getParameter("admin_password");
        if (managerService.login(manager_no, manager_password)) {
            mav.setViewName("success4manager");
        } else {
            mav.setViewName("error4manager");
        }
        return mav;
    }

    @RequestMapping("/getAuthority")
    public void getAuthority(HttpServletRequest request, HttpServletResponse response) {
        try {
            ArrayList lists = managerService.queryAll();
            JSONArray data = JSONArray.parseArray(JSON.toJSONString(lists));
            response.setCharacterEncoding("utf-8");
            request.setAttribute("lists", data);
            request.getRequestDispatcher("/getAuthority.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
