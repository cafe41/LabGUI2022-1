package main.java.GUI.MenuJugador;

import main.java.Dobble.game.DobbleGame;
import main.java.Dobble.game.Player;
import main.java.GUI.genericText;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class EliminarJugador extends JFrame{
    private JButton agregarMazoButton;
    private JPanel panelCrearCarta;
    private JTextField numeroJugador;
    private JLabel sigJugadores;
    private JLabel indexText;
    private JLabel jugadoresPosiblesLabel;

    public static DobbleGame game;

    public EliminarJugador(String title, DobbleGame game) {
        super(title);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setContentPane(panelCrearCarta);
        this.pack();

        EliminarJugador.game = game;

        List<Player> jugadoresActuales = game.getJugadores();

        actualizarTexto(jugadoresActuales, jugadoresPosiblesLabel);

        agregarMazoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Actualizar cardsSet
                List<Player> jugadoresActuales = game.getJugadores();
                boolean eliminado = false;

                //Remover
                for (int i=0; i<jugadoresActuales.size();i++) {
                    if (Integer.parseInt(numeroJugador.getText()) ==
                            jugadoresActuales.get(i).getNumeroJugador()){
                        jugadoresActuales.remove(i);
                        eliminado = true;
                    }
                }
                if (!eliminado){
                    JFrame frame1 = new genericText("Error", "El jugador no existe.");
                    frame1.setVisible(true);
                }

                //Actualizar cardsSet
                actualizarTexto(jugadoresActuales, jugadoresPosiblesLabel);
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
