class Robot {

    private GridPosition currentPosition;
    private Orientation currentOrientation;

    Robot(GridPosition initialPosition, Orientation initialOrientation) {        
         this.currentPosition = initialPosition;
         this.currentOrientation = initialOrientation;
    }

    GridPosition getGridPosition() {
        return currentPosition;
    }

    Orientation getOrientation() {
        return currentOrientation;
    }

    void advance() {
        switch (currentOrientation) {
        case NORTH:
            currentPosition = new GridPosition(
                currentPosition.x,
                currentPosition.y + 1
            );
            break;
        case EAST:
            currentPosition = new GridPosition(
                currentPosition.x + 1,
                currentPosition.y
            );
            break;
        case WEST:
            currentPosition = new GridPosition(
                currentPosition.x - 1,
                currentPosition.y
            );
            break;
        case SOUTH:
            currentPosition = new GridPosition(
                currentPosition.x,
                currentPosition.y - 1
            );
            break;
    }
    }

    void turnLeft() {
        switch (currentOrientation){
            case NORTH:
                currentOrientation = Orientation.WEST;
                break;
            case EAST:
                currentOrientation = Orientation.NORTH;
                break;
            case SOUTH:
                currentOrientation = Orientation.EAST;
                break;
            case WEST:
                currentOrientation = Orientation.SOUTH;
                break;
        }
    }

    void turnRight() {
        switch (currentOrientation){
            case NORTH:
                currentOrientation = Orientation.EAST;
                break;
            case EAST:
                currentOrientation = Orientation.SOUTH;
                break;
            case SOUTH:
                currentOrientation = Orientation.WEST;
                break;
            case WEST:
                currentOrientation = Orientation.NORTH;
                break;
        }
    }

    void simulate(String instructions) {
        
        for (int i = 0; i < instructions.length(); i++) {
            char instruction = instructions.charAt(i);
    
        switch (instruction) {
            case 'R' -> turnRight();
            case 'L' -> turnLeft();
            case 'A' -> advance();
        }
        }
    }    

}