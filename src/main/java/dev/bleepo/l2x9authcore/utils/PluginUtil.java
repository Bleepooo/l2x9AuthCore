package dev.bleepo.l2x9authcore.utils;

import dev.bleepo.l2x9authcore.Instance;
import dev.bleepo.l2x9authcore.commands.ReloadCommand;
import dev.bleepo.l2x9authcore.listeners.*;
import dev.bleepo.l2x9authcore.runnables.Tablist;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;

public class PluginUtil implements Instance {

    private static final PluginManager pluginManager = Bukkit.getServer().getPluginManager();

    public static void registerListeners() {
        pluginManager.registerEvents(new PreventCommands(), plugin);
        pluginManager.registerEvents(new PreventChat(), plugin);
        pluginManager.registerEvents(new JoinMessages(), plugin);
        pluginManager.registerEvents(new FreezePlayer(), plugin);
        pluginManager.registerEvents(new ForceGamemode(), plugin);
        pluginManager.registerEvents(new HidePlayer(), plugin);
    }

    public static void registerCommands() {
        plugin.getCommand("bat").setExecutor(new ReloadCommand());
    }

    public static void startRunnables() {
        Bukkit.getScheduler().runTaskTimer(plugin, new Tablist(), 0L, 20L);
    }
}
