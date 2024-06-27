//==============================================================================
//Calculator.java (S. Some)
//This program is largely based on  AwtCalc.java
//Author:  Ernest Criss Jr.
//==============================================================================

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] argv) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new CalCFrame("Calculator");
                frame.setSize(360, 200);
                frame.setVisible(true);
            }
        });
    }
}