package ga.ganma.retosonow.listener;

import ga.ganma.retosonow.event.RunnerkakuhoEvent;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

public class MyEventget implements Listener {

    public MyEventget(Plugin plugin){
        Bukkit.getPluginManager().registerEvents(this,plugin);
    }

    @EventHandler
    public void getRunnerkakuhoEvent(RunnerkakuhoEvent e){
    }
}
