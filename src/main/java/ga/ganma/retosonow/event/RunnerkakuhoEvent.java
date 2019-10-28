package ga.ganma.retosonow.event;

import ga.ganma.retosonow.api.GamePlayer;
import ga.ganma.retosonow.api.Position;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.*;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class RunnerkakuhoEvent extends Event implements Listener, Cancellable {

    private static HandlerList handlers = new HandlerList();
    private Player runner,hunter;
    private boolean cancelled;

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public Player getRunner() {
        return runner;
    }

    public Player getHunter() {
        return hunter;
    }

    @EventHandler
    public void getEntityDamageByEntityEvent(EntityDamageByEntityEvent e){
        Entity fromentity = e.getEntity();
        Entity toentity = e.getDamager();
        if(fromentity instanceof Player && toentity instanceof Player){
            Player fromplayer = (Player) fromentity;
            Player toplayer = (Player) toentity;
            if(GamePlayer.getPlayerposition(fromplayer) == Position.RUNNER &&
            GamePlayer.getPlayerposition(toplayer) == Position.HUNTER){
                runner = fromplayer;
                hunter = toplayer;
                RunnerkakuhoEvent event = new RunnerkakuhoEvent();
                Bukkit.getServer().getPluginManager().callEvent(event);
            }
        }
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
