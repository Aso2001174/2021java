
import java.util.Random;

public class Ship {
    private int x;  //船の位置　(x位置)
    private int y;  //船の位置　(y位置)
    private int hp; //船の体力
    
    //判定結果の定数
    public final static int NOHIT = 0; //はずれ
    public final static int NEAR = 1; //波高し
    public final static int HIT = 2; //命中
    public final static int SINK = 3; //撃沈

    //コンストラクタで初期化をします
    public Ship(){
        x = 0;
        y = 0;
        hp = 3;
        System.out.println("コンストラクタが動きました。");
    }
    
    //船の位置を取得するメソッド
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    

    public void determinPos(){
        Random random = new Random();

        x = random.nextInt(5);
        y = random.nextInt(5);

        System.out.printf("船の位置を決めました！(%d, %d)\n", x, y);
    }

    //爆弾に対する当たり判定を行います
    //引数：爆弾の位置(bombX, bombY)
    //戻り値：判定結果（0：はずれ　1：波高し　2：命中　3：撃沈）
    public int judgeForBomb(int bombX, int bombY){
        int result = NOHIT;
        
        //体力がすでに0か
        if(hp == 0){
            return NOHIT;
        }
        //爆弾が船に当たったか？
        if( bombX == x && bombY == y){
            //船の体力を減らす
            hp = hp -1;
            if(hp == 0){
                //撃沈
                System.out.println("船は撃沈しました！");
                result = SINK;
            }else{
                //命中（まだ生きている）
                System.out.println("船に命中しました！");
                result = HIT;
            }
        }else if(
            (bombX == x && (bombY - 1) == y) || //上
            (bombX == x && (bombY + 1) == y) || //下
            ((bombX - 1) == x && bombY == y) || //左
            ((bombX + 1) == x && bombY == y)    //右
        ) {
             //波高し
             System.out.println("波高し！");
             result = NEAR;
        }

        return result;
    }

    //船が沈んでいるかのチェック
    public boolean isSink(){
        //体力が0なら船は沈んでいる
        return (hp == 0);
    }
}
