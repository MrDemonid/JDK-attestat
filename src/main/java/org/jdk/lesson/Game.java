package org.jdk.lesson;

import org.jdk.lesson.types.DoorType;

public class Game {

    private final Doors doors;
    private final Leading leading;
    private final Player player;

    public Game(int numDoors)
    {
        doors = new Doors(numDoors);
        leading = new Leading("Монти Холл", doors);
        player = new Player(numDoors);
    }

    /**
     * Игра.
     * @return true - если игрок выиграл
     */
    public boolean doGame()
    {
        // 1. Игрок выбирает дверь для открытия
        int curDoor = player.getFirstDoor();

        // 2. Ведущий открывает все двери с козами, оставляя только две - с козой и авто
        leading.openDoorWithGoat(curDoor);

        // 3. Ведущий предлагает игроку поменять дверь, игрок выбирает:
        int lastDoor = player.getLastDoor(doors.getClosedDoors());

        return doors.getDoor(lastDoor) == DoorType.Auto;
    }


}
