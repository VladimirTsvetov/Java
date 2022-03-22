package java2.homework1;

public interface Prohibitive {
    default double getWall(){
        return 0;
    };
    default double getTreadMill(){
        return 0;
    }
}
