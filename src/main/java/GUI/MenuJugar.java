package main.java.GUI;

import javax.swing.*;

public class MenuJugar extends JFrame{
    private JPanel panelJugar;
    private JButton modoContrarrelojPvPButton;
    private JButton modoCooperativoVsIAButton;
    private JButton modoCompetitivoPvPButton;
    private JButton modoContrarrelojButton;
    private JButton modoVsIAButton;
    private JButton modoDePruebaButton;
    private JLabel texto1;

    /**
    * MenuJugar: Constructor de menú jugar, pide un título que será el título de la ventana creada.
    * La función llama al constructor de JFrame a través de "super(title)"
    * DOM: String (title)
    * REC: MenuJugar
    */
    public MenuJugar(String title) {
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(panelJugar);
        this.pack();
    }
}
