package Monsters;

import java.util.HashMap;
import java.util.Objects;
import java.util.Random;

import Abilities.*;
import Monsters.*;

public abstract class Monster {
    private Integer hp;
    private Integer xp;
    private Integer maxHP;
    Integer agi = 0;
    Integer def = 0;
    Integer str = 0;
    Attack attack;
    HashMap<String,Integer> items;

    public Monster(int xp, int maxHP, HashMap<String, Integer> items) {
        this.xp = xp;
        this.maxHP = maxHP;
        hp = maxHP;
        this.items = items;
    }

    public Integer getHp() {
        return hp;
    }

    public Integer getXp() {
        return xp;
    }

    public Integer getMaxHP() {
        return maxHP;
    }

    public HashMap<String, Integer> getItems() {
        return items;
    }

    public void setHp(Integer hp) {
        this.hp = hp;
    }

    public void setItems(HashMap<String, Integer> items) {
        this.items = items;
    }
    public Integer attackTarget(Monster target){
       return this.attack.attack(target);
    }

    public Integer getAgi() {
        return agi;
    }

    public Integer getDef() {
        return def;
    }

    public Integer getStr() {
        return str;
    }
    Integer getAttribute(Integer min, Integer max){
        Random rand = new Random();
        if(min > max){
            Integer temp = min;
            min = max;
            max = temp;
        }
        return rand.nextInt(max-min) + min;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Monster)) return false;
        Monster monster = (Monster) o;
        return getHp() == monster.getHp() &&
                getXp() == monster.getXp() &&
                getMaxHP() == monster.getMaxHP() &&
                getItems().equals(monster.getItems());
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "Monster{" +
                "hp=" + hp +
                ", xp=" + xp +
                ", maxHP=" + maxHP +
                ", agi=" + agi +
                ", def=" + def +
                ", str=" + str +
                ", attack=" + attack +
                ", items=" + items +
                '}';
    }
}
