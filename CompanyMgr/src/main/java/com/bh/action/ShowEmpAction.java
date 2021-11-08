package com.bh.action;

import com.bh.dao.EmpDAO;
import com.bh.vo.Emp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @author Supreme
 */
public class ShowEmpAction extends HttpServlet {

    @Override
    protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost (HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        //解决乱码问题
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        //设置字符集编码
        resp.setContentType("text/html;charset=utf-8");

        PrintWriter out = resp.getWriter();
        out.println("<html><body margintop='100'>");
        out.println("<a href='addEmp.html'>增加EMP信息</a>");

        out.println("<h1>员工信息数据展示</h1>");
        out.println("<table width='800' align='center' border='1' bordercolor='gray' cellspacing='0' cellpadding='0'>" +
                "<tr bgcolor='gray'>" +
                "<td>员工编号</td>" +
                "<td>员工名称</td>" +
                "<td>员工工作</td>" +
                "<td>员工上司</td>" +
                "<td>员工上岗日期</td>" +
                "<td>员工工资</td>" +
                "<td>员工补助</td>" +
                "<td>部门编号</td>" +
                "<td>备注</td>" +
                "<td>操作</td>" +
                "</tr>");
        EmpDAO empDao = new EmpDAO();
        List<Emp> list = null;
        try {

            list = empDao.findAll();

        } catch (Exception e) {
            e.printStackTrace();
        }


        for (int i = 0; i < list.size(); i++) {
            out.println("<tr>");
            Emp emp = list.get(i);
            out.println("<td>");
            out.println(emp.getEmpno());
            out.println("</td>");
            out.println("<td>");
            out.println(emp.getEname());
            out.println("</td>");
            out.println("<td>");
            out.println(emp.getJob());
            out.println("</td>");
            out.println("<td>");
            out.println(emp.getMgr());
            out.println("</td>");
            out.println("<td>");
            out.println(emp.getHiredate());
            out.println("</td>");
            out.println("<td>");
            out.println(emp.getSal());
            out.println("</td>");
            out.println("<td>");
            out.println(emp.getComm());
            out.println("</td>");
            out.println("<td>");
            out.println(emp.getDeptno());
            out.println("</td>");
            out.println("<td>");
            out.println(emp.getQwerdf());
            out.println("</td>");

            // 删除按钮
            out.println("<td><a href='delemp?empno=" + emp.getEmpno() + "'>删除</a>");
            out.println("</td>");
            out.println("</tr>");

        }

        out.println("</table></body></html>");

    }
}
