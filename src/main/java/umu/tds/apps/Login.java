package umu.tds.apps;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class Login {
    public static void open_window() {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("AppChat");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 300);
            frame.setLocationRelativeTo(null);
            JLabel label = new JLabel("Test", SwingConstants.CENTER);
            frame.add(label);
            frame.setVisible(true);
        });
    }
}
