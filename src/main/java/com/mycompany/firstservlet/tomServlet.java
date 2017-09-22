/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.firstservlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mehmetefeekiner
 */
public class tomServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    public static String getTomLogs(String path, HttpServletRequest request, HttpServletResponse response) throws IOException {

        String s = "";
        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();
        int length = listOfFiles.length;
        //int lengthOfArray = listOfFiles.length;

        PrintWriter writer = response.getWriter();

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        writer.append("<!DOCTYPE html>\r\n")
                .append("<html>\r\n")
                .append("	<head>\r\n")
                .append("		<title>TomServlet</title>\r\n")
                .append("	</head>\r\n")
                .append("	<body>\r\n")
                .append("           <h3>Tomcat Log Reader!</h3>\r\n")
                .append("<ol>\r\n");

        for (File file : listOfFiles) {
            if (file.isFile()) {

                //System.out.println(file.getName());
                s = s + "\n" + file.getName();
                writer.append("<li>\r\n");
                writer.append("		<a href=tomServletRead>" + file.getName() + "</a>\r\n");
                writer.append("<br/>\r\n");
            }
        }
        writer.append("</li>\r\n")
                .append("		<ol>\r\n")
                .append("        	</li>\r\n")
                .append("      	</ul>\r\n")
                .append("	</body>\r\n")
                .append("</html>\r\n");

        System.out.println("Method getTomLogs invoked.");
        return s;

    }

    public static void readIT(String path) throws IOException {
        BufferedReader tomcatLogReader = null;

        try {
            tomcatLogReader = new BufferedReader(new FileReader("/Users/mehmetefeekiner/Tomcat/logs/" + path));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String sCurrentLine;

        while ((sCurrentLine = tomcatLogReader.readLine()) != null) {
            System.out.println(sCurrentLine);
        }
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet tomServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet tomServlet at " + request.getContextPath() + "</h1>");
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
//        processRequest(request, response);

        System.out.println("Project: FirstServlet\n"
                + "Class: tomServlet.java\n"
                + "Package: com.mycompany.firstservlet.tomServlet.java\n");

        getTomLogs("/Users/mehmetefeekiner/Tomcat/logs", request, response);

        //String listOfFiles = "listOfFiles worked.";
        //writer.print(listOfFiles); // variable printed on the website. 
        // method call works
        //writer.print(getTomLogs("/Users/mehmetefeekiner/Tomcat/logs"));
//    	/*
//    	 * Names of these variables in capital, are CGI Environment Variables, and the method associated
//    	 * with them are Corresponding Servlet Methods. 
//    	 */
//    	String SERVER_NAME 		= request.getServerName() + "\t[request.getServerName()]";
//    	String SERVER_SOFTWARE 	= getServletContext().getServerInfo() + "\t[getServletContext().getServerInfo())]";
//    	String SERVER_PROTOCOL 	= request.getProtocol() + "\t[request.getProtocol()]";
//    	/*
//    	 * SERVER_PORT returns int.
//    	 */
//    	String SERVER_PORT 		= request.getServerPort() + "\t[request.getServerPort()]";
//    	String REQUEST_METHOD 	= request.getMethod() + "\t[request.getMethod()]";
//    	String PATH_INFO 		= request.getPathInfo() + "\t[request.getPathInfo()]";
//    	String PATH_TRANSLATED 	= request.getPathTranslated() + "\t[request.getPathTranslated()]";
//    	String SCRIPT_NAME		= request.getServletPath() + "\t[request.getServletPath()]";
//    	String DOCUMENT_ROOT 	= request.getServletContext().getRealPath("/") + "\t[request.getServletContext().getRealPath(\"/\")]";
//    	String QUERY_STRING 		= request.getQueryString() + "\t[request.getQueryString()]";
//    	String REMOTE_HOST 		= request.getRemoteHost() + "\t[request.getRemoteHost()]";
//    	String REMOTE_ADDR 		= request.getRemoteAddr() + "\t[request.getRemoteAddr()]";
//    	String AUTH_TYPE 		= request.getAuthType() + "\t[request.getAuthType()]";
//    	String REMOTE_USER 		= request.getRemoteUser() + "\t[request.getRemoteUser()]";
//    	String CONTENT_TYPE		= request.getContentType() + "\t[request.getContentType()]";
//    	/*
//    	 * CONTENT_LENTH returns int.
//    	 */
//    	String CONTENT_LENGTH 	= request.getContentLength() + "\t[request.getContentLength()]";
//    	String HTTP_ACCEPT 		= request.getHeader("Accept") + "\t[request.getHeader(\"Accept\")]";
//    	String HTTP_USER_AGENT 	= request.getHeader("User-Agent") + "\t[request.getHeader(\"User-Agent\")]";
//    	String HTTP_REFERER 		= request.getHeader("Referer") + "\t[request.getHeader(\"Referer\")]";
//    	
//    	 	
//    	
//    	writer.println(SERVER_NAME + "\r\n");
//    	writer.println(SERVER_SOFTWARE + "\r\n");
//    	writer.println(SERVER_PROTOCOL + "\r\n");
//    	writer.println(SERVER_PORT + "\r\n");
//    	writer.println(REQUEST_METHOD + "\r\n");
//    	writer.println(PATH_INFO + "\r\n");
//    	writer.println(PATH_TRANSLATED + "\r\n");
//    	writer.println(SCRIPT_NAME + "\r\n");
//    	writer.println(DOCUMENT_ROOT + "\r\n");
//    	writer.println(QUERY_STRING + "\r\n");
//    	writer.println(REMOTE_HOST + "\r\n");
//    	writer.println(REMOTE_ADDR + "\r\n");
//    	writer.println(AUTH_TYPE + "\r\n");
//    	writer.println(REMOTE_USER + "\r\n");
//    	writer.println(CONTENT_TYPE + "\r\n");
//    	writer.println(CONTENT_LENGTH + "\r\n");
//    	writer.println(HTTP_ACCEPT + "\r\n");
//      writer.println(HTTP_USER_AGENT + "\r\n");
//      writer.println(HTTP_REFERER + "\r\n");
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
