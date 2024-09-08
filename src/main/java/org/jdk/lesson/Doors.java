package org.jdk.lesson;

import lombok.Getter;
import lombok.ToString;
import org.jdk.lesson.types.DoorType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


@ToString
@Getter
public class Doors {

    private static final Random random = new Random();

    private int numDoors;
    private DoorType[] doors;

    public Doors(int numDoors) {
        initDoors(numDoors);
    }

    public DoorType getDoor(int index)
    {
        index = Math.min(Math.max(0, index), numDoors);     // усекаем в допустимый диапазон
        return doors[index];
    }

    /**
     * Открываем дверь и возвращаем что за ней было
     */
    public DoorType openDoor(int index)
    {
        int idx = clampIndex(index);
        DoorType res = doors[idx];
        doors[idx] = DoorType.Open;
        return res;
    }

    /**
     * Возвращает массив индексов закрытых дверей
     */
    public int[] getClosedDoors()
    {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < doors.length; i++)
        {
            if (doors[i] != DoorType.Open)
                res.add(i);
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }


    private int clampIndex(int index)
    {
        return Math.min(Math.max(0, index), numDoors);     // усекаем в допустимый диапазон
    }

    private void initDoors(int numDoors)
    {
        this.numDoors = numDoors;
        doors = new DoorType[numDoors];
        Arrays.fill(doors, DoorType.Goat);
        doors[random.nextInt(numDoors)] = DoorType.Auto;
    }


}
