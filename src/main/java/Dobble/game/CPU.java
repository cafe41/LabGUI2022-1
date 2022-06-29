package main.java.Dobble.game;

import main.java.Dobble.cardsSet.Card;

import java.util.List;

public class CPU implements Player {
    private String user;  //Ej: "CPU 1"
    private int nJugador; //EJ: 2 [jugador1, cpu1]
    private boolean CPU;  //CPU: true
    private int puntaje;  //EJ: 29
    private List<Card> mano;

    public CPU(String user, List<Player> jugadores) {
        this.nJugador = jugadores.size() + 1;
        this.user = user;
        this.CPU = true;
        this.puntaje = 0;
    }

    //Setters: solo el nombre del CPU y el puntaje deberían poder cambiarse
    public void setUser(String user) {this.user = user;}
    public void setPuntaje(int puntaje) {this.puntaje = puntaje;}

    //Getters:
    public String getUser() {return user;}
    public int getNumeroJugador() {return nJugador;}
    public boolean isCPU() {return CPU;}
    public int getPuntaje() {return puntaje;}
    public List<Card> getMano() {return mano;}

    //Otros métodos

    //agregarPuntaje, método que agrega un puntaje "agregado" al puntaje.
    //DOM: int
    //REC: void
    public void agregarPuntaje(int agregado){
        setPuntaje(getPuntaje() + agregado);
    }

    @Override
    //Override de toString
    public String toString() {
        return  "Nombre: \"" + user + '\"' +
                ", Número de Jugador: " + nJugador +
                ", CPU: Si" +
                ", Puntaje: " + puntaje +
                ", Mano: " + mano + "\n";
    }

    @Override
    //Override de equals
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CPU)) return false;

        CPU cpu = (CPU) o;

        if (nJugador != cpu.nJugador) return false;
        if (isCPU() != cpu.isCPU()) return false;
        if (getPuntaje() != cpu.getPuntaje()) return false;
        if (getUser() != null ? !getUser().equals(cpu.getUser()) : cpu.getUser() != null) return false;
        return getMano() != null ? getMano().equals(cpu.getMano()) : cpu.getMano() == null;
    }
}
