import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

/**
 * Created by Chameera on 18/01/28.
 */
public class KeystrokeListener implements KeyListener{

    private ArrayList<String> keysPressed;
    private ArrayList<Long> tRelese;
    private ArrayList<Long> tPerss;
    private int pressedKey;
    private int relesedKey;
    private long pressedTime;
    private long relesedTime;

    public KeystrokeListener (){
        setKeysPressed(new ArrayList<>());
        settRelese(new ArrayList<>());
        settPerss(new ArrayList<>());

        pressedKey = -1;
        relesedKey = -1;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {



        if(KeyEvent.getKeyText(e.getKeyCode())=="Backspace") {
            JOptionPane.showMessageDialog(new JPanel(), "Backspase pressed. Please click 'Reset' button and input your logintext in one try!");
            //System.out.println("BackspacePressed");
        }

        if(e.getKeyCode() != pressedKey) {
            //System.out.println("The key pressed is " + KeyEvent.getKeyText(e.getKeyCode()) + " At time " + System.currentTimeMillis());
            getKeysPressed().add(KeyEvent.getKeyText(e.getKeyCode()));
            pressedTime = System.currentTimeMillis();
            gettPerss().add(pressedTime);

            pressedKey = e.getKeyCode();
            relesedKey = -1;
        }


    }

    @Override
    public void keyReleased(KeyEvent e) {
        long tQueuedRelese;
        int QueuedKey;
        if(e.getKeyCode() != relesedKey) {
            //System.out.println("\nKey " + KeyEvent.getKeyText(e.getKeyCode()) + " relesed at time " + System.currentTimeMillis());
            relesedKey = e.getKeyCode();


            gettRelese().add(System.currentTimeMillis());





            pressedKey = -1;

            //System.out.println(getKeysPressed().toString() + " press "+ gettPerss().toString()+ " relese "+ gettRelese().toString());


        }


    }

    public void clearData(){
        keysPressed.clear();
        tPerss.clear();
        tRelese.clear();
        pressedKey = -1;
        relesedKey = -1;
        pressedTime =0;
        relesedTime = 0;


    }

    public ArrayList<String> getKeysPressed() {
        return keysPressed;
    }

    public void setKeysPressed(ArrayList<String> keysPressed) {
        this.keysPressed = keysPressed;
    }

    public ArrayList<Long> gettRelese() {
        return tRelese;
    }

    public void settRelese(ArrayList<Long> tRelese) {
        this.tRelese = tRelese;
    }

    public ArrayList<Long> gettPerss() {
        return tPerss;
    }

    public void settPerss(ArrayList<Long> tPerss) {
        this.tPerss = tPerss;
    }
}
