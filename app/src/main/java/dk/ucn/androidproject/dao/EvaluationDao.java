package dk.ucn.androidproject.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import dk.ucn.androidproject.model.Evaluation;
import dk.ucn.androidproject.model.ItemDescription;

/**
 * Created by ki on 25-10-2015.
 */
public class EvaluationDao {
    private Context context;
    private DBAccess dbAccess;
    private SQLiteDatabase database;
    private String[] allColumns;

    public EvaluationDao(Context context) {
        this.context = context;
        this.dbAccess = DBAccess.getInstance(context);
        this.database = dbAccess.getWritableDatabase();

        this.allColumns = new String[] {EvaluationTableHelper.COLUMN_ID, EvaluationTableHelper.COLUMN_USER, EvaluationTableHelper.COLUMN_DATE};
    }

    public Evaluation getEvaluationById(long id){
        return null;
    }

    public long createEvaluation(Evaluation evaluation){
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        String date = dateFormat.format(evaluation.getDate());
        ContentValues values = new ContentValues();
        values.put(EvaluationTableHelper.COLUMN_USER, evaluation.getUser().get_id());
        values.put(EvaluationTableHelper.COLUMN_DATE, date);

        return database.insert(EvaluationTableHelper.TABLE_NAME, null, values);
    }
}
