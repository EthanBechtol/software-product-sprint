package com.google.sps.servlets;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Handles requests sent to the /simple-string URL.
 *  This servlet simply returns a simple hard-coded html page containing a header and a paragraph.
*/
@WebServlet("/simple-string")
public class SimpleStringServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;");
        response.getWriter().println("<h1>Server response</h1>");
        response.getWriter().println("<p>This is a hard-coded string returned by a servlet!</p>");
    }
}