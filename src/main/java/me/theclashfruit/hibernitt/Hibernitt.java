package me.theclashfruit.hibernitt;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class Hibernitt extends JavaPlugin {

    @Override
    public void onEnable() {
        FileConfiguration config         = getConfig();
        //ConfigurationSection configMessages = getConfig().getConfigurationSection("messages");

        config.addDefault("prefix", "&8[&6Hibernitt&8] &7");
        config.addDefault("hibernate", true);

        //configMessages.addDefault("hibernate", "&aHibernating...");
        //configMessages.addDefault("unhibernate", "&aUnhibernating...");

        //configMessages.addDefault("hibernate-error", "&cError while hibernating!");

        config.options().copyDefaults(true);

        getCommand("hibernitt").setExecutor(new CommandHandler());
        getCommand("hibernate").setExecutor(new CommandHandler());

        getServer().getPluginManager().registerEvents(new PlayerEvents(getLogger()), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
