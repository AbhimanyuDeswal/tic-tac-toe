package com.abhimanyu.tic_tac_toe;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    int activePlayer = 0;
    int[] gamePosition = {2,2,2,2,2,2,2,2,2};
    boolean gameState = true;
    int[][] winningPositions = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{2,5,8},{0,4,8},{2,4,6},{1,4,7}};



    public void divein(View view){

        // 0: yellow, 1: red

        TextView winnerTextView = (TextView) findViewById(R.id.winnerTextView);
        Button playAgainButton = (Button) findViewById(R.id.playAgainButton);

;
        ImageView counter = (ImageView) view;
        int tappedCounter = Integer.parseInt(counter.getTag().toString());
        Log.i("info",counter.getTag().toString());

        //Toast.makeText(this,counter.getTag().toString(),Toast.LENGTH_SHORT).show();

        if(gamePosition[tappedCounter]==2 && gameState) {
            String winner = "";

            gamePosition[tappedCounter] = activePlayer;
        //  counter.setTranslationY(-1000);



            if (activePlayer == 0) {

                counter.setImageResource(R.drawable.yellow);

                activePlayer = 1;

            } else {

                counter.setImageResource(R.drawable.red);
                activePlayer = 0;
            }

            counter.animate().alpha(1).setDuration(1000);


            for(int[] winPos : winningPositions){

                if(gamePosition[winPos[0]]==gamePosition[winPos[1]] && gamePosition[winPos[1]]==gamePosition[winPos[2]] && gamePosition[winPos[0]]!=2){

                    if (activePlayer==1){
                      winner="Yellow won!";
                    }

                    if (activePlayer==0){
                      winner="Red won!";
                    }
                   // Toast.makeText(this,winner,Toast.LENGTH_SHORT).show();

                    winnerTextView.setText(winner);
                    winnerTextView.setVisibility(View.VISIBLE);
                    playAgainButton.setVisibility(View.VISIBLE);

                }

                else if(gamePosition[0] != 2 && gamePosition[1] !=2 && gamePosition[2] !=2 &&
                        gamePosition[3] != 2 && gamePosition[4] !=2 && gamePosition[5] !=2 &&
                        gamePosition[6] != 2 && gamePosition[7] !=2 && gamePosition[8] !=2){

                    playAgainButton.setVisibility(View.VISIBLE);
                }
            }



        }else {
            gameState = false;

        }



    }


    public void playAgain(View view){

        Button playAgainButton = (Button) findViewById(R.id.playAgainButton);
        TextView winnerTextView = (TextView) findViewById(R.id.winnerTextView);

        playAgainButton.setVisibility(View.INVISIBLE);
        winnerTextView.setVisibility(View.INVISIBLE);

        GridLayout gridLayout = (GridLayout) findViewById(R.id.gridLayout);

        for(int i=0 ; i<gridLayout.getChildCount();i++){

            ImageView counter =(ImageView) gridLayout.getChildAt(i);
            counter.setImageDrawable(null);

        }

        for(int i = 0; i < gamePosition.length; i++){

            gamePosition[i]=2;
        }

        activePlayer = 0;
        gameState = true;


    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
