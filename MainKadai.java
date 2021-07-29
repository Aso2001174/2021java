import java.util.Scanner;

public class MainKadai {
    public static void main(String[] args){

        System.out.println("************************");
        System.out.println("       戦艦ゲーム      ");
        System.out.println("************************");
        
        int[][] sea = new int[5][5];
        sea[0][0] = 1;
        sea[0][1] = 1;
        sea[0][2] = 2;
        sea[0][3] = 0;
        sea[0][4] = 0;
        
        sea[1][0] = 2;
        sea[1][1] = 2;
        sea[1][2] = 0;
        sea[1][3] = 2;
        sea[1][4] = 0;

        sea[2][0] = 0;
        sea[2][1] = 0;
        sea[2][2] = 2;
        sea[2][3] = 1;
        sea[2][4] = 2;

        sea[3][0] = 0;
        sea[3][1] = 0;
        sea[3][2] = 0;
        sea[3][3] = 2;
        sea[3][4] = 0;

        sea[4][0] = 0;
        sea[4][1] = 0;
        sea[4][2] = 0;
        sea[4][3] = 0;
        sea[4][4] = 0;
        
        int turn = 1;
        while(turn <= 10){
        System.out.println("-------[ターン" + turn + "]-------");

        System.out.println("爆弾のx座標を入力してください。(1～5)");
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        System.out.println("爆弾のy座標を入力してください。(1～5)");
        int y = sc.nextInt();

        x = x - 1;
        y = y - 1;

        Ship s = new Ship();

        if(x == 0 && y == 0 ){           
            s.bomb1();
        }
        if(x == 0 && y == 1 ){
            s.bomb2();
        }
        if(x == 2 && y == 3 ){
            s.bomb3();
        }

        else if(sea[x][y] == 2){
            System.out.println("波高し！");
        }else if(sea[x][y] == 0){
            System.out.println("戦艦は無事だ！");
        }

        turn += 1;
        }
    }
}
