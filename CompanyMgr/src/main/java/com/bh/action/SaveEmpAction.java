package com.bh.action;

import com.bh.dao.DeptDAO;
import com.bh.dao.EmpDAO;
import com.bh.vo.Dept;
import com.bh.vo.Emp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class SaveEmpAction extends HttpServlet {
    @Override
    public void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    public void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 乱码问题的解决
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        // 获得页面的参数
        String no = request.getParameter("empno");
        String name = request.getParameter("ename");
        String sal = request.getParameter("sal");

        // DB
        EmpDAO empDao = new EmpDAO();
        Emp emp = new Emp();
        emp.setEmpno(Integer.parseInt(no));
        emp.setEname(name);
        emp.setSal(Integer.parseInt(sal));

        PrintWriter out = response.getWriter();
        out.println(no);
        out.println(name);
        out.println(sal);

        response.setContentType("text/html;charset=utf-8");

        out.println("<html><body>");


        try {
            empDao.save(emp);
            out.println("保存成功");
            out.println("<br>");
        } catch (Exception e) {
            e.printStackTrace();

            out.println("保存失败");
            out.println("<br>");
        }
        out.println("<a href='showemp'>展示数据</a>");
        out.println("</body></html>");


        System.out.println("end=============");
    }
}