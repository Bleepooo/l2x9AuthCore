package dev.bleepo.l2x9authcore;

import org.bukkit.configuration.file.FileConfiguration;

public interface Instance {
    Main plugin = Main.getPlugin();
    FileConfiguration config = plugin.getConfig();
}
