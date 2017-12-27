/*
 * Class to make changes to the tech database.
 * © December 3, 2017 Sarah Bean
 */
package data;

import java.sql.*;
import business.Tech;

/**
 *
 * @author Sarah
 */
public class TechDB {

    /**
     *
     * @param tech
     * @return
     */
    public static int insert(Tech tech) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query
                = "INSERT INTO tech (lastName, firstName, password) "
                + "VALUES (?, ?, ?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, tech.getLastName());
            ps.setString(2, tech.getFirstName());
            ps.setString(3, tech.getPassword());
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    /**
     *
     * @param tech
     * @return
     */
    public static int update(Tech tech) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query = "UPDATE tech SET "
                + "firstName = ? "
                + "password = ? "
                + "WHERE lastName = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, tech.getLastName());
            ps.setString(2, tech.getFirstName());
            ps.setString(3, tech.getPassword());
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    /**
     *
     * @param tech
     * @return
     */
    public static int delete(Tech tech) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query = "DELETE FROM tech WHERE lastName = ? "
                + "firstName = ? "
                + "password = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, tech.getLastName());
            ps.setString(2, tech.getFirstName());
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    /**
     *
     * @param lastName
     * @param firstName
     * @param password
     * @return
     */
    public static boolean techExists(String lastName, String firstName, String password) {
        boolean st = false;
        try {
            //creating connection with the database 
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/techtracker", "root", "sesame");
            String query = "SELECT * FROM tech " + 
                    "WHERE lastName = ? "
                    + "password = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, lastName);
            ps.setString(2, firstName);
            ps.setString(3, password);
            ResultSet rs = ps.executeQuery();
            st = rs.next();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return st;
    }

    /**
     *
     * @param lastName=lastName of tech
     * @param firstName=firstName of tech
     * @return password
     */
    public static String getPasswordDB(String lastName, String firstName) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection c = pool.getConnection();
        PreparedStatement p = null;
        ResultSet r = null;
        String q = "SELECT password FROM tech "
                + "WHERE lastName = ?" + "firstName = ?";
        try {
            p = c.prepareStatement(q);
            p.setString(1, lastName);
            p.setString(2, firstName);
            r = p.executeQuery();
            return r.getString("password");
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            DBUtil.closeResultSet(r);
            DBUtil.closePreparedStatement(p);
            pool.freeConnection(c);
        }
        return ("password");

    }
}
