package com.trvthanh.qlks;

public class Khach {
    private String CMND;
    private String Ten;
    private String DiaChi;
    private String SDT;
    private String GioiTinh;

    public Khach() {

    }

    public String getCMND() {
        return CMND;
    }

    public void setCMND(String CMND) {
        this.CMND = CMND;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        this.Ten = ten;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String diaChi) {
        this.DiaChi = diaChi;
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
        this.GioiTinh = gioiTinh;
    }

    public Khach(String CMND, String ten, String diaChi, String SDT, String gioiTinh) {
        this.CMND = CMND;
        this.Ten = ten;
        this.DiaChi = diaChi;
        this.SDT = SDT;
        this.GioiTinh = gioiTinh;
    }

    @Override
    public String toString() {
        return getTen()+"";
    }
}
