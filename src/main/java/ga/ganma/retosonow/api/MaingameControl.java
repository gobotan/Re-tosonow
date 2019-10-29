package ga.ganma.retosonow.api;

import ga.ganma.retosonow.Retosonow;
import ga.ganma.retosonow.mission.FinalMission;
import ga.ganma.retosonow.mission.MissionAPI;
import ga.ganma.retosonow.runneble.MainGametimer;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.Collections;


public class MaingameControl {

    private static MissionAPI[] mission = new MissionAPI[2];
    private FinalMission finalmission;
    private static byte missionnumber;
    private static MainGametimer mg = new MainGametimer();

    public static void gamestart(Plugin plugin){
        mg.runTaskTimer(plugin,0,20);
        Retosonow.getGamemanager().registermission();
        Retosonow.getGamemanager().setgamestart();
    }

    public static void gameend(Plugin plugin){
        mg.cancel();
        Retosonow.resetGamemanager();
        missionnumber = 0;
    }

    public static TextComponent gettime(){
        TextComponent component = new TextComponent();
        int sec = Retosonow.getGamemanager().getTime();
        String time = sec % 60 < 10 ?  (sec%3600)/60 + ":0" + sec%60 : (sec%3600)/60 + ":" + sec%60;
        component.setText(time);
        return component;
    }

    public static void onmission(){
        mission[missionnumber].onmission();
    }

    public static void failedmission(){
        mission[missionnumber].missionfailure();
    }

    public static void successmission(){
        mission[missionnumber].missionSuccess();
    }

    public static void endmission(){
        mission[missionnumber].missionend();
        missionnumber++;
    }

    public static String getmissiontitle(){
        return mission[missionnumber].getmissionname();
    }

    public static void onFinalmission(){

    }

    private static void setupmission(){
        ArrayList<MissionAPI> arraymission = new ArrayList<>(Retosonow.getGamemanager().getAllmission());
        Collections.shuffle(arraymission);
        mission[0] = arraymission.get(0);
        mission[1] = arraymission.get(1);
        mission[2] = arraymission.get(2);
    }

    public static Player randomselectPlayer(ArrayList<Player> players){
        Collections.shuffle(players);
        return players.get(0);
    }

    public Location gethunterboxLoc(int boxnumber, String worldname){
        FileConfiguration fc2 = Retosonow.gethunterboxConfig(boxnumber);
        String location = fc2.getString(worldname + ".Location");
        return Serialize.getLocationFromString(location);
    }

    public void sethunterboxloc(int boxnumber , Location loc){
        FileConfiguration fc2 = Retosonow.gethunterboxConfig(boxnumber);
        fc2.set(loc.getWorld().getName() + ".location",Serialize.getStringFromLocation(loc));
    }
}
