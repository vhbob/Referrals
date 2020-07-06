package com.vhbob.referrals.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.vhbob.referrals.utils.ReferralUtils;

public class SetupReferral implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String name, String[] args) {
		if (cmd.getName().equalsIgnoreCase("MyReferral")) {
			if (sender instanceof Player) {
				Player p = (Player) sender;
				p.sendMessage(ChatColor.BOLD + "Your referral code is: " + ChatColor.GREEN
						+ ReferralUtils.getReferral(p.getUniqueId()));
			} else {
				sender.sendMessage(ChatColor.RED + "You are not a player!");
			}
			return true;
		}
		return false;
	}

}
