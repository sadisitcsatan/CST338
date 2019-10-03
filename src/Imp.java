import java.util.HashMap;

public class Imp extends Monster {
    public Imp(int maxHP, int xp, HashMap<String, Integer> items) {
        super(xp, maxHP, items);
    }

    @Override
    public String toString() {
        return "Imp has : " +
                "hp=" + hp +
                '/' + getMaxHP();
    }
}
