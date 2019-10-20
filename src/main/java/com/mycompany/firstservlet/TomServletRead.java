/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.firstservlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 *
 * @author mehmetefeekiner
 */
public class TomServletRead extends HttpServlet {

    public static void readIT( HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter writer = response.getWriter();

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        writer.append("<!DOCTYPE html>\r\n")
                .append("<html>\r\n")
                .append("	<head>\r\n")
                .append("		<title>TomServletRead</title>\r\n")
                .append("	</head>\r\n")
                .append("	<body>\r\n")
                .append("           <h4>Tomcat Log Reader!</h3>\r\n")
                .append("<br/><br/>\r\n")
                .append("<h4>");
        BufferedReader tomcatLogReader = null;
        String passedParameter = request.getParameter("path");
        /*String passedJSParameter = request.getParameter("text");
        String passedJSParameter2 = "some text";
        response.getWriter().write(passedJSParameter2);
        */
        
        
        
        try {
            tomcatLogReader = new BufferedReader(new FileReader("/Users/mehmetefeekiner/Tomcat/logs/" + passedParameter));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String sCurrentLine;

        writer.append("<h4>The LOG  you're currently seeing is:</h4>\r\n")
              .append("<h5>")
              .append(passedParameter)
              .append("</h5>");
              
        while ((sCurrentLine = tomcatLogReader.readLine()) != null) {
            writer.println((sCurrentLine));
            
        }
        writer.append("</h4>")
                .append("<br/>\r\n")
                .append("	</body>\r\n")
                .append("</html>\r\n");
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TomServletRead</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TomServletRead at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);

        readIT( request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
