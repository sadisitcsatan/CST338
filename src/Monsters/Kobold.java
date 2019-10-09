package Monsters;

import Abilities.*;

import java.util.HashMap;

public class Kobold extends Monster {
    public Kobold(int maxHP, int xp, HashMap<String, Integer> items) {

        super(xp, maxHP, items);
        Integer maxStr = 20;
        Integer maxDef = 5;
        Integer maxAgi = 7;
        attack = new RangedAttack(this);
        str = super.getAttribute(str,maxStr);
        def = super.getAttribute(def,maxDef);
        agi = super.getAttribute(agi,maxAgi);
    }

    @Override
    public String toString() {
        return "Monsters.Kobold has : " +
                "hp=" + super.getHp() +
                '/' + getMaxHP();
    }
}
