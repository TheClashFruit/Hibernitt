package me.theclashfruit.hibernitt;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import static org.bukkit.plugin.java.JavaPlugin.getPlugin;

public class CommandHandler implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        sender.sendMessage(getPlugin(Hibernitt.class).getConfig().getString("prefix") + "&cCommands are not implemented yet!");

        return true;
    }
}