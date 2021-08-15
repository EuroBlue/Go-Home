package pack;

import java.util.Random;

public class MainClass{
    public static void main(String[] args) throws Exception {
        System.out.println("Big Niggus gonna rape!");
        Window.start();
    }
    public static int genRanInt(int min, int max) {
        Random r=new Random();
        return min + r.nextInt((max-min+1)) +min;
    }
}