import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.util.Random;

public class TrollOkno extends JFrame{
    private static Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    private Point deltaPoint = Settings.START_MOVE_OF_WINDOW;
    private static Random rand = new Random();
    private static int i=0;
        TrollOkno() throws MalformedURLException {
            JPanel panel = new JPanel();
            setContentPane(panel);
            pack();
            setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            this.setTitle( "Jan Paweł II Ciebie kocha");
            JLabel label = new JLabel(ResourceManager.icons.get(rand.nextInt(ResourceManager.icons.size())));
            add(label, BorderLayout.CENTER);
            setSize(Settings.SIZE_OF_TROLL_WINDOW);
            setVisible(true);
            this.setLocation(rand.nextInt((int)dim.getWidth()),rand.nextInt((int)dim.getHeight()));
            Move move = new Move(this);
            move.start();
            i++;
            System.err.println("Tworzę okno nr: "+i);
    }
    public void setCurrentLocation(){
        Point currentPoint = this.getLocation();
        deltaPoint.x+=rand.nextInt(10);
        deltaPoint.y+=rand.nextInt(10);
        if(currentPoint.x<=0||Settings.SCREEN_DIMENSION.getWidth()-currentPoint.x<=Settings.SIZE_OF_TROLL_WINDOW.getWidth()) deltaPoint.x=-deltaPoint.x;
        if(currentPoint.y<=0||Settings.SCREEN_DIMENSION.getHeight()-currentPoint.y<=Settings.SIZE_OF_TROLL_WINDOW.getHeight()) deltaPoint.y=-deltaPoint.y;
        this.setLocation(currentPoint.x+deltaPoint.x,currentPoint.y+deltaPoint.y);
    }
}
class Move implements Runnable{
    private TrollOkno gui = null;
    private Thread t;

    public Move(TrollOkno gui) {
        this.gui = gui;
    }

    @Override
    public void run() {
        try {
            while (true) {
                gui.setCurrentLocation();
                Thread.sleep(Settings.DELTA_TIME_OF_WINDOW_MOVE);
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
