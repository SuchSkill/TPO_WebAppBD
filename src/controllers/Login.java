package controllers;

import DAO.*;

import javax.annotation.Resource;
import javax.servlet.annotation.WebServlet;
import javax.sql.DataSource;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.sql.*;

@WebServlet(name = "ControllerLogin", urlPatterns = {"/login"})
public class Login extends HttpServlet {

    @Resource(name = "jdbc/tpo")
    private DataSource dataSource;


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=windows-1250");
        PrintWriter out = resp.getWriter();

        int user_id = getUser_id(req);
//        int user_id = 1;

        Cookie[] cookies = req.getCookies();
        HttpSession session = null;
        if (cookies != null) {
            for (int i=0; i<cookies.length; i++) {
                String name = cookies[i].getName();
                String value = cookies[i].getValue();
                out.println("<br>" + name + " " + value);
                if (name.equals("session")) {
                    session =  req.getSession();
                }
            }
        }

//        HttpSession session = req.getSession();
        session.setAttribute("user_id", user_id);
        Cookie ck = new Cookie("session", session.getId());
        resp.addCookie(ck);
        req.getSession().setAttribute("user_id", user_id);
//        RequestDispatcher rd = req.getRequestDispatcher("/resources");


        List<UserResource> list = new ArrayList<>();

        Connection con = null;
        try {
            synchronized (dataSource) {
                con = dataSource.getConnection();
            }
            PreparedStatement getUser = con.prepareStatement("select  r.res_id, res_name, res_content from resources r , users_res ur WHERE user_id = ? and r.res_id = ur.res_id");
            getUser.setInt(1, user_id);
            ResultSet rs = getUser.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("res_id");
                String name = rs.getString("res_name");
                String text = rs.getString("res_content");
                list.add(new UserResource(id, name, text));
            }



            rs.close();
            getUser.close();

        } catch (Exception exc) {
        } finally {
            try {
                con.close();
            } catch (Exception exc) {
            }
        }

//        list.add(new UserResource(1,"email", "1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678909999999123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890999999912345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789099999991234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678909999999888812345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789099999991234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678909999999123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890777777777777"));
//        list.add(new UserResource(2,"pmail", "fhnfdstreregg"));
//        list.add(new UserResource(3,"gmail", "rthbtyjvcaergeaag"));

        req.getSession().setAttribute("list", list);
        req.getRequestDispatcher("resources.jsp").forward(req, resp);



//        rd.forward(req, resp);
        out.close();
    }

    private int getUser_id(HttpServletRequest req) {
        String login = req.getParameter("login");
        int password = Integer.parseInt(req.getParameter("password"));

        Connection con = null;
        int user_id = 0;
        try {
            synchronized (dataSource) {
                con = dataSource.getConnection();
            }
            PreparedStatement getUser = con.prepareStatement("select user_id from users where user_login=? and user_password = ?");
            getUser.setString(1, login);
            getUser.setInt(2, password);
            ResultSet rs = getUser.executeQuery();

            while (rs.next()) {
                user_id = rs.getInt("user_id");
            }



            rs.close();
            getUser.close();

        } catch (Exception exc) {
        } finally {
            try {
                con.close();
            } catch (Exception exc) {
            }
        }
        return user_id;
    }
}
