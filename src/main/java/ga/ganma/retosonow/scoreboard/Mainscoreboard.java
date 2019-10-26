package ga.ganma.retosonow.scoreboard;

import ga.ganma.retosonow.Retosonow;
import ga.ganma.retosonow.api.GamePlayer;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;

public class Mainscoreboard {
    //プレイヤーにサイドバーにゲームの情報を乗っけるやつ
    public static void setupScoreboard(Player player) {
        //ゲームマネージャーがnullでないことの確認
        if (!Retosonow.isGameManagerEmpty()) {
            //スコアボード関係
            ScoreboardManager manager = Bukkit.getScoreboardManager();
            Scoreboard sb = manager.getNewScoreboard();
            //オブジェクト作成
            Objective objective = sb.registerNewObjective(player.getName(), "dummy");
            objective.setDisplayName(player.getName());
            objective.setDisplaySlot(DisplaySlot.SIDEBAR);
            //項目の設定
            Score s1 = objective.getScore(ChatColor.GRAY + "ハンターの人数：" + ChatColor.WHITE + Retosonow.getGamemanager().getHunter().size() + ChatColor.GRAY + "人");
            Score s2 = objective.getScore(ChatColor.AQUA + "逃走者の人数：" + ChatColor.WHITE + Retosonow.getGamemanager().getRunner().size() + ChatColor.AQUA + "人");
            Score s3 = objective.getScore(ChatColor.DARK_GRAY + "牢獄の人数：" + ChatColor.WHITE + Retosonow.getGamemanager().getJailer().size() + ChatColor.DARK_GRAY + "人");
            Score s4 = objective.getScore(ChatColor.GOLD + "現在の賞金：" + ChatColor.WHITE + Retosonow.getGamemanager().getTotalprize() + ChatColor.GOLD + "ゾス");
            Score s5 = objective.getScore(ChatColor.YELLOW + "現在のあなたの役職：" + ChatColor.WHITE + GamePlayer.getPlayerposition(player));
            Score s6 = objective.getScore(ChatColor.BLUE + "残り時間：" + ChatColor.WHITE + Retosonow.getGamemanager().getTime() + ChatColor.BLUE + "秒");
            Score s7 = objective.getScore(ChatColor.DARK_PURPLE + "現在の賞金単価：" + ChatColor.WHITE + "1" + ChatColor.DARK_PURPLE + "秒" + ChatColor.WHITE + Retosonow.getGamemanager().getPrize() + ChatColor.DARK_PURPLE + "ゾス");
            Score s8 = objective.getScore("");
            Score s9 = objective.getScore(ChatColor.GREEN + "play.zosuserver.xyz");
            s1.setScore(8);
            s2.setScore(7);
            s3.setScore(6);
            s4.setScore(5);
            s5.setScore(4);
            s6.setScore(3);
            s7.setScore(2);
            s8.setScore(1);
            s9.setScore(0);
            //プレイヤーにスコアボードを設定するやつ
            player.setScoreboard(sb);
        }
    }
}
