package com.wendy.basic.object_oriented.enumPrac;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2021/7/18 21:20
 * @Version 1.0
 */
public enum DirectEnum {
    NORTH(0, 'N'),
    EAST(1, 'E'),
    SOUTH(2, 'S'),
    WEST(3, 'W');

    private int num;
    private Character direction;

    DirectEnum(int num, Character direction) {
        this.num = num;
        this.direction = direction;
    }

    public static int getNumByDirect(Character direction) {
        for (DirectEnum directEnum : DirectEnum.values()) {
            if (direction == directEnum.getDirection()) {
                return directEnum.num;
            }
        }
        return -1;
    }

    public static Character getDirectByNum(int num) {
        Character c = ' ';
        for (DirectEnum directEnum : DirectEnum.values()) {
            if (num == directEnum.getNum()) {
                c = directEnum.getDirection();
                break;
            }
        }
        return c;
    }

    public int getNum() {
        return num;
    }

    public Character getDirection() {
        return direction;
    }

}
