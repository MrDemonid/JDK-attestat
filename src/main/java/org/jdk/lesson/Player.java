package org.jdk.lesson;

import java.util.Random;

public class Player {

    private final Random random = new Random();

    private final int numDoors;
    private int curDoor;

    public Player(int numDoors) {
        this.numDoors = numDoors;
        this.curDoor = -1;
    }

    /**
     * Первый ход игрока - выбор двери для открывания
     */
    public int getFirstDoor()
    {
        curDoor = random.nextInt(numDoors);
        return curDoor;
    }

    /**
     * Игрок окончательно решает - либо меняет выбранную дверь, либо оставляет выбранную
     * @param doors массив доступных (закрытых) дверей
     */
    public int getLastDoor(int[] doors)
    {
        return doors[random.nextInt(doors.length)];     // сделаем случайный выбор
    }

}
