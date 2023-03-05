package com.wendy.basic.object_oriented;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2021/11/23 22:57
 * @Version 1.0
 */
public class Canten {
    public static void main(String[] args) {
        Farmer farmerA = new Farmer("农民A");
        sell(farmerA);

        Worker workerB = new Worker("工人A");
        sell(workerB);

        Coder coder = new Coder("码农a");
        sell(coder);
    }

    static public void sell(Eater eater){
        System.out.println("卖饭");
        eater.eat();
    }

    static public void sell(Farmer farmer){
        System.out.println("卖饭");
        farmer.eat();
    }

    static public void sell(Worker worker){
        System.out.println("卖饭");
        worker.eat();
    }

}
interface Eater{
    public void eat();
}

class Farmer {
    private String name;

    public Farmer(String name) {
        this.name = name;
    }

    public void eat(){
        System.out.println("农民吃饭");
    }

}

class Worker{
    private String name;

    public Worker(String name) {
        this.name = name;
    }

    public void eat(){
        System.out.println("工人吃饭");
    }
}

class Coder implements Eater{
    private String name;

    public Coder(String name) {
        this.name = name;
    }

    @Override
    public void eat(){
        System.out.println("码农吃饭");
    }
}
