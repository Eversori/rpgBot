package rpgBot.rpgBot;


import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;


public class DataConnect
{
	private static BufferedWriter out = null;


	public static BufferedWriter getOut()
	{
		if (out == null)
		{
			try
			{
				out = Files.newBufferedWriter(Paths.get("Output"), StandardOpenOption.DELETE_ON_CLOSE,
						StandardOpenOption.APPEND, StandardOpenOption.CREATE);
				// out = Files.newBufferedWriter(Paths.get("Output"), StandardOpenOption.APPEND,
				// StandardOpenOption.CREATE);
				System.out.println("Writer open");
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}

		return out;
	}

	public static void writeDoc(String s)
	{
		try
		{
			out.write(s);
			out.newLine();
			out.flush();
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void closeWriter()
	{
		if (out != null)
		{
			try
			{
				out.close();
				out = null;
				System.out.println("Writer closed");
			}
			catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void openDB()
	{

	}

	public static void safeData()
	{

	}

	public static void closeDB()
	{

	}

}
