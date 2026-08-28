public class GameMaster {
    
    //string charclass = Character.getCharacterClass();
    //int level = Character.getLevel();
    //int hp = Character.getHitPoints();
    
    public String describe(String characterClass, int level, int hp) {
        return "You're a level " + level + " " + characterClass + " with " + hp + " hit points.";
}
    public String describe(Character character) {
        return describe(character.getCharacterClass(), character.getLevel(), character.getHitPoints());
    }
    
    public String describe(String name, int inhabitants){
        return "You've arrived at " +name+ ", which has " +inhabitants+ " inhabitants.";    
    }
    public String describe(Destination destination){
        return describe(destination.getName(), destination.getInhabitants());
    }
    public String describe(TravelMethod travelMethod) {
    if (travelMethod == TravelMethod.HORSEBACK) {
        return "You're traveling to your destination on horseback.";
    }
    return "You're traveling to your destination by walking.";
}
    public String describe(Character character, Destination destination, TravelMethod travelMethod) {
        return describe(character) + " " + describe(travelMethod) + " " + describe(destination);
    }
    public String describe(Character character, Destination destination) {
        return describe(character, destination, TravelMethod.WALKING);
    }
 

    // TODO: define a 'describe' method that returns a description of a Character, Destination and TravelMethod

    // TODO: define a 'describe' method that returns a description of a Character and Destination
}
