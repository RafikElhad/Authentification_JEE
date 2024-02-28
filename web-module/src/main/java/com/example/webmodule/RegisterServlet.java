package com.example.webmodule;


import com.example.ejbmodule.entities.UserEntity;
import com.example.ejbmodule.pojos.User;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name="registerServlet" ,value = "/registerServlet")
public class RegisterServlet extends HttpServlet{

    @EJB
    private User user;
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        // Hello
//        PrintWriter out = response.getWriter();
//        out.println("<html><body>");
//        out.println("<h1>" + message + "</h1>");
//        out.println("</body></html>");
        this.getServletContext().getRequestDispatcher("/register.jsp").forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");

        UserEntity user = new UserEntity();
        user.setUsername(email);
        user.setPassword(password);
        this.user.addUser(user);



        response.sendRedirect(request.getContextPath() + "/loginServlet");

    }

    public void destroy() {
    }
}
