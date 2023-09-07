package org.geo.firstplugin.command;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;


public class TestCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Only player can use this command！");
            return true;
        }

        if (args.length != 1) {
            sender.sendMessage(ChatColor.RED + "usage: /copy <number>");
            return true;
        }

        Player player = (Player) sender;
        int amount;

        try {
            amount = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            sender.sendMessage(ChatColor.RED + "{argument} must be a number！");
            return true;
        }

        if (amount <= 0) {
            sender.sendMessage(ChatColor.RED + "Argument must large than 0！");
            return true;
        }

        ItemStack itemInHand = player.getInventory().getItemInMainHand();

        if (itemInHand == null) {
            sender.sendMessage(ChatColor.RED +"You dont have anything in your hand！");
            return true;
        }

        Material itemType = itemInHand.getType();

        // 
        if (isOre(itemType)) {
            // 
            ItemStack copiedItem = itemInHand.clone();
            copiedItem.setAmount(amount);

            player.getWorld().dropItem(player.getLocation(), copiedItem);

            sender.sendMessage(ChatColor.GREEN + "Copy Item Successfully！ item : " + copiedItem.toString());
        } else {
            sender.sendMessage(ChatColor.RED +"Only Ore can be copied！！");
        }

        return true;
    }

    private boolean isOre(Material material) {
        // 通过检查物品类型是否继承自矿物来判断
        return material.isBlock() && material.name().endsWith("_ORE");
    }
}
