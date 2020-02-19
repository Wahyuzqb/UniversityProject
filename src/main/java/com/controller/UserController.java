package com.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pojo.MyJson;
import com.pojo.Transfers;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/userManager")
public class UserController {
    @Autowired
    private UserService userService;
    private Date utilDate = new Date(System.currentTimeMillis());//util utilDate
    private Timestamp sqlDate = new Timestamp(utilDate.getTime());//uilt date转sql date
    ModelAndView mav = new ModelAndView();

    @RequestMapping("/deposit")
    public ModelAndView deposit(HttpServletRequest request, HttpSession session) {
        String id_account = (String) session.getAttribute("id_account");
        Integer tr_money = Integer.valueOf(request.getParameter("log.tr_money"));
        String deposit_type = request.getParameter("deposit_type");
        String date = request.getParameter("log.datetime");
        String location = request.getParameter("location");
        userService.addPreSave(id_account, tr_money, deposit_type, date, location);
        userService.changePreSaveAuth(id_account);
        request.setAttribute("msg", "预约成功！如有意外消息我们会在第一时间通知您。");
        mav.setViewName("messages");
        return mav;
    }

    @RequestMapping("/queryLeaves")
    public ModelAndView queryLeaves(HttpServletRequest request, HttpSession session) {
        String id_account = (String) session.getAttribute("id_account");
        String account = userService.queryAccountById(id_account);
        String msg = userService.queryLeaves(account);
        if (msg == null)
            request.setAttribute("msg", "请耐心等待答复");
        else
            request.setAttribute("msg", msg);
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

    @RequestMapping("/getInOut")
    @ResponseBody
    public Object getInOut(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
        String id_account = (String) session.getAttribute("id_account");
        Integer out = userService.queryOutMoneyById(id_account);
        Integer in = userService.queryInMoneyById(id_account);
        Map<String, Object> maps = new LinkedHashMap<String, Object>();
        maps.put("outList", out);
        maps.put("inList", in);
        String str = JSONObject.toJSONString(maps);
        return str;
    }

    @RequestMapping("/getInOutList")
    @ResponseBody
    public Object getInOutList(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
        System.out.println("进了第二个图");
        String id_account = (String) session.getAttribute("id_account");
        List<Integer> out = userService.queryOutMoneyListById(id_account);
        List<Integer> in = userService.queryInMoneyListById(id_account);
        Map<String, Object> maps = new LinkedHashMap<String, Object>();
        maps.put("outList", out);
        maps.put("inList", in);
//        List list = new ArrayList();
//        list.add(maps);
        String str = JSONObject.toJSONString(maps);
//        request.setAttribute("mylist", JSON.toJSON(list));
        return str;
    }

    @RequestMapping("/InAndOut")
    public void inAndOut(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
        System.out.println("进了第一个图");
        String id_account = (String) session.getAttribute("id_account");
        Integer out = userService.queryOutMoneyById(id_account);
        Integer in = userService.queryInMoneyById(id_account);
        request.setAttribute("money_out", out);
        request.setAttribute("money_in", in);
        request.getRequestDispatcher("/checkInAndOut.jsp").forward(request, response);
    }

    @RequestMapping(value = "/checkInAndOutMethod", produces = "application/json; charset=utf-8")
    @ResponseBody
    public Object checkIO(HttpSession session, HttpServletRequest request) throws ServletException, IOException {
        String id_account = (String) session.getAttribute("id_account");
        try {
            List<Transfers> trans1 = userService.queryOut(id_account);
            List<Transfers> trans2 = userService.queryIn(id_account);
            JSONArray data1 = JSONArray.parseArray(JSON.toJSONString(trans1));
            JSONArray data2 = JSONArray.parseArray(JSON.toJSONString(trans2));
            data1.fluentAddAll(data2);
            List<Transfers> lists = JSONObject.parseArray(data1.toJSONString(), Transfers.class);
            MyJson mj = new MyJson();
            mj.setData(lists);
            System.out.println(mj.toString());
            String str = JSONObject.toJSONString(mj);
            return str;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
