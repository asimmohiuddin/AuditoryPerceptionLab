import java.io.*;

public class ReadBuckeye{
  public static main void (String args[]) throws FileNotFoundException{
    
    Scanner s = new Scanner(new File("BuckeyeWords.txt"));
    double timeLowest = 50000, previousEnd = 0, previousTimeLowest = 0;
    boolean isConsecutive = true, isNewFile = false;
    int previousID = -1, previousTalkerNumber = 0;
    String sentence = "", previousFileName = "";
    while (s.hasNextLine()){
      String line = s.nextLine();
      Scanner lineScanner = new Scanner(line);
      lineScanner.useDelimiter(",");
      int index = lineScanner.next().parseInt();
      String fileName = lineScanner.next();
      int talkerNumber = lineScanner.next().parseInt();
      lineScanner.next();
      lineScanner.next();
      String word = lineScanner.next();
      lineScanner.next();
      lineScanner.next();
      double timeStart = lineScanner.next().parseDouble();
      double timeEnd = lineScanner.next().parseDouble();
      if (index < previousID) isNewfile = true;
      else isNewfile = false;
      if (timeStart < timeLowest) timeLowest = timeStart;
      if (((word.startsWith("<") || word.startsWith("{")) && !(word.startsWith("<HES") ||
         word.startsWith("<CUT") || word.startsWith("<EXT") || word.startsWith("<EXCL"))) || isNewFile) {
         if (!isConsecutive) {
           System.out.println(previousFileName + "," + previousTalkerNumber + "," + previousTimeLowest + "," + previousEnd + "," + sentence);
         }
         timeLowest = 50000;
         isConsecutive = true;
         sentence = "";
      } else {
        isConsecutive = false;
        sentence = sentence + " " + word;
      }
      previousEnd = timeEnd;
      previousID = index;
      previousTalkerNumber = talkerNumber;
      previousFileName = fileName;
      previousTimeLowest = timeLowest;
    }
  }
}
