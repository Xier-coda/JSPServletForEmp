package com.bh.action;

import com.bh.dao.DeptDAO;
import com.bh.dao.EmpDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class DelEmpAction extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 乱码问题的解决
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String no = request.getParameter("empno");
        PrintWriter out = response.getWriter();
        response.setContentType("text/html;charset=utf-8");

        out.println("<html><body>");
        // DB
        EmpDAO deptDao = new EmpDAO();
        try {
            deptDao.delete(Integer.parseInt(no));
            out.println("删除成功");
            out.println("<br>");
        } catch (Exception e) {
            e.printStackTrace();
            out.println("删除失败");
            out.println("<br>");
        }

        out.println("<a href='showemp'>展示数据</a>");
        out.println("</body></html>");
        System.out.println("end=============");
    }
}
