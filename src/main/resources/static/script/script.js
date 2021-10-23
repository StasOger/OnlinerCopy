package easybudda.animatedlabels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TestLabel {
    private AnimatedLabel label;

    TestLabel() {
        label = new AnimatedLabel();
        label.setPreferredSize(new Dimension(300, 50));

        JButton button = new JButton("Phrase...");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String str = JOptionPane.showInputDialog("Enter some phrase...");
                if ( str != null && ! str.isEmpty() )
                    label.setText(str);
            }
        });

        Box box = Box.createVerticalBox();
        box.add(button);
        box.add(label);

        JFrame frame = new JFrame("Animated label");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(box);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TestLabel();
            }
        });
    }
}
