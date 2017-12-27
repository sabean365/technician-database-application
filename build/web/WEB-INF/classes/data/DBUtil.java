/*
 * This is a Java Bean containing close methods for statements from the db.
 * © Sarah Bean 12/3/2017 - DBUtil file using JPA
 */
package data;

import java.sql.*;

/**
 *
 * @author Sarah
 */
public class DBUtil {

    /**
     *
     * @param s
     */
    public static void closeStatement(Statement s) {
        try {
            if (s != null) {
                s.close();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    /**
     *
     * @param ps
     */
    public static void closePreparedStatement(Statement ps) {
        try {
            if (ps != null) {
                ps.close();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    /**
     *
     * @param rs
     */
    public static void closeResultSet(ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
