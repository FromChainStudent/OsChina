package com.example.oschina.module.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.oschina.module.bean.Lv_Content;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

/**
 * Created by YC on 2017/5/11.
 */

public class OrmHelper extends OrmLiteSqliteOpenHelper {
    private static String dbName;
    public OrmHelper(Context context, String databaseName, int databaseVersion) {
        super(context, databaseName, null, databaseVersion);
        this.dbName = databaseName;
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, Lv_Content.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            TableUtils.dropTable(connectionSource, Lv_Content.class, true);
            onCreate(database);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static OrmHelper instance;

    public static synchronized OrmHelper getInstance(Context context) {
        if (instance == null) {
            synchronized (OrmHelper.class) {
                if (instance == null) {
                    instance = new OrmHelper(context, dbName, 1);
                }
            }
        }
        return instance;
    }

    private Dao<Lv_Content, Integer> dao;
    public Dao<Lv_Content, Integer> getNewsDao() throws SQLException {
        if (dao == null) {
            dao = getDao(Lv_Content.class);
        }
        return dao;
    }

    @Override
    public void close() {
        super.close();
        dao = null;
    }
}
