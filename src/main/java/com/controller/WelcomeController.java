package com.controller;

import com.service.WelcomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller("welcomeController")
@RequestMapping("/welcome")
public class WelcomeController {
    @Autowired
    private WelcomeService welcomeService;

    //注册账号
    @RequestMapping(value = "/regist")
    public ModelAndView register(HttpServletRequest request, HttpSession session) {
        ModelAndView mav = new ModelAndView();
        String id_account = request.getParameter("id_account");
        String account_password = request.getParameter("account_password");
        /*判断是否存在卡号*/
        int exists = welcomeService.checkUser(id_account);
        /*存在或不属于该行则无法重复注册*/
        if (exists == 0) {
            mav.setViewName("oldJsp/error4regist");
        } else {
            /*不存在则可以继续操作*/
            /*将账户存入session*/
            session.setAttribute("id_account", id_account);
            session.setAttribute("account_password", account_password);
            mav.setViewName("oldJsp/checkUserTele");

        }
        return mav;
    }

    //检查手机号归属
    @RequestMapping("/checkUserTele")
    public ModelAndView checkUserTele(HttpServletRequest request, HttpSession session) {
        ModelAndView mav = new ModelAndView();

        String telephone = request.getParameter("telephone");
        String id_account = (String) session.getAttribute("id_account");
        String account_password = (String) session.getAttribute("account_password");

        int is = welcomeService.checkUserTele(id_account, telephone);
        if (is == 1) {
            session.setAttribute("teleMsg", new String("请先确认是在本行注册的手机号"));
            welcomeService.saveUser(id_account, account_password);
            mav.setViewName("/login");
        } else {
            session.setAttribute("teleMsg", new String("手机号错误，请重试！"));
            mav.setViewName("oldJsp/checkUserTele");
        }
        return mav;
    }

    @RequestMapping("/login")
    public ModelAndView login(HttpServletRequest request, HttpSession session) {
        ModelAndView mav = new ModelAndView();
        /*普通用户登录*/
        String telephone = request.getParameter("telephone");
        String account_password = request.getParameter("account_password");
        String id_account = null;
        if ((id_account = welcomeService.login(telephone, account_password)) != null) {
            /*判断是否经过管理员许可开户*/
            session.setAttribute("id_account", id_account);
            if (welcomeService.checkAuth(id_account)) {
                session.setAttribute("telephone", telephone);
                mav.setViewName("success");
            }else{
                mav.setViewName("wait4manager");
            }
        } else {
            mav.setViewName("oldJsp/error4login");
        }
        return mav;
    }
}
