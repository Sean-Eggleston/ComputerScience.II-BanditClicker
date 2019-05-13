/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package retiredcode;

/**
 *
 * @author seane1001
 */
abstract class Beast {
    String name;
    int HP, AP;
    boolean isAlive;

    public Beast(String name, int HP, int AP, boolean isAlive) {
        this.name = name;
        this.HP = HP;
        this.AP = AP;
        this.isAlive = isAlive;
    }

 
    
    public void setName(String name) {
        this.name = name;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public void setAP(int AP) {
        this.AP = AP;
    }

    public void setIsAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }

    public String getName() {
        return name;
    }

    public int getHP() {
        return HP;
    }

    public int getAP() {
        return AP;
    }

    public boolean isIsAlive() {
        return isAlive;
    }
    
    
    
}
