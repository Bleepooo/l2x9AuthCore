package dev.bleepo.l2x9authcore.runnables;

import dev.bleepo.l2x9authcore.Instance;
import dev.bleepo.l2x9authcore.utils.Util;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

public class Tablist extends BukkitRunnable implements Instance {
    @Override
    public void run() {
        if (Bukkit.getOnlinePlayers().size() > 0) {
            Bukkit.getOnlinePlayers().forEach(player -> {
                String header = String.join("\n", config.getStringList("Tablist.Header"));
                String footer = String.join("\n", config.getStringList("Tablist.Footer"));
                BaseComponent h = new TextComponent(Util.formatTab(player, header));
                BaseComponent f = new TextComponent(Util.formatTab(player, footer));
                player.setPlayerListHeaderFooter(h, f);
            });
        }
    }
}
