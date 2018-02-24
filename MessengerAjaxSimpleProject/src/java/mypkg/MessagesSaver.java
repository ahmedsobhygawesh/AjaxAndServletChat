
package mypkg;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mypkg.MyMessage;


/**
 *
 * @author ahmedelgawesh
 */

@WebServlet("/MessagesSaver")

public class MessagesSaver extends HttpServlet
{

    static ArrayList<MyMessage> messages = new ArrayList();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException 
    {
//        String sender = request.getParameter("myName");
        String messageBody = request.getParameter("myMessage");
        if(!messageBody.equals(""))
        {
            MyMessage msg = new MyMessage(messageBody);
            messages.add(msg); 
          //    System.out.println("sender:"+sender);
//           System.out.println("message:"+messageBody);
        }      
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        Gson gson= new Gson();
        PrintWriter out = response.getWriter();
        out.println(gson.toJson(messages));
    }

}
