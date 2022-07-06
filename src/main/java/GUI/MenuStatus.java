package main.java.GUI;

import javax.swing.*;

public class MenuStatus extends JFrame{


    private JPanel panelStatus;
    private JLabel texto1;
    private JButton estadoDelMazoButton;
    private JButton back;
    private JButton estadoJugadoresButton;
    private JButton estadoPartidaButton;

    /**
     * MenuStatus: Constructor del menú que muestra el estado del juego por pantalla,
     * La función llama al constructor de JFrame a través de "super(title)"
     * <p>
     * @param title Título de la ventana a crear.
     * <p>
     * @return MenuStatus
     * @see MainMenu Menú Principal
     */
    public MenuStatus(String title) {
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(panelStatus);
        this.pack();
    }
}
