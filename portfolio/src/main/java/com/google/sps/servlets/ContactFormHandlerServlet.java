package com.google.sps.servlets;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;    

@WebServlet("/contact-me-form-handler")
public class ContactFormHandlerServlet extends HttpServlet {

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    // Get the values entered in the form.
    String nameValue = request.getParameter("name-input");
    String subjectValue = request.getParameter("subject-input");
    String messageValue = request.getParameter("message-input");
    String visibilityValue = request.getParameter("message-visibility").equals("public") ? "Public" : "Private";

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");  
    LocalDateTime now = LocalDateTime.now();  
    String submissionTime = dtf.format(now);  

    // Build response string based on input values.
    StringBuilder sb = new StringBuilder();
    sb.append("Visibility: " + visibilityValue + System.lineSeparator());
    sb.append("Date: " + submissionTime + System.lineSeparator());
    sb.append("Name: " + nameValue + System.lineSeparator());
    sb.append("Subject: " + subjectValue + System.lineSeparator());
    sb.append("Message: " + messageValue);

    // Log form submission to server.
    System.out.println("--- New Contact Form Submission ---");
    System.out.println(sb.toString());

    // Write the value to the response so the user can see it.
    response.getWriter().println("Thanks for submitting this form! Here's what I got from you:");
    response.getWriter().println(sb.toString());
  }
}