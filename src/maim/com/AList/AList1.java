package maim.com.AList;

import maim.com.IList;

import java.util.Arrays;

public class AList1 implements IList{
    private int capacity;
    private Integer[] array;

    public AList1() {
        capacity = 10;
        array = new Integer[capacity];
    }

    public AList1(int capacity) {
        this.capacity = capacity;
        array = new Integer[capacity];
    }

    public AList1(Integer[] array) {
        this.array = array;
        capacity = array.length;
    }

    @Override
    public void clear() {
        array = new Integer[0];
    }

    @Override
    public int size() {
        return array.length;
    }

    @Override
    public int get(int index) {
        return array[index];
    }

    @Override
    public boolean add(int value) {
        int amount = 0;
        for (int i = 0; i < array.length; i++) {
            if((array[i]+"").equals("null")){
                array[i] = value;
                amount++;
                return true;
            }
        }
        if (amount == 0){
            Integer[] helpArr = new Integer[array.length*2];
            for (int i = 0; i < array.length; i++){
                helpArr[i] = array[i];
            }
            helpArr[array.length] = value;
            array = helpArr;
            return true;
        }
        return false;
    }

    @Override
    public boolean add(int index, int value) {
        if(index < array.length){
            Integer[] helpArr = new Integer[array.length+1];
            for(int i = 0; i < index; i++){
                helpArr[i] = array[i];
            }
            helpArr[index] = value;
            for(int i = index+1; i < array.length+1; i++){
                helpArr[i] = array[i-1];
            }
            array = helpArr;
            return true;
        }
        else {
//            Integer[] helpArr = new Integer[index+5];
//            for (int i = 0; i < array.length; i++){
//                helpArr[i] = array[i];
//            }
//            helpArr[index] = value;
//            array = helpArr;
            return false;
        }
    }

    @Override
    public boolean remove(int number) {
        int index = -1;

        for(int i = 0; i < array.length; i++){
            if(array[i] == number){
                index = i;
                break;
            }
        }

        if(index == -1){
            return false;
        }
        else {
            Integer[] helpArr = new Integer[array.length-1];
            for (int i = 0; i < index; i++){
                helpArr[i] = array[i];
            }
            for (int i = index+1; i < array.length; i++){
                helpArr[i-1] = array[i];
            }
            array = helpArr;
            return true;
        }
    }

    @Override
    public int removeByIndex(int index) {
        if(index >= array.length){
            return -1;
        }
        else {
            Integer[] helpArr = new Integer[array.length-1];
            for (int i = 0; i < index; i++){
                helpArr[i] = array[i];
            }
            for (int i = index+1; i < array.length; i++){
                helpArr[i-1] = array[i];
            }
            array = helpArr;
            return index;
        }
    }

    @Override
    public boolean contains(int value) {
        for (Integer num:array) {
            if (num == null){
                continue;
            }
            else {
                if(num == value){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean set(int index, int value) {
        if(index < array.length){
            array[index] = value;
            return true;
        }
        return false;
    }

    @Override
    public void print() {
        System.out.println(Arrays.toString(array));
    }

    @Override
    public int[] toArray() {
        int[] helpArr = new int[array.length];
        for(int i = 0; i < array.length; i++){
            helpArr[i] = array[i];
        }
        return helpArr;
    }

    @Override
    public boolean removeAll(int[] ar) {
        Integer[] arrayCMP = array;
        for(int i = 0; i < ar.length; i++){
            remove(ar[i]);
        }

        if(array != arrayCMP){
            return true;
        }
        return false;
    }
}

