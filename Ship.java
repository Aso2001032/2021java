package kadai;

public class Ship{
    private int x;
    private int y;
    private int vitality;
    private final int MAX_VITALITY = 3;
    public final static int NO_HIT = 0;
    public final static int NEAR = 1;
    public final static int HIT = 2;
    public final static int SINK = 3;

    public int getPosX(){return x;}
    public int getPosY(){return y;}

    public Ship(){
        x = 0;
        y = 0;

    }

    public void init(int mapSize){
        move(mapSize);
        vitality = MAX_VITALITY;
    }

    public void move(int mapSize){
        x = (int)(Math.random()*mapSize);
        y = (int)(Math.random()*mapSize);
    }

    public void check(int x,int y){
        int result = NO_HIT;
        if(x == this.x && y == this.y){
            vitality--;
            if( vitality == 0){
                result = SINK;
            }else{
                result = HIT;
            }
        }
        else if(
            (this.x-1 <= x && x <= this.x+1) &&
            (this.y-1 <= y && y <= this.y+1)
        ){
            result = NEAR;
        }

        return result;
    }

    public boolean isAlive(){
        return (vitality>0);
    }
}