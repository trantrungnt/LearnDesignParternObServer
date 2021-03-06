import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

/**
 * Created by Tdh4vnPC on 3/1/2016.
 */
public class Bullet extends GameObject{

    private int speed;

    private Vector<PlaneEnemy> vectorPlaneEnemy = PlaneEnemyManager.getInstance().getVectorPlaneEnemy();

    private Bullet() {
        positionX = 0;
        positionY = 0;
    }

    public Bullet(int positionX, int positionY, int speed) {//Alt + Inseart
        this.positionX = positionX;
        this.positionY = positionY;
        this.speed = speed;
        try {
            this.sprite = ImageIO.read(new File("Resources/DAN.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void move(){
        this.positionY -= this.speed;
    }

    public void update(){
        int x;
        this.move();

        if (checkCollision()) {
            //asdasdsadsadasdasdasdasd
            System.out.println("Trung dan roi!");
            //don vi mau giam di 30 don vi mau

            if (BloodManager.getInstance().getBlood().getWidth()>0) {
                x = BloodManager.getInstance().getBlood().getWidth()-3;
                BloodManager.getInstance().getBlood().setWidth(x);
            }
            else
            {
                BloodManager.getInstance().getBlood().setWidth(0);
                BloodManager.getInstance().getBlood().setHeight(0);
            }
        }

        //System.out.println(checkCollisionBulletPlaneEnemy());
        for (int i=0; i<vectorPlaneEnemy.toArray().length; i++)
            if (checkCollisionBulletPlaneEnemy())
                vectorPlaneEnemy.removeElementAt(i);


    }

    //kiem tra hinh chu nhat dan co giao voi hinh chu nhat may bay PlaneKey khong?
    public boolean checkCollision(){
        Rectangle rectBullet = new Rectangle(positionX,positionY,sprite.getWidth()
                                            ,sprite.getHeight());
        Rectangle rectPlaneKey =
                new Rectangle(PlaneManager.getInstance().getPlaneMoveByKey().getPositionX()
                            ,PlaneManager.getInstance().getPlaneMoveByKey().getPositionY()
                            ,PlaneManager.getInstance().getPlaneMoveByKey().getWidth()
                            ,PlaneManager.getInstance().getPlaneMoveByKey().getHeight());
        return rectBullet.intersects(rectPlaneKey);
    }
    //Lay toa do cua 2 may bay
    //PlaneManager.getInstance()....

    ////////////////////////////////////////////////////////////////////////
    //kiem tra hinh chu nhat dan Bullet co giao voi hinh chu nhat may bay PlaneEnemy khong?
    public boolean checkCollisionBulletPlaneEnemy(){
        /*for (PlaneEnemy planeEnemy : vectorPlaneEnemy) {
            Rectangle rectPlaneEnemy =
                    new Rectangle(planeEnemy.getPositionX()
                            , planeEnemy.getPositionY()
                            , planeEnemy.getSprite().getWidth()
                            , planeEnemy.getSprite().getHeight());
            System.out.println(rectBullet.intersects(rectPlaneEnemy));
        }*/
        boolean check=false;

        Rectangle rectBullet = new Rectangle(positionX, positionY,
                sprite.getWidth(), sprite.getHeight());



        for (int i=0; i< vectorPlaneEnemy.toArray().length; i++)
        {
            Rectangle rectPlaneEnemy =
                    new Rectangle(vectorPlaneEnemy.elementAt(i).getPositionX()
                            , vectorPlaneEnemy.elementAt(i).getPositionY()
                            , vectorPlaneEnemy.elementAt(i).getSprite().getWidth()
                            , vectorPlaneEnemy.elementAt(i).getSprite().getHeight());
            check = rectBullet.intersects(rectPlaneEnemy);
        }

        return check;
    }



    public void draw(Graphics g){
        g.drawImage(sprite,positionX,positionY,null);
        BloodManager.getInstance().getBlood().draw(g);


    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
