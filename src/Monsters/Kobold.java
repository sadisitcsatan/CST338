package Monsters;

import java.util.HashMap;

public class Kobold extends Monster {
    public Kobold(int maxHP, int xp, HashMap<String, Integer> items) {
        super(xp, maxHP, items);
    }

    @Override
    public String toString() {
        return "Monsters.Kobold has : " +
                "hp=" + hp +
                '/' + getMaxHP();
    }
}
