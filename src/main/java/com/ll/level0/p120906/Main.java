package com.ll.level0.p120906;

public class Main {
    public static void main (String[] args){

    }
}
class Solution {

    public int solution(int n) {
        return (n + "") // 123=> "123"
                .chars() // "123" => intStream[49, 50, 51]
                .map(e -> Character.getNumericValue(e)) // intStream[49, 50, 51] => intStream[1, 2, 3]
                .sum(); // intStream[1, 2, 3] => 6
    }

        public int solutionV1(int n) {
            return (n + "") // 123 => "123"
                    .chars() // "123" => intStream[49, 50, 51]
                    .map(Character::getNumericValue) // intStream[49, 50, 51] => intStream[1, 2, 3]
                    .sum(); // intStream[1, 2, 3] => 6
        }


    public int solutionV2(int n){
        String nStr = n + "";
        int sum = 0;
        for ( int i = 0; i < nStr.length(); i++){
            char c =nStr.charAt(i); //charAt 문장을 이루고 있는 i 번째 글자
            sum += Character.getNumericValue(c);
        }
        return sum;
    }

}
