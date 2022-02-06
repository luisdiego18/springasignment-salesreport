package edu.wctc;

import edu.wctc.Interfaces.SalesInput;
import edu.wctc.Interfaces.ShippingPolicy;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReaderProvider implements SalesInput {
    @Autowired
    private ShippingPolicy ship;
    @Override
    public List<Sale> getSales() {
        List<Sale> list = new ArrayList<>();
        File file = new File("sales.txt");

        try {
            Scanner reader = new Scanner(file);

            while (reader.hasNext()) {
                String line = reader.nextLine();
                String[] contents = line.split(",");

                Sale sale = new Sale();
                sale.setCustomer(contents[0]);
                sale.setCountry(contents[1]);
                sale.setAmount(Double.parseDouble(contents[2]));
                sale.setTax(Double.parseDouble(contents[3]));

                ship.applyShipping(sale);
                list.add(sale);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }

}
