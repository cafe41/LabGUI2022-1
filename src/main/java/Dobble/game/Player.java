package main.java.Dobble.game;

import main.java.Dobble.cardsSet.Card;

import java.util.List;

public interface Player {
    //Player será el jugador y en "DobbleGame" habrá una lista de jugadores.

    void agregarPuntaje(int agregado);

    //Getters
    String getUser();
    int getNumeroJugador();
    boolean isCPU();
    int getPuntaje();
    List<Card> getMano();

    //Setters
    void setPuntaje(int puntaje);
}
