package ga.ganma.retosonow.command.subCommands;

import ga.ganma.retosonow.Retosonow;
import ga.ganma.retosonow.command.CommandAPI;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class TosoHelp implements CommandAPI {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandlabel, String[] args) {
        if(sender.isOp()) {
            sender.sendMessage(Retosonow.prefix + "運営ヘルプ");
            sender.sendMessage(Retosonow.prefix + "/toso End");
            sender.sendMessage(Retosonow.prefix + "逃走中を強制終了するコマンドです。");
            sender.sendMessage(Retosonow.prefix + "/toso Help");
            sender.sendMessage(Retosonow.prefix + "このヘルプを表示します。");
            sender.sendMessage(Retosonow.prefix + "/toso Prize");
            sender.sendMessage(Retosonow.prefix + "逃走者に賞金を渡します。");
            sender.sendMessage(Retosonow.prefix + "/toso Setting");
            sender.sendMessage(Retosonow.prefix + "ゲームに関する設定を表示します。");
            sender.sendMessage(Retosonow.prefix + "/toso Start");
            sender.sendMessage(Retosonow.prefix + "逃走中をスタートします。");
            sender.sendMessage(Retosonow.prefix + "/toso time");
            sender.sendMessage(Retosonow.prefix + "逃走中の制限時間を変更します。");
            sender.sendMessage("--------------------------------");
        }
        else {
            sender.sendMessage(Retosonow.prefix + "一般ヘルプ");
            sender.sendMessage(Retosonow.prefix + "/toso phone");
            sender.sendMessage(Retosonow.prefix + "携帯電話を見ます。");
        }

        return false;
    }
}
