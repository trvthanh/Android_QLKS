package com.trvthanh.qlks;

import java.util.Date;

public class NhanVien {
    public NhanVien(int maNV, String tenNV, String CMND, String ngaySinh, String diaChi, String SDT, String gioiTinh) {
        MaNV = maNV;
        TenNV = tenNV;
        this.CMND = CMND;
        NgaySinh = ngaySinh;
        DiaChi = diaChi;
        this.SDT = SDT;
        GioiTinh = gioiTinh;
    }

    public int getMaNV() {

        return MaNV;
    }

    public void setMaNV(int maNV) {
        MaNV = maNV;
    }

    public String getTenNV() {
        return TenNV;
    }

    public void setTenNV(String tenNV) {
        TenNV = tenNV;
    }

    public String getCMND() {
        return CMND;
    }

    public void setCMND(String CMND) {
        this.CMND = CMND;
    }

    public String getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        NgaySinh = ngaySinh;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String diaChi) {
        DiaChi = diaChi;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        GioiTinh = gioiTinh;
    }

    int MaNV;
    String TenNV;
    String CMND;
    String NgaySinh;
    String DiaChi;
    String SDT;
    String GioiTinh;
    public NhanVien()
    {}

    @Override
    public String toString() {
        return getMaNV()+"";
    }
}
