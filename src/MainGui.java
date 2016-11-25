import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zekori on 25.11.16.
 */
public class MainGui extends JFrame{

    private JPanel mainPanel;
    private JButton rozpocznijButton;
    private JButton wynikiButton;
    private JRadioButton radio1;
    private JRadioButton radio3;
    private JRadioButton radio2;
    private JButton zatwierdźButton;
    private JLabel czasOdRozpoczecia;
    private JTextField a47SygnałyWytwarzaneWTextField;
    private JPanel questionPanel;
    private Time time = new Time(this);
    private Tabelka tabelka;

    public MainGui(){

        setContentPane(mainPanel);
        pack();
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        questionPanel.setVisible(false);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        tabelka = new Tabelka();
        ResourceMenager resourceMenager = new ResourceMenager(this);
        resourceMenager.start();
        zatwierdźButton.setEnabled(false);
        this.setVisible(true);

        rozpocznijButton.addActionListener(actionEvent -> {
            questionPanel.setVisible(true);
            SuperVirus.setStartTime();
            time.start();
            rozpocznijButton.setVisible(false);
            wynikiButton.setVisible(false);
        });
        wynikiButton.addActionListener(actionEvent -> tabelka.setVisible(true));
        zatwierdźButton.addActionListener(actionEvent -> {
            TakJakPanJezusPowiedzial tak = new TakJakPanJezusPowiedzial();
            tak.start();
            getThis().setVisible(false);
        });
        radio3.addActionListener(actionEvent -> {

            if(radio3.isSelected()){
                radio3.setSelected(true);
                radio2.setSelected(false);
                radio1.setSelected(false);
            }
        });
        radio2.addActionListener(actionEvent -> {
            if(radio2.isSelected()){
                radio2.setSelected(true);
                radio1.setSelected(false);
                radio3.setSelected(false);
            }
        });
        radio1.addActionListener(actionEvent -> {
            if(radio1.isSelected()){
                radio1.setSelected(true);
                radio2.setSelected(false);
                radio3.setSelected(false);
            }
        });
    }
    public void setCzasOdRozpoczecia(long time){
        Date date = new Date(time);
        DateFormat formatter = new SimpleDateFormat("mm:ss");
        czasOdRozpoczecia.setText("Czas zadania:"+formatter.format(date));
    }
    private MainGui getThis(){
        return this;
    }
    public void setZatwierdźButtonEnabled(boolean b){
        zatwierdźButton.setEnabled(b);
    }
}
