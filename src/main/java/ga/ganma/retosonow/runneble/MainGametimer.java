package ga.ganma.retosonow.runneble;

import ga.ganma.retosonow.Retosonow;
import ga.ganma.retosonow.api.MaingameControl;
import ga.ganma.retosonow.scoreboard.Mainscoreboard;
import net.md_5.bungee.api.ChatMessageType;
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

            //プレイヤーのアクションバーに残り時間の表示
            p.spigot().sendMessage(ChatMessageType.ACTION_BAR, MaingameControl.gettime());

            //賞金の追加
            Retosonow.getGamemanager().addprize();
        }
    }
}
