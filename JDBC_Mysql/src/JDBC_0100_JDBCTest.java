import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_0100_JDBCTest
{

	public static void main(String[] args)
	{
		Connection conn = null;
		Statement statement = null;
		ResultSet rs = null;

		try
		{
			Class.forName("com.mysql.jdbc.Driver");

			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/mydata?user=root&password=1111");

			statement = conn.createStatement();

			rs = statement.executeQuery("select * from dept");

			while (rs.next())
			{
				System.out.println(rs.getString("dname"));
				System.out.println(rs.getString("location"));
				System.out.println(rs.getInt("deptno"));
			}
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
				if (null != rs)
					rs.close();
				if (null != statement)
					statement.close();
				if (null != conn)
					conn.close();
			}
			catch (SQLException e2)
			{
				e2.printStackTrace();
			}

		}

	}
}
