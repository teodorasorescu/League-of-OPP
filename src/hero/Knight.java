package hero;

import ability.KnightAbilities;
import constants.Constants;
import hpstrategy.HpStrategy;
import hpstrategy.KnightStrategy;


public final class Knight extends Hero {

    private KnightAbilities abilities = new KnightAbilities();
    private HpStrategy hpStrategy = new HpStrategy();

    //strategy
    public void newFeatures(final Hero striker) {
        hpStrategy.execute(new KnightStrategy(), striker);
    }

    //verifies on each land is on and adds the land modifier
    public void addLandModifier(final Hero hero) {
        if (hero.getLocation() == 'L') {
            hero.setBonusLand(Constants.Land.LAND);
        } else {
            hero.setBonusLand(Constants.Land.NEUTRAL);
        }
    }

    @Override
    public void fightsWith(final Hero hero) {
        hero.interactWith(this);
    }

    @Override
    public void interactWith(final Knight knight) {
        addLandModifier(knight);
        abilities.firstAbility(knight, this);
        abilities.secondAbility(knight, this);
    }

    @Override
    public void interactWith(final Pyromancer pyromancer) {
        addLandModifier(pyromancer);
        abilities.firstAbility(pyromancer, this);
        abilities.secondAbility(pyromancer, this);

    }

    @Override
    public void interactWith(final Rogue rogue) {
        addLandModifier(rogue);
        abilities.firstAbility(rogue, this);
        abilities.secondAbility(rogue, this);

    }

    @Override
    public void interactWith(final Wizard wizard) {
        addLandModifier(wizard);
        abilities.firstAbility(wizard, this);
        abilities.secondAbility(wizard, this);

    }

    public KnightAbilities getAbilities() {
        return abilities;
    }

    public void setAbilities(final KnightAbilities abilities) {
        this.abilities = abilities;
    }

    public HpStrategy getHpStrategy() {
        return hpStrategy;
    }

    public void setHpStrategy(final HpStrategy hpStrategy) {
        this.hpStrategy = hpStrategy;
    }
}
