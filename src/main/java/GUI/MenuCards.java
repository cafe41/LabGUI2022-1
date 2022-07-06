package main.java.GUI;

import javax.swing.*;

public class MenuCards extends JFrame{


    private JPanel panelCards;
    private JLabel texto1;
    private JTable mazoActualTable;
    private JButton estadoDelMazoButton;
    private JButton back;

    /**
     * MenuCards: Constructor del menú que muestra el estado del juego por pantalla,
     * La función llama al constructor de JFrame a través de "super(title)"
     * <p>
     * @param title Título de la ventana a crear.
     * <p>
     * @return MenuCards
     * @see MainMenu Menú Principal
     */
    public MenuCards(String title) {
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(panelCards);
        this.pack();
    }

}
