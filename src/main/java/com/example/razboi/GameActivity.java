package com.example.razboi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;
import android.content.Intent;
import java.util.ArrayList;
public class GameActivity extends AppCompatActivity {
    private int nrApasariButon1;
    private int nrApasariButon2;
    private int nrCartiDeDat;
    private Player player1;
    private Player player2;
    private ArrayList<Carte> carti_masa;
    private Game game;
    private Carte carte_masa1;
    private Carte carte_masa2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        game = new Game();
        player1 = new Player();
        player2 = new Player();
        player1.SetPachet(game.GivePlayer1Cards());
        player2.SetPachet(game.GivePlayer2Cards());
        Button button = (Button)findViewById(R.id.giveCard2);
        button.setClickable(false);
        nrCartiDeDat = 1;
        carti_masa = new ArrayList<Carte>();
        nrApasariButon1 = 0;
        nrApasariButon2 = 0;
    }
    private boolean IsEmpty(Player player){
        if(player.GetPachet().size() == 0)
            return true;
        return false;
    }
    private void Game(int vcarte_masa1, int vcarte_masa2, int x){
        if(nrApasariButon1 == nrApasariButon2 || IsEmpty(player1) || IsEmpty(player2)){
            if(game.DeclareWinner(vcarte_masa1, vcarte_masa2) == 1){
                 Button iale = (Button)findViewById(R.id.iale1);
                 iale.setVisibility(View.VISIBLE);
                 nrCartiDeDat = 1;
            }
            else if(game.DeclareWinner(vcarte_masa1, vcarte_masa2) == 2){
                Button iale = (Button)findViewById(R.id.iale2);
                iale.setVisibility(View.VISIBLE);
                nrCartiDeDat = 1;
            }
            else{
                nrCartiDeDat = x;
            }
        }
        nrApasariButon1 = 0;
        nrApasariButon2 = 0;
    }
    public void onClickGiveCard1(View view){
        nrApasariButon1++;
        carte_masa1 = player1.GiveCard();
        player1.RemoveCard();
        TextView test = (TextView)findViewById(R.id.test);
        test.setText(Integer.toString(carte_masa1.GetValoare()));
        carti_masa.add(carte_masa1);
        ImageView image = (ImageView)findViewById(R.id.card1);
        int imageID = getResources().getIdentifier(carte_masa1.GetUrl(), "drawable", getPackageName());
        image.setImageResource(imageID);
        if(nrApasariButon1 == nrCartiDeDat || IsEmpty(player1)){
             view.setClickable(false);
             Button button = (Button)findViewById(R.id.giveCard2);
             button.setClickable(true);
        }
    }
    public void onClickGiveCard2(View view){
        nrApasariButon2++;
        carte_masa2 = player2.GiveCard();
        player2.RemoveCard();
        carti_masa.add(carte_masa2);
        TextView test = (TextView)findViewById(R.id.test1);
        test.setText(Integer.toString(carte_masa2.GetValoare()));
        ImageView image = (ImageView)findViewById(R.id.card2);
        int imageID = getResources().getIdentifier(carte_masa2.GetUrl(), "drawable", getPackageName());
        image.setImageResource(imageID);
        if(nrApasariButon2 == nrCartiDeDat || IsEmpty(player2)){
            view.setClickable(false);
            Button button = (Button)findViewById(R.id.giveCard1);
            button.setClickable(true);
            int a = carte_masa2.GetValoare();
            System.out.println("a = " + Integer.toString(a));
            if(a == 15)
                a = 11;
            Game(carte_masa1.GetValoare(), carte_masa2.GetValoare(), a);
        }
    }
    public void onClickIale1(View view) {
        if (player2.GetPachet().size() == 0) {
            TextView text = (TextView) findViewById(R.id.winner);
            text.setText(R.string.player1);
            Button button = (Button) findViewById(R.id.returnButton);
            button.setVisibility(View.VISIBLE);
            return;
        }
        int i;
        for (i = 0; i < carti_masa.size(); i++)
            player1.GetCard(carti_masa.get(i));
        carti_masa.clear();
        view.setVisibility(View.INVISIBLE);
        ImageView image1 = (ImageView)findViewById(R.id.card1);
        ImageView image2 = (ImageView)findViewById(R.id.card2);
        image1.setImageResource(R.drawable.blue_back);
        image2.setImageResource(R.drawable.blue_back);
        TextView text = (TextView)findViewById(R.id.scor1);
        text.setText(Integer.toString(player1.GetPachet().size()));
        TextView text1 = (TextView)findViewById(R.id.scor2);
        text1.setText(Integer.toString(player2.GetPachet().size()));
        nrApasariButon1 = 0;
        nrApasariButon2 = 0;
    }
    public void onClickIale2(View view){
        if(player1.GetPachet().size() == 0){
            TextView text = (TextView)findViewById(R.id.winner);
            text.setText(R.string.player2);
            Button button = (Button)findViewById(R.id.returnButton);
            button.setVisibility(View.VISIBLE);
            return;
        }
        int i;
        for(i = 0; i < carti_masa.size(); i++)
            player2.GetCard(carti_masa.get(i));
        carti_masa.clear();
        view.setVisibility(View.INVISIBLE);
        ImageView image1 = (ImageView)findViewById(R.id.card1);
        ImageView image2 = (ImageView)findViewById(R.id.card2);
        image1.setImageResource(R.drawable.blue_back);
        image2.setImageResource(R.drawable.blue_back);
        TextView text = (TextView)findViewById(R.id.scor2);
        text.setText(Integer.toString(player2.GetPachet().size()));
        TextView text1 = (TextView)findViewById(R.id.scor1);
        text1.setText(Integer.toString(player1.GetPachet().size()));
        nrApasariButon1 = 0;
        nrApasariButon2 = 0;
    }
    public void onClickReturnButton(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
