import java.util.ArrayList;

/**
 * Created by Tobiasz Rumian on 26.11.2016.
 */
public class Timekeeper {
    public static ArrayList<Time> times = new ArrayList<>();
    public static int createClockThread(MainGui gui,int whatToDo){
        int index = times.size();
        times.add(index,new Time(gui,whatToDo));
        times.get(index).start();
        return index;
    }
}
class Time implements Runnable{
    private long startTime=0L;
    private MainGui gui=null;
    private Thread t=null;
    private int what=0;
    public Time(MainGui gui,int what){
        this.gui=gui;
        this.what=what;
    }
    @Override
    public void run() {
        try {
            while(true) {
                whatToDo(what);
                Thread.sleep(1000);
            }
        }catch (InterruptedException e) {
            e.getMessage();
        }
    }
    public void start () {
        this.startTime=System.currentTimeMillis();
        if (t == null) {
            t = new Thread (this);
            t.start ();
        }
    }
    public long getTimePass(){
        return System.currentTimeMillis()-startTime;
    }
    private void whatToDo(int i){
        switch(i){
            case 1:gui.setCzasOdRozpoczecia(System.currentTimeMillis()-startTime);
                break;
            case 2:;
                break;
            default:;
        }
    }
}
