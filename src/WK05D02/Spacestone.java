package WK05D02;

public class Spacestone implements Istone{
    private String location = "unknown";
    private static Spacestone spacestone = null;

    public static Spacestone get(String location){
        if(spacestone == null){
            spacestone = new Spacestone(location);
        }
        spacestone.setLocation();
        return spacestone;
    }

    public void setLocation(String loc) {
        this.location = loc;
    }

    public String getLocation() {
        return location;
    }

    private Spacestone(String location){
        this.location = location;
    }

    public void special(Person owner) {

    }
}
