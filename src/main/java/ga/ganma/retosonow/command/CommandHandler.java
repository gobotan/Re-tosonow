package ga.ganma.retosonow.command;

import ga.ganma.retosonow.Retosonow;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class CommandHandler implements CommandExecutor {

    private static HashMap<String ,CommandAPI> commands = new HashMap<>();

    public void register(String name,CommandAPI cmd){
        commands.put(name,cmd);
    }

    public boolean exists(String name){
        return commands.containsKey(name);
    }

    public CommandAPI getExecutor(String name){
        return commands.get(name);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            if(args.length == 0){
                getExecutor("toso").onCommand(sender,command,label,args);
                return true;
            }

            if (args.length > 0){
                if(exists(args[0])){
                    getExecutor(args[0]).onCommand(sender, command, label, args);
                    return true;
                }
                else {
                    sender.sendMessage(Retosonow.prefix + "そのコマンドは存在しません！");
                    return true;
                }
            }
        }
        else {
            Bukkit.getLogger().info(Retosonow.prefix + "逃走中関連のコマンドは必ずゲーム中から実行してください！");
        }
        return false;
    }
}
