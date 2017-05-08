package com.hayukleung.x.bequiet.common.wrapper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.hayukleung.x.bequiet.database.DaoMaster;
import com.hayukleung.x.bequiet.database.DaoSession;

/**
 * SQLite
 */
public class XDao {

  private static XDao sInstance;
  private DaoMaster.DevOpenHelper helper;
  private SQLiteDatabase database;
  private DaoMaster daoMaster;
  private DaoSession daoSession;

  private XDao(Context context) {
    helper = new DaoMaster.DevOpenHelper(context, "x-bequiet.db", null);
    database = helper.getWritableDatabase();
    daoMaster = new DaoMaster(database);
    daoSession = daoMaster.newSession();
  }

  public static XDao getInstance(Context context) {
    Context ctx = context.getApplicationContext();
    if (sInstance == null) {
      sInstance = new XDao(ctx);
    }
    return sInstance;
  }

  public DaoSession getDaoSession() {
    return daoSession;
  }

  public DaoMaster.DevOpenHelper getHelper() {
    return helper;
  }

  public SQLiteDatabase getDatabase() {
    return database;
  }

  public DaoMaster getDaoMaster() {
    return daoMaster;
  }

  public void close() {
    helper.close();
  }
}
