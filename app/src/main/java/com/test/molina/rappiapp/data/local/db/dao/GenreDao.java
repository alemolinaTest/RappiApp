package com.test.molina.rappiapp.data.local.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.test.molina.rappiapp.data.model.db.Genre;

import java.util.List;

/**
 * Created by Amolina on 02/02/17.
 */
//ROOM Data Access Object - database interactions
@Dao
public interface GenreDao {

    @Query("SELECT * FROM genre")
    List<Genre> loadAll();

    @Query("SELECT name FROM genre WHERE id IN (:genreIds)")
    List<String> loadGenresByIds(Long[] genreIds);

    @Query("SELECT name FROM genre WHERE id = :genreId")
    List<Genre> loadAllById(Long genreId);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Genre genre);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Genre> genres);

}
