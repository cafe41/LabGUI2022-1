package main.java.GUI.MenuJugar;

import main.java.Dobble.cardsSet.Card;
import main.java.Dobble.game.CPU;
import main.java.Dobble.game.DobbleGame;
import main.java.Dobble.game.Player;
import main.java.GUI.genericText;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Juego extends JFrame{
    private JPanel panelJuego;
    private JLabel registro;
    private JLabel fondoIzq;
    private JComboBox<String> comboBox1;
    private JButton iniciarButton;
    private JLabel cartasEnMesa;
    private JLabel fondoArriba;
    private JLabel tiempoRestante;
    private JLabel fondoBottom;
    private JLabel puntajeJugador;
    private JScrollPane scrollPane;
    private JLabel fondoDer;
    private JLabel modoTurno;
    private JButton back;
    //Atributos juego:
    public DobbleGame game;
    public Player turno;
    public String acumRegistro;
    public boolean contraReloj;
    public int time;
    public String modo;
    public List<Card> mesa;
    public int tiempoMax;
    public Thread hilo;
    public int puntajeTiempo;
    public int nCPU;

    public Juego(String title, DobbleGame game, int tiempoMax, int puntajeTiempo,
                 boolean contraReloj, String modo, int nCPU) {
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(panelJuego);
        this.pack();

        this.game = game;
        this.modo = modo; game.setModoDeJuego(modo);
        this.contraReloj = contraReloj;
        this.tiempoMax = tiempoMax;
        this.puntajeTiempo = puntajeTiempo;
        this.mesa = new ArrayList<>();
        this.nCPU = nCPU;

        scrollPane.getViewport().setBackground(Color.black);

        //Agregamos elementos al comboBox
        for (int i = 0; i < game.getMazoCartas().getListaElementos().size(); i++){
            comboBox1.addItem(game.getMazoCartas().getListaElementos().get(i));
        }

        //Creamos una cantidad de CPU basándonos en "nCPU"
        for (int i = 0;i<nCPU;i++){
            CPU cpu = new CPU("cpu"+i,game.getJugadores());
            game.getJugadores().add(cpu);
        }

        //Creamos un nuevo hilo con timer
        hilo = nuevoHilo();

        //Botón que inicia el juego/Selecciona el elemento
        iniciarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Objects.equals(iniciarButton.getText(), "Iniciar")){
                    if (game.getMazoCartas().getCardsSet().size() <= 1){
                        JFrame error = new genericText("Error: insuficientes cartas",
                                "No hay suficientes cartas para iniciar");
                        error.setVisible(true);
                    }
                    else {
                        //Creamos el registro
                        acumRegistro = "<html> Inicia la partida<br/></html>";
                        //Cambiar botón
                        iniciarButton.setText("OK");
                        //Actualizamos el puntaje, registro, cartas, etc.
                        actualizarTodo();
                    }
                }
                else {
                    if (!game.getJugadorActual().isCPU()) {
                        String selected = Objects.requireNonNull(comboBox1.getSelectedItem())
                                .toString();
                        if (mesa.get(0).getCarta().contains(selected) &&
                                mesa.get(1).getCarta().contains(selected)) {
                            //Eliminamos las cartas del mazo
                            game.getMazoCartas().getCardsSet().remove(0);
                            game.getMazoCartas().getCardsSet().remove(0);
                            //Agregamos puntaje al jugador
                            game.getJugadorActual()
                                    .agregarPuntaje(puntajeTiempo * (tiempoMax - time));
                            //Registro
                            actualizarRegistro("Correcto, " +
                                    game.getJugadorActual().getUser() + " ha ganado " +
                                    (tiempoMax - time) + " puntos.");
                            //Avanzamos turno
                            game.avanzarTurno();
                            //Revisamos si el juego debería terminar
                            if (game.getMazoCartas().getCardsSet().size() <= 1) {
                                actualizarRegistro("No quedan más cartas con las que " +
                                        "jugar<br/>La partida terminó.");
                                actualizarRegistro("El ganador es: " + game.vaGanando() +
                                        ", " + "con " + game.puntajeMayor() + " puntos.");
                                registro.setText(acumRegistro);
                                game.eliminarCPUS(); game.limpiarPuntajes();
                                try {
                                    hilo.interrupt();
                                } catch (Exception ex) {
                                    throw new RuntimeException("Thread interrupted");
                                }
                            } else { //si no, sigue
                                actualizarTodo();
                            }
                        } else { //Si se ingresó algo incorrecto
                            //Pierde puntaje el jugador
                            actualizarRegistro("Incorrecto, " +
                                    game.getJugadorActual().getUser()
                                    + " ha perdido 10 de puntaje.");
                            game.getJugadorActual().agregarPuntaje((-10));
                            //Resto de acciones:
                            incorrecto();
                        }
                    }
                }
            }
        });
        back.addActionListener(new ActionListener() {
            /**
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    public void actualizarRegistro(String textoNuevo){
        //</html> = 7 char
        StringBuilder stringNuevo = new StringBuilder(acumRegistro);
        //Removemos el </html>
        for (int i=0;i< 7;i++) {
            stringNuevo.deleteCharAt(stringNuevo.length() -1);
        }
        acumRegistro = stringNuevo + textoNuevo + "<br/></html>";
    }

    public void actualizarTodo(){
        //Cambiar cartas sobre la mesa
        if (mesa.size() > 1){
        mesa.remove(0);mesa.remove(0);}
        mesa.add(this.game.getMazoCartas().getCardsSet().get(0));
        mesa.add(this.game.getMazoCartas().getCardsSet().get(1));
        cartasEnMesa.setText("<html>Cartas en la mesa:<br/>" +
                "Carta: "+ mesa.get(0) +"<br/>" +
                "Carta: "+ mesa.get(1) +"</html>");
        //Turno del jugador:
        turno = this.game.getJugadorActual();
        modoTurno.setText("<html>Modo de juego: "+ modo + "<br/>" +
                "Turno actual: " + this.game.getJugadorActual().getUser() +
                "</html>");
        //Puntaje:
        puntajeJugador.setText("<html>Puntaje del jugador:<br/>" +
                this.game.getJugadorActual().getPuntaje() + "</html>");
        //Registro
        registro.setText(acumRegistro);
        //Reiniciamos Timer
        try {
            hilo.interrupt();
        }
        catch (Exception e) {
            System.out.println("Exception handled");
        }
        hilo = nuevoHilo();
        hilo.start();
    }

    public void incorrecto(){
        //Se retiran las cartas de la mesa
        this.mesa.remove(0); this.mesa.remove(0);
        //Se cambia de turno
        game.avanzarTurno();
        //Revisamos si el juego debería terminar
        if (game.getMazoCartas().getCardsSet().size() <= 1){
            actualizarRegistro("No quedan más cartas con las que " +
                    "jugar<br/>La partida terminó.");
            actualizarRegistro("El ganador es: " + game.vaGanando() + ", " +
                    "con " + game.puntajeMayor() + " puntos.");
            registro.setText(acumRegistro);
            game.eliminarCPUS(); game.limpiarPuntajes();
        }
        else { //si no, sigue
            actualizarTodo();
        }
    }

    public Thread nuevoHilo(){
        return new Thread(this::run);
    }

    private void run() {
        tiempoRestante.setText("<html><br/>Tiempo Restante: " +
                tiempoMax + "</html>");
        for (this.time = 0; time <= tiempoMax; time++) {
            try {
                Thread.sleep(1000);
                tiempoRestante.setText("<html><br/>Tiempo Restante: " +
                        (tiempoMax - time) + "</html>");
                //Config CPU
                if(game.getJugadorActual().isCPU()) {
                    turnoCPU();
                }
                if (tiempoMax - time <= 0) {
                    if (contraReloj) {
                        game.limpiarPuntajes(); game.eliminarCPUS();
                        JFrame frameDerrota = new genericText("Derrota",
                                "Se ha agotado el tiempo, fin de la partida.");
                        frameDerrota.setVisible(true);
                        dispose();
                    } else {
                        //Pierde puntaje
                        actualizarRegistro("Se ha agotado el tiempo, " +
                                game.getJugadorActual().getUser()
                                + " ha perdido 10 de puntaje.");
                        game.getJugadorActual().agregarPuntaje((-10));
                        //Resto de cosas
                        incorrecto();
                    }
                }
            } catch (InterruptedException e) {
                throw new RuntimeException("Thread interrupted");
            }
        }
    }

    public void turnoCPU(){
        if (time == 5) {
            //Eliminamos las cartas del mazo
            game.getMazoCartas().getCardsSet().remove(0);
            game.getMazoCartas().getCardsSet().remove(0);
            //Agregamos puntaje al jugador
            game.getJugadorActual()
                    .agregarPuntaje(puntajeTiempo * (tiempoMax - time));
            //Registro
            actualizarRegistro("Correcto, " +
                    game.getJugadorActual().getUser() + " ha ganado " +
                    (tiempoMax - time) + " puntos.");
            //Avanzamos turno
            game.avanzarTurno();
            //Revisamos si el juego debería terminar
            if (game.getMazoCartas().getCardsSet().size() <= 1) {
                actualizarRegistro("No quedan más cartas con las que " +
                        "jugar<br/>La partida terminó.");
                actualizarRegistro("El ganador es: " + game.vaGanando() + ", " +
                        "con " + game.puntajeMayor() + " puntos.");
                game.eliminarCPUS(); game.limpiarPuntajes();
                registro.setText(acumRegistro);
                try {
                    hilo.interrupt();
                } catch (Exception e) {
                    System.out.println("Exception handled");
                }
            } else { //si no, sigue
                actualizarTodo();
            }
        }
    }
}
