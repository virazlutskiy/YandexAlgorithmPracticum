package io.github.virazlutskiy.basics;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/*
функция twosum_extra_ds(numbers, X):
    # Создаём вспомогательную структуру данных с быстрым поиском элемента.
    previous = set()

    для каждого A из numbers:
        Y = X - A
        если Y уже лежит в previous, то:
            вернуть A, Y
        иначе:
            добавить A в previous

    # Если ничего не нашлось в цикле, значит, нужной пары элементов в массиве нет.
    вернуть None, None

 */


public class TwoSumsSorted {
    public static void main(String[] args)throws IOException {
        List<Integer> arr;
        int n,k;
        boolean founded = false;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            n = Integer.parseInt(reader.readLine().strip());
            arr = Arrays.asList(reader.readLine().strip().split(" "))
                    .stream()
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            k = Integer.parseInt(reader.readLine().strip());
        }
        HashSet<Integer> set=new HashSet();
        for(int el : arr){
            if(set.contains(k-el)){
                System.out.printf("%d %d", k-el,el);
                founded = true;
                break;
            }else{
                set.add(el);
            }
        }
        if (!founded){
            System.out.println("None");
        }
    }
}
