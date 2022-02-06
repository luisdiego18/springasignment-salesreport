package edu.wctc;

import edu.wctc.Interfaces.SalesInput;
import edu.wctc.Interfaces.SalesReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SalesHelper {
    @Autowired
    private SalesInput salesInput;
    @Autowired
    private SalesReport salesReport;

    public void processSales() {
        List<Sale> list = salesInput.getSales();

        salesReport.generateReport(list);
    }

}