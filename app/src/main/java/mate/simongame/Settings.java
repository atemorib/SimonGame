package mate.simongame;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;




public class Settings extends Activity {

    private RadioGroup difficulty;
    private Button back;
    private final int EASY = 1500;
    private final int MEDIUM = 1000;
    private final int HARD = 500;
    public static int PREFFERED_DIFFICULTY;


    private RadioButton easy;
    private RadioButton medium;
    private RadioButton hard;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        this.easy = findViewById(R.id.easy);
        this.medium = findViewById(R.id.medium);
        this. hard = findViewById(R.id.hard);
        this.back = findViewById(R.id.back);
        difficulty = (RadioGroup) findViewById(R.id.difficulty);
        loadDifficulty();
        setDifficulty();
        back.setOnClickListener((View v)->{
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
        });


    }

    private void setDifficulty(){
        difficulty.setOnCheckedChangeListener((RadioGroup group, int checkedId)->{
            switch (checkedId){
                case R.id.easy: PREFFERED_DIFFICULTY = EASY;       saveDifficulty();
                break;
                case R.id.medium: PREFFERED_DIFFICULTY = MEDIUM;       saveDifficulty();
                break;
                case R.id.hard: PREFFERED_DIFFICULTY = HARD;      saveDifficulty();
                break;
            }

                });


    }

    private void saveDifficulty(){
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean("Easy", easy.isChecked());
        editor.putBoolean("Medium", medium.isChecked());
        editor.putBoolean("Hard", hard.isChecked());
        editor.apply();

    }

    private void loadDifficulty(){
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
        easy.setChecked(pref.getBoolean("Easy", false));
        medium.setChecked(pref.getBoolean("Medium", false));
        hard.setChecked(pref.getBoolean("Hard", false));

    }


}
