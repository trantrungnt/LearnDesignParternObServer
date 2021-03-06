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
+ Định nghĩa ObServer
```
public interface Observer {
    void update(String msg);
}
```

+ Định nghĩa Subject 
```
public interface Subject {
    void addObserver(Observer ob);
    void removeObserver(Observer ob);
    void notifiObserver();
}
```

+ Máy bay Plane dùng Subject để phát thông điệp 
```
public class Plane extends GameObject implements Subject{
    ...

    @Override
    public void addObserver(Observer ob) {
        vecTai.add(ob);
    }

    @Override
    public void removeObserver(Observer ob) {
        vecTai.remove(ob);
    }

    @Override
    public void notifiObserver() {
        if(true){
            System.out.println("AAAAA");
            for(Observer ob : vecTai){
                ob.update("Bo Vua An Duoc Qua");
            }
        }
    }
   
    ....
}

```


+ Các máy bay địch PlaneEnemy dùng ObServer để lắng nghe thông điệp
```
public class PlaneEnemy extends GameObject implements Observer{
.....
//Kiem tra thong diep tu may bay Plane vua gui cho may bay dich PlaneEnemy
@Override
    public void update(String msg) {
        if(msg.equals("Bo Vua An Duoc Qua")){
            //tao tu huy
            System.out.println("Thang Player Vua An Duoc Qua Roi");
        }
    }
.....
}
```

##Yêu cầu làm thêm:
+ Vẽ thanh máu: khi ta bị trúng đạn của địch thì ta bị mất 3 máu
+ Xử lý va chạm như sau: mình bắn dịch chết luôn, mình ăn quà thì địch chết hết

##Hiện tại đang làm kiểu
+ Máy bay MoveByMouse ăn quà thì tất cả máy bay địch PlaneEnemy đều chết
+ Máy bay MoveByKey khi bị trúng đạn thì bị mất 3 máu
+ Máy bay MoveByMouse bắn đạn thì: Máy bay PlaneEnemy nào bị trúng đạn thì bị chết

##Tham khảo
+ [Học về Design Partern](http://www.tutorialspoint.com/design_pattern/index.htm)