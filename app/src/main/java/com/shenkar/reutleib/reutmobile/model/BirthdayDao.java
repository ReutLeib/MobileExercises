package com.shenkar.reutleib.reutmobile.model;

/**
 * Created by USER on 08/05/2018.
 */

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;


// insert and get obj
@Dao
public interface BirthdayDao {

    @Query("select * from BirthdayEntity")
    LiveData<List<BirthdayEntity>> loadBirthday();

    @Insert
    void insertToLog(BirthdayEntity logRow);

}
