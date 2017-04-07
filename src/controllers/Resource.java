package controllers;


import DAO.UserResource;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ControllerResource", urlPatterns = {"/resource"})
public class Resource extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("resource.jsp").forward(req, resp);
//        PrintWriter out = resp.getWriter();
//
//        int user_id = (int)req.getSession().getAttribute("user_id");
//        List<UserResource> list = (List<UserResource>)req.getSession().getAttribute("list");
//
//        int picked_id = Integer.parseInt(req.getParameter("picked_id"));
//        out.println("user id = " + user_id);
//        out.println(list.get(picked_id-1).getText());
//
//
//
//
//        out.close();

    }

}
