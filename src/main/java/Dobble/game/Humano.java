package Dobble.game;

import Dobble.cardsSet.Card;

import java.util.List;

public class Humano implements Player {
    private String user;     //Ej: "Jugador1"
    private int nJugador;    //EJ: 1 [jugador1, cpu1]
    private boolean CPU;     //CPU: true
    private int puntaje;     //EJ: 20
    private List<Card> mano; //Si el jugador posee mano es una lista de cartas, sino es "null"

    //Constructor
    public Humano(String user, List<Player> jugadores) {
        this.user = user;
        this.nJugador = jugadores.size() + 1;
        this.CPU = false;
        this.puntaje = 0;
    }

    //Setters: El nombre de usuario y el puntaje se pueden cambiar
    public void setUser(String user) {
        this.user = user;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    //Getters:
    public String getUser() {
        return user;
    }

    public int getNumeroJugador() {
        return nJugador;
    }

    public boolean isCPU() {
        return CPU;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public List<Card> getMano() {
        return mano;
    }

    //Otros métodos

    //agregarPuntaje, método que agrega un puntaje "agregado" al puntaje.
    //DOM: int
    //REC: void
    public void agregarPuntaje(int agregado) {
        setPuntaje(getPuntaje() + agregado);
    }

    @Override
    //Override de toString
    public String toString() {
        return  "Nombre: \"" + user + '\"' +
                ", Número de Jugador: " + nJugador +
                ", CPU: No" +
                ", Puntaje: " + puntaje +
                ", Mano: " + mano + "\n";
    }

    @Override
    //Override de equals
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Humano)) return false;

        Humano humano = (Humano) o;

        if (nJugador != humano.nJugador) return false;
        if (isCPU() != humano.isCPU()) return false;
        if (getPuntaje() != humano.getPuntaje()) return false;
        if (getUser() != null ? !getUser().equals(humano.getUser()) : humano.getUser() != null)
            return false;
        return getMano() != null ? getMano().equals(humano.getMano()) : humano.getMano() == null;
    }
}
