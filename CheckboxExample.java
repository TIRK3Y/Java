
// importing necessary packages  
import java.awt.*;
import java.awt.event.*;

public class CheckboxExample {
        // constructor to initialize
        CheckboxExample() {
                // creating the frame
                Frame f = new Frame("CheckBox Example");
                // creating the label
                Label label1 = new Label();
                Label label2 = new Label();

                label1.setBounds(100, 50, 200, 20);
                label2.setBounds(100, 70, 200, 20);
                // creating the checkboxes
                Checkbox checkbox1 = new Checkbox("C++");
                checkbox1.setBounds(100, 100, 50, 50);
                Checkbox checkbox2 = new Checkbox("Java");
                checkbox2.setBounds(100, 150, 50, 50);
                // adding the checkbox to frame
                f.add(checkbox1);
                f.add(checkbox2);
                f.add(label1);
                f.add(label2);

                // adding event to the checkboxes
                checkbox1.addItemListener(new ItemListener() {
                        public void itemStateChanged(ItemEvent e) {
                                label1.setText("C++ Checkbox: "
                                                + (e.getStateChange() == 1 ? "checked" : "unchecked"));
                        }
                });
                checkbox2.addItemListener(new ItemListener() {
                        public void itemStateChanged(ItemEvent e) {
                                label2.setText("Java Checkbox: "
                                                + (e.getStateChange() == 1 ? "checked" : "unchecked"));
                        }
                });

                f.addWindowListener(new WindowAdapter() {
                        public void windowClosing(WindowEvent e) {
                                f.dispose();
                        }
                });
                // setting size, layout and visibility of frame
                f.setSize(400, 400);
                f.setLayout(null);
                f.setVisible(true);
        }

        // main method
        public static void main(String args[]) {
                new CheckboxExample();
        }
}