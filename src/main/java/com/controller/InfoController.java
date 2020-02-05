package com.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.pojo.Transfers;
import com.service.InfoService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import sun.misc.Request;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/info")
public class InfoController {
    @Autowired
    private InfoService infoService;

    @ResponseBody
    @RequestMapping("/info_modify")
    public ModelAndView modifyTele(HttpServletRequest request, HttpSession session) {
        ModelAndView mav = new ModelAndView();
        String id_account = (String) session.getAttribute("id_acount");
        String telephone = request.getParameter("telephone");
        try {
            infoService.modifyTele(id_account, telephone);
            session.removeAttribute("telephone");
            session.setAttribute("telephone", telephone);
        } catch (Exception e) {
            e.printStackTrace();
        }
        mav.setViewName("modify");
        return mav;
    }

    @RequestMapping("/list")
    public void list(HttpSession session, HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
        String id_account = (String) session.getAttribute("id_account");
        try {
            List<Transfers> trans = infoService.queryAll(id_account);
            System.out.println(trans+"------------");
            JSONArray data = JSONArray.parseArray(JSON.toJSONString(trans));
            response.setCharacterEncoding("utf-8");
//            PrintWriter resWriter = response.getWriter();
//            resWriter.append(data.toJSONString());
            System.out.println(data + " " + data.getClass() + " " + data.toString() + " " + data.toString().getClass());
            request.setAttribute("lists",data);
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("/fenye.jsp").forward(request,response);
    }
}
