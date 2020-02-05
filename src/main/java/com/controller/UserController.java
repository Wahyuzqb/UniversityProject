package com.controller;

import com.pojo.Transfers;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

@Controller
@RequestMapping("/userManager")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "checkUserBalance", produces = {"application/json;charset=UTF-8"})
    public ModelAndView userBalance(HttpSession session) {
        ModelAndView mav = new ModelAndView();
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
        ModelAndView mav = new ModelAndView();
        if (userService.changeUserInfo(id_account, account_password) == 1) {
            mav.setViewName("oldJsp/userInfo");
        } else {
            mav.setViewName("网络波动请稍后重试");
        }
        return mav;
    }

    @RequestMapping("/user_logout")
    public ModelAndView user_logout(HttpSession session) {
        ModelAndView mav = new ModelAndView();
        session.removeAttribute("id_account");
        mav.setViewName("login");
        return mav;
    }

    @RequestMapping("changepwd")
    public ModelAndView changepwd(HttpServletRequest request, HttpSession session) {
        ModelAndView mav = new ModelAndView();
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
        Date utilDate = new Date(System.currentTimeMillis());//util utilDate
        Timestamp sqlDate = new Timestamp(utilDate.getTime());//uilt date转sql date
        ModelAndView mav = new ModelAndView();
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
}
