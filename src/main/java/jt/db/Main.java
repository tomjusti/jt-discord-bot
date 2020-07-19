package jt.db;

import javax.security.auth.login.LoginException;

import jt.db.commands.Embed;
import jt.db.commands.Clear;
import jt.db.commands.RedditPosts;
import jt.db.events.MemberJoin;
import jt.db.events.MemberLeave;
import jt.db.events.MessageReceived;
import jt.db.events.MessageReceived2;
import jt.db.events.ReactionAdd;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;

public class Main {

	public static String prefix = "!";
	
	public static void main(String[] args) throws LoginException {
				
		JDABuilder builder = new JDABuilder();
		builder.setToken("");
		builder.setStatus(OnlineStatus.ONLINE);
		builder.addEventListeners(new Clear());
		builder.addEventListeners(new Embed());
		builder.addEventListeners(new RedditPosts());
		builder.addEventListeners(new MemberJoin());
		builder.addEventListeners(new MemberLeave());
		builder.addEventListeners(new MessageReceived());
		builder.addEventListeners(new MessageReceived2());
		builder.addEventListeners(new ReactionAdd());
        builder.build();
		
	}
}