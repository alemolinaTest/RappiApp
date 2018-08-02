package com.test.molina.rappiapp.data.local.db;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class DataConverters {
    @TypeConverter
    public static ArrayList<Long> fromString(String value) {
        Type listType = new TypeToken<ArrayList<Long>>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public static String fromArrayLisr(ArrayList<Long> list) {
        Gson gson = new Gson();
        String json = gson.toJson(list);
        return json;
    }
}