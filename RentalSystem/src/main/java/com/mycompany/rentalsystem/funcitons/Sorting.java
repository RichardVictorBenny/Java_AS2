package com.mycompany.rentalsystem.funcitons;

import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 * this class has differnt sorting functions
 */
public class Sorting {
    /**
     * Sorts JTable
     * reference: https://stackoverflow.com/questions/31158089/how-to-search-data-in-jtable-using-jtextfield
     * 
     * @param table JTable instance of the table to be sorted
     * @param text String filter word
     */
    public static void sortTable(JTable table, String text) {
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        TableRowSorter<DefaultTableModel> rowSorter = new TableRowSorter<>(tableModel);
        table.setRowSorter(rowSorter);
        rowSorter.setRowFilter(RowFilter.regexFilter(text));
    }
}
