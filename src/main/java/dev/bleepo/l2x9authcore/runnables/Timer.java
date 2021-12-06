package dev.bleepo.l2x9authcore.runnables;

import dev.bleepo.l2x9authcore.Instance;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import static dev.bleepo.l2x9authcore.utils.Util.isTaco;
import static dev.bleepo.l2x9authcore.utils.Util.sendMessage;

public class Timer implements Listener, Instance {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        Bukkit.getScheduler().runTaskTimer(plugin, new Runnable() {
            int time = plugin.getConfig().getInt("Time");

            @Override
            public void run() {
                if (this.time == 0) {
                    if (isTaco(player)) sendMessage(player, plugin.getConfig().getString("Spanish.Message"));
                    sendMessage(player, plugin.getConfig().getString("English.Message"));
                }

                --this.time;
                if (isTaco(player)) {
                    String msg = plugin.getConfig().getString("Spanish.Message");
                    player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(ChatColor.translateAlternateColorCodes('&', msg.replace("{time}", String.valueOf(time)))));
                }

                String msg = plugin.getConfig().getString("English.Message");
                player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(ChatColor.translateAlternateColorCodes('&', msg.replace("{time}", String.valueOf(time)))));

                if (plugin.getConfig().getBoolean("Sound")) {
                    player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 100.0f, 1.0f);
                }
            }
        }, 0L, 20L);
        player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 100.0f, 1.0f);
    }
}
