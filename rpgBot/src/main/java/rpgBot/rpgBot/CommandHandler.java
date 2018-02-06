package rpgBot.rpgBot;


import java.util.HashMap;
import commands.Command;


public class CommandHandler
{

	public static final CommandParser parse = new CommandParser();

	public static HashMap<String, Command> commands = new HashMap<String, Command>();


	public static void handleCommand(CommandParser.commandContainer cmd)
	{
		System.out.println(cmd.invoke);
		if (commands.containsKey(cmd.invoke))
		{
			boolean safe = true;

			safe = commands.get(cmd.invoke).called(cmd.args, cmd.event);

			if (!safe)
			{
				commands.get(cmd.invoke).action(cmd.args, cmd.event);
				commands.get(cmd.invoke).executed(safe, cmd.event);
			}
			else
			{
				commands.get(cmd.invoke).executed(safe, cmd.event);
			}
		}
		else
		{
			System.out.println("Not in the table");
		}
	}
}
