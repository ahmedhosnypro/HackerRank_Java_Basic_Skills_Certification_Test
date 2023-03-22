package org.test;

public class TypeCounter {
    /*
     * Identify the different data types present in an input string and report their counts. Each of the substrings, separated by one or more spaces, is one of either the String, Integer, or Double type. Print the results on 3 lines in the order shown in the example. If a type does not occur, report that type with a count of 0.
     */
    public static void typeCounter(String sentence) {
        String[] words = sentence.split(" ");
        int stringCount = 0;
        int integerCount = 0;
        int doubleCount = 0;
        for (String word : words) {
           try{
               Double.parseDouble(word);
               doubleCount++;
           }catch (NumberFormatException e){
               try{
                   Integer.parseInt(word);
                   integerCount++;
               }catch (NumberFormatException ex){
                   stringCount++;
               }
           }
        }
        System.out.println(stringCount);
        System.out.println(integerCount);
        System.out.println(doubleCount);
    }
}
