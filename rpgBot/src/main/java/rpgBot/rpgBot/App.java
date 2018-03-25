package rpgBot.rpgBot;

import javax.security.auth.login.LoginException;
import commands.CmdAddGrpMembers;
import commands.CmdCreateRPG;
import commands.CmdRollDiceEight;
import commands.CmdRollDiceFour;
import commands.CmdRollDiceHundred;
import commands.CmdRollDiceSix;
import commands.CmdRollDiceTen;
import commands.CmdRollDiceTwelve;
import commands.CmdRollDiceTwenty;
import commands.CmdStartPrivateConv;
import commands.CmdStartTheRPG;
import conversations.TestConvs;
import listeners.CommandListener;
import listeners.PrivateConversationListener;
import listeners.ReadyListener;
import listeners.ReconnectedListener;
import listeners.ShutdownListener;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.OnlineStatus;
import util.Secrets;

public class App
{

	public static JDABuilder builder;

	public static void main(String[] args)
	{
		JDA jda = null;

		builder = new JDABuilder(AccountType.BOT);
		builder.setToken(Secrets.token);
		builder.setAutoReconnect(true);
		builder.setStatus(OnlineStatus.ONLINE);

		addListeners();
		addCommands();
		addConversations();

		try
		{
			jda = builder.buildBlocking();
		}
		catch (LoginException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IllegalArgumentException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// catch (RateLimitedException e)
		// {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
	}

	public static void addCommands()
	{
		CommandHandler.commands.put("w6", new CmdRollDiceSix());

		CommandHandler.commands.put("w4", new CmdRollDiceFour());

		CommandHandler.commands.put("w10", new CmdRollDiceTen());

		CommandHandler.commands.put("w8", new CmdRollDiceEight());

		CommandHandler.commands.put("w12", new CmdRollDiceTwelve());

		CommandHandler.commands.put("w20", new CmdRollDiceTwenty());

		CommandHandler.commands.put("w100", new CmdRollDiceHundred());

		CommandHandler.commands.put("with", new CmdAddGrpMembers());

		CommandHandler.commands.put("startrpg", new CmdCreateRPG());

		CommandHandler.commands.put("go", new CmdStartTheRPG());

		// CommandHandler.commands.put("createCharacter", new
		// CmdCreateACharacter());

		CommandHandler.commands.put("hey", new CmdStartPrivateConv());
	}

	public static void addConversations()
	{
		PrivateConversationHandler.convs.put("test", new TestConvs());
	}

	private static void addListeners()
	{
		builder.addEventListener(new ReadyListener());
		builder.addEventListener(new CommandListener());
		builder.addEventListener(new ShutdownListener());
		builder.addEventListener(new ReconnectedListener());
		builder.addEventListener(new PrivateConversationListener());
		/**
		 * TODO: fehler, den ich mit herr wolf gesucht hab (war aber nicht die
		 * lösung des problems)
		 */
	}

}
