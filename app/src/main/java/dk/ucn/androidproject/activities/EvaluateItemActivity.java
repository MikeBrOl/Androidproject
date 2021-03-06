package dk.ucn.androidproject.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import dk.ucn.androidproject.R;
import dk.ucn.androidproject.dao.ItemDao;
import dk.ucn.androidproject.model.Item;

/**
 * Created by ki on 25-10-2015.
 */
public class EvaluateItemActivity extends AppCompatActivity {
    private long currentItemDescriptionId;
    private long currentEvaluationId;
    private String currentDescriptionTitle;
    private Item currentItem;
    private Intent resultIntent;
    private ItemDao itemDao;
    private TextView header;
    private Spinner pointSpinner;
    private EditText noteInput;
    private TextView lblLux;
    private TextView txtLux;
    private TextView lblSlope;
    private TextView txtSlope;
    private Button btnLux;
    private Button btnSlope;
    public static final int RESULT = 1;
    public static final String DESCRIPTION_ID = "DESCRIPTION_ID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evaluate_item);
        itemDao = new ItemDao(getApplicationContext());
        Bundle bundle = getIntent().getExtras();
        currentItemDescriptionId = bundle.getLong(EvaluationActivity.CURRENT_ITEM_DESCRIPTION_ID);
        currentEvaluationId = bundle.getLong(EvaluationActivity.CURRENT_EVALUATION_ID);
        currentDescriptionTitle = bundle.getString(EvaluationActivity.CURRENT_DESCRIPTION);
        boolean isLuxMeasurable = bundle.getBoolean(EvaluationActivity.CURRENT_LUX_MEASURABILITY);
        boolean isSlopeMeasurable = bundle.getBoolean(EvaluationActivity.CURRENT_SLOPE_MEASURABILITY);

        setVisibilityOfWidgets(isLuxMeasurable, isSlopeMeasurable);
        loadPage();
    }

    private void loadPage() {
        header = (TextView)findViewById(R.id.txt_header);
        header.setText(currentDescriptionTitle);

        currentItem = loadCurrentItem();

        pointSpinner = (Spinner)findViewById(R.id.point_spinner);
        ArrayAdapter spinnerAdapter = ArrayAdapter.createFromResource(getApplicationContext(), R.array.points, R.layout.spinner_item);
        pointSpinner.setAdapter(spinnerAdapter);
        pointSpinner.setSelection(currentItem.getPoint());
        pointSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                handleSpinnerItemSelected(parent.getSelectedItem());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        noteInput = (EditText)findViewById(R.id.txt_note);
        if (currentItem.getNote() != null){
            noteInput.setText(currentItem.getNote());
        }
        noteInput.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                boolean handled = false;
                if (actionId == EditorInfo.IME_ACTION_SEND){
                    currentItem.setNote(v.getText().toString());
                    hideSoftKeyboard();
                    handled = true;
                }
                return handled;
            }
        });

        if (currentItem.getLux() != null){
            txtLux.setText(currentItem.getLux());
        }
        if (currentItem.getSlope() != null){
            txtSlope.setText(currentItem.getSlope());
        }

        Button btnLux = (Button)findViewById(R.id.btn_measure_lux);
        btnLux.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                onGetLuxClick(v);
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
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveCurrentItem();
            }
        });
    }

    private void hideSoftKeyboard() {
        if (getCurrentFocus() != null){
            InputMethodManager inputMethodManager = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
    }

    private Item loadCurrentItem() {
        Item item = itemDao.getItem(currentEvaluationId, currentItemDescriptionId);
        if (item == null){
            item = new Item();
        }
        return item;
    }

    private void saveCurrentItem() {
        if (itemDao.createItem(currentItem, currentItemDescriptionId, currentEvaluationId)){
            resultIntent = new Intent();
            setResult(RESULT_OK, resultIntent);
            resultIntent.putExtra(DESCRIPTION_ID, currentItemDescriptionId);
            onBackPressed();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (resultIntent != null){
            resultIntent.putExtra("EvaluateItemActivity", true);
        }
        finish();
    }

    private void setVisibilityOfWidgets(boolean isLuxMeasurable,boolean isSlopeMeasurable) {
        lblLux = (TextView)findViewById(R.id.lbl_lux);
        txtLux = (TextView)findViewById(R.id.txt_lux);
        lblLux.setVisibility(isLuxMeasurable ? View.VISIBLE : View.GONE);
        txtLux.setVisibility(isLuxMeasurable ? View.VISIBLE : View.GONE);


        lblSlope = (TextView)findViewById(R.id.lbl_slope);
        txtSlope = (TextView)findViewById(R.id.txt_slope);
        lblSlope.setVisibility(isSlopeMeasurable ? View.VISIBLE : View.GONE);
        txtSlope.setVisibility(isSlopeMeasurable ? View.VISIBLE : View.GONE);

        btnLux = (Button)findViewById(R.id.btn_measure_lux);
        btnLux.setVisibility(isLuxMeasurable ? View.VISIBLE : View.GONE);

        btnSlope = (Button)findViewById(R.id.btn_measure_slope);
        btnSlope.setVisibility(isSlopeMeasurable ? View.VISIBLE : View.GONE);
    }

    private void handleSpinnerItemSelected(Object selectedItem) {
        currentItem.setPoint(Integer.parseInt(selectedItem.toString()));
    }


    public void onGetLuxClick(View view) {
        Intent getLuxReadingScreen = new Intent(this, LuxReadingActivity.class);

        //getLuxReadingScreen.putExtra("callingLux", "EvaluateItemActivity");
        startActivityForResult(getLuxReadingScreen, RESULT);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RESULT){
            if (resultCode == RESULT_OK){
                String luxSentBack = data.getStringExtra("LuxReading");
                txtLux.setText((luxSentBack));
                currentItem.setLux(luxSentBack);
            }
        }

    }
}
