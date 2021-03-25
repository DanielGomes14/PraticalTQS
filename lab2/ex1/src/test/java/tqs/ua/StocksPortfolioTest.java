package tqs.ua;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StocksPortfolioTest {

    @Mock
    private IStocksMarket market;
    @InjectMocks
    private StocksPortfolio portfolio;


    @Test
    void getTotalValue() {

        // Mock Loading with the proper expectations
        when(market.getPrice("EBAY")).thenReturn(4.0);
        when(market.getPrice("MSFT")).thenReturn(1.5);

        // Test Execution with the service in the SuT
        portfolio.addStock(new Stock("EBAY",2));
        portfolio.addStock(new Stock("MSFT",4));
        double res = portfolio.getTotalValue();
        //Verification of the result(assert) and the use of the mock
        //assertEquals(14.0, res);
        assertThat(res, is(14.0));

        verify(market,times(2)).getPrice(anyString());
    }
}