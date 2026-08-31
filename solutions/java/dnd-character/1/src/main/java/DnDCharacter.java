import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class DnDCharacter {

    private int strength = ability(rollDice());
    private int dexterity = ability(rollDice());
    private int constitution = ability(rollDice());
    private int intelligence = ability(rollDice());
    private int wisdom = ability(rollDice());
    private int charisma = ability(rollDice());


    int ability(List<Integer> scores) {
        int sum = 0;
        int lowest = Collections.min(scores);
        for (int score : scores) {
        sum += score;
}
        return sum - lowest;
    }

    List<Integer> rollDice() {    
    List<Integer> rolls = new ArrayList<>();
    for (int i = 0; i < 4; i++) {
        int roll = (int)(Math.random() * 6) + 1;
        rolls.add(roll);
        }
    return rolls;    
    }

    int modifier(int input) {
        return (int) Math.floor((input - 10)/2.0);
    }

    int getStrength() {
        return strength;
    }

    int getDexterity() {
        return dexterity;
    }

    int getConstitution() {
        return constitution;
    }

    int getIntelligence() {
        return intelligence;
    }

    int getWisdom() {
        return wisdom;
    }

    int getCharisma() {
        return charisma;
    }

    int getHitpoints() {
        return 10+modifier(constitution);
    }
}
