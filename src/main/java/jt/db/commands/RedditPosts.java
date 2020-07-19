package jt.db.commands;

import java.util.List;

import jt.db.Main;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import redditjackal.entities.Post;
import redditjackal.entities.Reddit;
import redditjackal.entities.Subreddit;
import redditjackal.exceptions.RedditorNotFoundException;
import redditjackal.exceptions.WrongCredentialsException;

public class RedditPosts extends ListenerAdapter {

	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		
		Reddit reddit = null;
		
		try {
			
			reddit = new Reddit("username", "password", "appId", "appSecret");
		
		}
		
		catch (WrongCredentialsException e) {
			
			e.printStackTrace();
			
		}
		
		Subreddit Coronavirus = reddit.getSubreddit("Coronavirus");
		System.out.println(Coronavirus.getDescription());
		Coronavirus.postHistory().updateHot(10);
		List<Post> posts = Coronavirus.postHistory().getHotPosts();
		
		String[] args = event.getMessage().getContentRaw().split("\\s+");
		
		if (args[0].equalsIgnoreCase(Main.prefix + "reddit")) {
			
			event.getChannel().sendTyping().queue();

			for (Post post : posts) {
				
				event.getChannel().sendMessage("Here is the latest information from the Coronavirus subreddit about COVID-19.").queue();
				event.getChannel().sendMessage(post.getTitle()).queue();
				event.getChannel().sendMessage(post.getBody()).queue();
				
			}
		}
	}
}