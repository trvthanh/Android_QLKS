package com.trvthanh.qlks;

public class Khach {
    String CMND;
    String Ten;
    String DiaChi;
    String SDT;
    Boolean GioiTinh;

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
        Ten = ten;
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

    public Khach(String CMND, String ten, String diaChi, String SDT, Boolean gioiTinh) {
        this.CMND = CMND;
        Ten = ten;
        DiaChi = diaChi;
        this.SDT = SDT;
        GioiTinh = gioiTinh;
    }
}
