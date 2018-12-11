package com.trvthanh.qlks;

import java.util.Date;

public class NhanVien {
    int MaNV;
    String TenNV;
    String CMND;
    Date NgaySinh;
    String DiaChi;
    String SDT;
    Boolean GioiTinh;

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

    public Date getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
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

    public Boolean getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(Boolean gioiTinh) {
        GioiTinh = gioiTinh;
    }

    public NhanVien(int maNV, String tenNV, String CMND, Date ngaySinh, String diaChi, String SDT, Boolean gioiTinh) {
        MaNV = maNV;
        TenNV = tenNV;
        this.CMND = CMND;
        NgaySinh = ngaySinh;
        DiaChi = diaChi;
        this.SDT = SDT;
        GioiTinh = gioiTinh;
    }
}
