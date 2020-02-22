package main;

import ability.OvertimeAbilities;
import angels.*;
import comparators.ColumnComparator;
import comparators.RawComparator;
import constants.Constants;

import hero.Hero;
import hero.HeroActions;
import hero.HeroFactory;
import hero.Initialisation;

import modifiers.LandModifiers;
import movement.Direction;
import movement.Map;
import thegreatmagician.LevelUp;
import thegreatmagician.TheGreatMagician;
import thegreatmagician.Powers;
import thegreatmagician.Position;
import thegreatmagician.AngelLife;

import java.io.IOException;
import java.io.PrintStream;
import java.util.LinkedList;

public class Main {
    public static void main(final String[] args) throws IOException {
        InputReader inputReader = new InputReader();
        inputReader.reader(args[0]);

        Map map = new Map(inputReader.getLandType(), inputReader.getN(), inputReader.getM());

        LinkedList<Hero> heroes = new LinkedList<>();
        HeroFactory heroFactory = HeroFactory.getInstance();
        HeroActions actions = new HeroActions();
        Initialisation init = new Initialisation();

        LinkedList<Angel> angels = new LinkedList<Angel>();
        AngelFactory angelFactory = AngelFactory.getInstance();
        Actions actionsAngel = new Actions();

        //setting the output writing
        PrintStream file = new PrintStream(args[1]);
        System.setOut(file);

        int i, j;

        //heroes
        for (i = 0; i < inputReader.getP(); i++) {
            heroes.add(heroFactory.createHero(inputReader.getPlayerType().get(i)));
        }
        //angels
        for (i = 0; i < inputReader.getAngelType().size(); i++) {
            angels.add(angelFactory.createAngel(inputReader.getAngelType().get(i)));
        }


        //it sets the position of an angel
        actionsAngel.setUpRaw(angels, inputReader.getRawAngels(), inputReader.getColumnAngels());
        actionsAngel.setUpType(angels, inputReader.getAngelType());

        actions.setUpRace(heroes, inputReader.getPlayerType());
        //sets the XP and perLevel values
        init.initHeroes(heroes, inputReader.getPlayerType());
        //sets the directions for each hero
        //sets the initial positions
        actions.setUpPosition(heroes, inputReader.getPosInit1(), inputReader.getPosInit2()); //merge
        //it initializes the modifiers for all heroes
        actions.initialiseModifiers(heroes);
        //it sets the flags
        actions.initialiseFlags(heroes);

        int r, start = 0, count = 0, round, level1, level2;

        Direction move = new Direction();
        RawComparator rawComparator = new RawComparator();
        ColumnComparator columnComparator = new ColumnComparator();
        LandModifiers landModifiers = new LandModifiers();

        TheGreatMagician theGreatMagician = TheGreatMagician.getInstance();

        for (r = 0; r < inputReader.getR(); r++) {
            round = r + 1;
            //it writes in the file the number of the round
            System.out.println("~~ Round " + round + " ~~");
            //initialise damage and withoutModifiers
            actions.initialise(heroes);
            //initialise the direction
            actions.setUpDirection(heroes, inputReader.getPlayerRoute(), r);
            //the strategies for heroes
            for (i = 0; i < heroes.size(); i++) {
                heroes.get(i).newFeatures(heroes.get(i));
            }
            //heroes change their positions and move on map
            move.executeMove(heroes);
            //applies overtime abilities
            for (i = heroes.size() - 1; i >= 0; i--) {
                //ignite
                if (heroes.get(i).getIgnite() == 1 && heroes.get(i).getNoLessDamage() != 0) {
                    OvertimeAbilities overtime = new OvertimeAbilities();
                    overtime.ignite(heroes.get(i), args[1]);
                }
                //paralysis
                if (heroes.get(i).getStandStill() == 1 && heroes.get(i).getNoMoves() != 0) {
                    OvertimeAbilities overtime = new OvertimeAbilities();
                    overtime.paralysis(heroes.get(i));
                }
            }

            //the fight
            for (i = 0; i < heroes.size(); i++) {
                for (j = i + 1; j < heroes.size(); j++) {
                    //verifies if they have the same positions
                    if (j != i && rawComparator.compare(heroes.get(i), heroes.get(j))
                            == Constants.NULL
                            && columnComparator.compare(heroes.get(i), heroes.get(j))
                            == Constants.NULL) {
                        //it saves the current levels
                        level1 = heroes.get(i).getLevel();
                        level2 = heroes.get(j).getLevel();
                        //sets the type of land for each position
                        landModifiers.setLocation(heroes.get(i), map);
                        landModifiers.setLocation(heroes.get(j), map);

                        //fight:
                        if (heroes.get(j).getDead() == Constants.NULL
                                && heroes.get(i).getDead() == Constants.NULL) {
                            if (heroes.get(i).getRace().equals("W")) {
                                heroes.get(i).fightsWith(heroes.get(j));
                                heroes.get(j).fightsWith(heroes.get(i));
                            } else if (heroes.get(j).getRace().equals("W")) {
                                heroes.get(j).fightsWith(heroes.get(i));
                                heroes.get(i).fightsWith(heroes.get(j));
                            } else {
                                heroes.get(j).fightsWith(heroes.get(i));
                                heroes.get(i).fightsWith(heroes.get(j));
                            }

                            //sets the HP for the fighters
                            heroes.get(i).setHP(heroes.get(i).getHP()
                                    - (int) heroes.get(i).getDamage());
                            heroes.get(j).setHP(heroes.get(j).getHP()
                                    - (int) heroes.get(j).getDamage());

                            //it verifies if a fighter died and it notices the great magician
                            TheGreatMagician.getInstance().getObserverList().clear();
                            actions.verifyIfItsDead(heroes.get(j), heroes.get(i), args[1]);
                            actions.verifyIfItsDead(heroes.get(i), heroes.get(j), args[1]);

                            //it notices the great magician if an hero will level up after a fight
                            TheGreatMagician.getInstance().getObserverList().clear();
                            actions.showsTheLevels(heroes.get(i), level1);
                            actions.showsTheLevels(heroes.get(j), level2);
                            actions.finalLevel(heroes.get(i), level1);
                            actions.finalLevel(heroes.get(j), level2);

                            break;
                        }
                    }
                }
            }

            //the appearance of angels
            Behavior behavior = new Behavior();
            Position position1 = new Position();
            AngelLife angelLife1 = new AngelLife();
            LevelUp levelUp = new LevelUp();
            Powers powers1 = new Powers();

            int lvl;
            count += inputReader.getNoAngelsperRound()[r];

            if (inputReader.getNoAngelsperRound()[r] != 0) {
                for (i = start; i < count; i++) {
                    //it adds the observers
                    TheGreatMagician.getInstance().add(position1);
                    TheGreatMagician.getInstance().execute(null, angels.get(i), null);
                    TheGreatMagician.getInstance().getObserverList().clear();
                    theGreatMagician.add(powers1);
                    theGreatMagician.add(angelLife1);
                    theGreatMagician.add(levelUp);
                    //it verifies if on the angel's position is an hero
                    for (j = 0; j < heroes.size(); j++) {
                        if (angels.get(i).getRawAngel() == heroes.get(j).getRaw()
                                && angels.get(i).getColumnAngel() == heroes.get(j).getColumn()) {
                            lvl = heroes.get(j).getLevel();
                            angels.get(i).accept(behavior, heroes.get(j));

                            //it verifies if an hero is dead and it sets the flag
                            if (heroes.get(j).getHP() < 0) {
                                heroes.get(j).setDead(1);
                            }
                            //it verifies if it is needed to level up
                            if (lvl < actions.verifyLevel(heroes.get(j))) {
                                actions.XP_level_up(heroes.get(j));
                            }
                            if (angels.get(i).getType().equals("LifeGiver")) {
                                actions.XP_level_up(heroes.get(j));
                            }
                            //it notices the Great Magician
                            TheGreatMagician.getInstance().execute(
                                    heroes.get(j), angels.get(i), null);
                        }
                    }
                    TheGreatMagician.getInstance().getObserverList().clear();
                }

            }
            start += inputReader.getNoAngelsperRound()[r];
            TheGreatMagician.getInstance().getObserverList().clear();
            System.out.println();
        }
        //it writes the output
        OutputWriter outputWriter = new OutputWriter();
        outputWriter.outputWriter(heroes, inputReader);
    }

}

