package jt.db.events;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class MessageReceived extends ListenerAdapter {

	public void messageReceived(GuildMessageReceivedEvent event) {
		
		event.getMessage().addReaction("").queue();
		
	}
}