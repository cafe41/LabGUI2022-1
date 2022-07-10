package main.java.GUI.MenuJugador;

import main.java.Dobble.cardsSet.Card;
import main.java.Dobble.game.DobbleGame;
import main.java.Dobble.game.Humano;
import main.java.Dobble.game.Player;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class AgregarJugador extends JFrame{
    private JButton agregarJugadorButton;
    private JPanel panelCrearCarta;
    private JTextField nombreJugador;
    private JLabel jugadoresActuales;
    private JLabel ingreseText;
    private JLabel jugadoresLabel;

    public static DobbleGame game;

    public AgregarJugador(String title, DobbleGame game) {
        super(title);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setContentPane(panelCrearCarta);
        this.pack();

        AgregarJugador.game = game;

        List<Player> jugadores = game.getJugadores();

        actualizarTexto(jugadores, jugadoresLabel);

        agregarJugadorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Lista con jugadores
                List<Player> jugadores = game.getJugadores();
                Humano jugador = new Humano(nombreJugador.getText(),jugadores);
                jugadores.add(jugador);

                //Actualizar texto con jugadores
                actualizarTexto(jugadores, jugadoresLabel);
            }
        });
    }

    /**
     * Función que encapsula los procesos para actualizar el texto del label.
     * @param players Lista con los jugadores actuales
     * @param labelPlayers Label que muestra los jugadores actuales
     */
    public static void actualizarTexto(List<Player> players, JLabel labelPlayers){
        if (players == null || players.size() == 0){
            labelPlayers.setText("No hay jugadores.");
        }
        else {
            labelPlayers.setText(obtenerTexto(players));
        }
    }

    /**
     * Función que encapsula el proceso para recalcular el missingCards y pasarlo a texto.
     * @param jugadores Lista con jugadores
     * @return String con los jugadores
     */
    public static String obtenerTexto(List<Player> jugadores){
        StringBuilder acum = new StringBuilder("<html>");
        for (Player jugador : jugadores) {
            acum.append(jugador.getNumeroJugador()).append(".- Nombre: ")
                    .append(jugador.getUser()).append(", Puntaje: ")
                    .append(jugador.getPuntaje()).append("<br/>");
        }
        acum.append("</html>");
        return acum.toString();
    }

}
