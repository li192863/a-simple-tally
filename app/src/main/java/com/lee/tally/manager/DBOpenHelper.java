package com.lee.tally.manager;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.lee.tally.R;
import com.lee.tally.model.Account;

public class DBOpenHelper extends SQLiteOpenHelper {
    public DBOpenHelper(@Nullable Context context) {
        super(context, "tally.db", null, 1);
    }

    /**
     * 创建数据库 只有项目第一次运行时会被调用
     * @param sqLiteDatabase
     */
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql;
        // 创建表示类型的表
        sql = "CREATE TABLE tb_type(id integer PRIMARY KEY AUTOINCREMENT, name varchar(10), imageId integer, selectImageId integer, kind integer)";
        sqLiteDatabase.execSQL(sql);
        insertType(sqLiteDatabase);// 向tb_type表中插入元素
        // 创建表示账目的表
        sql = "CREATE TABLE tb_account(id integer PRIMARY KEY AUTOINCREMENT, typeName varchar(10), selectImageId integer, comment varchar(255), money float, date datetime, kind integer)";
        sqLiteDatabase.execSQL(sql);
    }

    /**
     * 数据库版本更新时发生改变会调用此方法
     * @param sqLiteDatabase
     * @param i
     * @param i1
     */
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    /**
     * // 向tb_type表中插入元素
     * @param sqLiteDatabase
     */
    private void insertType(SQLiteDatabase sqLiteDatabase) {
        String sql = "INSERT INTO tb_type (name, imageId, selectImageId, kind) VALUES (?, ?, ?, ?)";
        sqLiteDatabase.execSQL(sql, new Object[] {"其他", R.mipmap.ic_qita, R.mipmap.ic_qita_fs, 0});
        sqLiteDatabase.execSQL(sql, new Object[] {"餐饮", R.mipmap.ic_canyin, R.mipmap.ic_canyin_fs, 0});
        sqLiteDatabase.execSQL(sql, new Object[] {"交通", R.mipmap.ic_jiaotong, R.mipmap.ic_jiaotong_fs, 0});
        sqLiteDatabase.execSQL(sql, new Object[] {"购物", R.mipmap.ic_gouwu, R.mipmap.ic_gouwu_fs, 0});
        sqLiteDatabase.execSQL(sql, new Object[] {"服饰", R.mipmap.ic_fushi, R.mipmap.ic_fushi_fs, 0});
        sqLiteDatabase.execSQL(sql, new Object[] {"日用品", R.mipmap.ic_riyongpin, R.mipmap.ic_riyongpin_fs, 0});
        sqLiteDatabase.execSQL(sql, new Object[] {"娱乐", R.mipmap.ic_yule, R.mipmap.ic_yule_fs, 0});
        sqLiteDatabase.execSQL(sql, new Object[] {"零食", R.mipmap.ic_lingshi, R.mipmap.ic_lingshi_fs, 0});
        sqLiteDatabase.execSQL(sql, new Object[] {"烟酒茶", R.mipmap.ic_yanjiu, R.mipmap.ic_yanjiu_fs, 0});
        sqLiteDatabase.execSQL(sql, new Object[] {"学习", R.mipmap.ic_xuexi, R.mipmap.ic_xuexi_fs, 0});
        sqLiteDatabase.execSQL(sql, new Object[] {"医疗", R.mipmap.ic_yiliao, R.mipmap.ic_yiliao_fs, 0});
        sqLiteDatabase.execSQL(sql, new Object[] {"住房", R.mipmap.ic_zhufang, R.mipmap.ic_zhufang_fs, 0});
        sqLiteDatabase.execSQL(sql, new Object[] {"水电费", R.mipmap.ic_shuidianfei, R.mipmap.ic_shuidianfei_fs, 0});
        sqLiteDatabase.execSQL(sql, new Object[] {"通讯", R.mipmap.ic_tongxun, R.mipmap.ic_tongxun_fs, 0});
        sqLiteDatabase.execSQL(sql, new Object[] {"人情往来", R.mipmap.ic_renqingwanglai, R.mipmap.ic_renqingwanglai_fs, 0});

        sqLiteDatabase.execSQL(sql, new Object[] {"其他", R.mipmap.in_qita, R.mipmap.in_qita_fs, 1});
        sqLiteDatabase.execSQL(sql, new Object[] {"薪资", R.mipmap.in_xinzi, R.mipmap.in_xinzi_fs, 1});
        sqLiteDatabase.execSQL(sql, new Object[] {"奖金", R.mipmap.in_jiangjin, R.mipmap.in_jiangjin_fs, 1});
        sqLiteDatabase.execSQL(sql, new Object[] {"借入", R.mipmap.in_jieru, R.mipmap.in_jieru_fs, 1});
        sqLiteDatabase.execSQL(sql, new Object[] {"收债", R.mipmap.in_shouzhai, R.mipmap.in_shouzhai_fs, 1});
        sqLiteDatabase.execSQL(sql, new Object[] {"利息收入", R.mipmap.in_lixishouru, R.mipmap.in_lixishouru_fs, 1});
        sqLiteDatabase.execSQL(sql, new Object[] {"投资回报", R.mipmap.in_touzihuibao, R.mipmap.in_touzihuibao_fs, 1});
        sqLiteDatabase.execSQL(sql, new Object[] {"二手交易", R.mipmap.in_ershoushebei, R.mipmap.in_ershoushebei_fs, 1});
        sqLiteDatabase.execSQL(sql, new Object[] {"意外所得", R.mipmap.in_yiwaisuode, R.mipmap.in_yiwaisuode_fs, 1});
    }
}
