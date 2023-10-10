import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class bird here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class bird extends Actor
{
    /**
     * Act - do whatever the bird wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private double g = 1;
    private int y = 200;
    private boolean haspressed = false;
    private boolean isalive = true;
    private boolean isacross = false;
    private boolean hasaddscore = false;//Nilai awal artinya belum ditambah 
    public bird(){
        GreenfootImage image = getImage();
        image.scale(50, 40);
    }
    public void act()
    {
        //Jika tekan spasi, koordinat y akan berkurang dan terbang ke atas
        if(spacePressed()){
            g = -2;
        }
        g += 0.1; //Nilai g meningkat 0.1 setiap saat
        y += g; //Nilai y tidak berubah dengan kecepatan konstan
        setLocation(getX(), (int)(y));
        //jika menabrak ikan maka bird mati
        if(isTouchikan()){
            isalive = false;
        }
        //pemberian suara pada saat game  over 
        if(isTouchikan()){
            isalive = false;
        }
        //setelah jatuh atau menabrak ikan maka bird hilang
        if(!isalive){
            getWorld().addObject(new gameover(), 300, 200);
            getWorld().removeObject(this);
        }
        //penambahan skor setelah melewati ikan dan pemberian suara
        if(!hasaddscore && isacross && isalive){
            Greenfoot.playSound("score.mp3");
            skor.add(1);
        }
        hasaddscore = isacross;
    }
    public boolean spacePressed(){
        boolean pressed = false;
        if(Greenfoot.isKeyDown("Space")){
            if(!haspressed){//pemberian suara
                Greenfoot.playSound("flay.mp3");
                pressed = true;
            }
            haspressed = true;
        }else{
            haspressed = false;
        }
        return pressed;
    }
    //pemberian suara ketika menabrak ikan dan jatuh
    public boolean isTouchikan(){
        isacross = false;
        for(ikan ikan : getWorld().getObjects(ikan.class)){
            if(Math.abs(ikan.getX() - getX()) < 69){
            if(Math.abs(ikan.getY() + 30 - getY()) > 37){
                Greenfoot.playSound("peng.mp3");
                isalive = false;
            }
            isacross = true;
        }
    }
    return !isalive;
}
}
