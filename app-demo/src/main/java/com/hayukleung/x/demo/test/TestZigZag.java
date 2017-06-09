package com.hayukleung.x.demo.test;

import java.util.HashMap;

/**
 * X
 * com.hayukleung.x.demo
 * TestZigZag.java
 *
 * by hayukleung
 * at 2017-05-14 16:33
 */

public class TestZigZag {

  public static int[] twoSum(int[] numbers, int target) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < numbers.length; i++) {
      if (map.get(numbers[i]) != null) {
        int[] result = { map.get(numbers[i]) + 1, i + 1 };
        return result;
      } else {
        map.put(target - numbers[i], i);
      }
    }
    int[] result = {};
    return result;
  }

  public static void main(String[] args) {
    // int[] input = { 1, 2, 3, 4 };
    // int[] output = twoSum(input, 4);
    // System.out.println(String.format(Locale.CHINA, "{%d, %d}", output[0], output[1]));

    String input = "0123456789";
    System.out.println(zigzag(input, 1));
    System.out.println(zigzag(input, 2));
    System.out.println(zigzag(input, 3));
    System.out.println(zigzag(input, 4));
    System.out.println(zigzag(input, 5));
    System.out.println(zigzag(input, 6));
    System.out.println(zigzag(input, 7));
    System.out.println(zigzag(input, 8));
    System.out.println(zigzag(input, 9));
    System.out.println(zigzag(input, 10));
    System.out.println(zigzag(input, 11));
  }

  public static String zigzag(String input, int size) {
    String output = "";
    int length = input.length();
    if (1 == size) {
      output = input;
    } else {
      for (int i = 0; i < size; i++) {
        int delta = (size - i - 1) * 2;
        int deltaReverse = (size - 1) * 2 - delta;
        deltaReverse = (0 == deltaReverse ? (size - 1) * 2 : deltaReverse);
        boolean flag = false;
        for (int j = i; j < length; j += (flag ? delta : deltaReverse)) {
          output += input.substring(j, j + 1);
          if (0 == i || size - 1 == i) {
          } else {
            flag = !flag;
          }
        }
      }
    }
    return output;
  }
}
