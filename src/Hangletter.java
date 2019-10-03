public class Hangletter {
    private boolean found;
    private char let;
    private char show;

    public Hangletter(char let) {
        this.let = let;
        this.show = '_';
        this.found = false;
    }

    public boolean isFound() {
        return found;
    }

    public void setFound(boolean found) {
        this.found = found;
        if(found){
            this.show = Character.toUpperCase(this.let);
        }else {
            this.show = '_';
        }
    }

    public char getShow() {
        return show;
    }

    public char getLet() {
        return let;
    }
}
