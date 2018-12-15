package com.trvthanh.qlks;

import java.io.Serializable;

public class DichVu implements Serializable {
    int MaDV;
    String TenDV;
    String MoTaDV;
    String DVT;
    Integer Gia;

    public int getMaDV() {
        return MaDV;
    }

    public void setMaDV(int maDV) {
        MaDV = maDV;
    }

    public String getTenDV() {
        return TenDV;
    }

    public void setTenDV(String tenDV) {
        TenDV = tenDV;
    }

    public String getMoTaDV() {
        return MoTaDV;
    }

    public void setMoTaDV(String moTaDV) {
        MoTaDV = moTaDV;
    }

    public String getDVT() {
        return DVT;
    }

    public void setDVT(String DVT) {
        this.DVT = DVT;
    }

    public Integer getGia() {
        return Gia;
    }

    public void setGia(Integer gia) {
        Gia = gia;
    }

    public DichVu(int maDV, String tenDV, String moTaDV, String DVT, Integer gia) {
        MaDV = maDV;
        TenDV = tenDV;
        MoTaDV = moTaDV;
        this.DVT = DVT;
        Gia = gia;
    }
    public DichVu(){

    }


    @Override
    public String toString() {
        return getMaDV()+"";
    }
}
