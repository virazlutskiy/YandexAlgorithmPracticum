package io.github.virazlutskiy.basics;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MovingAverage {
    /*функция скользящее_среднее(timeseries, K):
    result = []  # Пустой массив.
            # Первый раз вычисляем значение честно и сохраняем результат.
    current_sum = сумма элементов timeseries[0..K)
            result.добавить(current_sum / K)
    для i из [0 .. len(timeseries) - K):
    current_sum -= timeseries[i]
    current_sum += timeseries[i+K]
    current_avg = current_sum / K
        result.добавить(current_avg)
    вернуть result
    */
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
        List<Float> result = new ArrayList<Float>();// Пустой массив.
        float current_sum = 0;
        for (int i = 0; i < k; i++){
            current_sum += arr.get(i);
        }
        result.add(current_sum / k);

        for (int i = 0; i<n-k;i++){
            current_sum -= arr.get(i);
            current_sum += arr.get(i + k);
            result.add(current_sum / k);
        }
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        for (float i : result) {
            writer.write(String.valueOf(i));
            writer.write(" ");
        }
        writer.flush();
    }
}
