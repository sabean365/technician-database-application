/*
 * This servlet allows a new technician to register.
 * © November 26, 2017 Sarah Bean
 */
package tech;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import business.*;
import data.*;

//Declare class

/**
 *
 * @author Sarah
 */
public class RegisterServlet extends HttpServlet {

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
        //default url
        String url = "/register.jsp";

        // get current action
        String action = request.getParameter("action");
        if (action.equals("add")) {
            // get parameters from the request

            String lName = request.getParameter("lastName");
            String fName = request.getParameter("firstName");
            String pWord = request.getParameter("password");

            //Declare user object
            Tech tech = new Tech();

            //Set Tech
            tech.setLastName(lName);
            tech.setFirstName(fName);
            tech.setPassword(pWord);

            // validate the parameters
            String message;
            if (!TechDB.techExists(lName, fName, pWord)) {

                try {
                    TechDB.insert(tech);
                } catch (Exception ex) {
                    System.out.print(ex.getMessage());
                }
                message = "";
                url = "/accountActivity.jsp";

            } else {
                message = "This technician is already registered. Please try again.";
                url = "/register.jsp";
            }

            //set Tech object in request; set message in request
            HttpSession actualSession = request.getSession();
            actualSession.setAttribute("tech", tech);
            actualSession.setAttribute("message", message);
        }
        //forward request and response objects to specified URL
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }

}
