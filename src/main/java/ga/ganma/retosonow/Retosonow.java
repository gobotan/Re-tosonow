package ga.ganma.retosonow;

import ga.ganma.retosonow.jecon.Jeconsetup;
import ga.ganma.retosonow.listener.GamegetEvent;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Collection;

public final class Retosonow extends JavaPlugin {
    public static Plugin pl;
    private static Gamemanager manager;
    public static String prefix = ChatColor.GRAY + "[" + ChatColor.RED + "逃走中" + ChatColor.GRAY + "]" + ChatColor.RESET;

    @Override
    public void onEnable() {
        pl = this;
        Jeconsetup.moneysetup();
        new GamegetEvent(this);
        saveDefaultConfig();
        FileConfiguration config = getConfig();
        int prize = config.getInt("prize");
        int time = config.getInt("time");

        creategamemanager(prize,time);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static boolean isGameManagerEmpty(){
        return manager == null;
    }

    public static Gamemanager getGamemanager(){
        return manager;
    }

    public static Gamemanager creategamemanager(int prize, int time){
        manager = new Gamemanager(prize, time);
        return manager;
    }

    public static void deleteGamemanager(){
        manager = null;
    }
}
