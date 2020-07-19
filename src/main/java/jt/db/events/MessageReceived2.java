package jt.db.events;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class MessageReceived2 extends ListenerAdapter {

	public void messageReceived(GuildMessageReceivedEvent event) {

		String[] args = event.getMessage().getContentRaw().split("\\s+");

		if (args[0].equalsIgnoreCase("~mute")) {

			if (args.length > 1 && args.length < 3) {

				Member member = event.getGuild().getMemberById(args[1].replace("<@", "").replace(">", ""));
				Role role = event.getGuild().getRoleById("");

				if (!member.getRoles().contains(role)) {

					event.getChannel().sendMessage("Muted " + args[1] + ".").queue();
					event.getGuild().modifyMemberRoles(event.getMember(), event.getGuild().getRolesByName("Muted", true)).complete();

				}

				else {

					event.getChannel().sendMessage("Unmuted " + args[1] + ".").queue();
					event.getGuild().modifyMemberRoles(event.getMember(), event.getGuild().getRolesByName("Muted", false)).complete();

				}
			}

			else {

				event.getChannel().sendMessage("Incorrect syntax! Use `!mute [user mention] [time {optional}]`.");

			}
		}
	}
}