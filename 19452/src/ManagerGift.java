/**
 * Created by TrungNT on 3/11/2016.
 */
public class ManagerGift {
    private static ManagerGift _sharePointer;

    public Gift getGift() {
        return gift;
    }

    private Gift gift;

    private ManagerGift()
    {
        //khoi tao qua tang gift
        gift = new Gift(300, 400);
    }

    public static ManagerGift getInstance(){
        if(_sharePointer == null){
            _sharePointer = new ManagerGift();
        }
        return _sharePointer;
    }
}
