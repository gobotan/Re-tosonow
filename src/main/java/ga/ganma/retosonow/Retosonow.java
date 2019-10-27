package ga.ganma.retosonow;

import ga.ganma.retosonow.command.*;
import ga.ganma.retosonow.command.subCommands.*;
import ga.ganma.retosonow.jecon.Jeconsetup;
import ga.ganma.retosonow.listener.GamegetEvent;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class Retosonow extends JavaPlugin {
    public static Plugin pl;
    private static Gamemanager manager;
    public static String prefix = ChatColor.GRAY + "[" + ChatColor.RED + "逃走中" + ChatColor.GRAY + "]" + ChatColor.RESET;

    @Override
    public void onEnable() {
        pl = this;
        Jeconsetup.moneysetup();
        new GamegetEvent(this);
        this.saveDefaultConfig();
        FileConfiguration config = getConfig();
        int prize = config.getInt("prize");
        int time = config.getInt("time");

        //コマンドの実装
        this.registerCommands();
        //ゲームマネージャーの作成
        creategamemanager(prize,time);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    //ゲームマネージャーがnullの確認 nullの場合trueを返す
    public static boolean isGameManagerEmpty(){
        return manager == null;
    }

    //ゲームマネージャーを取得
    public static Gamemanager getGamemanager(){
        return manager;
    }

    //ゲームマネージャーを作成 prizeが一秒ごとの賞金単価 timeがゲームにかかる時間
    public static Gamemanager creategamemanager(int prize, int time){
        manager = new Gamemanager(prize, time);
        return manager;
    }

    public static void resetGamemanager(){
        manager = null;
    }

    private void registerCommands(){
        CommandHandler handler = new CommandHandler();

        //tosoコマンド作成（メインコマンド）
        handler.register("toso",new  MainCommand());

        //サブコマンドを作成
        handler.register("start", new TosoStart());
        handler.register("prize", new TosoPrize());
        handler.register("time", new TosoTime());
        handler.register("end", new TosoTime());
        handler.register("setting",new TosoSetting());
        handler.register("help",new TosoHelp());
        handler.register("hunter",new TosoHunter());

        //Bukkitにコマンドの登録
        getCommand("toso").setExecutor(handler);
    }
}
