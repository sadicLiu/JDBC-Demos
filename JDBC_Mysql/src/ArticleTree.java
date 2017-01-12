import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 * Î´Íê³É
 */
public class ArticleTree
{
	public static void main(String[] args)
	{

	}
	
	public void show()
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
			
			rs = statement.executeQuery("select * from article where pid = 0");
			
			while(rs.next())
			{
				System.out.println(rs.getString("cont"));
				tree(conn,rs.getInt("id"), 1);
				
			}
		}
		catch (SQLException | ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if (rs != null)
				{
					rs.close();
					rs = null;
				}
				
				if(statement != null)
				{
					statement.close();
					statement = null;
				}
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
	}

	private void tree(Connection conn, int id, int level)
	{
		Statement statement = null;
		ResultSet rs = null;
		
		try
		{
			statement = conn.createStatement();
			String sql = "select * from article where pid = " + id;
			rs = statement.executeQuery(sql);
			
			while(rs.next())
			{
				System.out.println(rs.getString("cont"));
				tree(conn, rs.getInt("id"), level + 1);
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if (rs != null)
				{
					rs.close();
					rs = null;
				}
				
				if(statement != null)
				{
					statement.close();
					statement = null;
				}
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}

	}
}
