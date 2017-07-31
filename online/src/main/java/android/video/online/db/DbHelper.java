package android.video.online.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Jay on 2017/7/30.
 */

public class DbHelper extends SQLiteOpenHelper {

    //数据库名字
    private static final String DB_NAME = "online.db";

    //本版号
    private static final int VERSION = 1;

    //创建表
    private static final String CREATE_TABLE_UserModel = "CREATE TABLE online(_id integer primary key autoincrement," +
            "username text, password text, nickname text, avatar text, open_id text, bind text, email text, ip text, create_time text, lastlogin_time text" +
            ", lastlogin_ip text, login_count text, gid text, type text, old_passwd text, old_photo text, sex text, birthday text, qq text" +
            ", content text, tel text, mobile text, pic text, status text, pwd text, user_id text)";

    //删除表
    private static final String DROP_TABLE_UserModel = "drop table if exists online";


    public DbHelper(Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //SQLiteDatabase 用于操作数据库的工具类
        db.execSQL(CREATE_TABLE_UserModel);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_TABLE_UserModel);
        db.execSQL(CREATE_TABLE_UserModel);
    }

}
