package exchangerate;

import exchangerate.decoupled.ExchangeRateProvider;
import exchangerate.decoupled.ExchangeRateRenderer;
import exchangerate.decoupled.StandardInputExchangeRateProvider;
import exchangerate.decoupled.StandardOutputExchangeRateRenderer;

public class ExchangeRateApplication {

    public static void main(String[] args) {
        final ExchangeRateProvider provider = new StandardInputExchangeRateProvider();
        final ExchangeRateRenderer renderer = new StandardOutputExchangeRateRenderer();
        renderer.setExchangeRateProvider(provider);
        renderer.render();
    }
}
