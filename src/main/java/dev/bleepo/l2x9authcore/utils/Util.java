package dev.bleepo.l2x9authcore.utils;

import dev.bleepo.l2x9authcore.Instance;
import dev.bleepo.l2x9authcore.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.text.DecimalFormat;

public class Util implements Instance {
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public static int getPing(Player player) {
        try {
            String a = Bukkit.getServer().getClass().getPackage().getName().substring(23);
            Class<?> b = Class.forName("org.bukkit.craftbukkit." + a + ".entity.CraftPlayer");
            Object c = b.getMethod("getHandle", new Class[0]).invoke(player);
            return (int) (Integer) c.getClass().getDeclaredField("ping").get(c);
        } catch (Exception e) {
            return 0;
        }
    }

    public static String getTps() {
        double tps = Math.max(Bukkit.getTPS()[0], 20);
        return df.format(tps);
    }

    public static String getUptime() {
        long currentTime = System.currentTimeMillis();
        long timeDifference = currentTime - Main.timeAtEnable;
        return getFormattedInterval(timeDifference);
    }

    public static int getPlayerCount() {
        return Bukkit.getOnlinePlayers().size();
    }

    public static String getFormattedInterval(long ms) {
        long seconds = ms / 1000L % 60L;
        long minutes = ms / 60000L % 60L;
        long hours = ms / 3600000L % 24L;
        long days = ms / 86400000L;
        return String.format("%dd %02dh %02dm %02ds", days, hours, minutes, seconds);
    }

    public static String getPrefix() {
        return ChatColor.translateAlternateColorCodes('&', "&6[&bl2x9AuthCore&6] ");
    }

    public static void sendMessage(Object object, String message) {
        if (object instanceof Player) {
            Player casted = (Player) object;
            casted.sendMessage(ChatColor.translateAlternateColorCodes('&', getPrefix() + message));
        } else {
            if (object instanceof CommandSender) {
                CommandSender casted = (CommandSender) object;
                casted.sendMessage(ChatColor.translateAlternateColorCodes('&', getPrefix() + message));
            }
        }
    }

    public static void sendWarning(String message) {
        plugin.getLogger().warning(ChatColor.translateAlternateColorCodes('&', getPrefix() + message));
    }

    public static void logMessage(String message) {
        plugin.getLogger().info(ChatColor.translateAlternateColorCodes('&', getPrefix() + message));
    }

    public static boolean isTaco(Player player) {
        if (config.getBoolean("Spanish.Enabled")) {
            return player.getLocale().contains("es");
        } else {
            sendWarning("Spanish messages are not enabled in the config! You may want to enable them.");
            return false;
        }
    }

    public static String formatTab(Player player, String text) {
        text = ChatColor.translateAlternateColorCodes('&', text);
        return text.replaceAll(
                "%ping%", String.valueOf(Util.getPing(player))).replaceAll(
                "%tps%", Util.getTps()).replaceAll(
                "%uptime%", Util.getUptime()).replaceAll(
                "%online%", String.valueOf(Util.getPlayerCount()).replaceAll("&", "§"));
    }
}
