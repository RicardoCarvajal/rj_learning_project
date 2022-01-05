package ricardo.practica.label;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class DemoLabel {

    public static void main(String[] args) {

        ImageIcon labelIcon = new ImageIcon("");

        JLabel labelNorth = new JLabel(labelIcon);

        JLabel labelCenter = new JLabel(labelIcon);

        JLabel labelSouth = new JLabel(labelIcon);

        labelNorth.setText("Norte");

        labelSouth.setText("Sur");

        labelCenter.setText("Center");

        JFrame marco = new JFrame();

        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        marco.add(labelNorth, BorderLayout.NORTH);
        marco.add(labelCenter, BorderLayout.CENTER);
        marco.add(labelSouth, BorderLayout.SOUTH);

        marco.setSize(300, 300);

        marco.setVisible(true);

    }

}
