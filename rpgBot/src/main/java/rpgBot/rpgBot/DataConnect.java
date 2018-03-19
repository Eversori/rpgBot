package rpgBot.rpgBot;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
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

	public static Object safeData(String query) throws Exception
	{

		return 0;
	}

}
