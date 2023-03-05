package com.wendy.basic.object_oriented.enumPrac;

/**
 * @Description 有一个火星车，可以接受一串M  L  R等命令。
 * 可以左转（L)，每次转90度。每次移动向前移动1米(M)。给定一个命令串如 MMLLLMMM，判断其当前位置
 * @Author wendyma
 * @Date 2021/7/18 21:29
 * @Version 1.0
 */
public class MarsCar {
    private int x;
    private int y;
    private Character direction;

    //指定火星车初始位置及方向
    public MarsCar(int x, int y, Character direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }
    //给定命令，获取火星车移动后的位置
    public String getPosition(String command){
        for(int i=0;i<command.length();i++){
            if(command.charAt(i)=='M'){
                move();
            }else{
                turn(command.charAt(i));
            }
        }
        return "东西坐标： "+getX()+"南北坐标："+getY()+"朝向："+getDirection();
    }

    //火星车前进一米
    public void move() {
        if (this.direction == DirectEnum.NORTH.getDirection()) {
            this.y += 1;
        } else if (this.direction == DirectEnum.SOUTH.getDirection()) {
            this.y -= 1;
        } else if (this.direction == DirectEnum.EAST.getDirection()) {
            this.x += 1;
        } else {
            this.x -= 1;
        }
    }

    //转弯,一次转90度
    public void turn(Character turning) {
        int num = DirectEnum.getNumByDirect(this.direction);
        if (turning == 'L') {
            num = (num + 3) % 4;
            this.direction =DirectEnum.getDirectByNum(num);
        }else{
            num=(num+1)%4;
            this.direction =DirectEnum.getDirectByNum(num);
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Character getDirection() {
        return direction;
    }
}
