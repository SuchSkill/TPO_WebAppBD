package controllers;


import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ControllerResources", urlPatterns = {"/resources"})
public class Resources extends HttpServlet {


    @Resource(name = "jdbc/tpo")
    private DataSource dataSource;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();


        int user_id = (int)req.getSession().getAttribute("user_id");
        out.println("SUCSESS " + user_id);



        out.close();

    }
}
