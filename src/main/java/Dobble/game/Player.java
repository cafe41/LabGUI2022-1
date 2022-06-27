package Dobble.game;

import Dobble.cardsSet.Card;

import java.util.List;

public interface Player {
    //Player será el jugador y en "DobbleGame" habrá una lista de jugadores.

    void agregarPuntaje(int agregado);

    //Getters
    public String getUser();
    public int getNumeroJugador();
    public boolean isCPU();
    public int getPuntaje();
    public List<Card> getMano();
}
