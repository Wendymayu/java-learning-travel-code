package com.wendy.basic.multi_thread.volatil;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2021/12/12 19:31
 * @Version 1.0
 */
public class HappensBeforeTest {
    private Foo sharedFoo;
    int num;

    public void publisher(){
        try{
            num = 20;
            System.out.println("pushliser开始执行");
            sharedFoo = new Foo(45);
            System.out.println("pushliser结束执行");
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void consumer(){
        System.out.println("consumer执行"+num);
        Foo myFoo;
        do{
            myFoo = sharedFoo;
        }while(myFoo==null);
        System.out.println(myFoo.nr);
    }

    public static void main(String[] args) {
        HappensBeforeTest test = new HappensBeforeTest();
        new Thread(){
            public void run(){
                test.publisher();
            }
        }.start();

        new Thread(){
            public void run(){
                test.consumer();
            }
        }.start();
    }

}

class Foo{
    public int nr;

    public Foo(){

    }

    public Foo(int nr){
        this.nr =nr;
    }
}
