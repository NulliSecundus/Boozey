package wisc.boozey;

/**
 * Created by Christopher on 10/31/2017.
 */

public class Friend {
    private String name;
    private int played;
    private int w;
    private int l;
    private int isUser;
    public Friend(String name, int played, int w, int l, int isUser) {
        this.name = name;
        this.played = played;
        this.w = w;
        this.l = l;
        this.isUser = isUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPlayed() {
        return played;
    }

    public void setPlayed(int played) {
        this.played = played;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getL() {
        return l;
    }

    public void setL(int l) {
        this.l = l;
    }

    public int getIsUser() { return isUser; }

    public void setIsUser() { this.isUser = isUser; }
}
