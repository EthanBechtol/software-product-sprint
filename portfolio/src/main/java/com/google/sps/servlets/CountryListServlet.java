package com.google.sps.servlets;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.*;
import java.util.ArrayList;
import java.util.Arrays;

/** Handles requests sent to the /country-list-json URL.
 *  This servlet simply returns a json formatted list of countries I've visited.
*/
@WebServlet("/country-list-json")
public class CountryListServlet extends HttpServlet {
    private class CountryList {
        public ArrayList<String> countries;
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json;");
        response.getWriter().println(getCountryJSON());
    }

    private String getCountryJSON() {
        CountryList listObject = new CountryList();
        listObject.countries = new ArrayList<>(
            Arrays.asList("United States", "Costa Rica", "Israel", "Poland", "Spain", "France")
        );
        
        Gson gson = new Gson();
        return gson.toJson(listObject);
    }
}