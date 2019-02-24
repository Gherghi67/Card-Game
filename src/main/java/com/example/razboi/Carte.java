package com.example.razboi;


public class Carte {
    private int valoare;
    private Culoare culoare;
    private String url;
    public Carte(int valoare, Culoare culoare, String url){
        this.valoare = valoare;
        this.culoare = culoare;
        this.url = url;
    }
    public Carte(Carte x){
        this.valoare = x.GetValoare();
        this.url = x.GetUrl();
    }
    public int GetValoare(){
        return valoare;
    }
    public Culoare GetCuloare(){
        return culoare;
    }
    public String GetUrl(){
        return url;
    }
    public void SetValoare(int x){
        valoare = x;
    }
    public void SetCuloare(Culoare x){
        culoare = x;
    }
    public void SetUrl(String x){
        url = x;
    }
}
