package ma.project.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private RadioGroup groupe;
    private EditText cout;
    private Button calculate;
    private TextView result;
    private Switch aSwitch;
    private double montant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cout = findViewById(R.id.cout_de_service);
        groupe = findViewById(R.id.options);
        calculate = findViewById(R.id.button_calculate);
        aSwitch = findViewById(R.id.round_up_switch);
        result = findViewById(R.id.result);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int option = groupe.getCheckedRadioButtonId();
                double percent = 0;

                //ysf
                switch (option) {
                    case R.id.option_18_percent:
                        percent = 0.18;
                        break;
                    case R.id.option_15_percent:
                        percent = 0.15;
                        break;
                    case R.id.option_vingt_percent:
                        percent = 0.2;
                        break;
                }
                montant = Double.parseDouble(cout.getText().toString()) * percent;
                if (aSwitch.isChecked()) {
                    montant = Math.round(montant * 100.0) / 100.0;
                }
                result.setText("");
                result.append("Montant pourboire : " + montant);
            }
        });

    }
}