import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by TrungNT on 3/10/2016.
 */
public class Blood extends GameObject{
    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    private int width;
    private int height;

    public Blood(){
        this.positionX = 30;
        this.positionY = 30;
        this.width = 100;
        this.height = 10;
    }

    public Blood(int x, int y, int width, int height){
        this.positionX = x;
        this.positionY = y;
        this.width = width;
        this.height = height;

        try {
            this.sprite = ImageIO.read(new File("Resources/Blood.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void draw(Graphics g)
    {
        g.drawImage(this.sprite, this.positionX, this.positionY, this.width, this.height, null);
    }
}
