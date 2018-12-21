/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cbse.example.tester;

import com.cbse.example.service.PalindromeServiceRemote;
import com.cbse.example.entity.Palindrome;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author user
 */
@WebServlet(name = "PalindromeController", urlPatterns = {"/PalindromeController"})
public class PalindromeController extends HttpServlet {

    @EJB
    private PalindromeServiceRemote palindromeService;

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
            out.println("<title>Servlet PalindromeController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PalindromeController at " + request.getContextPath() + "</h1>");
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
        processRequest(request, response);
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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String input = request.getParameter("input-p");
            Palindrome p = palindromeService.createPalindrome(input);
            String responseString = "";
            if(p.checkPalindromic()) {
                responseString = "The String is palindromic!";
            } else {
                responseString = "The String is not palindromic!";
            }
            String htmlResponse = "<html>\n" +
"    <head>\n" +
"        <title>Palindrome Check</title>\n" +
"        <meta charset=\"UTF-8\">\n" +
"        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"        <style type=\"text/css\">\n" +
"            <!--\n" +
"               body {\n"+
                    "background-color: #FFA500;\n"+
                    "}\n"+
"        	h1{\n" +
"        		color: white;\n" +
"        		margin: 0 auto;\n" +
"        		text-align: center;\n" +
"        		font-size: 90px;\n" +
"        		font-style: bold;\n" +
"        		font-family: Brush Script MT, Brush Script Std, cursive;\n" +
"        	}\n" +
"        	body {\n" +
"	 			 background-image: url(\"orange.jpg\");\n" +
"	 			 background-repeat: no-repeat;\n" +
"	 			 background-position: right top;\n" +
"	 			 background-size: cover;\n" +
"	 			 padding-top: 40px;\n" +
"  				 padding-right: 30px;\n" +
"  				 padding-bottom: 50px;\n" +
"  				 padding-left: 80px;\n" +
"			}\n" +
"			h2 {\n" +
"        		color: white;\n" +
"				text-align: center;\n" +
"                       font-size: 60px;\n" +                    
"	    		width: 500px;\n" +
"	    		margin: 0 auto;\n" +
"			}\n" +
                    "form {\n" +
				"text-align: center;\n" +
	    		"width: 500px; \n" +
	    		"margin: 0 auto; \n" +
			"}\n" +
"			input[type=submit] {\n" +
"  			background-color: #ff0066;\n" +
"  			color: white;\n" +
"  			padding: 12px 20px;\n" +
"  			border: none;\n" +
"  			border-radius: 4px;\n" +
"  			cursor: pointer;\n" +
"  			text-align: center;\n" +
"                        }\n" +
"\n" +
"			input[type=submit]:hover {\n" +
" 				 background-color: #d1a77b;\n" +
"			}\n" +
"			.footer {\n" +
"   				position: fixed;\n" +
"			   left: 0;\n" +
"			   bottom: 0;\n" +
"			   width: 100%;\n" +
"			   color: white;\n" +
"			   text-align: left;\n" +
"			   padding-left: 15px;\n" +
"			}\n" +
"                        -->\n" +
"        </style>\n" +
"    </head>\n" +
"    <body>\n" +
"    	<h1>Palindrome Checker</h1><br><br><br><br><br><br><br>\n" +
                    "<h2>" + responseString+ "</h2><br>\n"+
"        <form action=\"http://localhost:8080/PalindromeWeb/\" method=\"post\">\n" +
"            <input type=\"submit\" value=\"Back\" />\n" +
"        </form>\n" +
"        <div class=\"footer\">\n" +
"  			<p>This web application is for academic purpose only.</p>\n" +
"		</div>\n" +
"    </body>\n" +
"</html>";
            out.println(htmlResponse);
        }
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
