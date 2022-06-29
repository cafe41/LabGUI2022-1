package main.java.GUI;

import javax.swing.*;
import java.awt.*;

public class MainMenu extends JFrame {
    private JPanel panelPrincipal;
    private JButton estadoActualButton;
    private JButton jugarButton;
    private JButton agregarJugadoresButton;
    private JButton crearMazoButton;
    private JLabel fondoDerecho;

    //Constructor
    public MainMenu(String title) {
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(panelPrincipal);
        this.pack();
    }

    //MAIN donde llamaremos las interfaces gráficas definidas arriba
    public static void main(String[] args) {
        JFrame frame = new MainMenu("Main menu");
        frame.setVisible(true);

    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        JLabel separador1 = new JLabel();
        separador1.setText("AYUDA");
        separador1.setIcon(new ImageIcon("GUI/JPG/Separador1.jpg"));
        separador1.setHorizontalTextPosition(JLabel.CENTER);
        separador1.setVerticalTextPosition(JLabel.TOP);
        separador1.setForeground(new Color(0xBB0007));
        separador1.setBackground(Color.BLACK);
        separador1.setOpaque(true);
        separador1.setBorder(BorderFactory.createLineBorder(Color.red,3));
    }
}


