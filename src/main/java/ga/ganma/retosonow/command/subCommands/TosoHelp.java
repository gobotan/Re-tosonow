package ga.ganma.retosonow.command.subCommands;

import ga.ganma.retosonow.Retosonow;
import ga.ganma.retosonow.command.CommandAPI;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class TosoHelp implements CommandAPI {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandlabel, String[] args) {
        sender.sendMessage(Retosonow.prefix + "コマンドリスト");
        sender.sendMessage(Retosonow.prefix + "/toso End");
        sender.sendMessage(Retosonow.prefix + "/toso Help");
        sender.sendMessage(Retosonow.prefix + "/toso Prize");
        sender.sendMessage(Retosonow.prefix + "/toso Setting");
        sender.sendMessage(Retosonow.prefix + "/toso Start");
        sender.sendMessage(Retosonow.prefix + "/toso time");

        return false;
    }
}
