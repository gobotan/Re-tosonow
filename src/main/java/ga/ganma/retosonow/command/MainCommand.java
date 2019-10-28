package ga.ganma.retosonow.command;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MainCommand implements CommandAPI, CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandlabel, String[] args) {
        new CommandHandler().getExecutor("help").onCommand(sender, cmd, commandlabel, args);
        return false;
    }
}
