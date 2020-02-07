package com.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.service.ManagerService;
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
    private HttpServletRequest request;
    private HttpSession session;
    private HttpServletResponse response;

    /*获取用户需求列表*/
    @RequestMapping("/userNeeds")
    public ModelAndView userNeeds() {
        String account = (String) session.getAttribute("account");
        System.out.println(account + "----------");
        if (managerService.isAuthorized(account) == 0)
            request.setAttribute("isAuthorized", "0");
        if (managerService.hasError(account) == 0)
            request.setAttribute("hasError", "0");
        if (managerService.preSave(account) == 0)
            request.setAttribute("preSave", "0");
        mav.setViewName("userNeeds");
        return mav;
    }

    /*激活用户账户*/
    @RequestMapping("/activeAccount")
    public ModelAndView changeAuthToDo() {
        String account = (String) session.getAttribute("account");
        managerService.changeAuthToOne(account);
        request.setAttribute("isAuthorized", "1");
        mav.setViewName("userNeeds");
        return mav;
    }

    /*反馈用户报错*/
    @RequestMapping("/hasError")
    public ModelAndView hasError() {

        return mav;
    }

    @RequestMapping("/login")
    public ModelAndView login() {
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

    /*获取用户列表*/
    @RequestMapping("/getAuthority")
    public void getAuthority() {
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
