package dk.ucn.androidproject.activities;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ExpandableListView;

import java.util.HashMap;
import java.util.List;

import dk.ucn.androidproject.R;
import dk.ucn.androidproject.dao.ItemCategoryDao;
import dk.ucn.androidproject.dao.ItemDescriptionDao;
import dk.ucn.androidproject.model.ItemCategory;
import dk.ucn.androidproject.model.ItemDescription;

public class EvaluationActivity extends AppCompatActivity {

    private ItemCategoryDao itemCategoryDao;
    private ItemDescriptionDao itemDescriptionDao;
    private ExpandableListView expandableListView;
    private ExpandableItemListAdapter listAdapter;
    private List<ItemCategory> listDataHeader;
    private HashMap<String, List<ItemDescription>> listDataChild;

    private class DownloadDataTask extends AsyncTask<Context, Integer, HashMap<String,List<ItemDescription>>> {
        @Override
        protected HashMap<String, List<ItemDescription>> doInBackground(Context... params) {
            listDataHeader = itemCategoryDao.getAllCategories();
            return listsToChildData(listDataHeader);
        }

        private HashMap<String, List<ItemDescription>> listsToChildData(List<ItemCategory> categories) {
            listDataChild = new HashMap<>();

            for (ItemCategory category : categories){
                List<ItemDescription> descriptions = itemDescriptionDao.getAllByCategory(category.getTitle());
                listDataChild.put(category.getTitle(), descriptions);
            }
            return listDataChild;
        }

        @Override
        protected void onPostExecute(HashMap<String, List<ItemDescription>> stringListHashMap) {
            expandableListView = (ExpandableListView)findViewById(R.id.expandableListView);
            listAdapter = new ExpandableItemListAdapter(getApplicationContext(), listDataChild, listDataHeader);
            expandableListView.setAdapter(listAdapter);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evaluation);
        Log.i("__Evaluation", "evaluation_activity");

        itemCategoryDao = new ItemCategoryDao(getApplicationContext());
        itemDescriptionDao = new ItemDescriptionDao(getApplicationContext());

        loadData(getApplicationContext());
    }

    private void loadData(Context applicationContext) {
        new DownloadDataTask().execute(applicationContext);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_evaluation, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}