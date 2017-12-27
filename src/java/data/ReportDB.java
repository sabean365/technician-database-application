/*
 * ReportDB Java Bean to create reports
 * for technicians to view tech info and open work requests.
 * © December 3, 2017 Sarah Bean
 */
package data;

import business.Tech;
import java.sql.*;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

/**
 *
 * @author Sarah
 */
public class ReportDB {

    /**
     *
     * @param lastName
     * @param firstName
     * @param password
     * @return
     */
    public static Workbook getTechReport(String lastName, String firstName, String password) {

        // create the workbook, its worksheet, and its title row
        Workbook work1 = new HSSFWorkbook();
        Sheet sheet = work1.createSheet("Technician Open Request Report");
        Row row = sheet.createRow(0);
        row.createCell(0).setCellValue("OpenRequests");

        // create the header row
        row = sheet.createRow(2);
        row.createCell(0).setCellValue("LastName");
        row.createCell(1).setCellValue("RequestDate");
        row.createCell(2).setCellValue("CompletionDate");
        row.createCell(3).setCellValue("RequestDescription");
        row.createCell(4).setCellValue("Notes");

        // create the data rows
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        Statement statement = null;
        ResultSet rs = null;
        String query = "SELECT * FROM requests "
                + "WHERE lastName = lName"
                + "compDate = null"
                + "ORDER BY reqDate DESC";
        try {
            statement = conn.createStatement();
            rs = statement.executeQuery(query);
            int i = 3;
            while (rs.next()) {
                row = sheet.createRow(i);
                row.createCell(0).setCellValue(rs.getString("lastName"));
                row.createCell(1).setCellValue(rs.getDate("reqDate"));
                row.createCell(2).setCellValue(rs.getDate("compDate"));
                row.createCell(3).setCellValue(rs.getString("reqDesc"));
                row.createCell(4).setCellValue(rs.getString("notes"));
                i++;
            }
            return work1;
        } catch (SQLException e) {
            System.err.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closeStatement(statement);
            pool.freeConnection(conn);
        }

    }

    /**
     *
     * @param lastName
     * @param firstName
     * @param password
     * @return
     */
    public static Workbook getTechInfo(String lastName, String firstName, String password) {

        // create the workbook, its worksheet, and its title row
        Workbook work2 = new HSSFWorkbook();
        Sheet sheet = work2.createSheet("Technician Info");
        Row row = sheet.createRow(0);
        row.createCell(0).setCellValue("Technician Information");

        // create the header row
        row = sheet.createRow(2);
        row.createCell(0).setCellValue("LastName");
        row.createCell(1).setCellValue("FirstName");
        row.createCell(2).setCellValue("Password");

        // create the data rows
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection con = pool.getConnection();
        Statement statement = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "SELECT * FROM tech "
                + "WHERE lastName = lName"
                + "firstname = fName";
        try {
            statement = con.createStatement();
            ps = con.prepareStatement(query);
            ps.setString(1, "lastName");
            ps.setString(2, "firstName");
            ps.setString(3, "password");
            rs = ps.executeQuery();
            return work2;
        } catch (SQLException e) {
            System.err.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closeStatement(statement);
            pool.freeConnection(con);
        }

    }

}
