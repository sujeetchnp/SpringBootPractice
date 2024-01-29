package com.sujeet.project.springboot.model;

public class UserAddress {
    private Integer uId;
    private String uCity;

    private String uCountry;

    private String uZipCode;

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getuCity() {
        return uCity;
    }

    public void setuCity(String uCity) {
        this.uCity = uCity;
    }

    public String getuCountry() {
        return uCountry;
    }

    public void setuCountry(String uCountry) {
        this.uCountry = uCountry;
    }

    public String getuZipCode() {
        return uZipCode;
    }

    public void setuZipCode(String uZipCode) {
        this.uZipCode = uZipCode;
    }
}
