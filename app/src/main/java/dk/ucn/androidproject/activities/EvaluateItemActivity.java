package dk.ucn.androidproject.activities;

import android.content.Intent;
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
    public boolean isHandled;

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

        Spinner pointSpinner = (Spinner)findViewById(R.id.point_spinner);
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

        EditText noteInput = (EditText)findViewById(R.id.txt_note);
        noteInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleNoteFieldClicked(((EditText)v.findViewById(R.id.txt_note)).getText().toString());
            }
        });

        Button btnLux = (Button)findViewById(R.id.btn_measure_lux);
        btnLux.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO measure lux intent
            }
        });

        Button btnSlope = (Button)findViewById(R.id.btn_measure_slope);
        btnSlope.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO measure slope intent
            }
        });

        Button btnSave = (Button)findViewById(R.id.btn_save);
        btnLux.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveCurrentItem();
            }
        });

    }

    private void saveCurrentItem() {
        //TODO insert current item into database
        //TODO mark handled checked on item description

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent resultIntent = new Intent();
        resultIntent.putExtra("EvaluateItemActivity", true);
        setResult(RESULT_OK, resultIntent);
        finish();
    }

    private void setVisibilityOfWidgets(boolean isLuxMeasurable,boolean isSlopeMeasurable) {
        TextView lblLux = (TextView)findViewById(R.id.lbl_lux);
        EditText txtLux = (EditText)findViewById(R.id.txt_lux);
        lblLux.setVisibility(isLuxMeasurable ? View.VISIBLE : View.GONE);
        txtLux.setVisibility(isLuxMeasurable ? View.VISIBLE : View.GONE);

        TextView lblSlope = (TextView)findViewById(R.id.lbl_slope);
        EditText txtSlope  = (EditText)findViewById(R.id.txt_slope);
        lblSlope.setVisibility(isSlopeMeasurable ? View.VISIBLE : View.GONE);
        txtSlope.setVisibility(isSlopeMeasurable ? View.VISIBLE: View.GONE);

        Button btnLux = (Button)findViewById(R.id.btn_measure_lux);
        btnLux.setVisibility(isLuxMeasurable ? View.VISIBLE : View.GONE);

        Button btnSlope = (Button)findViewById(R.id.btn_measure_slope);
        btnSlope.setVisibility(isSlopeMeasurable ? View.VISIBLE : View.GONE);
    }

    private void handleNoteFieldClicked(String text) {
        currentItem.setNote(text);
    }

    private void handleSpinnerItemSelected(Object selectedItem) {
        currentItem.setPoint(Integer.parseInt(selectedItem.toString()));
    }


}
