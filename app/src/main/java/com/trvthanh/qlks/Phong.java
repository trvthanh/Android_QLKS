package com.trvthanh.qlks;

public class Phong {

    int MaPhong;
    String LoaiPhong;
    String MoTa;
    int Gia;

    public int getMaPhong() {
        return MaPhong;
    }

    public String getLoaiPhong() {
        return LoaiPhong;
    }

    public String getMoTa() {
        return MoTa;
    }

    public int getGia() {
        return Gia;
    }

    public void setGia(int gia) {
        Gia = gia;
    }

    public void setMaPhong(int maPhong) {
        MaPhong = maPhong;
    }

    public void setLoaiPhong(String loaiPhong) {
        LoaiPhong = loaiPhong;
    }

    public void setMoTa(String moTa) {
        MoTa = moTa;
    }


    public Phong(int maPhong, String loaiPhong, String moTa, int gia) {
        MaPhong = maPhong;
        LoaiPhong = loaiPhong;
        MoTa = moTa;
        Gia = gia;
    }

    public Phong()
    {
    }

    @Override
    public String toString() {
        return getMaPhong()+"";
    }
}
