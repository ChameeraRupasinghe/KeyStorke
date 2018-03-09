import jdk.internal.org.objectweb.asm.tree.analysis.Analyzer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by Chameera on 18/01/28.
 */
public class UserInterface {

    KeystrokeListener listener;

    private Person loginUser;

    private ArrayList<Person> people;
    private ArrayList<String> userNames;
    private KeystrokeAnalyzer analyzer;


    public JPanel mainPanel;
    private JTextField tUserInput;
    private JButton submitButton;
    private JTextField tUserName;
    private JLabel lName;
    private JLabel lUserInput;
    private JButton resetButton;
    private JButton loginButton;

    public UserInterface(){
        setComponents();

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(tUserName.getText().length()>0 && tUserInput.getText().length()>0) {

                    if(listener.getKeysPressed().contains("Backspace")){
                        JOptionPane.showMessageDialog(new JPanel(), "Re-enter the login input!");
                        tUserInput.setText("");
                        listener.clearData();

                    }

                    else {

                        Person user = new Person(tUserName.getText(), listener.getKeysPressed(), listener.gettPerss(), listener.gettRelese());
                        people.add(user);

                        tUserInput.setText("");
                        tUserName.setText("");
                        listener.clearData();

                    }
                }

                else {
                    JOptionPane.showMessageDialog(new JPanel(), "Enter a required fields and retry");
                    tUserInput.setText("");
                    tUserName.setText("");
                    listener.clearData();
                }


                //System.out.println("People array " + people.toString());

            }
        });
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tUserInput.setText("");
                tUserName.setText("");
                listener.clearData();
            }
        });


        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(tUserName.getText().length()>0 && tUserInput.getText().length()>0){

                    userNames = new ArrayList<>();
                    for (int i = 0; i < people.size() ; i++) {
                        userNames.add(people.get(i).getName());
                    }

                    if(userNames.contains(tUserName.getText())){
                        analyzer = new KeystrokeAnalyzer();
                        loginUser = new Person(tUserName.getText(), listener.getKeysPressed(), listener.gettPerss(), listener.gettRelese());
                        Person registeredUser = people.get(userNames.indexOf(tUserName.getText()));
                   //     System.out.println(registeredUser.getName()+" of press "+registeredUser.getPressTimeArray().toString()+"\n and "+loginUser.getName()+" of press "+loginUser.getPressTimeArray().toString()+" comparing");

                        analyzer.comparePeople(loginUser, registeredUser);
                    }else
                        JOptionPane.showMessageDialog(new JPanel(), "Invalid Username!");


                }

                else {
                    JOptionPane.showMessageDialog(new JPanel(), "Enter required fields!");
                }
                tUserInput.setText("");
                listener.clearData();

            }
        });
    }

//    public void showMessage(String message){
//        JOptionPane.showMessageDialog(mainPanel, "Input Your Text in Single Attempt!");
//    }

    public void setComponents(){
        listener = new KeystrokeListener();
        tUserInput.addKeyListener(listener);
        people = new ArrayList<>();
    }

    public JTextField gettUserInput() {
        return tUserInput;
    }


}
