package com.vimeworld.cakesplugin.Commands;

import com.vimeworld.cakesplugin.Command;
import org.bukkit.command.CommandSender;

public class NotExisting implements Command {
    @Override
    public boolean execute(CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {
        sender.sendMessage("Такой команды не существует!");
        return true;
    }
}
