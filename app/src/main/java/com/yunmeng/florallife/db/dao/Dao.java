package com.yunmeng.florallife.db.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.yunmeng.florallife.bean.Databean;
import com.yunmeng.florallife.bean.TABLE;
import com.yunmeng.florallife.db.SqliteHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/3/26 0026.
 */
public class Dao {

    private SQLiteOpenHelper dbHelper;
    private SQLiteDatabase db;

    public Dao(Context context) {
        dbHelper = new SqliteHelper(context);
    }

    public void add(Databean data){
        db = dbHelper.getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put(TABLE.DAIRY.NUM,data.getNum());
        values.put(TABLE.DAIRY.PSW,data.getPsw());
        db.insert(TABLE.DAIRY.TABLE_NAME, null, values);
        db.close();
    }

    public void update(Databean data) {
        //得到数据库的操作对象
        db = dbHelper.getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put(TABLE.DAIRY.NUM,data.getNum());
        values.put(TABLE.DAIRY.PSW,data.getPsw());
        String whereClause = TABLE.DAIRY.NUM + " =?";
        String[] whereArgs = {data.getNum() + " "};
        db.update(TABLE.DAIRY.TABLE_NAME, values, whereClause, whereArgs);
        db.close();
    }

    public List<Databean> quary(){
        List<Databean> datas = new ArrayList<>();
        db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query(TABLE.DAIRY.TABLE_NAME,null,null,null,null,null,null);
        while(cursor.moveToNext()){
            Databean d = new Databean(cursor.getString(cursor.getColumnIndex(TABLE.DAIRY.NUM)), cursor.getString(cursor.getColumnIndex(TABLE.DAIRY.PSW)));
            datas.add(d);
        }
        db.close();
        return datas;
        }
    }


