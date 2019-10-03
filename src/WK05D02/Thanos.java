package WK05D02;

import java.util.ArrayList;
import java.util.List;

public class Thanos extends Person {
    List<Istone> stones = new ArrayList<>();

    Thanos(){
        this.setPower(1337.0);
    }

    @Override
    public String toString() {
        return "Power is " + power;
    }
    public void setStone(Istone stone){
        stones.add(stone);
    }
//    public Istone getStone(Istone stone){
//        return
//    }
}
