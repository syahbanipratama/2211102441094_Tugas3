import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class skor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class skor extends Actor
{
    /**
     * Act - do whatever the skor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public static int skor;//membuat variabel skor
    public skor(){
        skor= 0;//pemberian nilai awal 0
    }
    public void act()
    {
        World myWorld =getWorld();
        myWorld.showText(String.valueOf(skor), 300, 100);//penempatan skor
    }
    //skor akan bertambah sesuai dengan ikan yang dilewati
    public static void add(int num){
        skor += num;
    }
}
