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
}
