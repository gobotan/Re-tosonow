package ga.ganma.retosonow.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public interface CommandAPI {

    public boolean onCommand(CommandSender sender, Command cmd ,String commandlabel,String[] args);
}
