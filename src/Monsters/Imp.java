package Monsters;

import Abilities.MeleeAttack;

import java.util.HashMap;

public class Imp extends Monster {
    public Imp(int maxHP, int xp, HashMap<String, Integer> items) {

        super(xp, maxHP, items);
        Integer maxStr = 15;
        Integer maxDef = 6;
        Integer maxAgi = 3;
        attack = new MeleeAttack(this);
        str = super.getAttribute(str,maxStr);
        def = super.getAttribute(def,maxDef);
        agi = super.getAttribute(agi,maxAgi);
    }

    @Override
    public String toString() {
        return "Monsters.Imp has : " +
                "hp=" + super.getHp() +
                '/' + getMaxHP();
    }
}
