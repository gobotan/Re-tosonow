package ga.ganma.retosonow.listener;

import ga.ganma.retosonow.Retosonow;
import ga.ganma.retosonow.api.GamePlayer;
import ga.ganma.retosonow.api.Position;
import ga.ganma.retosonow.scoreboard.Mainscoreboard;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerToggleSprintEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;

public class GamegetEvent implements Listener {
    private Plugin pl;
    private HashMap<Player, Boolean> iswalktasknow = new HashMap<>();
    private HashMap<Player, Boolean> issprinttasknow = new HashMap<>();

    public GamegetEvent(Plugin pl) {
        Bukkit.getPluginManager().registerEvents(this, pl);
        this.pl = pl;
    }

    @EventHandler
    public void getonPlayerLoginEvent(PlayerJoinEvent e) {
        Player pl = e.getPlayer();
        GamePlayer.setPlayerPosition(pl, Position.RUNNER);
        pl.sendMessage(Retosonow.prefix + ChatColor.GRAY + "あなたを逃走者に追加しました。");
        Mainscoreboard.setupScoreboard(pl);
    }

    @EventHandler
    public void getPlayerStaminaEvent(PlayerToggleSprintEvent e) {
        if (!Retosonow.isGameManagerEmpty() && Retosonow.getGamemanager().isgamestart()) {
            Player pl = e.getPlayer();
            if (e.isSprinting()) {
                if (!issprinttasknow.containsKey(pl) || !issprinttasknow.get(pl)) {
                    issprinttasknow.put(pl, true);
                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            if (!pl.isSprinting()) {
                                this.cancel();
                                issprinttasknow.put(pl, false);
                                return;
                            }

                            if (pl.getFoodLevel() > 6) {
                                pl.setFoodLevel(pl.getFoodLevel() - 1);
                            }

                        }
                    }.runTaskTimer(this.pl, 20, 30);
                }
            } else {
                if (!iswalktasknow.containsKey(pl) || !iswalktasknow.get(pl)) {
                    iswalktasknow.put(pl, true);
                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            if (pl.isSprinting()) {
                                this.cancel();
                                iswalktasknow.put(pl, false);
                                return;
                            }
                            if (pl.getFoodLevel() < 20) {
                                pl.setFoodLevel(pl.getFoodLevel() + 1);
                            }

                        }
                    }.runTaskTimer(this.pl, 20, 50);
                }
            }
        }
    }

    @EventHandler
    public void getHunterrunEvent(PlayerToggleSprintEvent e){
        if(!Retosonow.isGameManagerEmpty() && Retosonow.getGamemanager().isgamestart()){
            Player pl = e.getPlayer();
            if(Retosonow.getGamemanager().getHunter().contains(pl)){
                if(e.isSprinting()){
                    pl.setWalkSpeed(1.5f);
                }
                else {
                    pl.setWalkSpeed(1.0f);
                }
            }
        }
    }
}
