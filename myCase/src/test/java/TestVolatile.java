import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * 什么时候工作内存同步主内存。
 * 1线程获取锁会强制从主存重新刷新变量值  在方法中调用同步方法 比如System.out.println();
 * 2当线程切换到其他线程，后来又切换到该线程的时候去重新读取  线程休眠sleep(1000);
 * 3说的是当执行该线程的cpu有空闲时，他会去主存读取一下共享变量的值来更新线程工作内存中的值  IO操作
 */

/**
 * 什么时候工作内存的变量刷新到主内存
 * 把一个从执行引擎接收的值赋给工作内存的变量后，立即同步到主内存。但是这两个操作并不保证原子性。中间可能有其他操作。
 * 线程释放锁之前，必须将变量同步到主内存
 */
public class TestVolatile {
  //注意没用volatile修饰数组
  public static volatile long[] arr = new long[20];
  //这里用volatile修饰另一个变量
  public static  int vol = 0;

  public static void main(String[] args) throws Exception {

    //线程2
    new Thread(new Thread(){
      @Override
      public void run() {
        while (arr[19] !=2){
//          System.out.println("arr[19]--->" + arr[19]);
//          try {
//            Thread.sleep(1000);
//          } catch (InterruptedException e) {
//            e.printStackTrace();
//          }
        }
//        while (true) {
//          //读取vol的值
////          int i = vol;
//
          System.out.println("arr[19]--->" + arr[19]);
//          System.out.println(new Date());
//          if (arr[19] == 2) {
//            break;
//          }
//        }
        System.out.println("Jump out of the loop!");
      }
    }).start();

    //线程1
    new Thread(new Thread(){
      @Override
      public void run() {
        try {
          TimeUnit.MILLISECONDS.sleep(1000);
          vol = 1;
          System.out.println("eee");
          arr[19] = 2;

        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }).start();

//    while (vol == 0){
//      Thread.sleep(1000);
//      System.out.println("ddd");
//    }
//    System.out.println("fff");
  }
}
