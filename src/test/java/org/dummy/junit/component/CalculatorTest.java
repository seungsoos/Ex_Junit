package org.dummy.junit.component;

import org.dummy.junit.component.DollarCalculator;
import org.dummy.junit.component.MarketApi;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CalculatorTest {

    @Mock
    private MarketApi marketApi;

    @BeforeEach
    public void init() {
        Mockito.lenient().when(marketApi.connect()).thenReturn(3000);
    }

    @Test
    public void dollar() {
        MarketApi marketApi = new MarketApi();

        DollarCalculator dollarCalculator = new DollarCalculator(marketApi);
        dollarCalculator.init();

        Assertions.assertEquals(22000, dollarCalculator.sum(10, 10));
        Assertions.assertEquals(0, dollarCalculator.minus(10, 10));
    }

    @Test
    @DisplayName("Mock 추가 테스트")
    public void mockTest() {
        DollarCalculator dollarCalculator = new DollarCalculator(marketApi);
        dollarCalculator.init();

        Assertions.assertEquals(60000, dollarCalculator.sum(10, 10));
        Assertions.assertEquals(0, dollarCalculator.minus(10, 10));
    }
}
