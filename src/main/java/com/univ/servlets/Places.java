package com.univ.servlets;

import com.univ.beans.Place;
import com.univ.dao.AbstractDao;
import com.univ.dao.DaoException;
import com.univ.dao.DaoFactory;
import com.univ.mysql.MySqlDaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "Places")
public class Places extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        PrintWriter writer = response.getWriter();

        String name = request.getParameter("name");
        DaoFactory factory = new MySqlDaoFactory();
        try {
            AbstractDao dao = factory.getDao(factory.getConnection(), Place.class);
            ArrayList<Place> places = dao.readAll();

            for (Place place : places) {
                if (place.getName().equals(name)){
                    HttpSession session = request.getSession();
                    session.setAttribute("place", place);
                    request.getRequestDispatcher("place.jsp").forward(request, response);
                }
            }
            writer.println("Cannot find this place");
        } catch (DaoException e) {
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        PrintWriter show = response.getWriter();

        DaoFactory factory = new MySqlDaoFactory();
        try {
            AbstractDao dao = factory.getDao(factory.getConnection(), Place.class);
            ArrayList<Place> places = dao.readAll();

            HttpSession session = request.getSession();
            session.setAttribute("places", places);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } catch (DaoException e) {
            show.print("There is none place");
        }
    }
}
