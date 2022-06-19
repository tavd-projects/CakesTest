package com.vimeworld.cakesplugin;

import org.bukkit.command.CommandSender;

public interface Command {
    boolean execute(CommandSender sender, org.bukkit.command.Command command, String label, String[] args);
}

