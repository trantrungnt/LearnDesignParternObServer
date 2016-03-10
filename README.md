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
