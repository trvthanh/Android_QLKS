package com.trvthanh.qlks;

public class Phong {

    int MaPhong;
    String LoaiPhong;
    String MoTa;
    int Gia;
    String TrangThai;

    public int getMaPhong() {
        return MaPhong;
    }

    public void setMaPhong(int maPhong) {
        MaPhong = maPhong;
    }

    public String getLoaiPhong() {
        return LoaiPhong;
    }

    public void setLoaiPhong(String loaiPhong) {
        LoaiPhong = loaiPhong;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String moTa) {
        MoTa = moTa;
    }

    public int getGia() {
        return Gia;
    }

    public void setGia(int gia) {
        Gia = gia;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String trangThai) {
        TrangThai = trangThai;
    }

    public Phong(int maPhong, String loaiPhong, String moTa, int gia, String trangThai) {
        MaPhong = maPhong;
        LoaiPhong = loaiPhong;
        MoTa = moTa;
        Gia = gia;
        TrangThai = trangThai;
    }

    public Phong()
    {
    }

    @Override
    public String toString() {
        return getMaPhong()+"";
    }
}
