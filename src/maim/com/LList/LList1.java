package maim.com.LList;

import maim.com.IList;

class Node {
    Integer data;
    Node next;

    public Node(Integer data){
        this.data = data;
    }
}

public class LList1 implements IList {
    Integer[] ar;
    Node head;


    public LList1(Integer[] ar) {
        for (int num:ar) {
            add(num);
        }
    }

    public void clear(){
        head = null;
    }

    public int size() {
        int i = 0;
        Node current = head;
        while (current != null) {
            i += 1;
            current = current.next;
        }
        return i;
    }

    @Override
    public int get(int index) {
        int[] arr = toArray();
        return arr[index];
    }

    public boolean add(int data) {
        int num1 = size();
        if (head == null)
        {
            head = new Node(data);
            return true;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Node(data);
        int num2 = size();
        if(num2 == num1){
            return false;
        }
        else {
            return true;
        }
    }

    @Override
    public boolean add(int index, int value) {
        int[] arr = toArray();
        if (index >= arr.length){
            return false;
        }
        else {
            clear();
            for(int i = 0; i < index; i++){
                add(arr[i]);
            }
            add(value);
            for(int i = index; i < arr.length; i++){
                add(arr[i]);
            }
            return true;
        }


    }

    @Override
    public boolean remove(int number) {
        int[] arr = toArray();
        if (contains(number)){
            removeByIndex(getIndex(number, arr));
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public int removeByIndex(int index) {
        int[] arr = toArray();
        if (index < arr.length){
            clear();
            for(int i = 0; i < arr.length; i++){
                if(i == index){
                    continue;
                }
                add(arr[i]);
            }
            return index;
        }
        else {
            return -1;
        }

    }

    @Override
    public boolean contains(int value) {
        int[] arr = toArray();
        for (int num: arr){
            if (num == value){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean set(int index, int value) {
        int[] arr = toArray();
        if (index >= arr.length){
            return false;
        }
        else {
            clear();
            for(int i = 0; i < index; i++){
                add(arr[i]);
            }
            add(value);
            for(int i = index+1; i < arr.length; i++){
                add(arr[i]);
            }
            return true;
        }
    }

    public void print() {
        Node current = head;
        if(current == null){
            System.out.println("[]");
        }
        else {
            System.out.print("[");
            while (current.next != null) {
                System.out.print(current.data + ", ");
                current = current.next;
            }
            System.out.println(current.data+"]");
        }
    }

    @Override
    public int[] toArray() {
        int[] Arr;
        Node current = head;
        if(current == null){
            Arr = new int[0];
        }
        else {
            int[] helpArr = new int[size()];
            int iterator = 0;
            for(int i = 0; i < size(); i++){
                helpArr[iterator] = current.data ;
                current = current.next;
                iterator++;
            }
            Arr = helpArr;
        }
        return Arr;
    }

    @Override
    public boolean removeAll(int[] ar) {
        int[] arr = toArray();
        boolean isContains = false;

        for(int num1: ar){
            for (int num2: arr) {
                if (num1 == num2){
                    isContains = true;
                    break;
                }
            }
        }

        if (isContains){
            for(int num: ar){
                remove(num);
            }
            return true;
        }
        else {
            return false;
        }
    }

    private int getIndex(int number, int[] arr){
        int index = -1;
        for (int i = 0; i < arr.length; i++){
            if(number == arr[i]){
                index = i;
            }
        }
        return index;
    }

}

