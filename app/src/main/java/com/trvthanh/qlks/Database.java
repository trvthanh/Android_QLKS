package com.trvthanh.qlks;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.webkit.WebHistoryItem;

import java.text.DateFormat;
import java.util.Calendar;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Database extends SQLiteOpenHelper {

    private static final String LOG = Database.class.getName();
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
    private static final String KEY_TRANGTHAI = "TrangThai";

    // Phong table create statement
    private static final String CREATE_TABLE_PHONG = "CREATE TABLE "
            + TABLE_PHONG + " (" + KEY_MAPHONG + " INTEGER PRIMARY KEY," + KEY_LOAIPHONG
            + " TEXT," + KEY_MOTAPHONG + " TEXT," + KEY_GIAPHONG
            + " INTEGER," + KEY_TRANGTHAI + " TEXT" + " )";


    // Dich Vu Table - column names
    private static final String KEY_MADV = "MaDV";
    private static final String KEY_TENDV = "TenDV";
    private static final String KEY_MOTADV = "MoTaDV";
    private static final String KEY_DVT = "DVT";
    private static final String KEY_GIADV = "GiaDV";

    // DichVu table create statement
    private static final String CREATE_TABLE_DV = "CREATE TABLE "
            + TABLE_DV + " (" + KEY_MADV + " INTEGER PRIMARY KEY," + KEY_TENDV
            + " TEXT," + KEY_MOTADV + " TEXT," + KEY_DVT
            + " TEXT," + KEY_GIADV + " INTEGER"+ " )";


    // Khach Table - column names
    private static final String KEY_CMNDKH   = "CMNDKhachHang";
    private static final String KEY_TENKH = "TenKH";
    private static final String KEY_DCKH = "DiaChiKH";
    private static final String KEY_SDTKH = "SDTKH";
    private static final String KEY_GIOITINHKH = "GioiTinhKH";

    // Khach table create statement
    private static final String CREATE_TABLE_KHACH = "CREATE TABLE "
            + TABLE_KHACH + " (" + KEY_CMNDKH + " TEXT PRIMARY KEY," + KEY_TENKH
            + " TEXT," + KEY_DCKH + " TEXT," + KEY_SDTKH
            + " TEXT," + KEY_GIOITINHKH + " TEXT"+ " )";

    // Nhan Vien Table - column names
    public static final String KEY_MaNV   = "MaNV";
    public static final String KEY_TENNV = "TenNV";
    public static final String KEY_CMNDNV = "CMNDNhanVien";
    public static final String KEY_NGAYSINH = "NgaySinh";
    public static final String KEY_DCNV = "DiaChiNV";
    public static final String KEY_SDTNV = "SDTNV";
    public static final String KEY_GIOITINHNV = "GioiTinhNV";

    // Nhan Vien table create statement
    private static final String CREATE_TABLE_NV = "CREATE TABLE "
            + TABLE_NV + " (" + KEY_MaNV + " INTEGER PRIMARY KEY," + KEY_TENNV
            + " TEXT," + KEY_CMNDNV + " TEXT," + KEY_NGAYSINH
            + " TEXT," + KEY_DCNV + " TEXT,"+ KEY_SDTNV + " TEXT,"+ KEY_GIOITINHNV + " TEXT"+ " )";

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
//Convert ngay

    // ------------------------ Phương Thức của bảng Phòng ----------------//

    //Tao 1 phòng
    public void createPhong(Phong phong) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_MAPHONG, phong.getMaPhong());
        values.put(KEY_LOAIPHONG, phong.getLoaiPhong());
        values.put(KEY_MOTAPHONG, phong.getMaPhong());
        values.put(KEY_GIAPHONG, phong.getGia());
        values.put(KEY_TRANGTHAI,phong.getTrangThai());

        // insert row
        db.insert(TABLE_PHONG, null, values);

    }
    //Lay toan bo Phong
    public List<Phong> getAllPhong() {
        List<Phong> phongs = new ArrayList<Phong>();
        String selectQuery = "SELECT  * FROM " + TABLE_PHONG;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                Phong p;
                p = new Phong();
                p.setMaPhong(c.getInt((c.getColumnIndex(KEY_MAPHONG))));
                p.setLoaiPhong(c.getString(c.getColumnIndex(KEY_LOAIPHONG)));
                p.setMoTa(c.getString(c.getColumnIndex(KEY_MOTAPHONG)));
                p.setGia(c.getInt(c.getColumnIndex(KEY_GIAPHONG)));
                p.setTrangThai(c.getString(c.getColumnIndex(KEY_TRANGTHAI)));

                // adding to tags list
                phongs.add(p);
            } while (c.moveToNext());
        }
        return phongs;
    }
    //get all by loai
    public List<Phong> getAllbyLoai(String loai) {
        List<Phong> phongs = new ArrayList<Phong>();
        if (loai.equals("All")) {
            phongs.addAll(getAllPhong());
        }
        else{
            String selectQuery = "SELECT  * FROM " + TABLE_PHONG+" WHERE "+KEY_LOAIPHONG+" ='"+loai+"'";
            SQLiteDatabase db = this.getReadableDatabase();
            Cursor c = db.rawQuery(selectQuery, null);

            // looping through all rows and adding to list
            if (c.moveToFirst()) {
                do {
                    Phong p;
                    p = new Phong();
                    p.setMaPhong(c.getInt((c.getColumnIndex(KEY_MAPHONG))));
                    p.setLoaiPhong(c.getString(c.getColumnIndex(KEY_LOAIPHONG)));
                    p.setMoTa(c.getString(c.getColumnIndex(KEY_MOTAPHONG)));
                    p.setGia(c.getInt(c.getColumnIndex(KEY_GIAPHONG)));
                    p.setTrangThai(c.getString(c.getColumnIndex(KEY_TRANGTHAI)));

                    // adding to tags list
                    phongs.add(p);
                } while (c.moveToNext());
            }
        }
        return phongs;
    }

     //Cap nhat phong

    public int updatePhong(Phong phong) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
       // values.put(KEY_MAPHONG, phong.getMaPhong());
        values.put(KEY_LOAIPHONG, phong.getLoaiPhong());
        values.put(KEY_MOTAPHONG, phong.getMoTa());
        values.put(KEY_GIAPHONG, phong.getGia());
        values.put(KEY_TRANGTHAI, phong.getTrangThai());

        // updating row
        return db.update(TABLE_PHONG, values, KEY_MAPHONG + " = ?",
                new String[] { String.valueOf(phong.getMaPhong()) });
    }

    //Xoa 1 phong
    public void deletePhong(int mp) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_PHONG, KEY_MAPHONG + " = ?", new String[] { String.valueOf(mp) });
        db.close();
    }
    //Lay 1 phong theo maphong
    public Phong getById(int maphong) {
        Phong phong=null;
        String selectQuery = "SELECT  * FROM " + TABLE_PHONG +"WHERE MAPHONG='"+maphong+"'";
        Log.e(LOG, selectQuery);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);
        if (c!=null)
            {
                phong.setMaPhong(c.getInt((c.getColumnIndex(KEY_MAPHONG))));
                phong.setLoaiPhong(c.getString(c.getColumnIndex(KEY_LOAIPHONG)));
                phong.setMoTa(c.getString(c.getColumnIndex(KEY_MOTAPHONG)));
                phong.setGia(c.getInt(c.getColumnIndex(KEY_GIAPHONG)));
                phong.setTrangThai(c.getString(c.getColumnIndex(KEY_TRANGTHAI)));
            }
        return phong;
    }
    // ------------------------ Phương Thức của bảng Dich vu ----------------//

    //Them 1 dich vu
    public long createDV(DichVu dv) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_MADV, dv.getMaDV());
        values.put(KEY_TENDV, dv.getTenDV());
        values.put(KEY_MOTADV, dv.getMoTaDV());
        values.put(KEY_DVT, dv.getDVT());
        values.put(KEY_GIADV,dv.getGia());
        // insert row
        long dv1 = db.insert(TABLE_DV, null, values);
        return dv1;
    }
    // ------------------------ Phương Thức của bảng Khach Hang ----------------//
    //lay toan bo Khach
    public List<Khach> LayKhach(){
        List<Khach> laykhach=new ArrayList<Khach>();
        String str="SELECT * FROM "+TABLE_KHACH;
       // Log.e(LOG,str);
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor c=db.rawQuery(str,null);

        if(c.moveToFirst()){
            do {
                Khach k = new Khach();
                k.setCMND(c.getString(c.getColumnIndex(KEY_CMNDKH)));
                k.setTen(c.getString(c.getColumnIndex(KEY_TENKH)));
                k.setDiaChi(c.getString(c.getColumnIndex(KEY_DCKH)));
                k.setSDT(c.getString(c.getColumnIndex(KEY_SDTKH)));
                k.setGioiTinh(c.getString(c.getColumnIndex(KEY_GIOITINHKH)));

                laykhach.add(k);
            }while(c.moveToNext());
        }
        return laykhach;
    }

    //Them 1 Khach hang
    public long createKhach(Khach khach) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_CMNDKH, khach.getCMND());
        values.put(KEY_TENKH, khach.getTen());
        values.put(KEY_DCKH,khach.getDiaChi() );
        values.put(KEY_SDTKH, khach.getSDT());
        values.put(KEY_GIOITINHKH,khach.getGioiTinh());


        // insert row
        long k = db.insert(TABLE_KHACH, null, values);

        return k;
    }
    // ------------------------ Phương Thức của bảng Nhan Vien ----------------//

    //Them 1 Nhan vien///hàm này them 1 nhan vien ne
    public long createNV(NhanVien nv) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_MaNV,nv.getMaNV() );
        values.put(KEY_TENNV, nv.getTenNV());
        values.put(KEY_CMNDNV,nv.getCMND() );
        values.put(KEY_NGAYSINH,nv.getNgaySinh());
        values.put(KEY_DCNV,nv.getDiaChi());
        values.put(KEY_SDTNV,nv.getSDT());
        values.put(KEY_GIOITINHNV,nv.getGioiTinh());


        // insert row
        long nv1 = db.insert(TABLE_NV, null, values);

        return nv1;
    }
    //ham sua nhan vien trong bang
    public long suaNV(NhanVien nv){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_MaNV,nv.getMaNV() );
        values.put(KEY_TENNV, nv.getTenNV());
        values.put(KEY_CMNDNV,nv.getCMND() );
        values.put(KEY_NGAYSINH,nv.getNgaySinh());
        values.put(KEY_DCNV,nv.getDiaChi());
        values.put(KEY_SDTNV,nv.getSDT());
        values.put(KEY_GIOITINHNV,nv.getGioiTinh());

        return db.update(TABLE_NV,values,KEY_MaNV + " = " + nv.getMaNV(),null);
    }
    //Ham xoa nhan vien trong bang
    public long xoaNV(int maNV){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NV,KEY_MaNV +" = " +maNV,null);
    }
    //Ham lay ra toan bo nhan vien trong bang
    public ArrayList<NhanVien> getalldata(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM "+TABLE_NV+" ;",null);
        ArrayList<NhanVien> ar = new ArrayList<>();

        if(c.moveToFirst()){
            do {
                NhanVien nv = new NhanVien();
                nv.setMaNV(c.getInt(c.getColumnIndex(KEY_MaNV)));
                nv.setTenNV(c.getString(c.getColumnIndex(KEY_TENNV)));
                nv.setCMND(c.getString(c.getColumnIndex(KEY_CMNDNV)));
                nv.setNgaySinh(c.getString(c.getColumnIndex(KEY_NGAYSINH)));
                nv.setDiaChi(c.getString(c.getColumnIndex(KEY_DCNV)));
                nv.setSDT(c.getString(c.getColumnIndex(KEY_SDTNV)));
                nv.setGioiTinh(c.getString(c.getColumnIndex(KEY_GIOITINHNV)));

                ar.add(nv);
            }while(c.moveToNext());
        }
        return ar;
    }
}
