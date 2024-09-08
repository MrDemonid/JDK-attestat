package org.jdk.lesson;

import lombok.ToString;
import org.jdk.lesson.types.DoorType;

import java.util.Random;

@ToString
public class Leading {

    private final Random random = new Random();
    String name;
    Doors doors;


    public Leading(String name, Doors doors) {
        this.name = name;
        this.doors = doors;
    }

    /**
     * Открывает все двери, оставляя только две:
     *      1) которую выбрал игрок
     *      2) любая другая, лишь бы за одной из оставшихся дверей был автомобиль
     * @param curDoor выбранная игроком дверь
     */
    public void openDoorWithGoat(int curDoor)
    {
        int k = curDoor;

        while (doors.getDoor(k) == DoorType.Auto)
        {
            k = random.nextInt(doors.getNumDoors());
        }
        // теперь открываем все оставшиеся, за исключением той, за которой автомобиль
        // в итоге у нас останется только две двери - с козой и автомобилем
        for (int i = 0; i < doors.getNumDoors(); i++)
        {
            if (i != k && doors.getDoor(i) != DoorType.Auto)
                doors.openDoor(i);
        }
    }


}
