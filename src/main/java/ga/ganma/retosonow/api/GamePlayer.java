package ga.ganma.retosonow.api;

import ga.ganma.retosonow.Gamemanager;
import ga.ganma.retosonow.Retosonow;
import org.bukkit.entity.Player;

import java.util.Collection;
import java.util.HashMap;

public class GamePlayer {
    private static Gamemanager gm = Retosonow.getGamemanager();

    //ゲーム中のプレイヤー関連のAPI

    //プレイヤーの役職を取得 Stringで返される
    public static String getPlayerpositionString(Player player){
        if(gm.getPlayerpositionHashMap().containsKey(player)){
            return gm.getPlayerpositionHashMap().get(player).getJPtext();
        }
        return null;
    }

    public static Position getPlayerposition(Player player){
        if(gm.getPlayerpositionHashMap().containsKey(player)){
            return gm.getPlayerpositionHashMap().get(player);
        }
        return null;
    }

    //プレイヤーの役職を変更 ゲームマネージャーの方もここで変更される
    //基本的にこ↑こ↓で役職を変更
    public static void setPlayerPosition(Player player,Position position){
        switch (position){
            case HUNTER:
                gm.addhunter(player);
                break;

            case JAILER:
                gm.addjailer(player);
                break;

            case RUNNER:
                gm.addrunner(player);
                break;

            case ADMIN:
                gm.addAdmin(player);
        }
    }

    public static void runnerkakuho(Player runner){
        if(gm.isrunner(runner)){
            setPlayerPosition(runner,Position.JAILER);
        }
    }

    public static Collection<Player> getRunners(){
        return gm.getRunner();
    }

    public static Collection<Player> getJailers() {
        return gm.getJailer();
    }

    public static Collection<Player> getHunters() {
        return gm.getHunter();
    }

    public static Collection<Player> getAdmin() {
        return gm.getAdmin();
    }
}
