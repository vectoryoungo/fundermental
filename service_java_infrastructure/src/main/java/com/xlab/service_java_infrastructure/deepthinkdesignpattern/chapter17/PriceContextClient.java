package com.xlab.service_java_infrastructure.deepthinkdesignpattern.chapter17;

public class PriceContextClient {

    public static void main(String[] args) {
        PriceStrategy priceStrategy = new SuperCustomerStrategy();
        PriceStrategy goldenMember = new GoldenMemberCustomerStrategy();
        PriceStrategy normalCustomer = new NormalCustomerStrategy();
        PriceContext context = new PriceContext(normalCustomer);

        double quote = context.quote(10000);
        System.out.println("price estimate to customer " + quote);
    }
}
