/**
 * Created by zekori on 25.11.16.
 */
public class WindowMove implements Runnable {
    private TrollOkno gui = null;
    private Thread t;

    public WindowMove(TrollOkno gui) {
        this.gui = gui;
    }

    @Override
    public void run() {
        try {
            while (true) {
                gui.setCurrentLocation();
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            e.getMessage();
        }
    }

    public void start() {
        if (t == null) {
            t = new Thread(this);
            t.start();

        }
    }
}