package com.yunmeng.florallife.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.yunmeng.florallife.bean.TABLE;


/**
 * Created by Administrator on 2016/3/26 0026.
 */
public class SqliteHelper extends SQLiteOpenHelper {
    private  static final String DB_NAME ="userinfo.db";
    public static final int VERSION = 1;

    public SqliteHelper(Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
      String sql = "CREATE TABLE "+ TABLE.DAIRY.TABLE_NAME+" ("+TABLE.DAIRY.NUM+" INTEGER  PRIMARY KEY AUTOINCREMENT,"+TABLE.DAIRY.PSW+" TEXT)";
     db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        super.onDowngrade(db, oldVersion, newVersion);
    }
}
