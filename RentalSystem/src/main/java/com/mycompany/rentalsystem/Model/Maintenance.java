package com.mycompany.rentalsystem.Model;

public class Maintenance {
    private static Integer logId = 8000;
    private static Integer count = 0;
    private String maintenanceId;
    private static String maintenaceTableLabels = "logId, tenantName, dateOfIssue, houseId, tenantId, description, status";



    public Maintenance(){
        logId++;
        count++;
        this.maintenanceId=String.valueOf(logId);

    }


    //getter and setter
    public String getMaintenanceId() {
        return maintenanceId;
    }



    public void setMaintenanceId(String maintenanceId) {
        this.maintenanceId = maintenanceId;
    }


    public static String getMaintenaceTableLabels() {
        return maintenaceTableLabels;
    }


    public static Integer getCount() {
        return count;
    }


    public static void setCount() {
        count++;
    }


    public Integer getLogId() {
        return logId;
    }


    public static void setLogId(Integer logId) {
        Maintenance.logId = logId;
    }   

    
    
}
