package com.example.webmodule;


import com.example.ejbmodule.entities.UserEntity;
import com.example.ejbmodule.pojos.User;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name="loginServlet", value = "/loginServlet")
public class LoginServlet extends HttpServlet {
    @EJB
    private User user;


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        this.getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);

//        // Hello
//        PrintWriter out = response.getWriter();
//        out.println("<html><body>");
//        out.println("<h1>" + message + "</h1>");
//        out.println("</body></html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        UserEntity user = this.user.getUser(password, email);

        if (user != null) {
            HttpSession session = request.getSession(true);
            session.setAttribute("user", user);

            response.sendRedirect(request.getContextPath() +"/todoServlet");
        } else {
            response.sendRedirect(request.getContextPath() +"/loginServlet");
        }

    }

    public void destroy() {
    }

}
