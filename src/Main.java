import javax.swing.*;

/**
 * Created by Chameera on 18/01/28.
 */
public class Main {
    public static void main(String[] args) {


        JFrame frame = new JFrame("Keystroke Authentication");
        frame.setContentPane(new UserInterface().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);


    }
}
