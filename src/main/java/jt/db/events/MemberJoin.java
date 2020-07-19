package jt.db.events;

import java.util.Random;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class MemberJoin extends ListenerAdapter {

	String[] messages = {
				
				"You are now a member of The Blue Table, [member]!",
				"Welcome to The Blue Table, [member]!"
				
		};
	
	public void memberJoin(GuildMemberJoinEvent event) {
		
		Random rand = new Random();
		int number = rand.nextInt(messages.length);
		EmbedBuilder join = new EmbedBuilder();
		join.setColor(0x66d8ff);
		join.setDescription(messages[number].replace("[member]", event.getMember().getAsMention()));
		event.getGuild().getDefaultChannel().sendMessage(join.build()).queue();
		event.getGuild().modifyMemberRoles(event.getMember(), event.getGuild().getRolesByName("Friend", true)).complete();
		
	}
}