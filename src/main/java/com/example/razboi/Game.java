package com.example.razboi;
import java.util.ArrayList;
import java.util.Collections;
public class Game {
    private ArrayList<Carte> pachet;
    public Game(){
        pachet = new ArrayList<Carte>();
        int i;
        for(i = 2; i <= 10; i++){
            pachet.add(new Carte(i, Culoare.INIMA_ROSIE, "x" + Integer.toString(i) + "h"));
            pachet.add(new Carte(i, Culoare.ROMB, "x" + Integer.toString(i) + "d"));
            pachet.add(new Carte(i, Culoare.TREFLA, "x" + Integer.toString(i) + "c"));
            pachet.add(new Carte(i, Culoare.INIMA_NEAGRA, "x" + Integer.toString(i) + "s"));
        }
        pachet.add(new Carte(15, Culoare.TREFLA, "ac"));
        pachet.add(new Carte(15, Culoare.ROMB, "ad"));
        pachet.add(new Carte(15, Culoare.INIMA_ROSIE, "ah"));
        pachet.add(new Carte(15, Culoare.INIMA_NEAGRA, "as"));
        pachet.add(new Carte(12, Culoare.INIMA_NEAGRA, "js"));
        pachet.add(new Carte(12, Culoare.INIMA_ROSIE, "jh"));
        pachet.add(new Carte(12, Culoare.ROMB, "jd"));
        pachet.add(new Carte(12, Culoare.TREFLA, "jc"));
        pachet.add(new Carte(14, Culoare.INIMA_ROSIE, "kh"));
        pachet.add(new Carte(14, Culoare.TREFLA, "kc"));
        pachet.add(new Carte(14, Culoare.INIMA_NEAGRA, "ks"));
        pachet.add(new Carte(14, Culoare.ROMB, "kd"));
        pachet.add(new Carte(13, Culoare.INIMA_NEAGRA, "qs"));
        pachet.add(new Carte(13, Culoare.ROMB, "qd"));
        pachet.add(new Carte(13, Culoare.INIMA_ROSIE, "qh"));
        pachet.add(new Carte(13, Culoare.TREFLA, "qc"));
        Collections.shuffle(pachet);
    }
    public ArrayList<Carte> GivePlayer1Cards(){
        int i;
        ArrayList<Carte> v = new ArrayList<Carte>();
        for(i = 1; i < 52; i = i +2){
            v.add(pachet.get(i));
        }
        return v;
    }
    public ArrayList<Carte> GivePlayer2Cards(){
        int i;
        ArrayList<Carte> v = new ArrayList<Carte>();
        for(i = 0; i < 52; i = i +2){
            v.add(pachet.get(i));
        }
        return v;
    }
    public int DeclareWinner(int x, int y){

        if(x > y) {
            return 1;
        }
        if(x < y) {
            return 2;
        }
        return 0;
    }
}
