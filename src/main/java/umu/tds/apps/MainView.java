package umu.tds.apps;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.SwingUtilities;

public class MainView {
    private JFrame frame;

    private final int FRAME_WIDTH = 400;
    private final int FRAME_HEIGHT = 300;
    private final int FIELD_COLUMNS = 20;

    private final int CLOSE_OPERATION = JFrame.EXIT_ON_CLOSE;

    public MainView() {
        frame = new JFrame();
    }

    public void showMainWindow(ArrayList<Chat> chats) {
        SwingUtilities.invokeLater(() -> {
            setupMainFrame(chats);
            frame.setVisible(true);
        });
    }

    private void setupMainFrame(ArrayList<Chat> chats) {
        JPanel contactsPanel = new JPanel();
        JPanel messagesPanel = new JPanel();
        JPanel topPanel = new JPanel();

        setupFrame();

        setupContactsPanel(contactsPanel, chats);
        frame.add(contactsPanel, BorderLayout.WEST);

        setupMessagesPanel(messagesPanel);
        frame.add(messagesPanel, BorderLayout.EAST);

        setupTopPanel(topPanel);
        frame.add(topPanel, BorderLayout.NORTH);
    }

    private void setupFrame() {
        frame.setTitle(App.name);
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(CLOSE_OPERATION);
    }

    private void setupContactsPanel(JPanel contactsPanel, ArrayList<Chat> chats) {
        contactsPanel.setLayout(new BoxLayout(contactsPanel, BoxLayout.Y_AXIS));
        ButtonGroup buttonGroup = new ButtonGroup();
        System.out.println(chats);
        
        for (Chat chat : chats) {
            JToggleButton chatButton = new JToggleButton(chat.getName());
            buttonGroup.add(chatButton);
            contactsPanel.add(chatButton);
        }
    }

    private void setupMessagesPanel(JPanel messagesPanel) {
        
    }

    private void setupTopPanel(JPanel topPanel) {
        
    }
}
