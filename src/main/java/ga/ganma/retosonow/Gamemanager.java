package ga.ganma.retosonow;

import ga.ganma.retosonow.api.Position;
import ga.ganma.retosonow.mission.*;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class Gamemanager {
    private int prize,time;
    private long totalprize;
    private HashMap<Player, Position> playerposition = new HashMap<>();
    private ArrayList<MissionAPI> mission = new ArrayList<>();
    private boolean isgamestart;
    Gamemanager(int prize, int time){
        this.prize = prize;
        this.time = time;
    }

    public void addrunner(Player runner){
        this.playerposition.put(runner,Position.RUNNER);
    }

    public void addrunner(ArrayList<Player> runner){
        for(Player p : runner){
            this.playerposition.put(p,Position.RUNNER);
        }
    }

    public void addhunter(Player hunter){
        this.playerposition.put(hunter,Position.HUNTER);
    }

    public void addhunter(ArrayList<Player> hunter){
        for (Player p : hunter){
            playerposition.put(p,Position.HUNTER);
        }
    }

    public void addAdmin(ArrayList<Player> admin) {
        for (Player p : admin){
            playerposition.put(p, Position.ADMIN);
        }
    }

    public void addAdmin(Player admin){
        playerposition.put(admin,Position.ADMIN);
    }

    public Collection<Player> getAdmin(){
        ArrayList<Player> admins = new ArrayList<>();
        for (Player p : Bukkit.getOnlinePlayers()){
            if(playerposition.get(p) == Position.ADMIN){
                admins.add(p);
            }
        }
        return admins;
    }

    public boolean runnerkakuho(Player runner){
        if(isrunner(runner)){
            playerposition.put(runner,Position.JAILER);
            return true;
        }
        return false;
    }

    public boolean runnerRevival(Player jailer){
        if(isjailer(jailer)){
            playerposition.put(jailer,Position.RUNNER);
        }
        return false;
    }

    public void addjailer(Player jailer){
        playerposition.put(jailer,Position.JAILER);
    }

    public void addjailer(ArrayList<Player> jailer){
        for (Player p : jailer){
            playerposition.put(p, Position.JAILER);
        }
    }

    public int getPrize() {
        return prize;
    }

    public int getTime() {
        return time;
    }

    public Collection<Player> getRunner() {
        ArrayList<Player> runners = new ArrayList<>();
        for (Player p : Bukkit.getOnlinePlayers()){
            if(playerposition.get(p) == Position.RUNNER){
                runners.add(p);
            }
        }
        return runners;
    }

    public Collection<Player> getHunter() {
        ArrayList<Player> hunters = new ArrayList<>();
        for (Player p : Bukkit.getOnlinePlayers()){
            if(playerposition.get(p) == Position.HUNTER){
                hunters.add(p);
            }
        }
        return hunters;
    }

    public ArrayList<Player> getJailer() {
        ArrayList<Player> jailers = new ArrayList<>();
        for (Player p : Bukkit.getOnlinePlayers()){
            if(playerposition.get(p) == Position.ADMIN){
                jailers.add(p);
            }
        }
        return jailers;
    }

    public boolean isrunner(Player player){
        return playerposition.containsKey(player);
    }

    public boolean isjailer(Player player){
        return playerposition.containsKey(player);
    }

    public boolean ishunter(Player player){
        return playerposition.containsKey(player);
    }

    public boolean isadmin(Player player){
        return playerposition.containsKey(player);
    }

    public void setgamestart(){
        this.isgamestart = true;
    }

    public void setgameend(){
        this.isgamestart = false;
    }

    public boolean isgamestart() {
        return isgamestart;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public void setPrize(int prize) {
        this.prize = prize;
    }

    public void decreasetime(){
        if(this.time > 0) {
            this.time--;
        }
    }

    public void addprize(int add){
        if(add>0){
            this.prize = this.prize + add;
        }
    }

    public void addprize(){
        this.totalprize = this.totalprize + this.prize;
    }

    public long getTotalprize(){
        return totalprize;
    }

    public ArrayList<MissionAPI> getAllmission(){
        return mission;
    }

    public void registermission(){
        mission.add(new Mission1());
        mission.add(new Mission2());
        mission.add(new Mission3());
        mission.add(new Mission4());
    }

    public HashMap<Player,Position> getPlayerpositionHashMap(){
        return playerposition;
    }
}
