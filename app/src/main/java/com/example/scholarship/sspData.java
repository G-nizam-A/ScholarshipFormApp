package com.example.scholarship;

public class sspData {
    String ssName,ssFatherName,ssDOB, ssCourseType,ssDur, ssTenReg, ssTenPass, ssRegNo, ssDay, ssRen, ssDis;

    public sspData(String ssName, String ssFatherName, String ssCourseType, String ssDur, String ssTenReg, String ssTenPass, String ssRegNo, String ssDay, String ssRen, String ssDis) {
        this.ssName = ssName;
        this.ssFatherName = ssFatherName;
        this.ssDOB = ssDOB;
        this.ssCourseType = ssCourseType;
        this.ssDur = ssDur;
        this.ssTenReg = ssTenReg;
        this.ssTenPass = ssTenPass;
        this.ssRegNo = ssRegNo;
        this.ssDay = ssDay;
        this.ssRen = ssRen;
        this.ssDis = ssDis;
    }

    public String getSsName() {
        return ssName;
    }

    public String getSsFatherName() {
        return ssFatherName;
    }

    public String getSsDOB() {
        return ssDOB;
    }

    public String getSsCourseType() {
        return ssCourseType;
    }

    public String getSsDur() {
        return ssDur;
    }

    public String getSsTenReg() {
        return ssTenReg;
    }

    public String getSsTenPass() {
        return ssTenPass;
    }

    public String getSsRegNo() {
        return ssRegNo;
    }

    public String getSsDay() {
        return ssDay;
    }

    public String getSsRen() {
        return ssRen;
    }

    public String getSsDis() {
        return ssDis;
    }
}
