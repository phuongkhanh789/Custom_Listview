package com.example.customlistview;

public class Khoahoc {
    private String imagekhoahoc;
    private  String tenkhoahoc;
    private  double hocphi;
    public Khoahoc(String imagekhoahoc,String tenkhoahoc,double hocphi){
        this.imagekhoahoc = imagekhoahoc;
        this.tenkhoahoc = tenkhoahoc;
        this.hocphi = hocphi;
    }
    public String getTenkhoahoc(){
        return tenkhoahoc;
    }
    public void setTenkhoahoc(String tenkhoahoc){
        this.tenkhoahoc = tenkhoahoc;
    }
    public double getHocphi(){
        return hocphi;
    }
    public void setHocphi(double hocphi){
        this.hocphi = hocphi;
    }
    public String getImagekhoahoc(){
        return imagekhoahoc;
    }
    public void setImagekhoahoc(String imagekhoahoc){
        this.imagekhoahoc = imagekhoahoc;
    }
    @Override
    public String toString(){
        return this.tenkhoahoc+" Học phí: "+this.hocphi+" ";
    }
}
