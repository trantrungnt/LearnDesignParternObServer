# LearnDesignParternObServer
+ Singleton: nghĩa là 1 đối tượng có thể được gọi mọi lúc, mọi nơi trong chương trình, chỉ tồn tại duy nhất 1 thực thể ở tại chương trình

```
public class PlaneEnemyManager { //singleton: thuc the duy nhat quan ly 2 may bay dich PlaneEnemy
    private Vector<PlaneEnemy> vectorPlaneEnemy;
    private static PlaneEnemyManager ourInstance = new PlaneEnemyManager();

    public static PlaneEnemyManager getInstance() {
        return ourInstance;
    }

    private PlaneEnemyManager() {
        vectorPlaneEnemy = new Vector<PlaneEnemy>();
    }

    public Vector<PlaneEnemy> getVectorPlaneEnemy() {
        return vectorPlaneEnemy;
    }
}
```

+ Trong class Bullet: ta định nghĩa hàm kiểm tra hình chữ nhật đạn giao với hình chữ nhật máy bay
```
public void update(){
        this.move();
        if (checkCollision()){
            //asdasdsadsadasdasdasdasd
            System.out.println("Trung dan roi!");
        }
    }
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
```
