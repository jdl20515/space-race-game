import javax.swing.*;

public class MyProgram {
    public static void main(String[] args)
    {
        //creating instance of JFrame
        JFrame frame = new JFrame();
        frame.setSize(400,300);
        frame.setTitle("Space Race");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Instantiate motionRunner
        spaceRaceRunner myRace =new spaceRaceRunner();
        //Call the start_timer method
        myRace.start_timer();
        frame.add(myRace);
        frame.setVisible(true);
    }
}