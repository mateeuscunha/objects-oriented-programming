import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Lagosta here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Lagosta extends Actor
{
    /**
     * Act - do whatever the Lagosta wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        movimentar();
        tentarComer();
    }
    private void movimentar() {
        move(2);
        if (Greenfoot.getRandomNumber(100) < 10) {
            int angulo = Greenfoot.getRandomNumber(90) - 45;
            turn(angulo);
        }
        if (isAtEdge()) {
            turn(180);
        }
    }
    private void tentarComer() {
        Actor caranguejo = getOneIntersectingObject(Caranguejo.class);
        if (caranguejo != null) {
            World mundo = getWorld();
            mundo.removeObject(caranguejo);
            Greenfoot.playSound("comendo.wav");
        }
    }

}
