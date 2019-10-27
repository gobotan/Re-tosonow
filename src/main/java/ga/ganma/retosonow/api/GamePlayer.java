package ga.ganma.retosonow.api;

import ga.ganma.retosonow.Gamemanager;
import ga.ganma.retosonow.Retosonow;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class GamePlayer {
    private static HashMap<Player,Position> playerPosition = new HashMap<>();
    private static Collection<Player> runner = new ArrayList<>()
            ,hunter = new ArrayList<>()
            ,jailer = new ArrayList<>()
            ,admin = new ArrayList<>();


    //ゲーム中のプレイヤー関連のAPI

    //プレイヤーの役職を取得 Stringで返される
    public static String getPlayerposition(Player player){
        if(playerPosition.containsKey(player)){
            return playerPosition.get(player).getJPtext();
        }
        return null;
    }

    //プレイヤーの役職を変更 ゲームマネージャーの方もここで変更される
    //基本的にこ↑こ↓で役職を変更
    public static void setPlayerPosition(Player player,Position position){
        Gamemanager gm = Retosonow.getGamemanager();
        playerPosition.put(player,position);
        switch (position){
            case HUNTER:

                if(gm.isrunner(player))
                runner.remove(player);

                if (gm.isjailer(player))
                jailer.remove(player);

                if(gm.isadmin(player))
                admin.remove(player);

                hunter.add(player);
                gm.removeadmin(player);
                gm.removejailer(player);
                gm.removeRunner(player);
                gm.addhunter(player);
                break;

            case JAILER:

                if(gm.isrunner(player))
                runner.remove(player);

                if(gm.ishunter(player))
                hunter.remove(player);

                if(gm.isadmin(player))
                admin.remove(player);

                if (gm.isjailer(player))
                jailer.add(player);
                gm.removeadmin(player);
                gm.removehunter(player);
                gm.removeRunner(player);
                gm.addjailer(player);
                break;

            case RUNNER:
                if(gm.ishunter(player))
                hunter.remove(player);

                if (gm.isjailer(player))
                jailer.remove(player);

                if(gm.isadmin(player))
                admin.remove(player);

                runner.add(player);
                gm.removeadmin(player);
                gm.removejailer(player);
                gm.removehunter(player);
                gm.addrunner(player);
                break;

            case ADMIN:
                if(gm.ishunter(player))
                hunter.remove(player);

                if (gm.isjailer(player))
                jailer.remove(player);

                if(gm.isrunner(player))
                runner.remove(player);

                admin.add(player);
                gm.removehunter(player);
                gm.removejailer(player);
                gm.removeRunner(player);
                gm.addAdmin(player);
        }
    }

    public static Collection<Player> getRunners(){
        return runner;
    }

    public static Collection<Player> getJailers() {
        return jailer;
    }

    public static Collection<Player> getHunters() {
        return hunter;
    }

    public static Collection<Player> getAdmin() {
        return admin;
    }
}
