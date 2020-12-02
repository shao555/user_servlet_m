package com.cs.servlet;

import com.cs.entity.User;
import com.cs.service.impl.UserServiceImpl;
import com.cs.util.PageSupport;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String comm = request.getParameter("comm");
        if (comm.equals("list")) {
            String pageNO = request.getParameter("indexno");
            if (pageNO == null || pageNO == "") {
                pageNO = "1";
            }
            int pno = Integer.parseInt(pageNO);
            UserServiceImpl usi = new UserServiceImpl();
            PageSupport ps = new PageSupport();
            ps.setCurrentPageNo(pno);
            ps.setPageSize(3);
            try {
                ps.setTotalCount(usi.findByCountUser());
                List<User> list = usi.findByPageUserInfo(ps.getCurrentPageNo(), ps.getPageSize());
                if (list.size() > 0 && list != null) {
                    request.getSession().setAttribute("lists", list);
                    request.getSession().setAttribute("ps", ps);
                    response.sendRedirect("list.jsp");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (comm.equals("query")) {
            UserServiceImpl usi = new UserServiceImpl();
            String id = request.getParameter("id");
            int ids = Integer.parseInt(id);
            User user = null;
            try {
                user = usi.findByIDdUserInfo(ids);
                if (user != null) {
                    request.setAttribute("user", user);
                    request.getRequestDispatcher("query.jsp").forward(request, response);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        if(comm.equals("del")){
            UserServiceImpl usi = new UserServiceImpl();
            String id = request.getParameter("id");
            int ids = Integer.parseInt(id);
            try {
                if (usi.delUser(ids)) {
                    request.getRequestDispatcher("UserServlet?comm=list").forward(request, response);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (comm.equals("修改")) {
            UserServiceImpl usi = new UserServiceImpl();
            User user = new User();
            String id = request.getParameter("id");
            int ids = Integer.parseInt(id);
            user.setId(ids);
            String name = request.getParameter("username");
            user.setUsername(name);
            String pass = request.getParameter("password");
            user.setPassword(pass);
            String sex = request.getParameter("sex");
            user.setSex(sex);
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
//            Date date = null;
            String bornDate = request.getParameter("bornDate");
            user.setBornDate(bornDate);
//            user.setUserpic(null);
//            String userpic = request.getParameter("userpic");
            try {
//                date = sdf.parse(bornDate);
                if (usi.updateUser(user)) {
                request.getRequestDispatcher("UserServlet?comm=list").forward(request, response);
                    //response.sendRedirect("UserServlet?&comm=list");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
