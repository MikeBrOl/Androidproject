package dk.ucn.androidproject.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import dk.ucn.androidproject.R;
import dk.ucn.androidproject.model.Item;

/**
 * Created by ki on 25-10-2015.
 */
public class EvaluateItemActivity extends AppCompatActivity {
    private long currentItemDescriptionId;
    private long currentEvaluationId;
    private String currentDescriptionTitle;
    private Item currentItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evaluate_item);
        Bundle bundle = getIntent().getExtras();
        currentItemDescriptionId = bundle.getLong(EvaluationActivity.CURRENT_ITEM_DESCRIPTION_ID);
        currentEvaluationId = bundle.getLong(EvaluationActivity.CURRENT_EVALUATION_ID);
        currentDescriptionTitle = bundle.getString(EvaluationActivity.CURRENT_DESCRIPTION);
        boolean isLuxMeasurable = bundle.getBoolean(EvaluationActivity.CURRENT_LUX_MEASURABLITY);
        boolean isSlopeMeasurable = bundle.getBoolean(EvaluationActivity.CURRENT_SLOPE_MEASURABILITY);

        currentItem = new Item();

        setVisibilityOfWidgets(isLuxMeasurable, isSlopeMeasurable);
        loadPage();
    }

    private void loadPage() {
        TextView header = (TextView)findViewById(R.id.txt_header);
        header.setText(currentDescriptionTitle);

        final Spinner pointSpinner = (Spinner)findViewById(R.id.point_spinner);
        ArrayAdapter spinnerAdapter = ArrayAdapter.createFromResource(getApplicationContext(), R.array.points, R.layout.spinner_item);
        pointSpinner.setAdapter(spinnerAdapter);

        pointSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                handleSpinnerItemSelected(parent.getSelectedItem());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        final EditText noteInput = (EditText)findViewById(R.id.txt_note);
        noteInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleNoteFieldClicked(noteInput.getText().toString());
            }
        });

    }

    private void setVisibilityOfWidgets(boolean isLuxMeasurable,boolean isSlopeMeasurable) {
        TextView lblLux = (TextView)findViewById(R.id.lbl_lux);
        EditText txtLux = (EditText)findViewById(R.id.txt_lux);
        lblLux.setVisibility(isLuxMeasurable ? View.VISIBLE : View.INVISIBLE);
        txtLux.setVisibility(isLuxMeasurable ? View.VISIBLE : View.INVISIBLE);

        TextView lblSlope = (TextView)findViewById(R.id.lbl_slope);
        EditText txtSlope  = (EditText)findViewById(R.id.txt_slope);
        lblSlope.setVisibility(isSlopeMeasurable ? View.VISIBLE : View.INVISIBLE);
        txtSlope.setVisibility(isSlopeMeasurable ? View.VISIBLE: View.INVISIBLE);

        Button btnLux = (Button)findViewById(R.id.btn_measure_lux);
        btnLux.setVisibility(isLuxMeasurable ? View.VISIBLE : View.INVISIBLE);

        Button btnSlope = (Button)findViewById(R.id.btn_measure_slope);
        btnSlope.setVisibility(isSlopeMeasurable ? View.VISIBLE : View.INVISIBLE);
    }

    private void handleNoteFieldClicked(String text) {
        currentItem.setNote(text);
    }

    private void handleSpinnerItemSelected(Object selectedItem) {
        currentItem.setPoint(Integer.parseInt(selectedItem.toString()));
    }


}
