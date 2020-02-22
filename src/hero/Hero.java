package hero;

import java.util.HashMap;
import java.util.Map;

public class Hero implements Heroes {

    private int raw;
    private int column;
    private int hp;
    private float xp;
    private int level;
    private char direction;
    private int perLevel;
    private float damage;
    private char location;
    private String race;
    private int standStill;
    private float withoutModifiers;
    private float bonusLand;
    private int dead;
    private int ignite;
    private int noMoves;
    private Hero paralysis;
    private Hero pyrStriker;
    private int noLessDamage;
    private int critical;
    private int broughtToLife;
    private int number;
    private int numberStriker;
    private int killedbyAngel;
    private int killedbyHero;
    private int reachedLevel;
    private int levelBefore;
    private int beenThere;
    private Map<String, Float> modifiers1 = new HashMap<>();
    private Map<String, Float> modifiers2 = new HashMap<>();


    public final Map<String, Float> getModifiers1() {
        return modifiers1;
    }

    public final void setModifiers1(final Map<String, Float> modifiers) {
        this.modifiers1 = modifiers;
    }

    public final Map<String, Float> getModifiers2() {
        return modifiers2;
    }

    public final void setModifiers2(final Map<String, Float> modifiers) {
        this.modifiers2 = modifiers;
    }

    public final int getBeenThere() {
        return beenThere;
    }

    public final void setBeenThere(final int beenThere) {
        this.beenThere = beenThere;
    }

    public final int getLevelBefore() {
        return levelBefore;
    }

    public final void setLevelBefore(final int levelBefore) {
        this.levelBefore = levelBefore;
    }

    public final int getReachedLevel() {
        return reachedLevel;
    }

    public final void setReachedLevel(final int reachedLevel) {
        this.reachedLevel = reachedLevel;
    }

    public final int getKilledbyHero() {
        return killedbyHero;
    }

    public final void setKilledbyHero(final int killedbyHero) {
        this.killedbyHero = killedbyHero;
    }

    public final int getKilledbyAngel() {
        return killedbyAngel;
    }

    public final void setKilledbyAngel(final int killedbyAngel) {
        this.killedbyAngel = killedbyAngel;
    }

    public final void setNumberStriker(final int numberStriker) {
        this.numberStriker = numberStriker;
    }

    public final int getNumberStriker() {
        return numberStriker;
    }

    public final int getNumber() {
        return number;
    }

    public final void setNumber(final int number) {
        this.number = number;
    }

    public final int getNoLessDamage() {
        return noLessDamage;
    }

    public final void setNoLessDamage(final int noLessDamage) {
        this.noLessDamage = noLessDamage;
    }

    public final Hero getPyrStriker() {
        return pyrStriker;
    }

    public final void setPyrStriker(final Hero pyrStriker) {
        this.pyrStriker = pyrStriker;
    }

    public final int getCritical() {
        return critical;
    }

    public final void setCritical(final int critical) {
        this.critical = critical;
    }

    public final Hero getParalysis() {
        return paralysis;
    }

    public final void setParalysis(final Hero paralysis) {
        this.paralysis = paralysis;
    }

    public final int getNoMoves() {
        return noMoves;
    }

    public final void setNoMoves(final int noMoves) {
        this.noMoves = noMoves;
    }

    public final int getIgnite() {
        return ignite;
    }

    public final void setIgnite(final int ignite) {
        this.ignite = ignite;
    }

    public final int getDead() {
        return dead;
    }

    public final void setDead(final int dead) {
        this.dead = dead;
    }

    public final void setPerLevel(final int perLevel) {
        this.perLevel = perLevel;
    }

    public final char getDirection() {
        return direction;
    }

    public final void setDirection(final char direction) {
        this.direction = direction;
    }

    public final float getXP() {
        return xp;
    }

    public final void setXP(final float xp) {
        this.xp = xp;
    }

    public final int getHP() {
        return hp;
    }

    public final void setHP(final int hp) {
        this.hp = hp;
    }

    public final int getLevel() {
        return level;
    }

    public final void setLevel(final int level) {
        this.level = level;
    }

    public final int getRaw() {
        return raw;
    }

    public final void setRaw(final int raw) {
        this.raw = raw;
    }

    public final int getColumn() {
        return column;
    }

    public final void setColumn(final int column) {
        this.column = column;
    }

    public final float getDamage() {
        return damage;
    }

    public final float getWithoutModifiers() {
        return withoutModifiers;
    }

    public final void setWithoutModifiers(final float withoutModifiers) {
        this.withoutModifiers = withoutModifiers;
    }

    public final void setDamage(final float damage) {
        this.damage = damage;
    }

    public final char getLocation() {
        return location;
    }

    public final void setLocation(final char location) {
        this.location = location;
    }

    public final String getRace() {
        return race;
    }

    public final void setRace(final String race) {
        this.race = race;
    }

    public final int getStandStill() {
        return standStill;
    }

    public final void setStandStill(final int standStill) {
        this.standStill = standStill;
    }

    public final int getBroughtToLife() {
        return broughtToLife;
    }

    public final void setBroughtToLife(final int broughtToLife) {
        this.broughtToLife = broughtToLife;
    }

    public final float getBonusLand() {
        return bonusLand;
    }

    public final void setBonusLand(final float bonusLand) {
        this.bonusLand = bonusLand;
    }

    @Override
    public void newFeatures(final Hero hero) {


    }

    @Override
    public void fightsWith(final Hero hero) {

    }

    @Override
    public void interactWith(final Knight knight) {

    }

    @Override
    public void interactWith(final Pyromancer pyromancer) {

    }

    @Override
    public void interactWith(final Rogue rogue) {

    }

    @Override
    public void interactWith(final Wizard wizard) {

    }

    @Override
    public void addLandModifier(final Hero hero) {

    }
}
