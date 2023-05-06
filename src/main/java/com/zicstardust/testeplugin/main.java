package com.zicstardust.testeplugin;
import com.zicstardust.testeplugin.listeners.playerListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class main extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin start logic
        System.out.println("Plugin ligado");
        this.getServer().getPluginManager().registerEvents(new playerListener(),this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("Plugin desligado");
    }
}
