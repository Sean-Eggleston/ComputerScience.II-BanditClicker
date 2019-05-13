/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package retiredcode;

import retiredcode.Adventurer;

/**
 *
 * @author Sean
 */
public class Player extends Adventurer {
    public Player() { }
    public Player(String name, String PlClass, String Job, int STR, int AGI, int MAG, int CON, int HitDie, boolean alive) {
        super(name, PlClass, Job, STR, AGI, MAG, CON, HitDie, alive);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getPlClass() {
        return PlClass;
    }

    @Override
    public String getJob() {
        return Job;
    }

    @Override
    public int getHP() {
        return HP;
    }

    @Override
    public int getMP() {
        return MP;
    }

    @Override
    public int getAP() {
        return AP;
    }

    @Override
    public int getSTR() {
        return STR;
    }

    @Override
    public int getAGI() {
        return AGI;
    }

    @Override
    public int getMAG() {
        return MAG;
    }

    @Override
    public int getCON() {
        return CON;
    }

    @Override
    public int getHitDie() {
        return HitDie;
    }

    @Override
    public int getCurrentHP() {
        return currentHP;
    }

    @Override
    public int getCurrentMP() {
        return currentMP;
    }

    @Override
    public int getCurrentAP() {
        return currentAP;
    }

    @Override
    public boolean isAlive() {
        return alive;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setPlClass(String PlClass) {
        this.PlClass = PlClass;
    }

    @Override
    public void setJob(String Job) {
        this.Job = Job;
    }

    @Override
    public void setHP(int HP) {
        this.HP = HP;
    }

    @Override
    public void setMP(int MP) {
        this.MP = MP;
    }

    @Override
    public void setAP(int AP) {
        this.AP = AP;
    }

    @Override
    public void setSTR(int STR) {
        this.STR = STR;
    }

    @Override
    public void setAGI(int AGI) {
        this.AGI = AGI;
    }

    @Override
    public void setMAG(int MAG) {
        this.MAG = MAG;
    }

    @Override
    public void setCON(int CON) {
        this.CON = CON;
    }

    @Override
    public void setHitDie(int HitDie) {
        this.HitDie = HitDie;
    }

    @Override
    public void setCurrentHP(int currentHP) {
        this.currentHP = currentHP;
    }

    @Override
    public void setCurrentMP(int currentMP) {
        this.currentMP = currentMP;
    }

    @Override
    public void setCurrentAP(int currentAP) {
        this.currentAP = currentAP;
    }

    @Override
    public void setAlive(boolean alive) {
        this.alive = alive;
    }




    }
    

