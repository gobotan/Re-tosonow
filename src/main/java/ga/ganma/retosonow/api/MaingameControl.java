package ga.ganma.retosonow.api;

import ga.ganma.retosonow.Retosonow;
import ga.ganma.retosonow.runneble.MainGametimer;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;


public class MaingameControl {
    public static void gamestart(Plugin plugin){
        new MainGametimer().runTaskTimer(plugin,0,20);
        for(Player p : Bukkit.getOnlinePlayers()){
            p.spigot().sendMessage(ChatMessageType.ACTION_BAR, gettime());
        }
    }

    public static void gameend(Plugin plugin){

    }

    public static TextComponent gettime(){
        TextComponent component = new TextComponent();
        int sec = Retosonow.getGamemanager().getTime();
        String time;
        time = sec/60 < 10 ?  (sec%3600)/60 + ":0" + sec/60 : (sec%3600)/60 + ":" + sec/60;
        component.setText(time);
        return component;
    }
}
