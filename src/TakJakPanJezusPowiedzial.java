import java.net.MalformedURLException;
import java.util.Random;

/**
 * Created by zekori on 25.11.16.
 */
public class TakJakPanJezusPowiedzial implements Runnable{
    private int wat;
    private Thread t;
    @Override
    public void run() {
        System.err.println("wchodzę do run");
        while(true){
            Random rand = new Random();
            wat = 5-rand.nextInt(5);
            try {
                Thread.sleep((long)wat*500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                System.err.println("Tworzę nowe okno");
                new TrollOkno();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

        }
    }
    public void start () {
        if (t == null) {
            t = new Thread (this);
            t.start ();
        }
    }
}
