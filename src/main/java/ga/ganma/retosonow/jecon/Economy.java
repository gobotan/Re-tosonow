package ga.ganma.retosonow.jecon;

import ga.ganma.retosonow.Retosonow;
import ga.ganma.retosonow.api.GamePlayer;
import ga.ganma.retosonow.api.Position;
import jp.jyn.jecon.Jecon;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Economy {
    public static void sendPrize(){
        for (Player p : Bukkit.getOnlinePlayers()){
            if(GamePlayer.getPlayerposition(p) != null) {
                if (GamePlayer.getPlayerposition(p) == Position.RUNNER){
                    Jecon.getInstance().getRepository().deposit(p.getUniqueId(), Retosonow.getGamemanager().getTotalprize());
                }
            }
        }
    }
}
