package com.test.molina.rappiapp.data.local.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.test.molina.rappiapp.data.model.db.PopularMovie;
import com.test.molina.rappiapp.data.model.db.TopRatedMovie;
import com.test.molina.rappiapp.data.model.db.UpcomingMovie;

import java.util.List;

/**
 * Created by Amolina on 02/02/17.
 */
//ROOM Data Access Object - database interactions
@Dao
public interface MovieDao {

    @Query("SELECT * FROM popular_movie")
    List<PopularMovie> loadAllPopular();

    @Query("SELECT * FROM top_rated_movie")
    List<TopRatedMovie> loadAllTopRated();

    @Query("SELECT * FROM upcoming_movie")
    List<UpcomingMovie> loadAllUpcoming();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAllPopular(List<PopularMovie> popular_movie);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAllTopRated(List<TopRatedMovie> movie);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAllUpcoming(List<UpcomingMovie> movie);

}
