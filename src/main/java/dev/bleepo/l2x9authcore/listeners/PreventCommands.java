package dev.bleepo.l2x9authcore.listeners;

import dev.bleepo.l2x9authcore.Instance;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class PreventCommands implements Listener, Instance {
    @EventHandler
    public void onCmd(PlayerCommandPreprocessEvent e) {
        if (plugin.getConfig().getBoolean("Prevent-Commands")) {
            if (!config.getStringList("Enabled-Cmds").contains(e.getMessage().split(" ")[0].toLowerCase())) {
                e.setCancelled(true);
            }
        }
    }
}
