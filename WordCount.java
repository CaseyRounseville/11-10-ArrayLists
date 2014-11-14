//Casey Rounseville
//9O
//11-10-2014 
import java.io.*; 
import java.net.*; 
import java.util.*; 

public class WordCount { 
  public static void main(String[] args) throws IOException, MalformedURLException { 
    URL url = new URL("http://basisphoenix.azurewebsites.net/wp-content/uploads/2014/11/battleship.txt"); 
    Scanner input = new Scanner(url.openStream()); 
    String txt = ""; 
    
    // create an ArrayList of type String to store the unique words 
//-----> YOUR CODE HERE 
    ArrayList<String>uniqueWords=new ArrayList<String>();
    // create an ArrayList of type Integer to store the count of each time the unique word appears 
//-----> YOUR CODE HERE 
    ArrayList<Integer>count=new ArrayList<Integer>();
    while(input.hasNextLine()) { 
      // get the next line from the input file 
      txt = input.nextLine(); 
      
      // print the original input 
      System.out.println(txt); 
      System.out.println(); 
      
      // call your method countUniqueWords 
//-----> YOUR CODE HERE 
      countUniqueWords(uniqueWords,count,txt);
      // print out number of unique words found, like: "Number of unique words: 23" 
//-----> YOUR CODE HERE 
      System.out.println("Number of unique words: "+count.size());
      System.out.println(); 
      
      System.out.println("Count\tWord "); 
      // for each word in your ArrayList of unique words, print the count followed by a tab and the word 
//-----> YOUR CODE HERE 
      for(int i=0;i<count.size();i++)
      {
        System.out.println(count.get(i)+"\t"+uniqueWords.get(i));
      }
    } 
    input.close(); 
  } 
  
  // COMPLETE method countUniqueWords - use wordList to store the unique words in String input with a length > 3 and 
  // wordCount to count the number of occurances of each unique word. 
  // 
  // Parameters: 
  //    wordList - an ArrayList of type String to store a sorted list of unique words in the String input 
  //    wordCount - an ArraltList of type Integer to store a list of the for each unique word in the String input 
  //    input - String of text to be processed 
  // Return Type: void 
  public static void countUniqueWords(ArrayList<String> wordList, ArrayList<Integer> wordCount, String input) { 
    Scanner getWords = new Scanner(input).useDelimiter("[\\W]"); 
    int index = 0; 
    String word = ""; 
    
    // while getWords has more text 
    //    get next word as lower case 
    //        if length of word > 3 characters 
    //            if wordList contains the word 
    //                get index of the word in the ArrayList 
    //                increment the word count at the same index in ArrayList wordCount 
    //             else 
    //                add word and count of 1 to wordList and wordCount, respectively 
    // 
//-----> YOUR CODE HERE 
    while(getWords.hasNext()==true)
    {
      word=getWords.next();
      word=word.toLowerCase();
      if(word.length()>3)
      {
        if(wordList.contains(word)==true)
        {
          index=wordList.indexOf(word);
          int temp=wordCount.get(index);
          temp++;
          wordCount.set(index,temp);
        }
        else
        {
          wordList.add(word);
          wordCount.add(1);
        }
      }
    }
    System.out.println(wordList);
    getWords.close(); 
    
    // sort wordList alphabetically, don't forget you will need to swap the values of wordCount 
    // anytime you swap values in wordList 
//-----> YOUR CODE HERE
    int i=0;
    while(i<wordList.size()-1)
    {
      if(wordList.get(i).compareTo(wordList.get(i+1))>0)
      {
        String temp=wordList.get(i+1);
        wordList.set(i+1,wordList.get(i));
        wordList.set(i,temp);
        int temp2=wordCount.get(i);
        wordCount.set(i,wordCount.get(i+1));
        wordCount.set(i+1,temp2);
        i=0;
      }
      else
      {
        i++;
      }
    }
  } 
} 

