package com.example.pro_attempt_1;

import com.example.pro_attempt_1.models.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/chat")
public class chat extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        System.out.println("in chat");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HttpSession httpSession =request.getSession(true);
        User user = (User) request.getSession().getAttribute("user");
        String username = user.getUsername();
        httpSession.setAttribute("username", username);
        if (username !=null) {
            RequestDispatcher rd = request.getRequestDispatcher("/pages/chatjsp.jsp");
            rd.forward(request, response);
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("    <title>Zane Academy WebSocketPrj13</title>");
//            out.println("    <script>");
//            out.println("        var websocket = new WebSocket(\"ws://${pageContext.request.contextPath}/EndPointTest\");");
//            out.println("");
//            out.println("        websocket.onmessage = function processMessage(message) {");
//            out.println("            var jsonData = JSON.parse(message.data);");
//            out.println("            if (jsonData.message != null) document.getElementById(\"messages TextArea\").value += jsonData.message + \"\\n\";");
//            out.println("        }");
//            out.println("");
//            out.println("        function sendMessage() {");
//            out.println("            websocket.send(document.getElementById(\"messageText\").value);");
//            out.println("            document.getElementById(\"messageText\").value = \"\";");
//            out.println("        }");
//            out.println("    </script>");
//            out.println("</head>");
//            out.println("<body>");
//            out.println("    <mark>username: ohm</mark><br>");
//            out.println("    <textarea id=\"messages TextArea\" readonly=\"readonly\" rows=\"10\" cols=\"45\"></textarea><br/>");
//            out.println("    <input type=\"text\" id=\"messageText\" size=\"50\" /><input type=\"button\" value=\"Send\" onclick=\"sendMessage();\" />");
//            out.println("</body>");
//            out.println("</html>");
        }
    }
}
