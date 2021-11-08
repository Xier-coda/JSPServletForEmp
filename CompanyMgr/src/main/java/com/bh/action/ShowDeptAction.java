package com.bh.action;

import com.bh.dao.DeptDAO;
import com.bh.vo.Dept;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ShowDeptAction extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 乱码问题的解决
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        PrintWriter out = response.getWriter();
        out.println("<html><body margintop='100'>");
        out.println("<a href='addDept.html'>增加部门信息</a>");

        out.println("<h1>部门信息数据展示</h1>");
        out.println("<table width='600' align='center' border='1' bordercolor='gray' cellspacing='0' cellpadding='0'>" +
                "<tr bgcolor='gray'>" +
                "<td>部门编号</td>" +
                "<td>部门名称</td>" +
                "<td>部门地址</td>" +
                "<td>操作</td>" +
                "</tr>");

        DeptDAO deptDao = new DeptDAO();
        List<Dept> list = null;
        try {
            // 取得所有的部门表数据
            list = deptDao.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i < list.size(); i++) {

            out.println("<tr>");
            Dept dept = list.get(i);
            out.println("<td>");
            out.println(dept.getDeptno());
            out.println("</td>");
            out.println("<td>");
            out.println(dept.getDname());
            out.println("</td>");
            out.println("<td>");
            out.println(dept.getLoc());
            out.println("</td>");
            // 删除按钮
            out.println("<td><a href='deldept?deptno="+dept.getDeptno()+"'>删除</a>");
            out.println("</td>");

            out.println("</tr>");
        }

        out.println("</table></body></html>");
    }
}
