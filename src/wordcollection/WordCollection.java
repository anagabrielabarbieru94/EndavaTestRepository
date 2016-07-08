package wordcollection;
import java.util.*;
/**
 * Created by abarbieru on 7/7/2016.
 */
public class WordCollection {

    public void printDuplicates(List <String> words){
        WordCollection coll = new WordCollection();
        Map<String, Integer> map = (TreeMap<String, Integer>) coll.findSortedWordFrequency(words);
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if(entry.getValue() > 1)
                System.out.println(entry.getKey());
        }
    }

    public void printDistincts(List <String> words){
        Set <String> wordSet = new HashSet<String>(words);
        for(String s : wordSet)
            System.out.println(s);
    }

    public Map <String, Integer>  findSortedWordFrequency(List <String> words){
        Set <String> wordSet = new TreeSet<String>(words);
        Map <String, Integer> wordFreq = new TreeMap<String, Integer>(new WordComparator());
        for(String s : wordSet){
            wordFreq.put(s, 0);
        }
        for(String s : words){
            Integer i = wordFreq.get(s);
            wordFreq.put(s, i+1);
        }
        return wordFreq;
    }

    public void printWordFrequency(List <String> words){
        Set <String> wordSet = new HashSet<String>(words);
        Map <String, Integer> wordFreq = new HashMap<String, Integer>();
        for(String s : wordSet){
            wordFreq.put(s, 0);
        }
        for(String s : words){
            Integer i = wordFreq.get(s);
            wordFreq.put(s, i+1);
        }
        for (Map.Entry<String, Integer> entry : wordFreq.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
    public void printSortedFrequencyTable(List <String> words){
        WordCollection coll = new WordCollection();
        Map<String, Integer> map = (TreeMap<String, Integer>) coll.findSortedWordFrequency(words);
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue() + " times");
        }
    }

    public void printAlphabetical(List <String> words){
        words.sort(new WordComparator());
        System.out.println(words);
    }

    public static void main(String [] args){
        WordCollection coll = new WordCollection();
        List <String> wordList = new ArrayList<String>();
        for(int i=0; i< args.length; i++){
            wordList.add(args[i]);
        }

        System.out.println("Words in alphabetical order: ");
        coll.printAlphabetical(wordList);

        System.out.println("Duplicates words are:");
        coll.printDuplicates(wordList);

        System.out.println("Distinct words are: ");
        coll.printDistincts(wordList);

        System.out.println("Frequency table in appearance order is:");
        coll.printWordFrequency(wordList);

        System.out.println("Frequency table in alphabetical order is:");
        coll.printSortedFrequencyTable(wordList);
    }

    public class WordComparator implements Comparator<String>{
        public int compare(String a, String b){
            return a.toLowerCase().compareTo(b.toLowerCase());
        }
    }
}
