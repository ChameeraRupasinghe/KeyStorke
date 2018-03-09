import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by Chameera on 18/01/28.
 */
public class KeystrokeAnalyzer {


    public ArrayList<Long> calculatePressTimeArray (ArrayList<Long> pressArray, ArrayList<Long> releaseArray){
        ArrayList <Long> pressTimeArray = new ArrayList<>();

        for (int i = 0; i < pressArray.size(); i++) {
            long pressTime = releaseArray.get(i) - pressArray.get(i);
            pressTimeArray.add(pressTime);

        }

        //System.out.println("Press time array " + pressTimeArray.toString());

        return pressTimeArray;
    }

    public ArrayList<Long> calculateIntervalArray (ArrayList<Long> pressArray, ArrayList<Long> releaseArray){
        ArrayList <Long> intervalArray = new ArrayList<>();

        for (int i = 0; i < pressArray.size()-1; i++) {
            long interval = pressArray.get(i+1) - releaseArray.get(i);
            intervalArray.add(interval);

        }

       // System.out.println("Press time array " + intervalArray.toString());

        return intervalArray;
    }

    public void comparePeople(Person loginUser, Person registeredUser){
        int pressScore = 0;
        int intervalScore = 0;
        if(loginUser.getKeysArray() == registeredUser.getKeysArray()){



            for (int i = 0; i <loginUser.getIntervalArray().size() ; i++) {
                //intervalScore += Math.abs(loginUser.getIntervalArray().get(i) - registeredUser.getIntervalArray().get(i));
                int intervalS = (int) Math.abs(loginUser.getIntervalArray().get(i) - registeredUser.getIntervalArray().get(i));
                //System.out.println(i + " gap "+ intervalS);

                if(intervalS < 30){
                    intervalScore++;
                }

            }

            for (int i = 0; i <loginUser.getPressTimeArray().size() ; i++) {
                //pressScore += Math.abs(loginUser.getPressTimeArray().get(i) - registeredUser.getPressTimeArray().get(i));
                int pressS = (int) Math.abs(loginUser.getPressTimeArray().get(i) - registeredUser.getPressTimeArray().get(i));
                //System.out.println(i + " gap "+pressS);

                if(pressS < 30){
                    pressScore++;
                }

            }

            float pressAvg = (pressScore*100)/loginUser.getPressTimeArray().size();
            float intervalAvg = (intervalScore*100)/loginUser.getIntervalArray().size();


            //System.out.println("Press Score "+pressScore+ " avg "+pressAvg+" interval Score "+intervalScore+" avg "+ intervalAvg);

            if(pressAvg>60 && intervalAvg>55){
                JOptionPane.showMessageDialog(new JPanel(), "Login Sucessful!\nWelcome "+registeredUser.getName()+".");
            }

            else {
                JOptionPane.showMessageDialog(new JPanel(), "Login Failed!");

            }

        }
        else{
            JOptionPane.showMessageDialog(new JPanel(), "Login Failed!");
        }




    }





}
