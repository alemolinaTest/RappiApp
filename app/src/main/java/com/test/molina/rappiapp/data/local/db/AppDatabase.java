package com.test.molina.rappiapp.data.local.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.test.molina.rappiapp.data.local.db.dao.GenreDao;
import com.test.molina.rappiapp.data.local.db.dao.MovieDao;
import com.test.molina.rappiapp.data.model.db.Genre;
import com.test.molina.rappiapp.data.model.db.PopularMovie;
import com.test.molina.rappiapp.data.model.db.TopRatedMovie;
import com.test.molina.rappiapp.data.model.db.UpcomingMovie;

/**
 * Created by Amolina on 02/02/17.
 */
//the classes to be tables
@Database(entities = {Genre.class, PopularMovie.class, TopRatedMovie.class,UpcomingMovie.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract GenreDao genreDao();

    public abstract MovieDao movieDao();


}
