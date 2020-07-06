package com.vhbob.referrals.utils;

import org.bukkit.entity.Player;

import com.vhbob.referrals.Referrals;

import net.md_5.bungee.api.ChatColor;

public class MessagingUtils {

	private static Referrals plugin;

	public MessagingUtils(Referrals plugin) {
		MessagingUtils.plugin = plugin;
	}

	// Use this to send a configurable message to a player
	public static void sendConfigMsg(Player p, String path) {
		for (String s : plugin.getConfig().getStringList(path))
			p.sendMessage(ChatColor.translateAlternateColorCodes('&', s));
	}

}
