package com.test.molina.rappiapp.data.model.db;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Amolina on 02/02/17.
 */
@Entity(tableName = "genre")
public class Genre {

    @PrimaryKey
    public Long id;

    public String name;

}
