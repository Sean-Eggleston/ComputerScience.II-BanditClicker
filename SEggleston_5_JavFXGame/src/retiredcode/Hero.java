/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package retiredcode;

/**
 *
 * @author sean-e
 */
public class Hero {

    String name, PlClass, Job;
    int HP, MP, AP, STR, AGI, MAG, CON, HitDie, currentHP, currentMP, currentAP;
    boolean alive;

    static class PlayerCharacter {

        String name, PlClass, Job;
        int HP, MP, AP, STR, AGI, MAG, CON, HitDie, currentHP, currentMP, currentAP;
        boolean alive;

        public PlayerCharacter(String name, String PlClass, String Job, int HP, int MP, int AP, int STR, int AGI, int MAG, int CON, int HitDie) {
            this.name = name;
            this.PlClass = PlClass;
            this.Job = Job;
            this.HP = HP;
            this.MP = MP;
            this.AP = AP;
            this.STR = STR;
            this.AGI = AGI;
            this.MAG = MAG;
            this.CON = CON;
            this.HitDie = HitDie;
        }

        public String getName() {
            return name;
        }

        public String getPlClass() {
            return PlClass;
        }

        public String getJob() {
            return Job;
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

        public int getCurrentHP() {
            return currentHP;
        }

        public int getCurrentMP() {
            return currentMP;
        }

        public int getCurrentAP() {
            return currentAP;
        }

        public boolean isAlive() {
            return alive;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setPlClass(String PlClass) {
            this.PlClass = PlClass;
        }

        public void setJob(String Job) {
            this.Job = Job;
        }

        public void setHP(int HP) {
            this.HP = HP;
        }

        public void setMP(int MP) {
            this.MP = MP;
        }

        public void setAP(int AP) {
            this.AP = AP;
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

        public void setCurrentHP(int currentHP) {
            this.currentHP = currentHP;
        }

        public void setCurrentMP(int currentMP) {
            this.currentMP = currentMP;
        }

        public void setCurrentAP(int currentAP) {
            this.currentAP = currentAP;
        }

        public void setAlive(boolean alive) {
            this.alive = alive;
        }

    }

    public String getName() {
        return name;
    }

    public String getPlClass() {
        return PlClass;
    }

    public String getJob() {
        return Job;
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

    public int getCurrentHP() {
        return currentHP;
    }

    public int getCurrentMP() {
        return currentMP;
    }

    public int getCurrentAP() {
        return currentAP;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPlClass(String PlClass) {
        this.PlClass = PlClass;
    }

    public void setJob(String Job) {
        this.Job = Job;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public void setMP(int MP) {
        this.MP = MP;
    }

    public void setAP(int AP) {
        this.AP = AP;
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

    public void setCurrentHP(int currentHP) {
        this.currentHP = currentHP;
    }

    public void setCurrentMP(int currentMP) {
        this.currentMP = currentMP;
    }

    public void setCurrentAP(int currentAP) {
        this.currentAP = currentAP;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }
    
    
    
}
