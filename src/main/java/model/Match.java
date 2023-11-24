package model;

public class Match {
    private int id;
    private int idusuario1;
    private int idusuario2;
    private int match;

    public Match() {
        this.id = 0;
        this.idusuario1 = 0;
        this.idusuario2 = 0;
        this.match = 0;
    }

    public Match(int id, int idusuario1, int idusuario2, int match) {
        setId(id);
        setIdusuario1(idusuario1);
        setIdusuario2(idusuario2);
        setMatch(match);
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setIdusuario1(int idusuario1) {
        this.idusuario1 = idusuario1;
    }

    public int getIdusuario1() {
        return idusuario1;
    }
    public void setIdusuario2(int idusuario2) {
        this.idusuario2 = idusuario2;
    }
    public int getIdusuario2() {
        return idusuario2;
    }
    public int getMatch() {
        return match;
    }
    public void setMatch(int match) {
        this.match = match;
    }

    
}
