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
abstract class Humanoid {

    public Humanoid(String name, String job, String role, int HP, int MP, int AP, boolean alive) {
        this.name = name;
        this.job = job;
        this.role = role;
        this.HP = HP;
        this.MP = MP;
        this.AP = AP;
        this.alive = alive;
    }
    String name, job, role;
    int HP, MP, AP;
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

    public String getJob() {
        return job;
    }

    public String getRole() {
        return role;
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
    void setJob(String job) {
        this.job = job;
    }
    void setRole(String role) {
        this.role = role;
    }
}

