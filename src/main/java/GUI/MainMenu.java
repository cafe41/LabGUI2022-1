package GUI;

import javax.swing.*;

public class MainMenu extends JFrame{
    private JPanel panelPrincipal;
    private JLabel backgroundLabel;

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
}


