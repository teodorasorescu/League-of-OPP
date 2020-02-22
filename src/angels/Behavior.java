package angels;

import hero.Hero;
import strategy.*;

public class Behavior implements Visitor {
    private Messenger messenger = new Messenger();

    @Override
    public final void visit(final DamageAngel damageAngel, final Hero hero) {
        messenger.appearance(new DamageStrategy(), hero);
    }

    @Override
    public final void visit(final DarkAngel darkAngel, final Hero hero) {
        messenger.appearance(new DarkStrategy(), hero);
    }

    @Override
    public final void visit(final Dracula dracula, final Hero hero) {
        messenger.appearance(new DraculaStrategy(), hero);
    }

    @Override
    public final void visit(final GoodBoy goodBoy, final Hero hero) {
        messenger.appearance(new GoodStrategy(), hero);
    }

    @Override
    public final void visit(final LevelUpAngel levelUpAngel, final Hero hero) {
        messenger.appearance(new LevelUpStrategy(), hero);
    }

    @Override
    public final void visit(final LifeGiver lifeGiver, final Hero hero) {
        messenger.appearance(new LifeGiverStrategy(), hero);
    }

    @Override
    public final void visit(final SmallAngel smallAngel, final Hero hero) {
        messenger.appearance(new SmallStrategy(), hero);
    }

    @Override
    public final void visit(final Spawner spawner, final Hero hero) {
        messenger.appearance(new SpawnerStrategy(), hero);
    }

    @Override
    public final void visit(final TheDoomer theDoomer, final Hero hero) {
        messenger.appearance(new TheDoomerStrategy(), hero);
    }

    @Override
    public final void visit(final XPAngel xpAngel, final Hero hero) {
        messenger.appearance(new XpStrategy(), hero);
    }

    public final Messenger getMessenger() {
        return messenger;
    }

    public final void setMessenger(final Messenger messenger) {
        this.messenger = messenger;
    }
}
