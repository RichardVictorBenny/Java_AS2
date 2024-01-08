package com.mycompany.rentalsystem.funcitons;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.html.ObjectView;

import com.mycompany.rentalsystem.Controller.LandlordController;
import com.mycompany.rentalsystem.Controller.TenantController;
import com.mycompany.rentalsystem.Model.House;
import com.mycompany.rentalsystem.Model.Maintenance;
import com.mycompany.rentalsystem.Model.Tenant;
import com.mycompany.rentalsystem.View.LandlordView;
import com.mycompany.rentalsystem.View.TenantView;
import com.mysql.cj.jdbc.Blob;

import io.opencensus.stats.Aggregation.LastValue;

public class TableRefresh {

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

            default:
                break;
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
                Blob houseBlob = (Blob) allHouseRows.getBlob("houseObject");
                byte[] houseByte = houseBlob.getBytes(1, (int) houseBlob.length());
                House tempHouseObj = (House) FileConvertion.toObject(houseByte);

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
                // String data = allTenantRows.getString("tenantId");

                // rebuild House object form ByteArray
                Blob blob = (Blob) allTenantRows.getBlob("tenantObject");
                byte[] tenantByte = blob.getBytes(1, (int) blob.length());
                Tenant tempObj = (Tenant) FileConvertion.toObject(tenantByte);
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

    public static void insertValueTable(JTable table, String[] data) {
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        tableModel.addRow(data);
    }

}
