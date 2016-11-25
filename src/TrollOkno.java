import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.util.Random;

/**
 * Created by Jarek Kaczor on 06.06.2006.
 */
public class TrollOkno extends JFrame{
    private static Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    private Point deltaPoint = new Point(100,100);
    private static Random rand = new Random();
    private static final Dimension WINDOW_SIZE = new Dimension(400,400);
    private static int i=0;
        TrollOkno() throws MalformedURLException {
            JPanel panel = new JPanel();
            setContentPane(panel);
            pack();
            setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            this.setTitle( "Jan Paweł II Ciebie kocha");
            JLabel label = new JLabel(ResourceMenager.icons.get(rand.nextInt(ResourceMenager.icons.size())));
            add(label, BorderLayout.CENTER);
            setSize(WINDOW_SIZE);
            setVisible(true);
            SuperVirus.setStartTime();
            this.setLocation(rand.nextInt((int)dim.getWidth()),rand.nextInt((int)dim.getHeight()));
            WindowMove move = new WindowMove(this);
            move.start();
            i++;
            System.err.println("Tworzę okno nr: "+i);
    }
    public void setCurrentLocation(){
        Point currentPoint = this.getLocation();
        deltaPoint.x+=rand.nextInt(10);
        deltaPoint.y+=rand.nextInt(10);
        if(currentPoint.x<=0) deltaPoint.x=-deltaPoint.x;
        if(currentPoint.y<=0) deltaPoint.y=-deltaPoint.y;
        if(dim.getWidth()-currentPoint.x<=WINDOW_SIZE.getWidth()) deltaPoint.x=-deltaPoint.x;
        if(currentPoint.y+WINDOW_SIZE.getHeight()<=dim.getHeight()) deltaPoint.y=-deltaPoint.y;
        this.setLocation(currentPoint.x+deltaPoint.x,currentPoint.y+deltaPoint.y);
    }
}
