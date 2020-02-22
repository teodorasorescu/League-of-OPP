package thegreatmagician;

import angels.Angel;
import hero.Hero;

import java.util.ArrayList;
import java.util.List;

public final class TheGreatMagician {
    private static TheGreatMagician instance = null;

    private TheGreatMagician() {
    }

    public static TheGreatMagician getInstance() {
        if (instance == null) {
            instance = new TheGreatMagician();
        }
        return instance;
    }

    private List<Observer> observerList = new ArrayList<>();

    public void add(final Observer observer) {
        observerList.add(observer);
    }

    public void execute(final Hero hero, final Angel angel, final Hero striker) {
        for (Observer observer : observerList) {
            observer.update(hero, angel, striker);
        }
    }

    public  List<Observer> getObserverList() {
        return observerList;
    }

    public void setObserverList(final List<Observer> observerList) {
        this.observerList = observerList;
    }
}
