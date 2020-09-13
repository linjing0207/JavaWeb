package com.linjing.servlet;

import com.linjing.pojo.Person;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class SessionDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //解决乱码问题
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        //得到session
        HttpSession session = req.getSession();
        //往session里存东西
        session.setAttribute("name", new Person("小猪佩奇", 5));
        //获取session id
        String id = session.getId();
        //判断session是不是新创建的
        if (session.isNew()){
            resp.getWriter().write("session创建成功，id：" + id);
        } else {
            resp.getWriter().write("session已经存在了，d：" + id);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
