package com.leckan.popularmoviesone;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.leckan.popularmoviesone.Data.Movie;

import java.util.List;

/**
 * Created by Simpa on 4/16/2017.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder>{


    private static final String TAG = MovieAdapter.class.getSimpleName();
    final private ListItemClickListener mOnClickListener;
    private static int viewHolderCount;
    List<Movie> movieList;

    private int mNumberItems;

    public MovieAdapter( List<Movie> theMovieLists, ListItemClickListener listener)
    {

        mNumberItems = theMovieLists.size();
        mOnClickListener = listener;
        viewHolderCount = 0;
        this.movieList = theMovieLists;
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutIdForListItem = R.layout.movie_item;
        LayoutInflater inflater = LayoutInflater.from(context);


        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIdForListItem, parent, shouldAttachToParentImmediately);

        MovieViewHolder viewHolder = new MovieViewHolder(view);



        viewHolderCount++;
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public interface ListItemClickListener {
        void onListItemClick(int clickedItemIndex);
    }



    public class MovieViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {

        // Will display the position in the list, ie 0 through getItemCount() - 1
        ImageView listMovieImageView;
        // Will display which ViewHolder is displaying this data
        TextView viewMovieName;



        public MovieViewHolder(View itemView) {
            super(itemView);


            listMovieImageView = (ImageView) itemView.findViewById(R.id.movie_image);
            viewMovieName = (TextView) itemView.findViewById(R.id.movie_name);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

            int clickedPosition = getAdapterPosition();
            mOnClickListener.onListItemClick(clickedPosition);
        }
    }
}
