package main.java.GUI;

import main.java.Dobble.game.DobbleGame;
import main.java.GUI.MenuCartas.MenuCards;
import main.java.GUI.MenuJugador.MenuPlayer;
import main.java.GUI.MenuJugar.MenuPlay;
import main.java.GUI.MenuStatus.MenuStatus;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame {
    private JPanel panelPrincipal;
    private JButton estadoActualButton;
    private JButton jugarButton;
    private JButton agregarJugadoresButton;
    private JButton crearMazoButton;
    private JLabel fondoDerecho;
    private JLabel fondoIzquierdo;
    private JLabel fondoArriba;
    private JLabel fondoBottom;

    public static DobbleGame game;


    /**
     * MainMenu: Constructor del menú principal,
     * La función llama al constructor de JFrame a través de "super(title)"
     * <p>
     * @param title Título de la ventana a crear.
     * @see MenuPlay Menú Jugar
     * @see MenuPlayer Menú para añadir/editar un jugador
     * @see MenuCards Menú para editar el mazo
     * @see MenuStatus Menú del estado del juego
     */
    public MainMenu(String title) {
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(panelPrincipal);
        this.pack();

        game = new DobbleGame();

        jugarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (game.getMazoCartas() == null || game.getJugadores().size() < 1) {
                    JFrame frame1 = new genericText("Error",
                            "<html>Necesita un mazo y jugadores para jugar</html>");
                    frame1.setVisible(true);
                }
                else {
                    JFrame frame1 = new MenuPlay("Menú Jugar", game);
                    frame1.setVisible(true);
                    dispose();
                }
            }
        });
        crearMazoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame2 = new MenuCards("Menú Cartas", game);
                frame2.setVisible(true);
                dispose();
            }
        });
        agregarJugadoresButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame3 = new MenuPlayer("Menú Jugadores", game);
                frame3.setVisible(true);
                dispose();
            }
        });
        estadoActualButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame4 = new MenuStatus("Menú Estado", game);
                frame4.setVisible(true);
                dispose();
            }
        });
    }
    /**
     * MainMenu: Constructor del menú principal,
     * La función llama al constructor de JFrame a través de "super(title)"
     * <p>
     * @param title Título de la ventana a crear.
     * @param game DobbleGame que se "pasa" entre menus y botones.
     * @see MenuPlay Menú Jugar
     * @see MenuPlayer Menú para añadir/editar un jugador
     * @see MenuCards Menú para editar el mazo
     * @see MenuStatus Menú del estado del juego
     */
    public MainMenu(String title, DobbleGame game){
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(panelPrincipal);
        this.pack();

        MainMenu.game = game;

        jugarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (game.getMazoCartas() == null) {
                    JFrame frame1 = new genericText("Error",
                            "<html>Necesita un mazo para jugar</html>");
                    frame1.setVisible(true);
                }
                else {
                    JFrame frame1 = new MenuPlay("Menú Jugar", game);
                    frame1.setVisible(true);
                    dispose();
                }
            }
        });
        crearMazoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame2 = new MenuCards("Menú Cartas", game);
                frame2.setVisible(true);
                dispose();
            }
        });
        agregarJugadoresButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame3 = new MenuPlayer("Menú Jugadores", game);
                frame3.setVisible(true);
                dispose();
            }
        });
        estadoActualButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame4 = new MenuStatus("Menú Estado", game);
                frame4.setVisible(true);
                dispose();
            }
        });
    }
    /**Método main donde llamaremos las interfaces gráficas definidas previamente.
     * <p>
     * @param args argumentos del main
     */
    public static void main(String[] args) {
        JFrame frame = new MainMenu("Menú Principal");
        frame.setVisible(true);
    }
}