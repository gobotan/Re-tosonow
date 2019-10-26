package ga.ganma.retosonow.mission;

import org.bukkit.Location;

public abstract class MissionAPI {

    Location missionlocation;
    String missionname;
    boolean ismissionclear;
    boolean ismisisonstart;

    //missionAPI型の配列のオブジェクトを作成して、ミッションの実行
    //これはあくまでも基本的なやつなので、継承先で新たなメソッドを作ることも可能


    //ミッションが実行されたとき
    abstract void onmission();

    //ミッションのタイトルを返すメソッド
    abstract String getmissionname();

    //失敗か成功かに関わらずミッション終了時に呼び出されるメソッド
    abstract void missionend();

    //ミッションが失敗したときに呼び出されるメソッド
    abstract void  missionfailure();

    //ミッションが成功したときに呼び出されるメソッド
    abstract void missionSuccess();
}
