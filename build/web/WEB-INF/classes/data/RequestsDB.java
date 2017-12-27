/*
 * RequestsDB Java Bean to query the database about work requests.
 * © December 3, 2017 Sarah Bean
 */
package data;

import java.sql.*;
import java.util.ArrayList;
import business.NewRequests;

/**
 *
 * @author Sarah
 */
public class RequestsDB {

    /**
     *
     * @param req
     * @return
     */
    public static int insert(NewRequests req) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query
                = "INSERT INTO requests (lastName, reqDate, compDate, reqDesc, notes) "
                + "VALUES (?, ?, ?, ?, ?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, req.getLastName());
            ps.setDate(2, req.getReqDate());
            ps.setDate(3, req.getCompDate());
            ps.setString(4, req.getReqDesc());
            ps.setString(5, req.getNotes());
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
     * @param req
     * @return
     */
    public static int update(NewRequests req) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query = "UPDATE requests SET "
                + "reqDate = ? "
                + "compDate = ? "
                + "reqDesc = ?"
                + "notes = ?"
                + "WHERE lastName = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, req.getLastName());
            ps.setDate(2, req.getReqDate());
            ps.setDate(3, req.getCompDate());
            ps.setString(4, req.getReqDesc());
            ps.setString(5, req.getNotes());
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
     * @return
     */
    public static NewRequests selectRequests(String lastName) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT * FROM requests "
                + "WHERE lastName = ?" + "compDate = null";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, lastName);
            rs = ps.executeQuery();
            NewRequests req = null;
            while (rs.next()) {
                req = new NewRequests();
                req.setLastName(rs.getString("lastName"));
                req.setReqDate(rs.getDate("reqDate"));
                req.setCompDate(rs.getDate("compDate"));
                req.setReqDesc(rs.getString("reqDesc"));
                req.setNotes(rs.getString("notes"));
            }
            return req;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    /**
     *
     * @param lastName
     * @param compDate
     * @return
     */
    public static ArrayList<NewRequests> selectOpenRequests(String lastName, Date compDate) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT * FROM requests "
                + "WHERE lastName = ?" + "compDate = null";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, lastName);
            ps.setDate(2, compDate);
            rs = ps.executeQuery();
            ArrayList<NewRequests> reqs = new ArrayList<>();
            while (rs.next()) {
                NewRequests req = new NewRequests();
                req.setLastName(rs.getString("lastName"));
                req.setReqDate(rs.getDate("reqDate"));
                req.setCompDate(rs.getDate("compDate"));
                req.setReqDesc(rs.getString("reqDesc"));
                req.setNotes(rs.getString("notes"));
            }
            return reqs;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
}
