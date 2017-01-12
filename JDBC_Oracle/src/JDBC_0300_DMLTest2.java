import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_0300_DMLTest2
{

	public static void main(String[] args)
	{
		Statement stmt = null;
		Connection conn = null;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// new oracle.jdbc.driver.OracleDriver();
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
			stmt = conn.createStatement();
			String sql = "insert into dept2 values (" + args[0] + ", '" + args[1] + "', '" + args[2] + "')";
			stmt.executeUpdate(sql);
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if (stmt != null)
				{
					stmt.close();
					stmt = null;
				}
				if (conn != null)
				{
					conn.close();
					conn = null;
				}
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
	}

}
