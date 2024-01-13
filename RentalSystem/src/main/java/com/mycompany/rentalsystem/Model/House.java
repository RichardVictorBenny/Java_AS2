/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rentalsystem.Model;

import java.io.Serializable;

/**
 * implements the serializable interface
 * @author Richard
 */
public class House implements Serializable {
    private static Integer houseId = 2000;
    private static Integer totalHouseCount = 0;
    private Integer extHouseId;
    private String houseType, houseAddress, houseDescription;
    private Integer houseRentPrice;
    
    public House(){}

    /**
     * Constructor for adding new house
     * 
     * @param houseType
     * @param houseAddress
     * @param houseDescription
     * @param houseRentPrice
     */
    public House(String houseType,
                String houseAddress,
                String houseDescription,
                Integer houseRentPrice){
                    House.houseId++;
                    this.extHouseId = House.houseId;
                    House.totalHouseCount++;
                    this.houseType = houseType;
                    this.houseAddress = houseAddress;
                    this.houseDescription = houseDescription;
                    this.houseRentPrice = houseRentPrice;

                }

    /**
     * constructor for building exsisting object
     * 
     * @param houseId
     * @param houseType
     * @param houseAddress
     * @param houseDescription
     * @param houseRentPrice
     */
    public House(String houseId,
                String houseType,
                String houseAddress,
                String houseDescription,
                Integer houseRentPrice){
                    this.extHouseId = Integer.valueOf(houseId);
                    this.houseType = houseType;
                    this.houseAddress = houseAddress;
                    this.houseDescription = houseDescription;
                    this.houseRentPrice = houseRentPrice;

                }

    /*
     * Getters and setters
     */
    public static Integer getTotalHouseCount() {
        return totalHouseCount;
    }

    public static void setTotalHouseCount(int totalHouseCount) {
        House.totalHouseCount = totalHouseCount;
    }

    public String getHouseType() {
        return houseType;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType;
    }

    public String getHouseAddress() {
        return houseAddress;
    }

    public void setHouseAddress(String houseAddress) {
        this.houseAddress = houseAddress;
    }

    public String getHouseDescription() {
        return houseDescription;
    }

    public void setHouseDescription(String houseDescription) {
        this.houseDescription = houseDescription;
    }

    public Integer getHouseRentPrice() {
        return houseRentPrice;
    }

    public void setHouseRentPrice(int houseRentPrice) {
        this.houseRentPrice = houseRentPrice;
    }

    public static void setHouseId(Integer id){
        houseId = id;
    }

    public void setExtHouseId(Integer houseId) {
        this.extHouseId = houseId;
    }

    public Integer getHouseId() {
        return extHouseId;
    }

    public void setExtHouseId(String extHouseId) {
        this.extHouseId = Integer.valueOf(extHouseId);
    }

    /**
     * {@inherit}
     * prints out the different values of the house
     */
    @Override
    public  String toString(){
        String value = ""+this.extHouseId+" "+this.houseType+" "+
        this.houseAddress+" "+this.houseDescription+" "+this.houseRentPrice;
        return value;
    }

    /**
     * Mostly used for updating the table.
     * @return String[] of all the needed values for the table.
     */
    public String[] getDataArray(){
        String[] dataArray = {String.valueOf(houseId), this.houseType, this.houseAddress, String.valueOf(this.houseRentPrice)};
        return dataArray;
    }

    
    
}
