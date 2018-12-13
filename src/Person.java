import java.util.ArrayList;

/**
 * Created by Chameera on 18/01/28.
 */
public class Person {
    private static int uid = 0;
    private String name;
    private ArrayList<String> keysArray;
    private ArrayList<Long> pressTimeArray;
    private ArrayList<Long> intervalArray;

    private ArrayList<Long> pressArray;
    private ArrayList<Long> releaseArray;

    public Person(String name, ArrayList<String> keysArray, ArrayList<Long> pressArray, ArrayList<Long> releaseArray) {
        this.setName(name);

        this.setKeysArray(keysArray);

        this.pressArray = pressArray;
        this.releaseArray = releaseArray;

        this.setIntervalArray(calculateIntervalArray(this.pressArray, this.releaseArray));
        this.setPressTimeArray(calculatePressTimeArray(this.pressArray, this.releaseArray));

        // System.out.println(this.getName() + " registered \npressTime Array " + this.getPressTimeArray().toString() + "\nrelease Interval Array " + this.getIntervalArray());


        //  System.out.println(this.getName() + " registered \npressTime " + this.pressArray.toString() + "\nreleaseTIme " + this.releaseArray);
        this.uid++;
    }


    public ArrayList<Long> calculatePressTimeArray(ArrayList<Long> pressArray, ArrayList<Long> releaseArray) {
        ArrayList<Long> pressTimeArray = new ArrayList<>();

        for (int i = 0; i < pressArray.size(); i++) {
            long pressTime = releaseArray.get(i) - pressArray.get(i);
            pressTimeArray.add(pressTime);

        }

        //  System.out.println("Press time array " + pressTimeArray.toString());

        return pressTimeArray;
    }


    public ArrayList<Long> calculateIntervalArray(ArrayList<Long> pressArray, ArrayList<Long> releaseArray) {
        ArrayList<Long> intervalArray = new ArrayList<>();

        for (int i = 0; i < pressArray.size() - 1; i++) {
            long interval = pressArray.get(i + 1) - releaseArray.get(i);
            intervalArray.add(interval);

        }

        //   System.out.println("Press time array " + intervalArray.toString());

        return intervalArray;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getKeysArray() {
        return keysArray;
    }

    public void setKeysArray(ArrayList<String> keysArray) {
        this.keysArray = keysArray;
    }

    public ArrayList<Long> getPressTimeArray() {
        return pressTimeArray;
    }

    public void setPressTimeArray(ArrayList<Long> pressTimeArray) {
        this.pressTimeArray = pressTimeArray;
    }

    public ArrayList<Long> getIntervalArray() {
        return intervalArray;
    }

    public void setIntervalArray(ArrayList<Long> intervalArray) {
        this.intervalArray = intervalArray;
    }
}
