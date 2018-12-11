package com.trvthanh.qlks;


import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper {


    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "QLKS";

    // Table Names
    private static final String TABLE_KHACH = "Khach";
    private static final String TABLE_DV = "DichVu";
    private static final String TABLE_NV = "NhanVien";
    private static final String TABLE_PHONG = "Phong";


    // Phong Table - column names
    private static final String KEY_MAPHONG = "MaPhong";
    private static final String KEY_LOAIPHONG = "LoaiPhong";
    private static final String KEY_MOTAPHONG = "MoTa";
    private static final String KEY_GIAPHONG = "Gia";

    // Phong table create statement
    private static final String CREATE_TABLE_PHONG = "CREATE TABLE "
            + TABLE_PHONG + "(" + KEY_MAPHONG + " INTEGER PRIMARY KEY," + KEY_LOAIPHONG
            + " TEXT," + KEY_MOTAPHONG + " TEXT," + KEY_GIAPHONG
            + " INTEGER" + ")";


    // Dich Vu Table - column names
    private static final String KEY_MADV = "MaDV";
    private static final String KEY_TENDV = "TenDV";
    private static final String KEY_MOTADV = "MoTaDV";
    private static final String KEY_DVT = "DVT";
    private static final String KEY_GIADV = "GiaDV";

    // DichVu table create statement
    private static final String CREATE_TABLE_DV = "CREATE TABLE "
            + TABLE_DV + "(" + KEY_MADV + " INTEGER PRIMARY KEY," + KEY_TENDV
            + " TEXT," + KEY_MOTADV + " TEXT," + KEY_DVT
            + " TEXT," + KEY_GIADV + " INTEGER"+ ")";


    // Khach Table - column names
    private static final String KEY_CMNDKH   = "CMNDKhachHang";
    private static final String KEY_TENKH = "TenKH";
    private static final String KEY_DCKH = "DiaChiKH";
    private static final String KEY_SDTKH = "SDTKH";
    private static final String KEY_GIOITINHKH = "GioiTinhKH";

    // Khach table create statement
    private static final String CREATE_TABLE_KHACH = "CREATE TABLE "
            + TABLE_KHACH + "(" + KEY_CMNDKH + " INTEGER PRIMARY KEY," + KEY_TENKH
            + " TEXT," + KEY_DCKH + " TEXT," + KEY_SDTKH
            + " TEXT," + KEY_GIOITINHKH + " BOOLEAN"+ ")";

    // Nhan Vien Table - column names
    private static final String KEY_MaNV   = "MaNV";
    private static final String KEY_TENNV = "TenNV";
    private static final String KEY_CMNDNV = "CMNDNhanVien";
    private static final String KEY_NGAYSINH = "NgaySinh";
    private static final String KEY_DCNV = "DiaChiNV";
    private static final String KEY_SDTNV = "SDTNV";
    private static final String KEY_GIOITINHNV = "GioiTinhNV";

    // Nhan Vien table create statement
    private static final String CREATE_TABLE_NV = "CREATE TABLE "
            + TABLE_NV + "(" + KEY_MaNV + " INTEGER PRIMARY KEY," + KEY_TENNV
            + " TEXT," + KEY_CMNDNV + " TEXT," + KEY_NGAYSINH
            + " DATE," + KEY_DCNV + " TEXT,"+ KEY_SDTNV + " TEXT,"+ KEY_GIOITINHNV + " BOOLEAN"+ ")";

    public Database(Context context) {
        super(context,DATABASE_NAME,null,1);
        SQLiteDatabase db=this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    // creating required tables
        db.execSQL(CREATE_TABLE_PHONG);
        db.execSQL(CREATE_TABLE_DV);
        db.execSQL(CREATE_TABLE_KHACH);
        db.execSQL(CREATE_TABLE_NV);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // on upgrade drop older tables
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PHONG);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_DV);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_KHACH);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NV);


        // create new tables
        onCreate(db);
    }
}
