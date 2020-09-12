package com.linjing.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletDemo04 extends HttpServlet {
    @Override protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        System.out.println("进入了ServletDemo04");
        ServletContext context = this.getServletContext();
        RequestDispatcher requestDispatcher = context.getRequestDispatcher("/gp"); //转发的请求路径
        requestDispatcher.forward(req, resp); //调用forward实现请求转发,将请求转发给"/gp"了. url不会变化
        //        context.getRequestDispatcher("/gp").forward(req, resp);
    }

    @Override protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        doPost(req, resp);
    }
}