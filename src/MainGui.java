import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zekori on 25.11.16.
 */
public class MainGui extends JFrame implements KeyListener {

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

    public MainGui() {

        setContentPane(mainPanel);
        addKeyListener(this);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        questionPanel.setVisible(false);
        this.setLocation(Settings.SCREEN_DIMENSION.width / 2 - this.getSize().width / 2, Settings.SCREEN_DIMENSION.height / 2 - this.getSize().height / 2);
        ResourceManager resourceManager = new ResourceManager(this);
        resourceManager.start();
        zatwierdźButton.setEnabled(false);
        pack();
        this.setVisible(true);
        //System.err.println(Settings.SCREEN_DIMENSION.getWidth()+"    "+Settings.SCREEN_DIMENSION.getHeight());
        rozpocznijButton.addActionListener(actionEvent -> {
            questionPanel.setVisible(true);
            Timekeeper.createClockThread(this, 1);
            rozpocznijButton.setVisible(false);
            wynikiButton.setVisible(false);
        });
        wynikiButton.addActionListener(actionEvent -> {
            Score score = new Score(getThis());
            score.setVisible(true);
        });
        zatwierdźButton.addActionListener(actionEvent -> {
            TakJakPanJezusPowiedzial tak = new TakJakPanJezusPowiedzial();
            tak.start();
            getThis().setVisible(false);
        });
        radio3.addActionListener(actionEvent -> {

            if (radio3.isSelected()) {
                radio3.setSelected(true);
                radio2.setSelected(false);
                radio1.setSelected(false);
            }
        });
        radio2.addActionListener(actionEvent -> {
            if (radio2.isSelected()) {
                radio2.setSelected(true);
                radio1.setSelected(false);
                radio3.setSelected(false);
            }
        });
        radio1.addActionListener(actionEvent -> {
            if (radio1.isSelected()) {
                radio1.setSelected(true);
                radio2.setSelected(false);
                radio3.setSelected(false);
            }
        });
    }

    public void setCzasOdRozpoczecia(long time) {
        Date date = new Date(time);
        DateFormat formatter = new SimpleDateFormat("mm:ss");
        czasOdRozpoczecia.setText("Czas zadania:" + formatter.format(date));
    }

    private MainGui getThis() {
        return this;
    }

    public void setZatwierdźButtonEnabled(boolean b) {
        zatwierdźButton.setEnabled(b);
    }

    public static void main(String[] args) {
        new MainGui();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //if (e.isShiftDown() && e.isControlDown() && e.isAltDown() && e.getKeyCode() == KeyEvent.VK_UP) System.err.println("działam");
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.err.println("działam");
        //TODO: Naprawić
    }
}

class Score extends JDialog {
    Score(JFrame owner) {
        super(owner, "Wyniki", true);
        setLocationRelativeTo(null);
        this.setLocation(Settings.SCREEN_DIMENSION.width / 2 - this.getSize().width / 2 - 453, Settings.SCREEN_DIMENSION.height / 2 - this.getSize().height / 2);
        JLabel label = new JLabel("Nie posiadasz jeszcze zapisanych wyników.");
        label.setFont(new Font("Serif", Font.PLAIN, 48));
        add(label, BorderLayout.CENTER);
        JButton ok = new JButton("ok");
        ok.addActionListener(e -> setVisible(false));
        add(ok, BorderLayout.SOUTH);
        setSize(906, 200);
    }
}