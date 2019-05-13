/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package retiredcode;

/**
 *
 * @author Sean
 */
abstract class Adventurer {

    public Adventurer() {
    }
    
    public Adventurer(String name, String PlClass, String Job, int STR, int AGI, int MAG, int CON, int HitDie, boolean alive) {
        this.name = name;
        this.PlClass = PlClass;
        this.Job = Job;
        this.STR = STR;
        this.AGI = AGI;
        this.MAG = MAG;
        this.CON = CON;
        this.HitDie = HitDie;
        this.HP = HitDie + ((CON - 10)/2);
        this.MP = ((MAG - 10)/2);
        this.AP = ((AGI - 10)/2);
        this.alive = alive;
        this.currentHP = this.HP;
        this.currentMP = this.MP;
        this.currentAP = this.AP;
    }

    public void setCurrentHP(int currentHP) {
        this.currentHP = currentHP;
    }

    public void setCurrentMP(int currentMP) {
        this.currentMP = currentMP;
    }

    public void setCurrentAP(int currentAP) {
        this.currentAP = currentAP;
    }

    public int getCurrentHP() {
        return currentHP;
    }

    public int getCurrentMP() {
        return currentMP;
    }

    public int getCurrentAP() {
        return currentAP;
    }
    String name, PlClass, Job;
    int HP, MP, AP, STR, AGI, MAG, CON, HitDie, currentHP, currentMP, currentAP;
    boolean alive;
    
    void setHP(int HP) {
        this.HP = HP;
    }
    void setMP(int MP) {
        this.MP = MP;
    }
    void setAP(int AP)  {
        this.AP = AP;
    }
    void setAlive(boolean alive) {
        this.alive = alive;
    }
    void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getHP() {
        return HP;
    }

    public int getMP() {
        return MP;
    }

    public int getAP() {
        return AP;
    }

    public boolean isAlive() {
        return alive;
    }

    public String getPlClass() {
        return PlClass;
    }

    public String getJob() {
        return Job;
    }

    public int getSTR() {
        return STR;
    }

    public int getAGI() {
        return AGI;
    }

    public int getMAG() {
        return MAG;
    }

    public int getCON() {
        return CON;
    }

    public int getHitDie() {
        return HitDie;
    }

    public void setPlClass(String PlClass) {
        this.PlClass = PlClass;
    }

    public void setJob(String Job) {
        this.Job = Job;
    }

    public void setSTR(int STR) {
        this.STR = STR;
    }

    public void setAGI(int AGI) {
        this.AGI = AGI;
    }

    public void setMAG(int MAG) {
        this.MAG = MAG;
    }

    public void setCON(int CON) {
        this.CON = CON;
    }

    public void setHitDie(int HitDie) {
        this.HitDie = HitDie;
    }
    
}

