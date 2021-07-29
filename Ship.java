public class Ship {
    int hp1 = 3;
    int hp2 = 3;
    int hp3 = 3;

public void die1(){
    System.out.println("戦艦１撃沈！");
}

public void die2(){
    System.out.println("戦艦２撃沈！");
}

public void die3(){
    System.out.println("戦艦３撃沈！");
}


public void bomb1() {
    System.out.println("戦艦１に命中！");
    this.hp1 -= 1;
    if(this.hp1 == 0){
        this.die1();
    }   
}
public void bomb2() {
    System.out.println("戦艦２に命中！");
    this.hp2 -= 1;
    if(this.hp2 == 0){
        this.die2();
    }
}
public void bomb3() {
    System.out.println("戦艦３に命中！");
    this.hp3 -= 1;
    if(this.hp3 == 0){
        this.die3();
    }
}

}
