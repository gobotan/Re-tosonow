package ga.ganma.retosonow.runneble;

import ga.ganma.retosonow.Retosonow;
import ga.ganma.retosonow.scoreboard.Mainscoreboard;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class MainGametimer extends BukkitRunnable {
    @Override
    public void run() {
        //ゲーム時間を1秒減らす
        Retosonow.getGamemanager().decreasetime();
        for(Player p: Bukkit.getOnlinePlayers()){
            //プレイヤーのスコアボードを更新
            Mainscoreboard.setupScoreboard(p);
        }
    }
}
