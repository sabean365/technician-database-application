/*
 * Login Servlet to check username and password from login page
 * © November 25, 2017 Sarah Bean
 */
package tech;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import business.Tech;
import data.TechDB;

/**
 *
 * @author Sarah
 */
public class LoginServlet extends HttpServlet {

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        //instance of url & message
        String url = "";
        String message = "";

        // get current action
        String action = request.getParameter("action");
        if (action == null) {
            action = "join";
            
        }
        // stay on page
        if (action.equals("join")) {
            url = "/index.jsp";    // the "join" page
        } else if (action.equals("add")) {
            // get login parameters from the request
            String lastName = request.getParameter("lastName");
            String firstName = request.getParameter("firstName");
            String password = request.getParameter("password");

            Tech tech = new Tech(lastName, firstName, password);

            //Compare instance with db to see if tech exists in db
            if (TechDB.techExists(lastName, firstName, password)) {
                //direct to the accountActivity page
                url = "/accountActivity.jsp";
            } else {
                message = "You must register to view open files.";
                url = "/register.jsp";
            }
            request.setAttribute("tech", tech);
            request.setAttribute("message", message);
            getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
        }
        
    }

}
