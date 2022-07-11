package main.java.GUI.MenuStatus;

import main.java.Dobble.game.DobbleGame;
import main.java.GUI.MainMenu;
import main.java.GUI.MenuCartas.MenuCards;
import main.java.GUI.MenuJugador.MenuPlayer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuStatus extends JFrame{


    private JPanel panelStatus;
    private JButton estadoDelMazoButton;
    private JButton back;
    private JButton estadoJugadoresButton;
    private JButton estadoPartidaButton;
    private JLabel fondoArriba;
    private JLabel fondoDerechoArriba;
    private JScrollPane scrollPaneCartas;
    private JScrollPane scrollPaneJugadores;
    private JScrollPane scrollPanePartida;
    private JLabel statusJugadores;
    private JLabel statusPartidaActual;
    private JLabel statusMazoCartas;

    public DobbleGame game;
    private JPanel panel1;

    /**
     * MenuStatus: Constructor del menú que muestra el estado del juego por pantalla,
     * La función llama al constructor de JFrame a través de "super(title)"
     * <p>
     * @param title Título de la ventana a crear.
     * @see MainMenu Menú Principal
     */
    public MenuStatus(String title, DobbleGame game) {
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(panelStatus);
        this.pack();

        this.game = game;

        scrollPaneCartas.getViewport().setBackground(Color.black);
        scrollPaneJugadores.getViewport().setBackground(Color.black);
        scrollPanePartida.getViewport().setBackground(Color.black);

        updateCardsSet();
        MenuPlayer.actualizarTexto(game.getJugadores(),statusJugadores);
        updateGameStatus();

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new MainMenu("Menú Principal", game);
                frame.setVisible(true);
                dispose();
            }
        });
    }

    /**
     * Método que actualiza el texto del label que muestra el set de cartas
     */
    public void updateCardsSet(){
        if (game.getMazoCartas() != null) {
            StringBuilder acum = new StringBuilder("<html> Mazo de Cartas:<br/>");
            for (int i = 1; i <= game.getMazoCartas().getCardsSet().size(); i++) {
                acum.append(game.getMazoCartas().getCardsSet().get(i - 1).toString()).append(" ");
            }
            acum.append("</html>");
            statusMazoCartas.setText(acum.toString());
        }
        else{
            statusMazoCartas.setText("Mazo Actual: null");
        }
    }

    /**
     * Método que actualiza el texto del label que muestra el estado del juego
     */
    public void updateGameStatus(){
        String acum = "<html>Partida Actual:<br/>";
        if (game.getModoDeJuego() == null){
            if(game.getJugadores().size() == 0){
                acum = acum + "No hay jugadores.<br/>";
            }
            if(game.getMazoCartas() == null){
                acum = acum + "No hay un mazo de cartas.<br/>";
            }
            acum = acum + "La partida aún no ha empezado.<br/>";
        }
        else {
            acum = "<html> En la partida:" +
                    "<br/>Es el turno de: " + game.getJugadorActual().getUser() +
                    "<br/>Los puntajes son: " + game.getPuntajes() +
                    "<br/>" + game.vaGanando() + " va ganando, con " + game.puntajeMayor()
                    + " puntos." + "<br/>El modo de juego es: " + game.getModoDeJuego()
                    + ".<br/></html>";
        }
        statusPartidaActual.setText(acum);
    }
}
