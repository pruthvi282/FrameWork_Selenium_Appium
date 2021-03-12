package generic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class JDBCutility {
	static Connection con = null;
	static ResultSet result = null;

	/**
	 * connecting to database
	 * @throws Throwable
	 */
	public void connectToDB() throws Throwable {
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruthvi", "root", "root");
	}
	/**
	 * closing database connection
	 * @throws SQLException
	 */
	public void closeDb() throws SQLException {
		con.close();
	}
    /**
     * execut a query
     * @param query
     * @return
     * @throws Throwable
     */
	public static ResultSet execyteQuery(String query) throws Throwable {
		// executing the query
		result = con.createStatement().executeQuery(query);
		return result;
	}
	
	/**
	 * execute the query and get the data 
	 * @param query
	 * @param columnName
	 * @param expectedData
	 * @return
	 * @throws Throwable
	 */
	public static String executeQueryAndGetData(String query, int columnName, String expectedData) throws Throwable {
		boolean flag = false;
		result = con.createStatement().executeQuery(query);

		while (result.next()) {
			if (result.getString(columnName).equals(expectedData)) {
				flag = true;
				break;
			}
		}

		if (flag) {
			System.out.println(expectedData + "===> data verified in data base table");
			return expectedData;
		} else {
			System.out.println(columnName + "===> data not verified in data base table");
			return expectedData;
		}

	}

}
