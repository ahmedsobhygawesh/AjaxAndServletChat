
<%@page import="java.util.Date"%>
<%@page import="classes.Users"%>
<%@page import="java.io.PrintWriter"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<Link rel=stylesheet href="css/reg_style.css" type="text/css">
<html>
        <%
            PrintWriter o= response.getWriter();
            Users us = (Users)request.getSession().getAttribute("mySession");
            if(us==null)
            {
                response.sendRedirect("index.jsp");
            }
            else
            {
                
                  o.print("<h1 style='font-size:30px;color:darkblue;margin-left:640px'>Welcome For you "+us.getterUsrName()+"</h1>");

            }
        %>    
    
    <script  src="lib/jquery-1.4.4.min.js"></script>
    <script>
        function refresh() {
            $.ajax({
                url: 'MessagesSaver',
                type: 'POST',
                contentType: 'application/json',
                dataType: 'json',
                success: function (val) {
                    var messages = val;
                    $("#myMessage").value=" ";
                    $("#displayMessages tr").remove();
                    for (var i = 0; i < val.length; i++) {
                        $('#displayMessages').append('<tr class="tr" ><td>' + messages[i].messageContent + '</td > </tr>');
                    }
                }
            });
            
            
            
                 $.ajax
                 ({
                    url: 'OnlineUsers',
                    type: 'POST',
                    contentType: 'application/json',
                    dataType: 'json',
                    success: function (data)
                    {
                        var usersOnline = data;
                        $("#onlineDiv label").remove();
                        $("#onlineDiv br").remove();

                        for (var i = 0; i < usersOnline.length; i++)
                        {
                            $('#onlineDiv').append('<label>'+usersOnline[i]+'</label>');
                            $('#onlineDiv').append('<br>');
                            //$('#onlineDiv').value(messages[i]);
                        }
                        
                    }
                 });
            
        }
        
        /**********************************************************************************/

        $("document").ready(function ()
        {
            $("#sendBtn").click(function () 
            {
                    var myMessage = $("#myMessage").val();
                    var jsonData = {"myMessage": myMessage};
                    $.ajax({url: 'MessagesSaver',
                    type: 'GET', //servlet request type
                    contentType: 'application/json', //For input type
                    data: jsonData, //input data
                    dataType: 'json', //For output type
                    success: function (data)
                    {
                        
                       //$("#myMessage").value(data);   
                       $("#myMessage").val("");   
                    }
                });
            });
        });
    </script>
   
    
    
    
    
    
    
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ChatRoom</title>
    </head>
    <form style="float: right" action="logout" method="post">
    <input type="submit" value="Logout" />
    
</form>
    <A href="index.jsp" >Log Out</A>
    <body onload="setInterval('refresh()',2000)">
      
    <center>
        <br>
        <LABEL style="float: left">Message :</LABEL> <input style="float: left" type="text" value="" name="myMessage" id="myMessage"/>
        <br><br>
        <input  type="button" value="Send" id="sendBtn" style="float: left;width: 100px;height: 30px;background-color: wheat;margin-left: 64px"/>
        <br><br><br><br>
        <div>
            <TABLE border="1">
                <TR>                
                    <TH>MESSAGE</TH>
                    <tbody id="displayMessages"></TBODY>
                </TR>
            </TABLE>
        </DIV>
    </CENTER>
    
    
    <DIV id="onlineDiv" style="float: right">  
        <h1 style="font-style:initial;font-family: fantasy;font: bold">Online Users</h1>        
    
    </DIV>
    
    
</body>
</html>
