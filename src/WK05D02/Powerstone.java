package WK05D02;

public class Powerstone implements Istone{
        Double powerUp = 1.5;
        private static Powerstone powerstone = null;
    public void special(Person owner){
        System.out.println("Using the Powerstone!!");
        Double power = owner.getPower();
        power *= powerUp;
        owner.setPower(power);
    }
    public static Powerstone get(){
        if(powerstone == null){
            powerstone = new Powerstone();
        }
        return powerstone;
    }

    private Powerstone(){
    }
}
