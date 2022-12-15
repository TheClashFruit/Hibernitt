package me.theclashfruit.hibernitt;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import static org.bukkit.Bukkit.getServer;

public class PlayerEvents implements Listener {
    Logger logger;

    public PlayerEvents(Logger logger) {
        this.logger = logger;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        String joinMessage = event.getJoinMessage();

        logger.info("Player " + player.getName() + " joined the server!");

        if(getServer().getOnlinePlayers().size() >= 1) {
            logger.info("Server is now not empty, unhibernating...");

            World mainWorld    = getServer().getWorlds().get(0);

            logger.info(mainWorld.getName());

            World newMainWorld = new WorldCreator(mainWorld.getName()).createWorld();
        }
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        String quitMessage = event.getQuitMessage();

        logger.info("Player " + player.getName() + " left the server!");

        logger.info("No players online, hibernating...");

        World mainWorld = getServer().getWorlds().get(0);

        logger.info(mainWorld.getName());

        Bukkit.unloadWorld(mainWorld, true);
    }
}