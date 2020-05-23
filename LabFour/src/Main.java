import dataBase.DataBase;
import java.sql.*;

public class MyAppFour
{
	public static void main(String[] args) throws SQLException
	{
		Connection conn = null;
		Statement stmt = null;
        String command;
        DatabaseMetaData metaData;
        ResultSet res;

		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/javaDataBase?autoReconnect=true&useSSL=false",
					"root",
					"");
		}
		catch (SQLException se)
		{
			se.printStackTrace();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		if (conn == null)
		{
			System.out.println("No connection with database!");
			System.exit(0);
		}

		stmt = conn.createStatement();
        metaData = conn.getMetaData();

        res = metaData.getTables(null, null, "products", new String[] {"TABLE"});
        if (res.next())
        {
            command = "TRUNCATE TABLE products";
            stmt.executeUpdate(command);
        }
        else
        {
            command = "CREATE TABLE products(" +
                    "id INT NOT NULL, " +
                    "prodid INT NOT NULL, " +
                    "title VARCHAR(128) NOT NULL, " +
                    "cost INT NOT NULL);";
            stmt.executeUpdate(command);
        }

        DataBase dataBase = new DataBase(conn, stmt);
        dataBase.serverServiceProc();

        dataBase = null;

		if (conn != null)
		{
			try
			{
				conn.close();
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
}
