package Dobble.game;

import Dobble.cardsSet.Dobble;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DobbleGame {
    List<Player> jugadores;
    int turnoActual; //index de la posición del jugador cuyo turno es
    Dobble mazoCartas;
    Dobble mazoIdeal;
    String modoDeJuego;

    //Constructor
    public DobbleGame() {
        this.jugadores = new ArrayList<>();
        this.turnoActual = 0;
    }

    //Getters
    public List<Player> getJugadores() {return jugadores;}
    public int getTurnoActual() {return turnoActual;}
    public int getCantidadJugadores() {return jugadores.size();}
    public Dobble getMazoCartas() {return mazoCartas;}
    public Dobble getMazoIdeal() {return mazoIdeal;}
    public String getModoDeJuego() {return modoDeJuego;}

    //Setters
    public void setTurnoActual(int turno) {this.turnoActual = turno;}
    public void setMazoCartas(Dobble mazoCartas) {this.mazoCartas = mazoCartas;}
    public void setMazoIdeal(Dobble mazoIdeal) {this.mazoIdeal = mazoIdeal;}
    public void setModoDeJuego(String modoDeJuego) {this.modoDeJuego = modoDeJuego;}

    //Otros métodos:

    //getNombreJugadores, método que retorna una lista con los nombres de los jugadores.
    //DOM: void
    //REC: List<String>
    public List<String> getNombreJugadores(){
        List<String> nombreJugadores = new ArrayList<>();
        for (int i = 0; i < getJugadores().size(); i++){
            nombreJugadores.add(getJugadores().get(i).getUser());
        }
        return nombreJugadores;
    }

    //avanzarTurno, método que avanza el turno.
    //DOM: void
    //REC: void
    public void avanzarTurno(){
        if (turnoActual < getCantidadJugadores()-1 ) {
            this.turnoActual = turnoActual + 1;
        }
        else  {turnoActual = 0;} //Si el turno actual es el del último jugador, se reinicia
    }

    //getPuntajes, método que obtiene una lista con los puntajes
    //DOM: void
    //REC: List<Integer>
    public List<Integer> getPuntajes(){
        List<Integer> listaPuntajes = new ArrayList<>();
        for (int i=0; i < getJugadores().size(); i++){
            listaPuntajes.add(getJugadores().get(i).getPuntaje());
        }
        return listaPuntajes;
    }

    //puntajeMayor, método que obtiene el mayor de los puntajes
    //DOM: void
    //REC: Integer
    public Integer puntajeMayor(){
        int puntajeMayor = 0;
        for (int i=0;i < getJugadores().size();i++){
            if (puntajeMayor < getPuntajes().get(i)){
                puntajeMayor = getPuntajes().get(i);
            }
        }
        return puntajeMayor;
    }

    //vaGanando, método que entrega el nombre del jugador que va ganando
    //DOM: void
    //REC: String
    public String vaGanando(){
        String vaGanando = "Nadie";
        Integer puntajeMayor = 0;
        for (int i=0;i < getJugadores().size();i++){
            if (puntajeMayor < getPuntajes().get(i)){
                puntajeMayor = getPuntajes().get(i);
                vaGanando = getJugadores().get(i).getUser();
            }
        }
        return vaGanando;
    }

    @Override
    //Override de toString
    public String toString() {
        return "DobbleGame:" +
                "\njugadores = " + jugadores +
                "\nturnoActual = " + turnoActual +
                "\nmazoCartas=" + mazoCartas +
                "\nmazoIdeal=" + mazoIdeal +
                "\nmodoDeJuego='" + modoDeJuego + '\'';
    }

    @Override
    //Override de equals
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DobbleGame)) return false;

        DobbleGame that = (DobbleGame) o;

        if (getTurnoActual() != that.getTurnoActual()) return false;
        if (getJugadores() != null ? !getJugadores().equals(that.getJugadores()) : that.getJugadores() != null)
            return false;
        if (getMazoCartas() != null ? !getMazoCartas().equals(that.getMazoCartas()) : that.getMazoCartas() != null)
            return false;
        if (getMazoIdeal() != null ? !getMazoIdeal().equals(that.getMazoIdeal()) : that.getMazoIdeal() != null)
            return false;
        return getModoDeJuego() != null ? getModoDeJuego().equals(that.getModoDeJuego()) : that.getModoDeJuego() == null;
    }

    //MODOS DE JUEGO

    //modoDemo, modo de juego donde competirá la CPU contra si misma.
    public void modoDemo(){
        setModoDeJuego("Modo Demo");
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("ss");
        while (getMazoCartas().getCardsSet().size() > 2){
            int inicioTurno = Integer.valueOf(formato.format(LocalDateTime.now()));
            int finTurno = inicioTurno + 3;
            //Para no caer en turnos infinitos:
            while (inicioTurno > 57){inicioTurno = inicioTurno - 1;}
            while (finTurno > 60){finTurno = finTurno - 1;}
            //Duración del turno = 3 segundos
            System.out.println("\nMazo de cartas: " + getMazoCartas().getCardsSet() +
                    "\n\nSeleccione dos cartas en base a su posición y un elemento en común\n" +
                    "Ejemplo: 0 1 78");
            while (inicioTurno < finTurno) { //El tiempo avanza hasta que pasen 3 seg.
                inicioTurno = Integer.valueOf(formato.format(LocalDateTime.now()));}
            if (getTurnoActual() == 0 || getTurnoActual() == 1){
                Random numeroRandom = new Random();
                int posC1 = numeroRandom.nextInt(getMazoCartas().getCardsSet().size());
                int posC2 = numeroRandom.nextInt(getMazoCartas().getCardsSet().size());
                while (posC1 == posC2){ //En caso de que ambas posiciones sean iguales
                    posC2 = numeroRandom.nextInt(getMazoCartas().getCardsSet().size());}
                System.out.println(getJugadores().get(getTurnoActual()).getUser() + ": " +
                        posC1 + " " + posC2 + " " + getMazoCartas().elementoComun(posC1,posC2));
                getMazoCartas().getCardsSet().remove(posC1);
                //En caso de que se remueva 1 menor o mayor, se ejecutará el "if"
                if (posC1 < posC2){getMazoCartas().getCardsSet().remove(posC2-1);}
                else {getMazoCartas().getCardsSet().remove(posC2);}
                int puntos =(10 - 3) * 2 ; //(10 - cantidad de tiempo) * cantidad de cartas
                System.out.println("\nCorrecto! Se han añadido " + puntos + " puntos al jugador " +
                        getJugadores().get(getTurnoActual()).getUser() + ".");
                getJugadores().get(getTurnoActual()).agregarPuntaje(puntos);
            }
            else {System.out.println("\nERROR: Hay más jugadores de los que debería\n");}
            avanzarTurno();
        }
        System.out.println("\nFin de la partida, los puntajes finales son:\n" + getPuntajes() +
                "\nEl ganador es: " + vaGanando());
    }
}

//IDEA:
//while el jugador no haga movimiento
//if horaActual > horaObjetivo
//Dobble.game.descalificarJugador