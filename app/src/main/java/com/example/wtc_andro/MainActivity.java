import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText hoursEditText;
    private EditText minutesEditText;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hoursEditText = findViewById(R.id.hoursEditText);
        minutesEditText = findViewById(R.id.minutesEditText);
        resultTextView = findViewById(R.id.resultTextView);

        Button calculateButton = findViewById(R.id.calculateButton);
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateWorkingTime();
            }
        });
    }

    private void calculateWorkingTime() {
        String userHours = hoursEditText.getText().toString();
        String userMin = minutesEditText.getText().toString();

        int hours = Integer.parseInt(userHours);
        int minutes = Integer.parseInt(userMin);

        while (minutes >= 60) {
            hours++;
            minutes -= 60;
        }

        String result = "Working time: " + hours + " hours and " + minutes + " minutes.";
        resultTextView.setText(result);
    }
}
