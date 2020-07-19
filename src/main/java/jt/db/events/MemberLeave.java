package jt.db.events;

import java.util.Random;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.guild.member.GuildMemberLeaveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class MemberLeave extends ListenerAdapter {
	
	String[] messages = {
			
			"You stink, [member]!",
			"[member] is not cool enough to be with The Blue Table!"
			
	};
	
	public void memberLeave (GuildMemberLeaveEvent event) {
		
		Random rand = new Random();
		int number = rand.nextInt(messages.length);
		EmbedBuilder leave = new EmbedBuilder();
		leave.setColor(0xf48342);
		leave.setDescription(messages[number].replace("[member]", event.getMember().getAsMention()));
		event.getGuild().getDefaultChannel().sendMessage(leave.build()).queue();
		
	}
}