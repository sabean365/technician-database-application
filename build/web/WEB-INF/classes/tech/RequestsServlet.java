/*
 * This servlet allows a technician to view reports.
 * © December 1, 2017 Sarah Bean
 */
package tech;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import data.*;

/**
 *
 * @author Sarah
 */
public class RequestsServlet extends HttpServlet {

    /**
     *
     * @param request
     * @param response
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {
        
        String url = "";

        String rName = request.getParameter("reportName");
        String lName = (String) request.getSession().getAttribute("lastName");
        String fName = (String) request.getSession().getAttribute("firstName");
        String pWord = (String) request.getSession().getAttribute("password");

        if ("getTechReport".equalsIgnoreCase(rName)) {
            ReportDB.getTechReport(lName, fName, pWord);

        } else if ("getTechInfo".equalsIgnoreCase(rName)) {
            ReportDB.getTechInfo(lName, fName, pWord);

        }
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }

}
