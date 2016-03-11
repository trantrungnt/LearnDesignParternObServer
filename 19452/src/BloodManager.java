/**
 * Created by TrungNT on 3/10/2016.
 */
public class BloodManager {
    private static BloodManager _sharePointer;

    public Blood getBlood() {
        return blood;
    }

    private Blood blood;

    private BloodManager()
    {
        blood = new Blood(30, 30, 200, 10);
    }

    public static BloodManager getInstance(){
        if(_sharePointer == null){
            _sharePointer = new BloodManager();
        }
        return _sharePointer;
    }


}
