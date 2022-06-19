package com.vimeworld.cakesplugin.Commands;

import com.vimeworld.cakesplugin.Command;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GiveCakes implements Command {
    @Override
    public boolean execute(CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {
        Player player = (Player) sender;

        int donatedCakesCount = 0;

        for (org.bukkit.entity.Player onlinePlayer : Bukkit.getServer().getOnlinePlayers()) {
            if (onlinePlayer.getLocation().distance(player.getLocation()) <= 25) {
                onlinePlayer.getInventory().addItem(Cake(onlinePlayer.getName()));
                donatedCakesCount++;
            }
        }

        player.sendMessage("Вы раздали " + donatedCakesCount + " тортиков в радиусе 25 метров!");

        return true;
    }

    private ItemStack Cake(String playerName) {
        ItemStack cake = new ItemStack(org.bukkit.Material.CAKE);
        ItemMeta meta = cake.getItemMeta();

        meta.setDisplayName("Тортик для " + playerName);
        cake.setItemMeta(meta);

        return cake;
    }
}
