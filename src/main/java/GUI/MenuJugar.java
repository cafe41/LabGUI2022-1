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
    private JButton back;

    /**
    * MenuJugar: Constructor de menú jugar, pide un título que será el título de la ventana creada.
    * La función llama al constructor de JFrame a través de "super(title)"
    * <p>
    * @param title Título de la ventana a crear.
    * <p>
    * @return MenuJugar
    * @see MainMenu Menú Principal
    */
    public MenuJugar(String title) {
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(panelJugar);
        this.pack();
    }
}
