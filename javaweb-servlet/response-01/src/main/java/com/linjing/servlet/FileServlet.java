package com.linjing.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

//下载文件
public class FileServlet extends HttpServlet {

    @Override protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        //1.下载文件的路径
        String realPath = "/Users/alice/Documents/GitHub/JavaWeb/response-01/src/main/resources/pic.jpg";
        System.out.println("下载文件的路径：" + realPath);
        //2.获取文件名
        String fileName = realPath.substring(realPath.lastIndexOf("\\") + 1); //反斜杠转义字符
        //3.设置浏览器能够支持下载的header, uft-8支持中文文件名
        resp.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
        //4.获取下载文件的输入流
        FileInputStream in = new FileInputStream(realPath);
        //5.创建缓冲区
        int len = 0;
        byte[] buffer = new byte[1024];
        //6.获取OutputStream对象
        ServletOutputStream out = resp.getOutputStream();
        //7.将输出流对象写入到buffer缓存区，使用outputstream将缓冲区数据输出到客户端
        while ((len = in.read(buffer)) > 0) {
            out.write(buffer, 0, len);
        }

        in.close();
        out.close();

    }

    @Override protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
