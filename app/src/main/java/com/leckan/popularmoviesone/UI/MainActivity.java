package com.leckan.popularmoviesone.UI;

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
import com.leckan.popularmoviesone.Utilities.Utility;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MovieAdapter.ListItemClickListener{

    RecyclerView moviesList;
    MovieAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        moviesList = (RecyclerView) findViewById(R.id.recycler_view);

        int mNoOfColumns = Utility.calculateNoOfColumns(getApplicationContext());

        List<Movie> Movies = DummyMovies.getMovieList();
        GridLayoutManager layoutManager =  new GridLayoutManager(this,mNoOfColumns);

        moviesList.setLayoutManager(layoutManager);
        adapter = new MovieAdapter(Movies, this);

        moviesList.setAdapter(adapter);
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
            //makeGithubSearchQuery();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onListItemClick(int clickedItemIndex) {

    }
}
