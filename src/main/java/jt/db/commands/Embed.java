package jt.db.commands;

import jt.db.Main;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Embed extends ListenerAdapter {

	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		
		String[] args = event.getMessage().getContentRaw().split("\\s+");
		
		if (args[0].equalsIgnoreCase(Main.prefix + "cdc")) {
			
			EmbedBuilder info = new EmbedBuilder();
			info.setTitle("COVID-19 Information", "https://www.cdc.gov/coronavirus/2019-ncov/index.html");
			info.setDescription("Get the latest information from the CDC about COVID-19.");
			info.setColor(0x007C91);
			event.getChannel().sendTyping().queue();
			event.getChannel().sendMessage(info.build()).queue();
			
		}
	}
}