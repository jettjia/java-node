package Test;

import java.util.concurrent.TimeUnit;  
  
public class DaemonDemo implements Runnable {  
    @Override  
    public void run() {  
        try {  
            while (true) {  
                Thread.sleep(1000);  
                System.out.println("#" + Thread.currentThread().getName());  
            }  
        } catch (InterruptedException e) {  
            e.printStackTrace();  
        } finally {// 后台线程不执行finally子句  
            System.out.println("finally ");  
        }  
    }  
  
    public static void main(String[] args) {  
        for (int i = 0; i < 10; i++) {  
            Thread daemon = new Thread(new DaemonDemo());  
            // 必须在start之前设置为后台线程  
            daemon.setDaemon(true);  
            daemon.start();  
        }  
        System.out.println("All daemons started");  
        try {  
            TimeUnit.MILLISECONDS.sleep(1000);  
        } catch (InterruptedException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
    }  
}  