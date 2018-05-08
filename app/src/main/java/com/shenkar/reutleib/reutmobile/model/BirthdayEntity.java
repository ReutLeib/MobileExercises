package com.shenkar.reutleib.reutmobile.model;

/**
 * Created by USER on 08/05/2018.
 */
//
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.*;
import java.sql.*;

@Entity
public class BirthdayEntity {
    @PrimaryKey(autoGenerate = true)

    @ColumnInfo (name = "id")
    public int id;

    @ColumnInfo (name = "date")
    public String date;

    @ColumnInfo (name = "name")
    public String name;

    public BirthdayEntity(String _date, String _name){
        this.date= _date;
        this.name = _name;
    }

    public BirthdayEntity(){
        this.date = null;
        this.name = null;
    }

}
