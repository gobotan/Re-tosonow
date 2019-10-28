package ga.ganma.retosonow.command.subCommands;

import ga.ganma.retosonow.Retosonow;
import ga.ganma.retosonow.api.GamePlayer;
import ga.ganma.retosonow.api.MaingameControl;
import ga.ganma.retosonow.api.Position;
import ga.ganma.retosonow.command.CommandAPI;
import ga.ganma.retosonow.scoreboard.Mainscoreboard;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class TosoHunter implements CommandAPI {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandlabel, String[] args) {
        Player pl = (Player) sender;
        if(args.length == 1){
            ArrayList<Player> players = new ArrayList<>();
            for(Player p : Bukkit.getOnlinePlayers()){
                Location loc1 = p.getLocation().clone();
                Location loc2 = p.getLocation().clone();
                loc1.setY(loc1.getY() - 1);
                loc2.setY(loc1.getY() - 1);
                if(loc1.getBlock().getType() == Material.DIAMOND_BLOCK && loc2.getBlock().getType() == Material.DIAMOND_BLOCK){
                    players.add(p);
                }
            }
            if(players.isEmpty()){
                return false;
            }
            Player hunter = MaingameControl.randomselectPlayer(players);
            GamePlayer.setPlayerPosition(hunter, Position.HUNTER);

            Bukkit.broadcastMessage(Retosonow.prefix + hunter.getName() + "さんがハンターになりました！");

            Mainscoreboard.showallplayersidebar();

        }
        return false;
    }

}
