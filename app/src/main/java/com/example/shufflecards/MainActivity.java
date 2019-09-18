package com.example.shufflecards;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;
public class MainActivity extends AppCompatActivity {

    int score;
    Button shuffle;
    TextView shuffleResults, remainingCardTv;
    Random rand;
    int cardNum;
    int totalCardsLeft = 52;
    String[] cardValues = {"Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
                        "Jack", "Queen", "King", "Ace"};
    String[] cardSuits = {"Hearts", "Diamond", "Spade", "Club"};
    ArrayList<String> cardsArray = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        score = 0;
        //create greeting
        Toast.makeText(getApplicationContext(), "Welcome to the game", Toast.LENGTH_SHORT).show();
        shuffleResults = (TextView) findViewById(R.id.shuffleResults);
        remainingCardTv = (TextView)findViewById(R.id.remainingCards);
        remainingCardTv.setText("Remaining Cards: "+totalCardsLeft);
        shuffle = (Button) findViewById(R.id.shuffle);
        //rand = new Random();
        //cardNum = rand.nextInt(51)+1;
        populateCardsDeck();

    }

    public void shuffleCards(View v){
        displayCard();

    }

    public void displayCard(){
        rand = new Random();
        cardNum = rand.nextInt(totalCardsLeft);
        shuffleResults.setText(cardsArray.get(cardNum));
        cardsArray.remove(cardNum);
        totalCardsLeft--;
        remainingCardTv.setText("Remaining Cards: "+totalCardsLeft);

        if(totalCardsLeft==0){
            totalCardsLeft=52;
            remainingCardTv.setText("Remaining Cards: "+totalCardsLeft);
            populateCardsDeck();
        }
    }

    public  void populateCardsDeck(){
        for( int i=0; i<cardSuits.length; i++){
            for(int j=0; j<cardValues.length; j++){
                cardsArray.add(cardValues[j]+" of "+cardSuits[i]);
            }
        }
    }

}







