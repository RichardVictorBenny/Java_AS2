package com.mycompany.rentalsystem.funcitons;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.event.MouseEvent;

import com.mycompany.rentalsystem.Model.House;
import com.mycompany.rentalsystem.Model.Maintenance;
import com.mycompany.rentalsystem.Model.Payments;
import com.mycompany.rentalsystem.Model.Tenant;
import com.mycompany.rentalsystem.View.LandlordView;
import com.mycompany.rentalsystem.View.TenantView;
import com.mysql.cj.jdbc.Blob;


public class TableRefresh {

    /**
     * Uses the JTable Name to run the correct refresh funtion.
     * 
     * @param view Object the view the action has to performed
     * @param database Database instance
     * @param tableName String name of the table the values are stored in the database
     * @param jTable JTable table which has to be refreshed
     */
    public static void refreshTable(Object view, Database database, String tableName, JTable jTable) {
        ResultSet allRows = database.findAll(tableName);

        removeRows(jTable);

        switch (jTable.getName()) {
            case "HOUSE TABLE":
                refreshHouseListTable(view, allRows);
                break;
            case "TENANT TABLE":
                refreshTenantlistTable(view, allRows);
                break;

            case "MAINTENANCE":
                refreshMaintenanceRequestListTable(view, allRows);
                break;
            case "MAINTENANCE SECONDARY":
                refreshMaintenanceSecondaryRequestListTable(view, allRows);
            case "NEW ERROR":
                refreshNewMaintenanceTables(view, allRows);
                break;
            case "REVIEW":
                refreshReviewMaintenanceTables(view, allRows);
                break;
            case "PREVIOUS":
                refreshPreviousMaintenanceTables(view, allRows);
                break;
            case "PAYMENTS":
            try {
                
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
                refreshPaymentsTable(view, allRows);
                break;

            default:
                break;
        }

    }
    private static void refreshPaymentsTable(Object view, ResultSet result){
        TenantView tenantView = (TenantView) view;
        try {
            while (result.next()) {
                String[] data = {
                        result.getString("id"),
                        result.getString("date"),
                        result.getString("type"),

                };
                insertValueTable(tenantView.getPaymentHistoryListTable(), data);
                Payments.setPaymentId(Integer.valueOf(result.getString("id")) + 1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void refreshMaintenanceSecondaryRequestListTable(Object view, ResultSet result) {
        LandlordView landlordView = (LandlordView) view;
        try {
            while (result.next()) {
                String[] data = {
                        result.getString("logId"),
                        result.getString("tenantName"),
                        result.getString("dateOfIssue"),
                        result.getString("houseId"),
                        result.getString("status")
                };
                insertValueTable(landlordView.getMaintenanceRequestListTable(), data);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void refreshHouseListTable(Object view, ResultSet allHouseRows) {
        LandlordView landlordView = (LandlordView) view;
        try {
            landlordView.getTenantHouseIdComboBox().removeAllItems();

            while (allHouseRows.next()) {
                String[] data = new String[4];
                data[0] = allHouseRows.getString("houseId");

                // adding adding houseId to the tenant panel combobox

                landlordView.getTenantHouseIdComboBox().addItem(data[0]);

                // rebuild House object form ByteArray
                House tempHouseObj = (House) FileConvertion.toObject(allHouseRows.getBlob("houseObject"));

                data[1] = tempHouseObj.getHouseType();
                data[2] = tempHouseObj.getHouseAddress();
                data[3] = String.valueOf(tempHouseObj.getHouseRentPrice());

                insertValueTable(landlordView.getHouseListTable(), data);
                House.setHouseId(tempHouseObj.getHouseId());

            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void refreshTenantlistTable(Object view, ResultSet allTenantRows) {
        LandlordView landlordView = (LandlordView) view;
        try {
            while (allTenantRows.next()) {
                // rebuild House object form ByteArray
                Tenant tempObj = (Tenant) FileConvertion.toObject(allTenantRows.getBlob("tenantObject"));

                insertValueTable(landlordView.getTenantListTable(), tempObj.getDataArray());
                Tenant.setTenantId(Integer.valueOf(tempObj.getTenantId()));
                // tenantArray.put(data, tempObj);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void refreshMaintenanceRequestListTable(Object view, ResultSet rows) {
        TenantView tenantView = (TenantView) view;
        try {
            while (rows.next()) {
                String[] data = {
                        rows.getString("logId"),
                        rows.getString("tenantName"),
                        rows.getString("dateOfIssue"),
                        rows.getString("status")
                };
                insertValueTable(tenantView.getMaintenanceRequestListTable(), data);
                
                //adding value to dashboard table.
                insertValueTable(tenantView.getDashboardMaintenanceSummaryTable(), data);
                Maintenance.setLogId(Integer.valueOf(rows.getString("logId")) + 1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void refreshNewMaintenanceTables(Object view, ResultSet result) {
        LandlordView landlordView = (LandlordView) view;
        try {
            while (result.next()) {
                if (result.getString("status").equals("Received")) {
                    String[] data = {
                            result.getString("logId"),
                            result.getString("tenantName"),
                            result.getString("dateOfIssue"),
                            result.getString("houseId")
                    };

                    insertValueTable(landlordView.getErrorNewListTable(), data);

                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private static void refreshReviewMaintenanceTables(Object view, ResultSet result) {
        LandlordView landlordView = (LandlordView) view;
        try {
            while (result.next()) {
                if (result.getString("status").equals("In Review")) {
                    String[] data = {
                            result.getString("logId"),
                            result.getString("tenantName"),
                            result.getString("dateOfIssue"),
                            result.getString("houseId")
                    };
                    insertValueTable(landlordView.getErrorReviewListTable(), data);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void refreshPreviousMaintenanceTables(Object view, ResultSet result) {
        LandlordView landlordView = (LandlordView) view;
        try {
            while (result.next()) {
                if (result.getString("status").equals("Rectified")) {
                    String[] data = {
                            result.getString("logId"),
                            result.getString("tenantName"),
                            result.getString("dateOfIssue"),
                            result.getString("houseId")
                    };
                    insertValueTable(landlordView.getPreviousErrorListTable(), data);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void removeRows(JTable table) {
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        try {
            tableModel.getDataVector().removeAllElements();
            tableModel.fireTableDataChanged();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * inserts data into a give JTable
     * @param table Jtable to which rows has to added
     * @param data an array of data to be added; has to be consistant with the columns in the JTalbe.
     */
    public static void insertValueTable(JTable table, String[] data) {
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        tableModel.addRow(data);
    }

    /**
     * 
     * @param clickedTable JTable instance of the table the aciton is being done on.
     * @param e            MouseEvent instance
     * @return String id of the row that is clicked on
     */
    public static String getIdAtPoint(JTable clickedTable, MouseEvent e) {
        int row = clickedTable.rowAtPoint(e.getPoint());
        int rowId = Integer.valueOf((String) clickedTable.getModel().getValueAt(row, 0));
        String id = (String.valueOf(rowId));
        return id;
    }
}
