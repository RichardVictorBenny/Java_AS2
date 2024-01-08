package com.mycompany.rentalsystem.Model;

/**
 * Class to set ids to maintenance request.
 */
public class Maintenance {
    private static Integer logId = 80000;
    private static Integer count = 0;
    private String maintenanceId;
    private static String maintenaceTableLabels = "logId, tenantName, dateOfIssue, houseId, tenantId, description, status";


    /**
     * Constructor of the class
     */
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


    public static Integer getLogId() {
        return logId;
    }


    public static void setLogId(Integer logId) {
        Maintenance.logId = logId;
    }   

    
    
}
