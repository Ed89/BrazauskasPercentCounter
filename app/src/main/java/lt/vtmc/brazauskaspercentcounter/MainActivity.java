package lt.vtmc.brazauskaspercentcounter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText EditAmount;
    private TextView textTip;
    private TextView textTotal;
    private TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditAmount = findViewById(R.id.EditAmount);


        textTip = findViewById(R.id.textTip);
        textTotal = findViewById(R.id.textTotal);
        textResult = findViewById(R.id.textResult);


        SeekBar seekBar = (SeekBar) findViewById(R.id.SeekBar);
        TextView textView = (TextView) findViewById(R.id.textProc);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                textView.setText("" + progress + "%");


                try {

                calcTip(progress);
                }
                catch (NumberFormatException ignored){}


            }

            private void calcTip(int progress) {
                double number = Double.parseDouble(EditAmount.getText().toString());
                double percent = ((double)(progress*number)/100);
                double roundOff = Math.round(percent*100.0)/100.0;
                textTip.setText("" + roundOff);
                double result = number-roundOff;
                double roundTotal = Math.round(((number-roundOff))*100.0)/100.0;

                textTotal.setText("" + (roundTotal));
                textResult.setText("Percent: "+progress+"\nTip: "+roundOff+"\nTotal: "+roundTotal);
            }


            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                int value = seekBar.getProgress();

            }
        });

    }
}