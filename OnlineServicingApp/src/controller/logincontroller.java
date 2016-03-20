package controller;
import java.io.*;
import java.util.*;
import java.util.logging.Logger;

import model.*;
import sun.util.logging.PlatformLogger.Level;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginController
 */

public class logincontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public logincontroller() {
        super();
        // TODO Auto-generated constructor stub
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		  processRequest(request, response);
	}
	
	   protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        response.setContentType("text/html;charset=UTF-8");
	        try  {
	            /* TODO output your page here. You may use following sample code. */
	     //     List errorMsgs = new  LinkedList();
	        	
	          PrintWriter out = response.getWriter();
	           String username = request.getParameter("login_id");
	           String password = request.getParameter("password");
	         	
	                 Login l = new Login(username, password);
	                 
	                 Services s = new Services();
	                 System.out.println("inside");
	                 int flag = s.checkLogin(l);
	                 RequestDispatcher rd= null;
	                 if (flag != 0)
	                 {System.out.println(" not found");
	           	  out.print("Invalid Username or password ");
	           	 rd = request.getRequestDispatcher("/login.jsp") ;
                         //      errorMsgs.clear();
           //  errorMsgs.add("Username already taken");
             //request.getSession().setAttribute("error",errorMsgs);
             
             
	                 }
	                 if (flag == 0)
	                 {  System.out.println("found");
	                // errorMsgs.clear();
	                 //request.setAttribute("ErrorMsgs",errorMsgs);
	                
	                 
	                 switch (username.substring(0, 3))
					{
	                 case "ADM" :  
	                	 out.print("logged in as admin");
	                	 rd = request.getRequestDispatcher("/login.jsp") ;
	                 			   break;
	                 case "STR" :  rd = request.getRequestDispatcher("/storemanhome.jsp");
	                 				break;
	                 case "DEL" :  rd = request.getRequestDispatcher("/deliverystaffhome.jsp");
	                 				break;
	                 case "TEC" :  rd = request.getRequestDispatcher("/technicianhome.jsp");
	                 				break;
	                 case "CUS" :  rd = request.getRequestDispatcher("/customerhome.jsp");
	                 				break;
	                 default :  out.print("invalid user id or password");
                	 			rd = request.getRequestDispatcher("/login.jsp") ;
	                 				
    				}
	                 
	                 rd.include(request, response);  
	                 }
	                 
	                
	                 
	            
	           
	    }  catch (Exception ex) {
	    	ex.printStackTrace();
	       }
	    }
	

}
