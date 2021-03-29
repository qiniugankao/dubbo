public class Test {
  public static void main(String[] args) throws InterruptedException {
    ThreadDemo td = new ThreadDemo();
    new Thread(td).start();
    while (true) {
      Thread.sleep(100);
      if (td.isFlag()) {
        System.out.println("---end break---");
        break;
      }
    }
  }
}

class ThreadDemo implements Runnable {
  private  boolean flag =false;

  @Override
  public void run() {
    try {
      Thread.sleep(200);
      flag = true;
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("flag=" + flag);
  }

  public boolean isFlag() {
    return flag;
  }
}
