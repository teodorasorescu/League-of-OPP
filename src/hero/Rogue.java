package hero;

import ability.RogueAbilities;
import constants.Constants;
import hpstrategy.HpStrategy;
import hpstrategy.RogueStrategy;



public final class Rogue extends Hero {
    private RogueAbilities abilities = new RogueAbilities();
    private HpStrategy hpStrategy = new HpStrategy();

    //strategy
    public void newFeatures(final Hero striker) {
        hpStrategy.execute(new RogueStrategy(), striker);
    }

    @Override
    //verifies on each land is on and adds the land modifier
    public void addLandModifier(final Hero hero) {
        if (hero.getLocation() == 'W') {
            hero.setBonusLand(Constants.Land.WOODS);
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

    public RogueAbilities getAbilities() {
        return abilities;
    }

    public void setAbilities(final RogueAbilities abilities) {
        this.abilities = abilities;
    }

    public HpStrategy getHpStrategy() {
        return hpStrategy;
    }

    public void setHpStrategy(final HpStrategy hpStrategy) {
        this.hpStrategy = hpStrategy;
    }
}
