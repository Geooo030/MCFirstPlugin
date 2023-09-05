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
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        String amount = strings[0];
        Integer nums = 1;
        try {
            nums = Integer.parseInt(amount);
        }catch (Exception e) {
            commandSender.sendMessage(ChatColor.RED + "参数错误");
            return false;
        }

        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;
            PlayerInventory inventory = player.getInventory();
            ItemStack itemStack = inventory.getItemInMainHand();
            if (itemStack.getType().equals(Material.AIR)) {
                commandSender.sendMessage(ChatColor.RED + "你不能复制：" + itemStack.getType().toString() + "!!!");
                return false;
            }
            Bukkit.getConsoleSender().sendMessage("§aUser -> " + commandSender + " copy the item: " + itemStack.toString());
            commandSender.sendMessage(ChatColor.GREEN + "你复制了物品：" + itemStack.toString());
            ItemStack clone = itemStack.clone();
            clone.setAmount(64 * nums);
            player.getWorld().dropItem(player.getLocation(), clone);

        }


        return true;
    }
}
