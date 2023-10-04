package Bonus.morpion.Views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MenuView extends JFrame {
    private JPanel btnsPanel = new JPanel();
    private ArrayList<JButton> btns = new ArrayList<JButton>();
    private GridBagConstraints gbc = new GridBagConstraints();
    private JLabel title = new JLabel(
            "Choisissez un mode :");

    public MenuView() {
        super("Morpion");
        setSize(500, 500);
        setBackground(new Color(255, 255, 255));
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.gbc.gridwidth = GridBagConstraints.REMAINDER;
        this.gbc.anchor = GridBagConstraints.CENTER;
        this.gbc.fill = GridBagConstraints.HORIZONTAL;
        this.gbc.insets = new Insets(10, 0, 10, 0);
        this.btnsPanel.setLayout(new GridBagLayout());
        this.btnsPanel.setBackground(new Color(255, 255, 255));
        this.btnsPanel.setSize(200, 200);

        this.title.setFont(new Font("Arial", 200, 50));
        this.title.setBackground(new Color(0, 0, 0));
        this.title.setForeground(new Color(255, 255, 255));
        this.title.setOpaque(true);
        this.add(this.title, BorderLayout.NORTH);
        this.add(this.btnsPanel, BorderLayout.CENTER);

    }

    public void createButton(String text, ActionListener callback) {
        JButton newBtn = new JButton(text);
        newBtn.setMargin(new Insets(10, 50, 10, 50));
        newBtn.addActionListener(callback);
        this.btns.add(newBtn);
        this.btnsPanel.add(newBtn, this.gbc);
    }
}
