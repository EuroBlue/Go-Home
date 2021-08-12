package pack;

import java.util.Random;

public class MainClass{
    private static int c=0;
    private static int c2=0;
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        System.out.println("0: "+c2+" 1: "+c);
        Window.start();
    }
    public static int genRanInt(int min, int max) {
        Random r=new Random();
        return min + r.nextInt((max-min+1)) +min;
    }
}
// TODO: game itself