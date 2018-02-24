/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ahmedelgawesh
 */
@WebServlet("/OnlineUsers")

public class OnlineUsers extends HttpServlet {

    
    public  static Vector<String> usersList= new Vector<>();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
//                System.out.println("gggg");

    }

    
    
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
//            System.out.println("UUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUU");
        
    }
  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        
//        System.out.println("classes.OnlineUsers.doPost()ssssssssssssssssssssssssssssssssssssssss");
        if(!usersList.isEmpty())
        {
        for(String str : usersList){
//            System.out.println(str+"jjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj");
        }
        //System.out.println("classes.OnlineUsers.doPost()"+usersList);
         //System.out.println(usersList);
        Gson gson= new Gson();
        PrintWriter out = response.getWriter();
        out.println(gson.toJson(usersList));
//       System.out.println("classes.OnlineUsers.doPost()"+usersList+"*222*");
        }
    }


}
