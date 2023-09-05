package org.geo.firstplugin.Listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.geo.firstplugin.FirstPlugin;

public class KickAutoListener implements Listener {


    @EventHandler
    public void onJoinServer(PlayerJoinEvent e) {

        Player player = e.getPlayer();

//        new BukkitRunnable() {
//
//            @Override
//            public void run() {
//
//            }
//        }.runTaskLater(FirstPlugin.class, 0L, 20L);
    }
}
