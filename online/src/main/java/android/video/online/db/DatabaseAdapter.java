package android.video.online.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.video.online.model.UserModel;

import java.util.ArrayList;

/**
 * Created by Jay on 2017/7/30.
 */

public class DatabaseAdapter {
    private DbHelper dbHelper;

    public DatabaseAdapter(Context context) {
        dbHelper = new DbHelper(context);
    }

    /**
     * 添加数据
     *
     * @param userModel
     */
    public void create(UserModel userModel) {
        String sql = "insert into online(username, password, nickname, avatar, open_id, bind, email, ip, create_time, lastlogin_time, lastlogin_ip, login_count, gid" +
                ", type, old_passwd, old_photo, sex,birthday, qq, content, tel, mobile, pic, status, pwd, user_id)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        Object[] args = {userModel.getUsername(), userModel.getPassword(), userModel.getNickname(), userModel.getAvatar(), userModel.getOpen_id(), userModel.getBind(), userModel.getEmail(), userModel.getIp(),
                userModel.getCreate_time(), userModel.getLastlogin_time(), userModel.getLastlogin_ip(), userModel.getLogin_count(), userModel.getGid(), userModel.getType(), userModel.getOld_passwd(), userModel.getOld_photo(),
                userModel.getSex(), userModel.getBirthday(), userModel.getQq(), userModel.getContent(), userModel.getTel(), userModel.getMobile(), userModel.getPic(), userModel.getStatus(), userModel.getPwd(), userModel.getUser_id()};
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        db.execSQL(sql, args);
        db.close();
    }

    /**
     * 删除数据
     *
     * @param id
     */
    public void remove(String id) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String sql = "delete from online where user_id = ?";
        Object[] args = {id};
        db.execSQL(sql, args);
        db.close();
    }

    /**
     * 修改数据
     *
     * @param userModel
     */
    public void update(UserModel userModel) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        Object[] args = {userModel.getUsername(), userModel.getPassword(), userModel.getNickname(), userModel.getAvatar(), userModel.getOpen_id(), userModel.getBind(), userModel.getEmail(), userModel.getIp(),
                userModel.getCreate_time(), userModel.getLastlogin_time(), userModel.getLastlogin_ip(), userModel.getLogin_count(), userModel.getGid(), userModel.getType(), userModel.getOld_passwd(), userModel.getOld_photo(),
                userModel.getSex(), userModel.getBirthday(), userModel.getQq(), userModel.getContent(), userModel.getTel(), userModel.getMobile(), userModel.getPic(), userModel.getStatus(), userModel.getPwd(), userModel.getUser_id()};

        String sql = "update online set username = ?, password = ?, nickname = ? , avatar = ?, open_id = ? , bind = ?, email = ? , ip = ?, create_time = ? , lastlogin_time = ?, lastlogin_ip = ? " +
                ", login_count = ?, gid = ? , type = ?, old_passwd = ? , old_photo = ?, sex = ? , birthday = ? , qq = ?, content = ? , tel = ?, create_time = ? , mobile = ?, pic = ? , status = ? , user_id = ? where _id = ?";
        db.execSQL(sql, args);
        db.close();
    }

    /**
     * 按id查询
     *
     * @param id
     * @return
     */
    public UserModel findById(String id) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String sql = "select * from online where user_id = ?";
        Cursor cursor = db.rawQuery(sql, new String[]{String.valueOf(id)});

        UserModel userModel = null;
        if (cursor.moveToNext()) {
            userModel = new UserModel();

            userModel.setUsername(cursor.getString(cursor.getColumnIndexOrThrow("username")));
            userModel.setPassword(cursor.getString(cursor.getColumnIndexOrThrow("password")));
            userModel.setNickname(cursor.getString(cursor.getColumnIndexOrThrow("nickname")));
            userModel.setAvatar(cursor.getString(cursor.getColumnIndexOrThrow("avatar")));
            userModel.setOpen_id(cursor.getString(cursor.getColumnIndexOrThrow("open_id")));
            userModel.setBind(cursor.getString(cursor.getColumnIndexOrThrow("bind")));
            userModel.setEmail(cursor.getString(cursor.getColumnIndexOrThrow("email")));
            userModel.setIp(cursor.getString(cursor.getColumnIndexOrThrow("ip")));
            userModel.setCreate_time(cursor.getString(cursor.getColumnIndexOrThrow("create_time")));
            userModel.setLogin_count(cursor.getString(cursor.getColumnIndexOrThrow("lastlogin_time")));
            userModel.setLastlogin_ip(cursor.getString(cursor.getColumnIndexOrThrow("lastlogin_ip")));
            userModel.setLogin_count(cursor.getString(cursor.getColumnIndexOrThrow("login_count")));
            userModel.setBirthday(cursor.getString(cursor.getColumnIndexOrThrow("birthday")));
            userModel.setGid(cursor.getString(cursor.getColumnIndexOrThrow("gid")));
            userModel.setType(cursor.getString(cursor.getColumnIndexOrThrow("type")));
            userModel.setOld_passwd(cursor.getString(cursor.getColumnIndexOrThrow("old_passwd")));
            userModel.setOld_photo(cursor.getString(cursor.getColumnIndexOrThrow("old_photo")));
            userModel.setSex(cursor.getString(cursor.getColumnIndexOrThrow("sex")));
            userModel.setQq(cursor.getString(cursor.getColumnIndexOrThrow("qq")));
            userModel.setContent(cursor.getString(cursor.getColumnIndexOrThrow("content")));
            userModel.setTel(cursor.getString(cursor.getColumnIndexOrThrow("tel")));
            userModel.setMobile(cursor.getString(cursor.getColumnIndexOrThrow("mobile")));
            userModel.setPic(cursor.getString(cursor.getColumnIndexOrThrow("pic")));
            userModel.setStatus(cursor.getString(cursor.getColumnIndexOrThrow("status")));
            userModel.setUser_id(cursor.getString(cursor.getColumnIndexOrThrow("user_id")));

        }
        cursor.close();
        db.close();

        return userModel;
    }

    /**
     * 查询所有
     *
     * @return
     */
    public ArrayList<UserModel> findAll() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String sql = "select * from online";
        Cursor cursor = db.rawQuery(sql, null);


        ArrayList<UserModel> userModels = new ArrayList<>();
        while (cursor.moveToNext()) {
            UserModel userModel = new UserModel();

            userModel.setUsername(cursor.getString(cursor.getColumnIndexOrThrow("username")));
            userModel.setPassword(cursor.getString(cursor.getColumnIndexOrThrow("password")));
            userModel.setNickname(cursor.getString(cursor.getColumnIndexOrThrow("nickname")));
            userModel.setAvatar(cursor.getString(cursor.getColumnIndexOrThrow("avatar")));
            userModel.setOpen_id(cursor.getString(cursor.getColumnIndexOrThrow("open_id")));
            userModel.setBind(cursor.getString(cursor.getColumnIndexOrThrow("bind")));
            userModel.setEmail(cursor.getString(cursor.getColumnIndexOrThrow("email")));
            userModel.setIp(cursor.getString(cursor.getColumnIndexOrThrow("ip")));
            userModel.setCreate_time(cursor.getString(cursor.getColumnIndexOrThrow("create_time")));
            userModel.setLogin_count(cursor.getString(cursor.getColumnIndexOrThrow("lastlogin_time")));
            userModel.setLastlogin_ip(cursor.getString(cursor.getColumnIndexOrThrow("lastlogin_ip")));
            userModel.setLogin_count(cursor.getString(cursor.getColumnIndexOrThrow("login_count")));
            userModel.setBirthday(cursor.getString(cursor.getColumnIndexOrThrow("birthday")));
            userModel.setGid(cursor.getString(cursor.getColumnIndexOrThrow("gid")));
            userModel.setType(cursor.getString(cursor.getColumnIndexOrThrow("type")));
            userModel.setOld_passwd(cursor.getString(cursor.getColumnIndexOrThrow("old_passwd")));
            userModel.setOld_photo(cursor.getString(cursor.getColumnIndexOrThrow("old_photo")));
            userModel.setSex(cursor.getString(cursor.getColumnIndexOrThrow("sex")));
            userModel.setQq(cursor.getString(cursor.getColumnIndexOrThrow("qq")));
            userModel.setContent(cursor.getString(cursor.getColumnIndexOrThrow("content")));
            userModel.setTel(cursor.getString(cursor.getColumnIndexOrThrow("tel")));
            userModel.setMobile(cursor.getString(cursor.getColumnIndexOrThrow("mobile")));
            userModel.setPic(cursor.getString(cursor.getColumnIndexOrThrow("pic")));
            userModel.setStatus(cursor.getString(cursor.getColumnIndexOrThrow("status")));
            userModel.setUser_id(cursor.getString(cursor.getColumnIndexOrThrow("user_id")));
            userModels.add(userModel);
        }
        cursor.close();
        db.close();
        return userModels;
    }

    /**
     * 分页查询
     *
     * @param limit 默认查询的数量
     * @param skip  跳过的行数
     * @return
     */
    public ArrayList<UserModel> findLimit(int limit, int skip) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String sql = "select * from online order by _id desc limit ? offset ?";
        String[] strs = new String[]{String.valueOf(limit), String.valueOf(skip)};
        Cursor cursor = db.rawQuery(sql, strs);


        ArrayList<UserModel> UserModels = new ArrayList<>();
        UserModel userModel = null;
        while (cursor.moveToNext()) {
            userModel = new UserModel();

            userModel.setUsername(cursor.getString(cursor.getColumnIndexOrThrow("username")));
            userModel.setPassword(cursor.getString(cursor.getColumnIndexOrThrow("password")));
            userModel.setNickname(cursor.getString(cursor.getColumnIndexOrThrow("nickname")));
            userModel.setAvatar(cursor.getString(cursor.getColumnIndexOrThrow("avatar")));
            userModel.setOpen_id(cursor.getString(cursor.getColumnIndexOrThrow("open_id")));
            userModel.setBind(cursor.getString(cursor.getColumnIndexOrThrow("bind")));
            userModel.setEmail(cursor.getString(cursor.getColumnIndexOrThrow("email")));
            userModel.setIp(cursor.getString(cursor.getColumnIndexOrThrow("ip")));
            userModel.setCreate_time(cursor.getString(cursor.getColumnIndexOrThrow("create_time")));
            userModel.setLogin_count(cursor.getString(cursor.getColumnIndexOrThrow("lastlogin_time")));
            userModel.setLastlogin_ip(cursor.getString(cursor.getColumnIndexOrThrow("lastlogin_ip")));
            userModel.setLogin_count(cursor.getString(cursor.getColumnIndexOrThrow("login_count")));
            userModel.setBirthday(cursor.getString(cursor.getColumnIndexOrThrow("birthday")));
            userModel.setGid(cursor.getString(cursor.getColumnIndexOrThrow("gid")));
            userModel.setType(cursor.getString(cursor.getColumnIndexOrThrow("type")));
            userModel.setOld_passwd(cursor.getString(cursor.getColumnIndexOrThrow("old_passwd")));
            userModel.setOld_photo(cursor.getString(cursor.getColumnIndexOrThrow("old_photo")));
            userModel.setSex(cursor.getString(cursor.getColumnIndexOrThrow("sex")));
            userModel.setQq(cursor.getString(cursor.getColumnIndexOrThrow("qq")));
            userModel.setContent(cursor.getString(cursor.getColumnIndexOrThrow("content")));
            userModel.setTel(cursor.getString(cursor.getColumnIndexOrThrow("tel")));
            userModel.setMobile(cursor.getString(cursor.getColumnIndexOrThrow("mobile")));
            userModel.setPic(cursor.getString(cursor.getColumnIndexOrThrow("pic")));
            userModel.setStatus(cursor.getString(cursor.getColumnIndexOrThrow("status")));
            userModel.setUser_id(cursor.getString(cursor.getColumnIndexOrThrow("user_id")));
            UserModels.add(userModel);
        }
        cursor.close();
        db.close();
        return UserModels;
    }
}
