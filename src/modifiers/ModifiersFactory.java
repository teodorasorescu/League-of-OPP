package modifiers;

import hero.Hero;


import java.util.HashMap;
import java.util.Map;


public final class ModifiersFactory {
    private static ModifiersFactory instance = null;

    private static class Damage {
        private static final Integer KDMG1 = 200;
        private static final Integer KDMG2 = 100;
        private static final Integer RDMG1 = 200;
        private static final Integer RDMG2 = 40;
        private static final Float WDMG1 = 0.2f;
        private static final Float WDMG2 = 0.35f;
        private static final Integer PDMG1 = 350;
        private static final Integer PDMG2 = 150;

    }

    private static class Pyromancer {
        private static final Float PR1 = 0.8f;
        private static final Float PK1 = 1.2f;
        private static final Float PP1 = 0.9f;
        private static final Float PW1 = 1.05f;

        private static final Float PR2 = 0.8f;
        private static final Float PK2 = 1.2f;
        private static final Float PP2 = 0.9f;
        private static final Float PW2 = 1.05f;
    }

    private static class Knight {
        private static final Float KR1 = 1.15f;
        private static final Float KK1 = 1f;
        private static final Float KP1 = 1.1f;
        private static final Float KW1 = 0.8f;

        private static final Float KR2 = 0.8f;
        private static final Float KK2 = 1.2f;
        private static final Float KP2 = 0.9f;
        private static final Float KW2 = 1.05f;
    }

    private static class Wizard {
        private static final Float WR1 = 0.8f;
        private static final Float WK1 = 1.2f;
        private static final Float WP1 = 0.9f;
        private static final Float WW1 = 1.05f;

        private static final Float WR2 = 1.2f;
        private static final Float WK2 = 1.4f;
        private static final Float WP2 = 1.3f;
        private static final Float WW2 = 0f;
    }

    private static class Rogue {
        private static final Float RR1 = 1.2f;
        private static final Float RK1 = 0.9f;
        private static final Float RP1 = 1.25f;
        private static final Float RW1 = 1.25f;

        private static final Float RR2 = 0.9f;
        private static final Float RK2 = 0.8f;
        private static final Float RP2 = 1.2f;
        private static final Float RW2 = 1.25f;
    }

    private final Map<String, Float> knightTabel1;
    private final Map<String, Float> knightTabel2;
    private final Map<String, Float> pyromancerTabel1;
    private final Map<String, Float> pyromancerTabel2;
    private final Map<String, Float> rogueTabel1;
    private final Map<String, Float> rogueTabel2;
    private final Map<String, Float> wizardTabel1;
    private final Map<String, Float> wizardTabel2;

    private final Map<Integer, Integer> knightAbilitiesDamage;
    private final Map<Integer, Integer> rogueAbilitiesDamage;
    private final Map<Integer, Integer> pyromancerAbilitiesDamage;
    private final Map<Integer, Float> wizardAbilitiesDamage;

    private ModifiersFactory() {
        knightTabel1 = new HashMap<String, Float>();
        knightTabel2 = new HashMap<String, Float>();
        pyromancerTabel1 = new HashMap<String, Float>();
        pyromancerTabel2 = new HashMap<String, Float>();
        rogueTabel1 = new HashMap<String, Float>();
        rogueTabel2 = new HashMap<String, Float>();
        wizardTabel1 = new HashMap<String, Float>();
        wizardTabel2 = new HashMap<String, Float>();

        knightAbilitiesDamage = new HashMap<Integer, Integer>();
        rogueAbilitiesDamage = new HashMap<Integer, Integer>();
        pyromancerAbilitiesDamage = new HashMap<Integer, Integer>();
        wizardAbilitiesDamage = new HashMap<Integer, Float>();
        initKnightTabels();
        initPyromancerTabels();
        initRogueTabels();
        initWizardTabels();

        initKnightDamage();
        initPyromancerDamage();
        initRogueDamage();
        initWizardDamage();
    }

    private void initKnightDamage() {
        knightAbilitiesDamage.put(0, Damage.KDMG1);
        knightAbilitiesDamage.put(1, Damage.KDMG2);
    }

    private void initPyromancerDamage() {
        pyromancerAbilitiesDamage.put(0, Damage.PDMG1);
        pyromancerAbilitiesDamage.put(1, Damage.PDMG2);
    }

    private void initRogueDamage() {
        rogueAbilitiesDamage.put(0, Damage.RDMG1);
        rogueAbilitiesDamage.put(1, Damage.RDMG2);
    }

    private void initWizardDamage() {
        wizardAbilitiesDamage.put(0, Damage.WDMG1);
        wizardAbilitiesDamage.put(1, Damage.WDMG2);
    }

