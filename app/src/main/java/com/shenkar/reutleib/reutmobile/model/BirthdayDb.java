package com.shenkar.reutleib.reutmobile.model;

/**
 * Created by USER on 08/05/2018.
 */

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import java.util.List;


@Database(entities = {BirthdayEntity.class}, version = 1)
public abstract class BirthdayDb extends RoomDatabase{


    private static final String TAG = BirthdayDb.class.getSimpleName();
    private static BirthdayDb INSTANCE;

    public static BirthdayDb getInstance(Context context) {
        synchronized (BirthdayDb.class) {
            if (INSTANCE == null) {
                // notice getApplicationContext
                // -- it prevents the memory leak that would happen if the activity was passed
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                        BirthdayDb.class, "clog.db")
//                        .addMigrations(MIGRATION_1_2) // placeholder for future db versions
                        .build();
            }
            return INSTANCE;
        }
    }

    public abstract BirthdayDao getBirthdayDao();

    //this func reads the records from our db
    public LiveData<List<BirthdayEntity>> readCaptainsLog() {
        LiveData<List<BirthdayEntity>> captainsLogEntities = getBirthdayDao().loadBirthday();
        return captainsLogEntities;
    }

    //this func inserts new record to our db
    public void writeToCaptainsLog(final BirthdayEntity logEntity) {
        // there are better ways than creating a new thread and a new Runnable every time.
        // we will cover these ways later (-au)
        new Thread(new Runnable() {
            @Override
            public void run() {
                getBirthdayDao().insertToLog(logEntity);
            }
        }).start();
    }

}
