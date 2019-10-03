package WK05D02;

import java.util.ArrayList;
import java.util.List;

public class Gauntlet {



    public static void main(String[] args) {
        Thanos madTitan = new Thanos();
        System.out.println(madTitan);
        Istone powerstone = Powerstone.get();

        madTitan.setStone(powerstone);
        for(int i =0 ; i < 5; i++) {
            madTitan.stones.get(0).special(madTitan);
        }
        powerstone.special(madTitan);
        System.out.println(madTitan);
    }
}
