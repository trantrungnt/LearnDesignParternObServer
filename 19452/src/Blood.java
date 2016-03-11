import java.awt.*;

/**
 * Created by TrungNT on 3/10/2016.
 */
public class Blood extends GameObject{
    public Blood(){
        this.positionX = 30;
        this.positionY = 30;
    }

    public void draw(Graphics g, int width, int height)
    {
        g.drawRect(this.getPositionX(), this.getPositionY(), width, height);
        g.fillRect(this.getPositionX(), this.getPositionY(), width, height);
        g.setColor(Color.red);
    }
}
