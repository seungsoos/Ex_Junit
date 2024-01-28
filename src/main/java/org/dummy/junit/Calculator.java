package org.dummy.junit;


import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Calculator {

    private final ICalculator iCalculator;

    public int sum(int x, int y) {
        return this.iCalculator.sum(x, y);
    }

    public int minus(int x, int y) {
        return this.iCalculator.minus(x, y);
    }

}
