import java.util.Scanner;

public class Main{
    private static int bombX = 0;
    private static int bombY = 0;
    public static void main(String[] args){
         dispTitle();
         
         //船の数分ループして位置を決める
         Ship[] ships = new Ship[3];
         for(int i = 0; i < 3; i++){
              ships[i] = new Ship();

              do{
                  ships[i].determinPos();
              }while( isDuplicateShipPos(ships[i], ships) );
            
         }

        Scanner sc = new Scanner(System.in);
         
         while(isShipAlive(ships)){
             inputBombPos(sc);

             for(int i = 0; i < 3; i++){
                int result = ships[i].judgeForBomb(bombX, bombY);
                //判定を受けての処理
                actionForJudge(result, ships[i], ships);
             }
             
         }
        
    }

    public static void dispTitle(){
        System.out.println("戦艦ゲーム");
    }

    //爆弾の位置を決めます
    public static void inputBombPos(Scanner sc){
        System.out.println("爆弾のX位置を入力してください！");
        bombX = sc.nextInt();

        System.out.println("爆弾のY位置を入力してください！");
        bombY = sc.nextInt();
    }

    //判定の結果を受けて必要な処理を行う
    public static void actionForJudge(int result, Ship myShip, Ship[] ships){
        if(result == Ship.HIT){
            //位置を決める
            do{
                myShip.determinPos();
            }while( isDuplicateShipPos(myShip, ships) );
        }
    }

    //かぶりチェックメソッド
    public static boolean isDuplicateShipPos(Ship myShip, Ship[] otherShips){

        boolean isSamePos = false;
        
        //チェックする船の数文ループする
        for(int i = 0; i < otherShips.length; i++){

            if(myShip != otherShips[i] && otherShips[i] != null){

                if(
                    myShip.getX() == otherShips[i].getX() && 
                    myShip.getY() == otherShips[i].getY()
                ){
                    isSamePos = true;
                    break;
                }
            }
        }
        return isSamePos;
    }

    //船がまだ残っているかのチェック
    public static boolean isShipAlive(Ship[] ships){
        boolean isAlive = false;
        for(Ship ship : ships){
            if(ship.isSink() == false){
                //生き残っている船がいる
                isAlive = true;
                break;
            }
        }

        return isAlive;
    }
}