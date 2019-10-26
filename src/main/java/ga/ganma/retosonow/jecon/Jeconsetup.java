package ga.ganma.retosonow.jecon;

import ga.ganma.retosonow.Retosonow;
import jp.jyn.jecon.Jecon;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Jeconsetup extends JavaPlugin {
    private static Jecon jecon;
    static public void moneysetup(){
        // get plugin
        Plugin plugin = Bukkit.getPluginManager().getPlugin("Jecon");
        if(plugin == null || !plugin.isEnabled()) {
            // not available
            Retosonow.pl.getLogger().warning("Jeconが存在しません！");
            Bukkit.getPluginManager().disablePlugin(Retosonow.pl);
        }

        Jeconsetup.jecon = (Jecon) plugin;
    }

    public static Jecon getJecon(){
        return jecon;
    }
}
