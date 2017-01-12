import java.sql.*;

public class JDBC_0600_BatchTest
{

	public static void main(String[] args) throws Exception
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
		/*
		 * Statement stmt = conn.createStatement();
		 * stmt.addBatch("insert into dept2 values (51, '500', 'haha')");
		 * stmt.addBatch("insert into dept2 values (52, '500', 'haha')");
		 * stmt.addBatch("insert into dept2 values (53, '500', 'haha')");
		 * stmt.executeBatch(); stmt.close();
		 */

		PreparedStatement ps = conn
				.prepareStatement("insert into dept2 values (?, ?, ?)");
		ps.setInt(1, 61);
		ps.setString(2, "haha");
		ps.setString(3, "bj");
		ps.addBatch();

		ps.setInt(1, 62);
		ps.setString(2, "haha");
		ps.setString(3, "bj");
		ps.addBatch();

		ps.setInt(1, 63);
		ps.setString(2, "haha");
		ps.setString(3, "bj");
		ps.addBatch();

		ps.executeBatch();
		ps.close();

		conn.close();

	}

}
