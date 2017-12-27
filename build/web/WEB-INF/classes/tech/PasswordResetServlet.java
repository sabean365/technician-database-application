/*
 * PasswordResetServlet to retrieve and manipulate data 
 * from data entered in the PasswordReset.jsp
 * © November 12, 2017 Sarah Bean
 */
package tech;


import business.Tech;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Sarah
 */
public class PasswordResetServlet extends HttpServlet {

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

        String url = "/passwordReset.jsp";

        Tech tech = (Tech) request.getSession().getAttribute("tech");
        if (tech == null) {
            url = "/register.jsp";
            
        } else {
            String message;
            String lName = request.getParameter("lastName");
            String newPword = request.getParameter("newPword");
            String confirmPword = request.getParameter("confirmPword");

            // validate the parameters
            //if some of the parameters are null or empty, display message to fill out all boxes and reload register.jsp
            if (lName == null || newPword == null || confirmPword == null || 
                    lName.isEmpty() || newPword.isEmpty() || confirmPword.isEmpty()) 
            {
                message = "Please fill out all forms.";
                url = "/passwordReset.jsp";
           
                //Check if new and confirm equal each other
            } else if (newPword.equals(confirmPword)) {

                message = "";
                tech.setPassword("newPword");
                url = "/accountActivity.jsp";

                //set password, user and message
                HttpSession session = request.getSession();
                session.setAttribute("tech", tech);
                request.setAttribute("message", message);
            }
            //forward request and response objects to specified URL
        }
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }
}
