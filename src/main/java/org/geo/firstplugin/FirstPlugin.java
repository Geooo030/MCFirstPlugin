package org.geo.firstplugin;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.geo.firstplugin.command.TestCommand;

public final class FirstPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // 将插件写好的配置保存到本地磁盘上

        this.saveDefaultConfig();
        FileConfiguration config = this.getConfig();

        Bukkit.getConsoleSender().sendMessage("§aGEOOO的第一个插件启动中...");
        Bukkit.getPluginCommand("copy").setExecutor(new TestCommand());


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
