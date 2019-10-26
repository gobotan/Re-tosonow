package ga.ganma.retosonow.api;

public enum Position {
    RUNNER("逃走者"),
    HUNTER("ハンター"),
    JAILER("確保者"),
    ADMIN("運営");
    private String st;

    Position(String s) {
        this.st = s;
    }

    public String  getJPtext(){
        return this.st;
    }
}
