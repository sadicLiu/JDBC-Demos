import java.sql.*;

public class JDBC_0500_ProcedureTest
{

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception
	{

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:orcl", "scott", "tiger");
		CallableStatement cstmt = conn.prepareCall("{call p(?, ?, ?, ?)}");
		cstmt.registerOutParameter(3, Types.INTEGER);
		cstmt.registerOutParameter(4, Types.INTEGER);
		cstmt.setInt(1, 3);
		cstmt.setInt(2, 4);
		cstmt.setInt(4, 5);
		cstmt.execute();
		System.out.println(cstmt.getInt(3));
		System.out.println(cstmt.getInt(4));
		cstmt.close();
		conn.close();
	}

}
