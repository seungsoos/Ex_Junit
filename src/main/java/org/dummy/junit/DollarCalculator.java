package org.dummy.junit;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DollarCalculator implements ICalculator{

    private final MarketApi marketApi;

    private int price = 1;

    public void init() {
        this.price = marketApi.connect();
    }

    @Override
    public int sum(int x, int y) {
        x *= price;
        y *= price;
        return x + y;
    }

    @Override
    public int minus(int x, int y) {
        x *= price;
        y *= price;
        return x - y;
    }
}
