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
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "Places")
public class Places extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        PrintWriter show = response.getWriter();

        DaoFactory factory = new MySqlDaoFactory();
        try {
            AbstractDao dao = factory.getDao(factory.getConnection(), Place.class);
            ArrayList<Place> places = dao.readAll();

            show.print("<table align=\"center\" border=\"1\">" +
                    "<tr>" +
                    "<th>Place name</th>" +
                    "<th width=\"50%\">Place description</th>" +
                    "<th>Latitude</th>" +
                    "<th>Longitude</th>" +
                    "<th>Radiation</th>" +
                    "<th>Radiation type</th>" +
                    "</tr>");
            for (Place place : places) {
                String degree = String.valueOf((char) 176);
                String latitude = place.getPosition().getLatitudeDegree() +
                        degree + place.getPosition().getLatitudeMinute() + " " + place.getPosition().getLatitude();
                String longitude = place.getPosition().getLongitudeDegree() +
                        degree + place.getPosition().getLongitudeMinute() + " " + place.getPosition().getLongitude();
                show.print("<tr>" +
                        "<td>" + place.getName() + "</td>" +
                        "<td width=\"50%\">" + place.getDescription() + "</td>" +
                        "<td>" + latitude + "</td>" +
                        "<td>" + longitude + "</td>" +
                        "<td>" + place.getInfluence().getRadiation().getRadiation() + "мкР</td>" +
                        "<td>" + place.getInfluence().getRadiation().getAdvantageType() + "</td>" +
                        "</tr>");
            }
            show.print("</table>");
        } catch (DaoException e) {
            show.print("There is none place");
        }
    }
}
