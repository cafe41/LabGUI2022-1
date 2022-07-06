package main.java.GUI;

import javax.swing.*;

public class MenuPlayer extends JFrame{


    private JPanel panelPlayer;
    private JLabel texto1;
    private JButton agregarJugadorButton;
    private JButton eliminarJugadorButton;
    private JButton back;

    /**
     * MenuPlayer: Constructor del menú para añadir/eliminar jugadores.
     * La función llama al constructor de JFrame a través de "super(title)"
     * <p>
     * @param title Título de la ventana a crear
     * <p>
     * @return MenuPlayer
     * @see MainMenu Menú Principal
     */
    public MenuPlayer(String title) {
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(panelPlayer);
        this.pack();
    }
}
