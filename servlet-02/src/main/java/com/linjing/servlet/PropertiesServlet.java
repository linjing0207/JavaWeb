package com.linjing.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesServlet extends HttpServlet {
    @Override protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        InputStream is =
            this.getServletContext().getResourceAsStream("/WEB-INF/classes/db.properties"); //所有servlet共享的资源
        Properties prop = new Properties();
        prop.load(is);
        String userName = prop.getProperty("username");
        String pwd = prop.getProperty("password");
        resp.getWriter().print(userName + ":" + pwd);
    }

    @Override protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
