package com.vhbob.referrals.utils;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;

import com.vhbob.referrals.Referrals;

public class ReferralUtils {

	private static Referrals plugin;

	public ReferralUtils(Referrals plugin) {
		ReferralUtils.plugin = plugin;
	}

	// Used to get a user's referral code
	public static String getReferral(UUID playerID) {
		File codesFile = new File(plugin.getDataFolder() + File.separator + "player-data", playerID + ".yml");
		if (!codesFile.exists())
			codesFile.mkdirs();
		YamlConfiguration config = new YamlConfiguration();
		try {
			config.load(codesFile);
		} catch (IOException | InvalidConfigurationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if (config.getString("key") != null)
			return config.getString("key");
		String key = UUID.randomUUID().toString().substring(0, 10);
		config.set("key", key);
		try {
			config.save(codesFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return key;
	}

}
