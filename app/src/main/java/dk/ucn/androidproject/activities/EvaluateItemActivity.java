package dk.ucn.androidproject.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
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

        currentItem = new Item();

        loadPage();
    }

    private void loadPage() {
        TextView header = (TextView)findViewById(R.id.txt_header);
        header.setText(currentDescriptionTitle);

        Spinner pointSpinner = (Spinner)findViewById(R.id.point_spinner);
        ArrayAdapter spinnerAdapter = ArrayAdapter.createFromResource(getApplicationContext(), R.array.points, R.layout.spinner_item);
        pointSpinner.setAdapter(spinnerAdapter);

        TextView noteInput = (TextView)findViewById(R.id.txt_note);

    }
}
