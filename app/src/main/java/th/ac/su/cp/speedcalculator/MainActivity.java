package th.ac.su.cp.speedcalculator;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button calButton = findViewById(R.id.button_cal);
        calButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText num_distance = findViewById(R.id.edit_distance);
                String str_distance = num_distance.getText().toString();

                EditText num_time = findViewById(R.id.edit_time);
                String str_time = num_time.getText().toString();
                if(str_distance.length() == 0 || str_time.length() == 0){
                    Toast t = Toast.makeText(MainActivity.this,R.string.required,Toast.LENGTH_LONG);
                    t.show();
                }
                else{
                    TextView setResult = findViewById(R.id.rusult_text);

                    Double distance = Double.parseDouble(str_distance);
                    Double time = Double.parseDouble(str_time);
                    Double kilo;
                    Double hr;
                    Double average;
                    String result;

                    AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);


                    if(time == 0.0){
                        Toast t = Toast.makeText(MainActivity.this,R.string.morezero,Toast.LENGTH_LONG);
                        t.show();
                    }
                    else{

                        kilo = distance/1000;
                        hr = time/3600;
                        average = kilo/hr;
                        if(average >= 80){
                            dialog.setTitle("SPEED CALCULATOR");
                            dialog.setMessage(R.string.more);
                            dialog.setPositiveButton("OK",null);
                            dialog.show();
                            result = String.format("%.2f",average);
                            setResult.setText(result);
                        }else{
                            result = String.format("%.2f",average);
                            setResult.setText(result);
                        }

                    }
                }


            }
        });
        Button clearButton = findViewById(R.id.button_clear);
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText num_distance = findViewById(R.id.edit_distance);
                EditText num_time = findViewById(R.id.edit_time);
                num_distance.setText("");
                num_time.setText("");
            }
        });



    }
}