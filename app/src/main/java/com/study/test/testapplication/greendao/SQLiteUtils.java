package com.study.test.testapplication.greendao;

import com.study.test.testapplication.app.MyApplication;
import com.study.test.testapplication.db.DaoMaster;
import com.study.test.testapplication.db.DaoSession;
import com.study.test.testapplication.db.UserDao;
import com.study.test.testapplication.greendao.bean.User;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.ArrayList;
import java.util.List;


public class SQLiteUtils {
    private static SQLiteUtils instance;
    private UserDao userEntityDao;
    private DaoSession daoSession;
    private DaoMaster.DevOpenHelper helper;

    private SQLiteUtils() {
        daoSession = MyApplication.getInstances().getDaoSession();
        userEntityDao = daoSession.getUserDao();//获取User操作类
        QueryBuilder.LOG_VALUES=true;//GreenDao Log开关
        QueryBuilder.LOG_SQL=true;//GreenDao Log开关
    }

    public static SQLiteUtils getInstance() {
        if (instance == null) {
            synchronized (SQLiteUtils.class) {
                if (instance == null) {
                    instance = new SQLiteUtils();
                }
            }
        }
        return instance;
    }

    //增加
    public void addUser(User testBean) {
        userEntityDao.insert(testBean);
    }

    //删除
    public void deleteUser(User testBean) {
        userEntityDao.delete(testBean);
    }

    //修改
    public void updateUsers(User testBean) {
        userEntityDao.update(testBean);
    }

    /**
     * 根据年龄，修改数据
     * @param age
     * @param user
     */
    public void updateWhereAgeUser(String age,User user){
        daoSession.getDatabase().execSQL("update user set age=? where age=?and email=?",new Object[]{age,user.getAge(),user.getEmail()});
    }

    //查询所有
    public List<User> selectAllContacts() {
        userEntityDao.detachAll();//清除缓存
        List<User> list1 = userEntityDao.loadAll();
        return list1 == null ? new ArrayList<User>() : list1;
    }

    //
    public List<User> selectOrderAge() {
        QueryBuilder<User> queryBuilder = userEntityDao.queryBuilder().orderAsc(UserDao.Properties.Sex);
        return queryBuilder.list();
    }

    //条件查询
    public List<User> selectWhereAge(String age) {
        QueryBuilder<User> queryBuilder = userEntityDao.queryBuilder().where(UserDao.Properties.Age.eq(age));
        return queryBuilder.list();
    }

    //删除表中内容
    public void deleteAllContact() {

        userEntityDao.deleteAll();
    }

    /**
     * 条件删除表中数据
     * @param age [条件]
     */
    public void deletewhereAge(String age) {
        daoSession.getDatabase().execSQL("delete from user where age = ?",new Object[]{age});
    }

    /**
     * 关闭所有的操作
     * 注：数据库开启之后，使用完毕必须要关闭
     */
    public void closeConnection() {
        closeHelper();
        closeDaoSession();
    }

    private void closeHelper() {
        if (helper != null) {
            helper.close();
            helper = null;
        }
    }

    private void closeDaoSession() {
        if (daoSession != null) {
            daoSession.clear();
            daoSession = null;
        }
    }
}
