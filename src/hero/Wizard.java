package hero;

import ability.WizardAbilities;
import constants.Constants;
import hpstrategy.HpStrategy;
import hpstrategy.WizardStrategy;


public final class Wizard extends Hero {

    private WizardAbilities abilities = new WizardAbilities();
    private HpStrategy hpStrategy = new HpStrategy();

    //strategy
    public void newFeatures(final Hero striker) {
        hpStrategy.execute(new WizardStrategy(), striker);
    }

    @Override
    //verifies on each land is on and adds the land modifier
    public void addLandModifier(final Hero hero) {
        if (hero.getLocation() == 'D') {
            hero.setBonusLand(Constants.Land.DESERT);
        } else {
            hero.setBonusLand(Constants.Land.NEUTRAL);
        }
    }

    @Override
    public void fightsWith(final Hero hero) {
        hero.interactWith(this);
    }

    @Override
    public void interactWith(final Knight hero) {
        addLandModifier(this);
        abilities.firstAbility(hero, this);
        abilities.secondAbility(hero, this);

    }

    @Override
    public void interactWith(final Pyromancer hero) {
        addLandModifier(this);
        abilities.firstAbility(hero, this);
        abilities.secondAbility(hero, this);

    }

    @Override
    public void interactWith(final Rogue hero) {
        addLandModifier(this);
        abilities.firstAbility(hero, this);
        abilities.secondAbility(hero, this);

    }

    @Override
    public void interactWith(final Wizard hero) {
        addLandModifier(this);
        abilities.firstAbility(hero, this);
        abilities.secondAbility(hero, this);

    }

    public WizardAbilities getAbilities() {
        return abilities;
    }

    public void setAbilities(final WizardAbilities abilities) {
        this.abilities = abilities;
    }

    public HpStrategy getHpStrategy() {
        return hpStrategy;
    }

    public void setHpStrategy(final HpStrategy hpStrategy) {
        this.hpStrategy = hpStrategy;
    }
}
