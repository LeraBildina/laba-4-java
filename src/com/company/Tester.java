package com.company;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Этот класс проверяет скорость методов списка
 */
public class Tester {

    /**
     * Количество итераций, которые используются в тестировании: добавление, удаление, получение
     */
    public int count;

    /**
     * Список, который проходит тестирование
     */
    private List<Object> list;

    /**
     * Конструктор
     * @param list -  список
     * @param initialize -  начальный размер списка
     * @param count - количество итераций
     */
    public Tester(List<Object> list, int initialize, int count) {
        this.list = list;
        this.count = count;
        setup(initialize);
    }

    /**
     * Этот метод добавляет initialize объектов в список
     * @param initialize - начальный размер списка
     */
    protected void setup(int initialize) {
        for (int i = 0; i < initialize; i++) {
            list.add(new Object());
        }
    }

    /**
     * Этот метод возвращает map скорости метода добавления в начало, середину и конец списка
     * @return map
     */
    public Map<Position, Long> testAdd() {
        Map<Position, Long> map = new HashMap<>();
        map.put(Position.BEGIN, testAddTo(Position.BEGIN));
        map.put(Position.MIDDLE, testAddTo(Position.MIDDLE));
        map.put(Position.END, testAddTo(Position.END));
        return map;
    }

    /**
     * Этот метод возвращает карту скорости метода получения из начала, середины и конца списка
     * @return map
     */
    public Map<Position, Long> testGet() {
        Map<Position, Long> map = new HashMap<>();
        map.put(Position.BEGIN, testGetFrom(Position.BEGIN));
        map.put(Position.MIDDLE, testGetFrom(Position.MIDDLE));
        map.put(Position.END, testGetFrom(Position.END));
        return map;
    }

    /**
     * Этот метод возвращает карту скорости метода удаления из начала, середины и конца списка
     * @return map
     */
    public Map<Position, Long> testDelete() {
        Map<Position, Long> map = new HashMap<>();
        map.put(Position.BEGIN, testDeleteFrom(Position.BEGIN));
        map.put(Position.MIDDLE, testDeleteFrom(Position.MIDDLE));
        map.put(Position.END, testDeleteFrom(Position.END));
        return map;
    }

    /**
     * Этот метод возвращает время, необходимое для добавления k элементов на позицию
     * @param position - место, куда добавляются элементы
     * @return time
     */
    protected long testAddTo(Position position) {
        long start = System.nanoTime();
        for(int i = 0; i < count; i++) {
            list.add(defineIndex(position), new Object());
        }
        long finish = System.nanoTime();
        return finish - start;
    }

    /**
     * Этот метод возвращает время, необходимое для получения k элементов
     * @param position - место, куда добавляются элементы
     * @return time
     */
    protected long testGetFrom(Position position) {
        long start = System.nanoTime();
        for(int i = 0; i < count; i++) {
            Object object = list.get(defineIndex(position));
        }
        long finish = System.nanoTime();
        return finish - start;
    }

    /**
     * Этот метод возвращает время, необходимое для удаления k элементов
     * @param position - место, куда добавляются элементы
     * @return time
     */
    protected long testDeleteFrom(Position position) {
        long start = System.nanoTime();
        for(int i = 0; i < count; i++) {
            list.remove(defineIndex(position));
        }
        long finish = System.nanoTime();
        return finish - start;
    }

    /**
     * Преобразование значения перечисления в индекс для списка
     * @param position - позиция добавления элементов
     * @return index
     */
    protected int defineIndex(Position position) {
        switch (position) {
            case BEGIN: {
                return 0;
            }
            case MIDDLE: {
                return list.size() / 2;
            }
            case END: {
                return list.size() - 1;
            }
        }
        return 0;
    }
}