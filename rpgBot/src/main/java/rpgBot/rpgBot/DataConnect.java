package rpgBot.rpgBot;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import util.STATIC;

public class DataConnect
{
	protected static Connection connection;

	public static void openDB()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connection = DriverManager.getConnection("jdbc:mysql://" + STATIC.MYSQLCON);
		}
		catch (InstantiationException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IllegalAccessException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void closeDB()
	{
		try
		{
			connection.close();
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static ResultSet extractData(String query) throws Exception
	{
		Statement stm = connection.createStatement();
		ResultSet rset = stm.executeQuery(query);

		return rset;
	}

	public static long safeData(String query) throws Exception
	{
		long result = 0;
		Statement stm = connection.createStatement();
		stm.executeUpdate(query);
		ResultSet help = stm.getGeneratedKeys();

		if (help != null)
		{
			result = help.getLong(0);
		}

		return result;
	}
}
