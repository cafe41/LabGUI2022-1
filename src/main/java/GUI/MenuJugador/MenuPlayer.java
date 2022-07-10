package main.java.GUI.MenuJugador;

import main.java.Dobble.game.DobbleGame;
import main.java.Dobble.game.Player;
import main.java.GUI.MainMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class MenuPlayer extends JFrame{


    private JPanel panelPlayer;
    private JButton agregarJugadorButton;
    private JButton eliminarJugadorButton;
    private JButton back;
    private JLabel fondoBottom;
    private JLabel fondoArriba;
    private JLabel fondoDerechoBottom;
    private JLabel fondoDerechoArriba;
    private JLabel jugadoresLabel;
    private JScrollPane scrollPane;

    public DobbleGame game;

    /**
     * MenuPlayer: Constructor del menú para añadir/eliminar jugadores.
     * La función llama al constructor de JFrame a través de "super(title)"
     * <p>
     * @param title Título de la ventana a crear
     * @see MainMenu Menú Principal
     */
    public MenuPlayer(String title, DobbleGame game) {
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(panelPlayer);
        this.pack();

        this.game = game;

        scrollPane.getViewport().setBackground(Color.black);
        actualizarTexto(game.getJugadores(), jugadoresLabel);

        agregarJugadorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarTexto(game.getJugadores(), jugadoresLabel);

                JFrame frame1 = new AgregarJugador("Agregar Jugador", game);
                frame1.setVisible(true);
            }
        });
        eliminarJugadorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarTexto(game.getJugadores(), jugadoresLabel);

                JFrame frame2 = new EliminarJugador("Agregar Jugador", game);
                frame2.setVisible(true);
            }
        });
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new MainMenu("Menú Principal", game);
                frame.setVisible(true);
                dispose();
            }
        });
        jugadoresLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                actualizarTexto(game.getJugadores(), jugadoresLabel);
            }
        });
    }
    public static void actualizarTexto(List<Player> players, JLabel labelPlayers){
        if (players == null || players.size() == 0){
            labelPlayers.setText("Jugadores Actuales: No hay jugadores.");
        }
        else {
            StringBuilder acum = new StringBuilder("<html>Jugadores Actuales:<br/>");
            for (Player jugador : players) {
                acum.append(jugador.getNumeroJugador()).append(".- Nombre: ")
                        .append(jugador.getUser()).append(", Puntaje: ")
                        .append(jugador.getPuntaje()).append("<br/>");
            }
            acum.append("</html>");
            labelPlayers.setText(acum.toString());
        }
    }
}
