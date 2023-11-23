import java.util.ArrayList;
import java.util.List;

class NewsAgency {
    private List<Subscriber> subscribers;

    public NewsAgency() {
        subscribers = new ArrayList<>();
    }

    public void subscribe(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    public void unsubscribe(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    public void notifySubscribers(String news) {
        for (Subscriber subscriber : subscribers) {
            subscriber.update(news);
        }
    }
}

interface Subscriber {
    void update(String news);
}

class NewsChannel implements Subscriber {
    @Override
    public void update(String news) {
        System.out.println("New breaking news received: " + news);
    }
}

class MobileApp implements Subscriber {
    @Override
    public void update(String news) {
        System.out.println("Mobile app received breaking news: " + news);
    }
}

public class RealTimeNewsSubscriptionService {
    public static void main(String[] args) {
        NewsAgency newsAgency = new NewsAgency();

        NewsChannel newsChannel = new NewsChannel();
        MobileApp mobileApp = new MobileApp();

        newsAgency.subscribe(newsChannel);
        newsAgency.subscribe(mobileApp);

        newsAgency.notifySubscribers("World cup 2022 winner is announced.");
    }
}