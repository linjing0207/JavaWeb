package com.linjing.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloServlet extends HttpServlet {

    @Override protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {

        //        this.getInitParameter() 初始化参数
        //        this.getServletConfig()  servlet配置
        //        this.getServletContext()  servlet上下文
        ServletContext context = this.getServletContext(); //this指代当前这个类本身，大家获取的ServletContext是同一个。
        String userName = "alice";
        context.setAttribute("username", userName); //将数据保存在了servletContext中，key:"username", value:userName

        System.out.println("Hello");
    }

}
