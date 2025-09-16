package exchangerate;

import exchangerate.decoupled.ExchangeRateSupportFactory;

public class ExchangeRateApplication {

    public static void main(String[] args) {
        ExchangeRateSupportFactory factory = ExchangeRateSupportFactory.getInstance();
        factory.getExchangeRateRenderer().render();
    }
}
