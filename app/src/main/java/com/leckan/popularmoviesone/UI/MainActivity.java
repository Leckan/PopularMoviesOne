package com.leckan.popularmoviesone.UI;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.leckan.popularmoviesone.Adapter.MovieAdapter;
import com.leckan.popularmoviesone.Model.DummyMovies;
import com.leckan.popularmoviesone.Model.Movie;
import com.leckan.popularmoviesone.R;
import com.leckan.popularmoviesone.Utilities.NetworkUtils;
import com.leckan.popularmoviesone.Utilities.Utility;

import java.net.URL;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MovieAdapter.ListItemClickListener {

    ConnectivityManager mConMgr;
    RecyclerView moviesList;
    MovieAdapter adapter;
    private String sPreferredType;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        moviesList = (RecyclerView) findViewById(R.id.recycler_view);

        int mNoOfColumns = Utility.calculateNoOfColumns(getApplicationContext());
        mConMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        List<Movie> Movies = DummyMovies.getMovieList();
        GridLayoutManager layoutManager = new GridLayoutManager(this, mNoOfColumns);

        moviesList.setLayoutManager(layoutManager);
        adapter = new MovieAdapter(Movies, this);

        moviesList.setAdapter(adapter);
    }


    @Override
    protected void onStart() {
        super.onStart();

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);

        sPreferredType = preferences.getString("chosenSortType", "Popularity");
        NetworkInfo networkInfo = mConMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            LoadMoviesPage(sPreferredType);
        } else {
            LoadDefaultPage();
        }
    }

    private void LoadDefaultPage() {
    }

    public void LoadMoviesPage(String prefType) {
        new DownloadMoviesTask().execute();
    }

    private class DownloadMoviesTask extends AsyncTask<Object, Object, Void> {


        @Override
        protected Void doInBackground(Object... voids) {

            URL movieURL = NetworkUtils.buildUrl(sPreferredType);
            String jsonStr = NetworkUtils.makeServiceCall(movieURL.toString());

            return null;
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemThatWasClickedId = item.getItemId();
        if (itemThatWasClickedId == R.id.action_settings) {
            Intent settingsIntent = new Intent(getBaseContext(), SettingsActivity.class);
            startActivity(settingsIntent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onListItemClick(int clickedItemIndex) {

    }
}
