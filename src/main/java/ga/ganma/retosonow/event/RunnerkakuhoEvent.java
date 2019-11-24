package ga.ganma.retosonow.event;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class RunnerkakuhoEvent extends Event implements Cancellable {

    private static HandlerList handlers = new HandlerList();
    private Player runner,hunter;
    private boolean cancelled;

    public RunnerkakuhoEvent(Player runner , Player hunter){
        this.runner = runner;
        this.hunter = hunter;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    public Player getRunner() {
        return runner;
    }

    public Player getHunter() {
        return hunter;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        cancelled = cancel;
    }
}
