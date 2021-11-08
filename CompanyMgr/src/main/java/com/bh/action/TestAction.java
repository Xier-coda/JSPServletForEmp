package com.bh.action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TestAction extends HttpServlet {
    @Override
    public void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String str1 = req.getParameter("key1");
        String str2 = req.getParameter("key2");
        System.out.println(str1);
        System.out.println(str2);
    }
}
