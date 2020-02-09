package com.controller;

import com.pojo.Transfers;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;

@Controller
@RequestMapping("/userManager")
public class UserController {
    @Autowired
    private UserService userService;
    private Date utilDate = new Date(System.currentTimeMillis());//util utilDate
    private Timestamp sqlDate = new Timestamp(utilDate.getTime());//uilt date转sql date
    ModelAndView mav = new ModelAndView();

    @RequestMapping("/deposit")
    public ModelAndView deposit(HttpServletRequest request, HttpSession session){
        String id_account = (String) session.getAttribute("id_account");
        Integer tr_money = Integer.valueOf(request.getParameter("log.tr_money"));
        String deposit_type =request.getParameter("deposit_type");
        String date = request.getParameter("log.datetime");
        String location = request.getParameter("location");
        userService.addPreSave(id_account,tr_money,deposit_type,date,location);
        userService.changePreSaveAuth(id_account);
        request.setAttribute("msg","预约成功！如有意外消息我们会在第一时间通知您。");
        mav.setViewName("messages");
        return mav;
    }

    @RequestMapping(value = "checkUserBalance", produces = {"application/json;charset=UTF-8"})
    public ModelAndView userBalance(HttpSession session) {
        String id_account = (String) session.getAttribute("id_account");
//        String jsonString = JSON.toJSONString(userService.userInfos(id_account));
//        System.out.println(jsonString);
        String card_balance = userService.userBalance(id_account);
        System.out.println(card_balance);
        session.setAttribute("card_balance", card_balance);
        mav.setViewName("infomation");
        return mav;
    }

    @RequestMapping("/changeUserInfo")
    public ModelAndView changeUserInfo(HttpServletRequest request, HttpSession session) {
        String account_password = request.getParameter("account_password");
        String id_account = (String) session.getAttribute("id_account");
        if (userService.changeUserInfo(id_account, account_password) == 1) {
            mav.setViewName("oldJsp/userInfo");
        } else {
            request.setAttribute("msg", "网络波动请稍后重试");
            mav.setViewName("messages");
        }
        return mav;
    }

    @RequestMapping("/user_logout")
    public ModelAndView user_logout(HttpSession session) {
        session.removeAttribute("id_account");
        mav.setViewName("login");
        return mav;
    }

    @RequestMapping("changepwd")
    public ModelAndView changepwd(HttpServletRequest request, HttpSession session) {
        String id_account = (String) session.getAttribute("id_account");
        String oldpwd = request.getParameter("oldpwd");
        String newpwd = request.getParameter("newpwd");
        if (userService.checkOldPWD(id_account, oldpwd)) {
            userService.changePWD(id_account, newpwd);
            mav.setViewName("change4success");
        } else {
            mav.setViewName("change4error");
        }
        return mav;
    }

    @RequestMapping("/transfer")
    public ModelAndView transfer(HttpServletRequest request, HttpSession session) {
        String myid = (String) session.getAttribute("id_account");
        String otherid = request.getParameter("log.otherid");
        String tr_money = request.getParameter("log.tr_money");
        Transfers trans = new Transfers();
        trans.setMyid(myid);
        trans.setOtherid(otherid);
        trans.setTr_money(tr_money);
        trans.setDatetime(sqlDate);
        if (userService.transfer(trans)) {
            userService.addMoney(trans.getMyid(), trans.getOtherid(), trans.getTr_money());
            mav.setViewName("trans4success");
        } else {
            /*账户余额不足或不存在转入账户*/
            mav.setViewName("trans4error");
        }
        return mav;
    }


    /*水费充值服务-1*/
    @RequestMapping("/livings4water")
    public ModelAndView livings4water(HttpServletRequest request, HttpSession session) {
        String id_account = (String) session.getAttribute("id_account");
        String account2water = userService.query4Water(id_account);
        request.setAttribute("account2water", account2water);
        if (account2water != null)
            request.setAttribute("water_balance", userService.queryWaterBalance(account2water));
        mav.setViewName("livings4water");
        return mav;
    }

    @RequestMapping("/livings_in_water")
    public void livings_in_water(HttpServletRequest request, HttpSession session, HttpServletResponse response) throws ServletException, IOException {
        Integer water_in = Integer.valueOf(request.getParameter("water_in"));
        String id_account = (String) session.getAttribute("id_account");
        String telephone = userService.queryTelephone(id_account);
        String userName = "中国电网";
        Integer flag = userService.waterIn(id_account, telephone, water_in);
        if (flag == 1) {
            /*先增加记录再提示消息*/
            Transfers trans = new Transfers();
            trans.setMyid(id_account);
            trans.setOtherid(userName);
            trans.setTr_money(water_in.toString());
            trans.setDatetime(sqlDate);
            userService.addWaterMemory(trans);
            request.setAttribute("msg", "充值成功！");
        } else if (flag == 2)
            request.setAttribute("msg", "余额不足，请稍后重试！");
        else if (flag == 3)
            request.setAttribute("msg", "网络波动，请稍后重试！");
        request.getRequestDispatcher("/messages.jsp").forward(request, response);
    }

    /*电话充值服务-1*/
    @RequestMapping("/livings4telephone")
    public ModelAndView livings4telephone(HttpServletRequest request, HttpSession session) {
        String id_account = (String) session.getAttribute("id_account");
        String telephone = userService.queryTelephone(id_account);
        request.setAttribute("telephone", telephone);
        request.setAttribute("telephone_balance", userService.queryTelBalance(telephone));
        mav.setViewName("livings4telephone");
        return mav;
    }

    /*电话充值服务-2*/
    @RequestMapping("/livings_in_telephone")
    public void livings_in_telephone(HttpServletRequest request, HttpSession session, HttpServletResponse response) throws ServletException, IOException {
        /*读取他行信息*/
        String userName = "南阳郑通水电有限公司";
        /*获取本行相关数据*/
        String id_account = (String) session.getAttribute("id_account");
        String telephone = userService.queryTelephone(id_account);
        Integer telephone_in = Integer.valueOf(request.getParameter("telephone_in"));
        /*转账记录*/
        Transfers trans = new Transfers();
        trans.setMyid(id_account);
        trans.setOtherid(userName);
        trans.setTr_money(telephone_in.toString());
        trans.setDatetime(sqlDate);

        Integer flag = userService.telIn(id_account, telephone, telephone_in);
        if (flag == 1) {
            /*先增加记录再提示消息*/
            userService.addTelMemory(trans);
            request.setAttribute("msg", "充值成功！");
        } else if (flag == 2)
            request.setAttribute("msg", "余额不足，请稍后重试！");
        else if (flag == 3)
            request.setAttribute("msg", "网络波动，请稍后重试！");
        request.getRequestDispatcher("/messages.jsp").forward(request, response);
    }
}
