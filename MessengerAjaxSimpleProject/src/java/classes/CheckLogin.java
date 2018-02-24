/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ahmedelgawesh
 */
@WebServlet("/CheckLogin")
public class CheckLogin extends HttpServlet 
{
    
    
    Users us;
    Vector<Users> users=new Vector<>();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
        {

        }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
                   response.setContentType("text/html;charset=UTF-8");
                   PrintWriter out = response.getWriter();
                            us=new Users();
                            us.setterUsrName(request.getParameter("lUsr"));
                            us.setterUsrPassword(request.getParameter("lPass"));
                            users.add(us);
                            response.sendRedirect("index.jsp");
                         

                    
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
               PrintWriter out = response.getWriter();
               String usr =  request.getParameter("rUsr");
               String pass =  request.getParameter("rPass");
               int count=0;
               
               for(Users e: users)
                {
                      if(usr.equals(e.getterUsrName()) && pass.equals(e.getterUsrPassword()))
                      {        
                         // out.println(e.getterUsrName()+" "+e.getterUsrPassword()); 
                          count++;      
                      }
                      
                }  
               if(count == 0 )
               {
                   //out.print("noooooooooooooooooooooooo");
                 response.sendRedirect("index.jsp");
                 
               }
               else
               {
                   
                   request.getSession().setAttribute("mySession", us);
//                   RequestDispatcher rd=  request.getRequestDispatcher("home.jsp");
//                   rd.forward(request, response);
                   response.sendRedirect("home.jsp");
                    //out.print("yesssssssssssssssssssssssss");
                    String onLineUsrs= new String(us.getterUsrName());
                    OnlineUsers.usersList.add(onLineUsrs);
//                    System.out.println("CheckLogin.doPost()"+onLineUsrs);

//                    System.out.println("teseeeeeeeeeeeeeeeeeesr"+OnlineUsers.usersList);
                    
               }
    
    }

    
   

}
