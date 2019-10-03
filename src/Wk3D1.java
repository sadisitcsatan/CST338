public class Wk3D1{
    String name;
    Integer count;


    public Wk3D1() {
        name = "Drew";
        count = 0;
    }

    @Override
    public String toString() {
        return "Wk3D1{" +
                "name='" + name + '\'' +
                ", count=" + count +
                '}';
    }

    public static void  main(String[] args){
        Wk3D1 o1 = new Wk3D1();
        Wk3D1 o2 = o1;
        System.out.println("o1 = " + o1);
        System.out.println("o2 = " + o2);
    }

}
