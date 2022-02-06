package edu.wctc;

import edu.wctc.Interfaces.SalesInput;
import edu.wctc.Interfaces.SalesReport;
import edu.wctc.Interfaces.ShippingPolicy;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "edu.wctc")
public class MyApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(MyApp.class);
        context.refresh();
        ((SalesHelper)context.getBean("salesHelper")).processSales();
    }

    // Uncomment to run different options
    @Bean
    public SalesInput reader() {
        return new FileReaderProvider();
    }
//    @Bean
//    public SalesInput reader() {
//        return new CommandLineProvider();
//    }

    @Bean
    public SalesReport report() {
        return new DetailReport();
    }
//    @Bean
//    public SalesReport report() {
//        return new SummaryReport();
//    }

    @Bean
    public ShippingPolicy ship() {
        return new FreeShipping();
    }
}