package ga.ganma.retosonow.command.subCommands;

import ga.ganma.retosonow.Retosonow;
import ga.ganma.retosonow.api.MaingameControl;
import ga.ganma.retosonow.command.CommandAPI;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class TosoStart implements CommandAPI {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandlabel, String[] args) {
        MaingameControl.gamestart(Retosonow.pl);
        return false;
    }
}
