package com.zicstardust.testeplugin.listeners;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class playerListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        event.setJoinMessage("Jogador" + event.getPlayer().getName() + "entrou no servidor dev!");
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        event.setQuitMessage("Jogador" + event.getPlayer().getName() + "Saiu do servidor dev!");
    }

    @EventHandler
    public void breakBlockEvent(BlockBreakEvent event) {

        Block block = event.getBlock();
        Player player = event.getPlayer();
        World world = player.getWorld();

        if (event.getBlock().getType() == Material.GRASS_BLOCK) {
            world.strikeLightningEffect(block.getLocation());
            player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_HURT,5,5);
            player.sendMessage(ChatColor.GREEN + player.getName() + "Quebrou um bloco de grama!");
        } else {
            world.createExplosion(block.getLocation(),5.0f,false);
            player.sendMessage(ChatColor.RED + player.getName() + "Não quebrou um bloco de grama!");

        }


    }
}
