package ga.ganma.retosonow;

import ga.ganma.retosonow.command.CommandHandler;
import ga.ganma.retosonow.command.MainCommand;
import ga.ganma.retosonow.command.subCommands.*;
import ga.ganma.retosonow.config.HunterboxConfig;
import ga.ganma.retosonow.config.MainConfig;
import ga.ganma.retosonow.event.RunnerkakuhoEvent;
import ga.ganma.retosonow.jecon.Jeconsetup;
import ga.ganma.retosonow.listener.BukkitEventget;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class Retosonow extends JavaPlugin {
    public static Plugin pl;
    private static Gamemanager manager;
    public static String prefix = ChatColor.GRAY + "[" + ChatColor.RED + "逃走中" + ChatColor.GRAY + "]" + ChatColor.RESET;
    private static MainConfig mainconfig;
    private static HunterboxConfig[] hunterboxconfig;

    @Override
    public void onEnable() {
        try {
            pl = this;
            Jeconsetup.moneysetup();
            this.saveDefaultConfig();
            mainconfig = new MainConfig(this);
            hunterboxconfig = new HunterboxConfig[mainconfig.getConfig().getInt("hunterboxcount")];
            createHunterboxConfig();
            int prize = mainconfig.getConfig().getInt("prize");
            int time = mainconfig.getConfig().getInt("time");
            //イベントの登録
            registerEvent();
            //コマンドの実装
            this.registerCommands();
            //ゲームマネージャーの作成
            creategamemanager(prize, time);
        }
        catch (Exception e){
            getLogger().warning(prefix + "設定ファイルが不正です！");
            getLogger().warning(prefix + "Re:tosonowを終了します。");
        }
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

    //ゲームマネージャーをリセット（無に返す）
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
        handler.register("hunterbox",new TosoHunter());

        //Bukkitにコマンドの登録
        getCommand("toso").setExecutor(handler);
    }

    private void registerEvent(){
        new BukkitEventget(this);
        new RunnerkakuhoEvent();
    }

    public static FileConfiguration getMainconfig(){
        return mainconfig.getConfig();
    }

    private void createHunterboxConfig(){
        for (int a = 0;a<mainconfig.getConfig().getInt("hunterboxcount");a++){
            hunterboxconfig[a] = new HunterboxConfig(this,"Hunterbox." + a++ + ".yml");
        }
    }

    public static FileConfiguration gethunterboxConfig(int number){
        FileConfiguration a;
        try {
            a = hunterboxconfig[number].getConfig();
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println(prefix + "予期せぬエラーが発生しました。製作者に番号を伝えてください。 number：101");
            return null;
        }
        return a;
    }


}
