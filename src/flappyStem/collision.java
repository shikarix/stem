package flappyStem;

public class collision {
    public boolean collision(Column A, Player B){
//        if (A.getX() + A.getW() < B.getX() || A.getX() > B.getX() + B.getW() || A.getY() + A.getH() < B.getY() || A.getY() > B.getY() + B.getH()) return false;
        if (B.getX() + B.getW() < A.getX() || B.getX() > A.getX() + A.getW() || B.getY() + B.getH() < A.getY() || B.getY() > A.getY() + A.getH()) return false;
        return true;
    }
}
