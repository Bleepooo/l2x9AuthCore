package dev.bleepo.l2x9authcore.commands;

import dev.bleepo.l2x9authcore.Instance;
import dev.bleepo.l2x9authcore.utils.Util;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class ReloadCommand implements CommandExecutor, Instance {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args[0].equalsIgnoreCase("reload")) {
            if (sender instanceof Player) {
                if (sender.isOp()) {
                    plugin.reloadConfig();
                    Util.sendMessage(sender, Util.getPrefix() + "Config Reloaded.");
                }
            } else {
                if (sender instanceof ConsoleCommandSender) {
                    Util.logMessage("Config Reloaded.");
                }
            }
        }
        Util.sendMessage(sender, "&6This server is running &bl2x9AuthCore &6v2.2.0");
        return true;
    }
}
