package com.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.pojo.PreSaves;
import com.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/adminManager")
public class ManagerController {
    @Autowired
    private ManagerService managerService;

    ModelAndView mav = new ModelAndView();

    /*获取用户需求列表*/
    @RequestMapping("/userNeeds")
    public ModelAndView userNeeds(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
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
    public ModelAndView changeAuthToDo(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        String account = (String) session.getAttribute("account");
        managerService.changeAuthToOne(account);
        request.setAttribute("isAuthorized", "1");
        mav.setViewName("userNeeds");
        return mav;
    }

    /*确认用户预存款项*/
    @RequestMapping("/preSave")
    public ModelAndView preSave(HttpServletRequest request, HttpSession session) {
        try {
            String account = (String) session.getAttribute("account");
            String id_account = managerService.queryIdByAccount(account);
            List<PreSaves> lists = managerService.queryPreSaves(id_account);
            JSONArray data = JSONArray.parseArray(JSON.toJSONString(lists));
            request.setAttribute("lists", data);
        } catch (Exception e) {
            e.printStackTrace();
        }
        mav.setViewName("checkPreSaves");
        return mav;
    }

    /*管理员确认项目*/
    @RequestMapping("/checkPres")
    public ModelAndView checkPres(HttpServletRequest request, HttpSession session) {
        String flag = request.getParameter("btn");
        String id = request.getParameter("id");
        System.out.println("进来了checkPres！" + id + " " + flag);
        String account = (String) session.getAttribute("account");
        System.out.println(account + "这是account");
        if ("agree".equals(flag)) {
            System.out.println("进来了判断！");
            managerService.agreeToPreSave(Integer.valueOf(id));
            String newLeaves = "您计划于" + request.getParameter("save_time") + "在网点" + request.getParameter("location") + "预存的金额为"
                    + request.getParameter("tr_money") + "的 " + request.getParameter("deposit_type") + "请求" +
                    "已通过，请准时前往办理。";
            managerService.sendAgree(account, newLeaves);
            request.setAttribute("msg", "操作成功");
            System.out.println("还有这儿");
            /*判断是否还有残余请求*/
            if (managerService.check4otherAsk(request.getParameter("id_account")) == null)
                managerService.setPreSaveTo1(account);
            mav.setViewName("messages");
            System.out.println(mav.toString() + "000000000000000000");
        } else if ("disagree".equals(flag)) {
            System.out.println("进来了disagree");
            String leaves = request.getParameter("leave");
            managerService.disagreeToPreSave(Integer.valueOf(id));
            String newLeaves = "您计划于" + request.getParameter("save_time") + "在网点" + request.getParameter("location") + "预存的金额为"
                    + request.getParameter("tr_money") + "的 " + request.getParameter("deposit_type") + "请求" +
                    "已被退回:" + leaves;
            managerService.sendDisagree(account, newLeaves);
            /*判断是否还有残余请求*/
            if (managerService.check4otherAsk(request.getParameter("id_account")) == null)
                managerService.setPreSaveTo1(account);
            request.setAttribute("msg", "操作成功");
            mav.setViewName("messages");
        }
        System.out.println("啥也没进");
        return mav;
    }


    @RequestMapping("/login")
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        String manager_no = request.getParameter("admin_username");
        System.out.println(manager_no);
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
    public void getAuthority(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
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
