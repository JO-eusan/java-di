package exchangerate;

import exchangerate.decoupled.ExchangeRateRenderer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ExchangeRateApplication {

    public static void main(String[] args) {
        final ApplicationContext context = new ClassPathXmlApplicationContext("exchange-rate-context.xml");
        final ExchangeRateRenderer renderer = context.getBean("exchangeRateRenderer", ExchangeRateRenderer.class);
        renderer.render();
    }
}
