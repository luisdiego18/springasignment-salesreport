package edu.wctc.Interfaces;

import edu.wctc.Sale;

import java.util.List;

public interface SalesReport {
    void generateReport(List<Sale> salesList);
}
