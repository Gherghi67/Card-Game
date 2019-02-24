package com.example.razboi;
import java.util.ArrayList;
public class Player {
    private ArrayList<Carte> pachet;
    public Player(){

    }
    public Carte GiveCard(){
        return pachet.get(0);
    }
    public void SetPachet(ArrayList<Carte> v){
        pachet = (ArrayList<Carte>)v.clone();
    }
    public ArrayList<Carte> GetPachet(){
        return pachet;
    }
    public void GetCard(Carte x){
        pachet.add(x);
    }
    public void RemoveCard(){
        pachet.remove(0);
    }
}
