import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

/**
 * Created by Jarek_Kaczor on 06.106.2006.
 */
public class SuperVirus {

    private static long startTime;
    public SuperVirus() {

    }

    public static void main(String[] args) {
        new MainGui();
    }


    public static void setStartTime(){
        startTime= System.currentTimeMillis();
    }
    public static long getTimePass(){
        return System.currentTimeMillis()-startTime;
    }
}