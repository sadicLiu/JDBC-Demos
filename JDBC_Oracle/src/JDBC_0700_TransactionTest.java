import java.sql.*;

public class JDBC_0700_TransactionTest
{

	public static void main(String[] args)
	{

		Connection conn = null;
		Statement stmt = null;

		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");

			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			stmt.addBatch("insert into dept2 values (51, '500', 'haha')");
			stmt.addBatch("insert into dept2 values (52, '500', 'haha')");
			stmt.addBatch("insert into dept2 values (53, '500', 'haha')");
			stmt.executeBatch();
			conn.commit();
			conn.setAutoCommit(true);
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (SQLException e)
		{

			e.printStackTrace();

			try
			{
				if (conn != null)
				{
					conn.rollback();
					conn.setAutoCommit(true);
				}
			}
			catch (SQLException e1)
			{
				e1.printStackTrace();
			}
		}
		finally
		{
			try
			{
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}

	}

}
