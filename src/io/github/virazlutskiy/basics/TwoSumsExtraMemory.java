package io.github.virazlutskiy.basics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TwoSumsExtraMemory {
    public static void main(String[] args)throws IOException {
        List<Integer> arr;
        int n,k;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            n = Integer.parseInt(reader.readLine().strip());
            arr = Arrays.asList(reader.readLine().strip().split(" "))
                    .stream()
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            k = Integer.parseInt(reader.readLine().strip());
        }
        arr.sort(Comparator.naturalOrder());
        int pointer1 = 0;
        int pointer2 = arr.size()-1;
        boolean founded = false;
        for(int i =0;i<arr.size()-1;i++){
            if (arr.get(pointer1)+arr.get(pointer2) == k){
                founded = true;
                break;
            }else if (arr.get(pointer1)+arr.get(pointer2) < k){
                pointer1++;
            }else{
                pointer2--;
            }
        }
        if (!founded){
            System.out.println("None");
        }else {
            System.out.printf("%d %d", arr.get(pointer1),arr.get(pointer2));
        }
    }
}
