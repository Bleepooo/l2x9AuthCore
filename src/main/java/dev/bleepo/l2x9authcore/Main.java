package dev.bleepo.l2x9authcore;

import dev.bleepo.l2x9authcore.utils.PluginUtil;
import dev.bleepo.l2x9authcore.utils.Util;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
    public static long timeAtEnable;

    public static Main getPlugin() {
        return getPlugin(Main.class);
    }

    @Override
    public void onEnable() {
        timeAtEnable = System.currentTimeMillis();
        Util.logMessage("Loading Config...");
        saveDefaultConfig();
        Util.logMessage("Loading Runnables...");
        PluginUtil.startRunnables();
        Util.logMessage("Loading Commands...");
        PluginUtil.registerCommands();
        Util.logMessage("Loading Listeners...");
        PluginUtil.registerListeners();
        Util.logMessage("Loaded and Enabled!");
    }
}
