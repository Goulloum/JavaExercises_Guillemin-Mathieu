package Bonus.morpion.Views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MenuView extends JFrame {
    private JPanel menuPanel = new JPanel();
    private ArrayList<JButton> btns = new ArrayList<JButton>();

    public MenuView() {
        super("Morpion");
        setSize(500, 500);
        setBackground(new Color(0, 0, 0));
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.menuPanel.setLayout(new BoxLayout(this.menuPanel, BoxLayout.PAGE_AXIS));
        this.add(this.menuPanel);

    }

    public void createButton(String text, ActionListener callback) {
        JButton newBtn = new JButton(text);
        newBtn.addActionListener(callback);
        this.btns.add(newBtn);
        this.menuPanel.add(newBtn);
    }
}
