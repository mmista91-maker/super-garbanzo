class Fighter {
    

    boolean isVulnerable() {
        return true;
    }

    int getDamagePoints(Fighter fighter) {
        return 1;
    }
}
class Warrior extends Fighter{
    
    @Override    
    public String toString(){
        return "Fighter is a Warrior";
    }
    @Override
    boolean isVulnerable() {
    return false;
    }
    @Override
    int getDamagePoints(Fighter opponent){
    return opponent.isVulnerable() ? 10 : 6;}  
    
}

class Wizard extends Fighter{
    
    boolean spellReady = false;
    
    @Override    
    public String toString(){
        return "Fighter is a Wizard";
    }
    
    public void prepareSpell(){
    spellReady = true;
    }
    @Override
    boolean isVulnerable() {
    return !this.spellReady;
    }
    
    @Override
    int getDamagePoints(Fighter opponent){
    return  spellReady ? 12 : 3;
    }   
}