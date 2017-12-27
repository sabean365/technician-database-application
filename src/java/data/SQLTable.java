/**
 * This Java Bean generates an HTML Table
 * from data in the mySql database.
 * © November 26, 2017 author Sarah Bean
 */
package data;

import java.sql.*;

/**
 *
 * @author Sarah
 */
public class SQLTable {

    /**
     *
     * @param results
     * @return
     * @throws SQLException
     */
    public static String getHtmlTable(ResultSet results)
            throws SQLException {
        StringBuilder htmlTable = new StringBuilder();
        ResultSetMetaData metaData = results.getMetaData();
        int columnCount = metaData.getColumnCount();

        htmlTable.append("<table>");

        // add header row
        htmlTable.append("<tr>");
        for (int i = 1; i <= columnCount; i++) {
            htmlTable.append("<th>");
            htmlTable.append(metaData.getColumnName(i));
            htmlTable.append("</th>");
        }
        htmlTable.append("</tr>");

        // add all other rows
        while (results.next()) {
            htmlTable.append("<tr>");
            for (int i = 1; i <= columnCount; i++) {
                htmlTable.append("<td>");
                htmlTable.append(results.getString(i));
                htmlTable.append("</td>");
            }
            htmlTable.append("</tr>");
        }

        htmlTable.append("</table>");
        return htmlTable.toString();
    }
}
