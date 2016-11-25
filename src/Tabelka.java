import javax.swing.*;
import java.awt.*;

/**
 * Created by zekori on 25.11.16.
 */
public class Tabelka extends JFrame{
    private JPanel panel1;
    public Tabelka(){
        setContentPane(panel1);
        pack();
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
    }
}
