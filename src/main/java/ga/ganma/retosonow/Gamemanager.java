package ga.ganma.retosonow;

import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Collection;

public class Gamemanager {
    private int prize,time;
    private long totalprize;
    private ArrayList<Player> runner = new ArrayList<>()
            ,hunter = new ArrayList<>()
            ,jailer = new ArrayList<>()
            ,admin = new ArrayList<>();
    private boolean isgamestart;
    Gamemanager(int prize, int time){
        this.prize = prize;
        this.time = time;
    }

    public void addrunner(Player runner){
        this.runner.add(runner);
    }

    public void addrunner(ArrayList<Player> runner){
        this.runner.addAll(runner);
    }

    public void addhunter(Player hunter){
        this.hunter.add(hunter);
    }

    public void addhunter(ArrayList<Player> hunter){
        this.hunter.addAll(hunter);
    }

    public void addAdmin(ArrayList<Player> admin) {
        this.admin.addAll(admin);
    }

    public void addAdmin(Player admin){
        this.admin.add(admin);
    }

    public Collection<Player> getAdmin(){
        return admin;
    }

    public boolean runnerkakuho(Player runner){
        if(this.runner.contains(runner)){
            this.runner.remove(runner);
            this.jailer.add(runner);

            return true;
        }
        return false;
    }

    public boolean runnerRevival(Player jailer){
        if(this.jailer.contains(jailer)){
            this.jailer.remove(jailer);
            this.runner.add(jailer);

            return true;
        }
        return false;
    }

    public void removeRunner(Player runner){
        if(isrunner(runner)) {
            this.runner.remove(runner);
        }
    }

    public void removehunter(Player hunter){
        if(ishunter(hunter)) {
            this.hunter.remove(hunter);
        }
    }

    public void removejailer(Player jailer){
        if(isjailer(jailer)){
            this.jailer.remove(jailer);
        }
    }

    public void removeadmin(Player admin){
        if(isadmin(admin)){
            this.admin.remove(admin);
        }
    }

    public void addjailer(Player jailer){
        this.jailer.add(jailer);
    }

    public void addjailer(ArrayList<Player> jailer){
        this.jailer.addAll(jailer);
    }

    public int getPrize() {
        return prize;
    }

    public int getTime() {
        return time;
    }

    public ArrayList<Player> getRunner() {
        return runner;
    }

    public ArrayList<Player> getHunter() {
        return hunter;
    }

    public ArrayList<Player> getJailer() {
        return jailer;
    }

    public boolean isrunner(Player player){
        return this.runner.contains(player);
    }

    public boolean isjailer(Player player){
        return this.jailer.contains(player);
    }

    public boolean ishunter(Player player){
        return this.hunter.contains(player);
    }

    public boolean isadmin(Player player){
        return this.admin.contains(player);
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
}
