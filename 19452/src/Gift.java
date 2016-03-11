import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by TrungNT on 3/11/2016.
 */
public class Gift extends GameObject {
    private Gift()
    {
        this.positionX = 200;
        this.positionY = 200;
    }

    public Gift(int x, int y)
    {
        this.positionX = x;
        this.positionY = y;

        try {
            this.sprite = ImageIO.read(new File("Resources/gift.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics g)
    {
        g.drawImage(this.sprite, this.positionX, this.positionY, null);
    }

    //Phuong thuc kiem tra anh Plane move by Mouse giao voi anh qua tang Gift
    public boolean checkCollision()
    {
        Rectangle rectGift = new Rectangle(ManagerGift.getInstance().getGift().getPositionX(),
                                           ManagerGift.getInstance().getGift().getPositionY(),
                                           ManagerGift.getInstance().getGift().sprite.getWidth(),
                                           ManagerGift.getInstance().getGift().sprite.getHeight());

        Rectangle rectPlaneMouse =
                new Rectangle(PlaneManager.getInstance().getPlaneMoveByMouse().getPositionX()
                        ,PlaneManager.getInstance().getPlaneMoveByMouse().getPositionY()
                        ,PlaneManager.getInstance().getPlaneMoveByMouse().getWidth()
                        ,PlaneManager.getInstance().getPlaneMoveByMouse().getHeight());
        return rectGift.intersects(rectPlaneMouse);
    }
}
