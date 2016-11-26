import javax.swing.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * Created by zekori on 25.11.16.
 */
class ResourceManager implements Runnable {
    private Thread thread;
    public static ArrayList<Icon> icons = new ArrayList<>();
    private static ArrayList<URL> urls = new ArrayList<>();
    private static ArrayList<String> addresses = new ArrayList<>();
    private static MainGui gui=null;
    private static boolean complete =false;
    //TODO: Możliwość jednokrotnego stworzenia klasy
    public ResourceManager(MainGui gui){
        this.gui=gui;
    }
    @Override
    public void run() {
        loadAddresses();
        loadUrl();
        icons.addAll(urls.stream().map(ImageIcon::new).collect(Collectors.toList()));
        complete =true;
        gui.setZatwierdźButtonEnabled(true);
    }
    void start() {
        if (thread == null) {
            thread = new Thread (this);
            thread.start ();
        }
    }
    private static void loadUrl(){
        for (String s:addresses) {
            try {
                urls.add(new URL(s));
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }
    private static void loadAddresses(){
        addresses.add("https://media.giphy.com/media/l0HlIKdi4DIEDk92g/giphy.gif");
        addresses.add("https://i.makeagif.com/media/1-03-2015/hOVykK.gif");
        addresses.add("https://8ch.pl/jp2/src/1427188131963.gif");
        addresses.add("https://media.giphy.com/media/l41lPd4rlOlw1lRqU/giphy.gif");
        addresses.add("https://i.makeagif.com/media/9-06-2015/pF5drO.gif");
    }
    public boolean isCompleate(){
        return complete;
    }
}