    private void initKnightTabels() {
        knightTabel1.put("R", Knight.KR1);
        knightTabel1.put("K", Knight.KK1);
        knightTabel1.put("P", Knight.KP1);
        knightTabel1.put("W", Knight.KW1);

        knightTabel2.put("R", Knight.KR2);
        knightTabel2.put("K", Knight.KK2);
        knightTabel2.put("P", Knight.KP2);
        knightTabel2.put("W", Knight.KW2);
    }

    private void initPyromancerTabels() {
        pyromancerTabel1.put("R", Pyromancer.PR1);
        pyromancerTabel1.put("K", Pyromancer.PK1);
        pyromancerTabel1.put("P", Pyromancer.PP1);
        pyromancerTabel1.put("W", Pyromancer.PW1);

        pyromancerTabel2.put("R", Pyromancer.PR2);
        pyromancerTabel2.put("K", Pyromancer.PK2);
        pyromancerTabel2.put("P", Pyromancer.PP2);
        pyromancerTabel2.put("W", Pyromancer.PW2);
    }

    private void initRogueTabels() {
        rogueTabel1.put("R", Rogue.RR1);
        rogueTabel1.put("K", Rogue.RK1);
        rogueTabel1.put("P", Rogue.RP1);
        rogueTabel1.put("W", Rogue.RW1);

        rogueTabel2.put("R", Rogue.RR2);
        rogueTabel2.put("K", Rogue.RK2);
        rogueTabel2.put("P", Rogue.RP2);
        rogueTabel2.put("W", Rogue.RW2);
    }

    private void initWizardTabels() {
        wizardTabel1.put("R", Wizard.WR1);
        wizardTabel1.put("K", Wizard.WK1);
        wizardTabel1.put("P", Wizard.WP1);
        wizardTabel1.put("W", Wizard.WW1);

        wizardTabel2.put("R", Wizard.WR2);
        wizardTabel2.put("K", Wizard.WK2);
        wizardTabel2.put("P", Wizard.WP2);
        wizardTabel2.put("W", Wizard.WW2);

    }

    public static ModifiersFactory getInstance() {
        if (instance == null) {
            instance = new ModifiersFactory();
        }
        return instance;
    }

    public Float getRogueModifiers2(final String hero) {
        return rogueTabel2.get(hero);
    }

    public Float getPyromancerModifiers2(final String hero) {
        return pyromancerTabel2.get(hero);
    }


    public void setModifiersKnight(final Map<String, Float> map, final Map<String, Float> map2) {
        map.put("R", Knight.KR1);
        map.put("K", Knight.KK1);
        map.put("P", Knight.KP1);
        map.put("W", Knight.KW1);

        map2.put("R", Knight.KR2);
        map2.put("K", Knight.KK2);
        map2.put("P", Knight.KP2);
        map2.put("W", Knight.KW2);
    }

    public void setModifiersPyromancer(final Map<String, Float> map,
                                       final Map<String, Float> map2) {
        map.put("R", Pyromancer.PR1);
        map.put("K", Pyromancer.PK1);
        map.put("P", Pyromancer.PP1);
        map.put("W", Pyromancer.PW1);

        map2.put("R", Pyromancer.PR2);
        map2.put("K", Pyromancer.PK2);
        map2.put("P", Pyromancer.PP2);
        map2.put("W", Pyromancer.PW2);
    }

    public void setModifiersRogue(final Map<String, Float> map, final Map<String, Float> map2) {
        map.put("R", Rogue.RR1);
        map.put("K", Rogue.RK1);
        map.put("P", Rogue.RP1);
        map.put("W", Rogue.RW1);

        map2.put("R", Rogue.RR2);
        map2.put("K", Rogue.RK2);
        map2.put("P", Rogue.RP2);
        map2.put("W", Rogue.RW2);
    }

    public void setModifiersWizard(final Map<String, Float> map, final Map<String, Float> map2) {
        map.put("R", Wizard.WR1);
        map.put("K", Wizard.WK1);
        map.put("P", Wizard.WP1);
        map.put("W", Wizard.WW1);

        map2.put("R", Wizard.WR2);
        map2.put("K", Wizard.WK2);
        map2.put("P", Wizard.WP2);
        map2.put("W", Wizard.WW2);
    }


    public void setModifiers(final String race, final float procent, final Hero hero) {
        if (hero.getModifiers1().get(race) != 1) {
            hero.getModifiers1().put(race, hero.getModifiers1().get(race) + procent);

        }
        if (hero.getModifiers2().get(race) != 1) {
            hero.getModifiers2().put(race, hero.getModifiers2().get(race) + procent);
            if (hero.getRace().equals("W") && race.equals("W")) {
                hero.getModifiers2().put("W", 0f);
            }
        }
    }

    public void changeModifiers(final float procent, final Hero hero) {
        setModifiers("K", procent, hero);
        setModifiers("P", procent, hero);
        setModifiers("R", procent, hero);
        setModifiers("W", procent, hero);
    }
}
