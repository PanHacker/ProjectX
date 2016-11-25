/**
 * Created by zekori on 25.11.16.
 */
public class Time implements Runnable{
    private MainGui gui=null;
    private Thread t;
    public Time(MainGui gui){
        this.gui=gui;
    }
    @Override
    public void run() {
        try {
            while(true) {
                gui.setCzasOdRozpoczecia(SuperVirus.getTimePass());
                Thread.sleep(1000);
            }
        }catch (InterruptedException e) {
            e.getMessage();
        }
    }
    public void start () {
        if (t == null) {
            t = new Thread (this);
            t.start ();
        }
    }
}