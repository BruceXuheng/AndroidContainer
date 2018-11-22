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
        userEntityDao = daoSession.getUserDao();
        QueryBuilder.LOG_VALUES=true;
        QueryBuilder.LOG_SQL=true;
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
    public void deleteContacts(User testBean) {
        userEntityDao.delete(testBean);
    }

    //修改
    public void updateContacts(User testBean) {
        userEntityDao.update(testBean);
    }

    /**
     * 条件搜索
     * @param user
     */
    public void updateUser(User user){
        daoSession.getDatabase().execSQL("update user set age=? where age=?and email=?",new Object[]{user.getAge(),"1","email"});
    }

    //查询所有
    public List<User> selectAllContacts() {
        userEntityDao.detachAll();//清除缓存
        List<User> list1 = userEntityDao.loadAll();
        return list1 == null ? new ArrayList<User>() : list1;
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

    //删除表中内容
    public void deletewhereAge(User user) {
        daoSession.getDatabase().execSQL("delete from user where age=?",new Object[]{"10"});
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
