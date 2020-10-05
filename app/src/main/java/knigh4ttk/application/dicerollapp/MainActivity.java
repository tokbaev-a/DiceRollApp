package knigh4ttk.application.dicerollapp;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Random random = new Random();
    int diceValue1;
    int diceValue2;
    int image1;
    int image2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState != null) {
            image1 = savedInstanceState.getInt("dice1");
            image2 = savedInstanceState.getInt("dice2");
            display(image1, image2);
        }
    }
    public void roll(View v) {
        diceValue1 = random.nextInt(6) + 1;
        diceValue2 = random.nextInt(6) + 1;
        image1 = getResources().getIdentifier("ic_dice_" + diceValue1, "drawable", "knigh4ttk.application.dicerollapp");
        image2 = getResources().getIdentifier("ic_dice_" + diceValue2, "drawable", "knigh4ttk.application.dicerollapp");
        display(image1, image2);
    }
    private void display(int image1, int image2) {
        ImageView dice1 = (ImageView) findViewById(R.id.first_dice);
        ImageView dice2 = (ImageView) findViewById(R.id.second_dice);
        dice1.setImageResource(image1);
        dice2.setImageResource(image2);
    }
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("dice1", image1);
        outState.putInt("dice2", image2);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }
}