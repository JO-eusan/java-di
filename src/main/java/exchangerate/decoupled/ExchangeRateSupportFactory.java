package exchangerate.decoupled;

import java.util.Properties;

public final class ExchangeRateSupportFactory {
    private static final ExchangeRateSupportFactory INSTANCE;
    private final ExchangeRateProvider exchangeRateProvider;
    private final ExchangeRateRenderer exchangeRateRenderer;

    static {
        INSTANCE = new ExchangeRateSupportFactory();
    }

    private ExchangeRateSupportFactory() {
        Properties properties = new Properties();
        try {
            final var resourceStream = this.getClass().getResourceAsStream("/exchange-rate.properties");
            properties.load(resourceStream); // 불러온 파일을 properties 객체에 저장

            final var providerClass = properties.getProperty("provider.class");
            final var rendererClass = properties.getProperty("renderer.class");

            this.exchangeRateProvider = (ExchangeRateProvider) Class.forName(providerClass).getDeclaredConstructor().newInstance();
            this.exchangeRateRenderer = (ExchangeRateRenderer) Class.forName(rendererClass).getDeclaredConstructor().newInstance();
            exchangeRateRenderer.setExchangeRateProvider(exchangeRateProvider);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public static ExchangeRateSupportFactory getInstance() {
        return INSTANCE;
    }

    public ExchangeRateProvider getExchangeRateProvider() {
        return exchangeRateProvider;
    }

    public ExchangeRateRenderer getExchangeRateRenderer() {
        return exchangeRateRenderer;
    }
}
