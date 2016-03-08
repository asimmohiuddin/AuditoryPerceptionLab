import java.io.*;

public class ReadBuckeye{
  public static main void (String args[]) throws FileNotFoundException{
    
    Scanner s = new Scanner(new File("BuckeyeWords.txt"));
    double timeLowest = 50000, timeHighest = 0;
    int previousID = -1;
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
      if (timeStart < timeLowest) timeLowest = timeStart;
      if ((word.startsWith("<") || word.startsWith("{")) && !(word.startsWith("<HES") ||
         word.startsWith("<CUT") || word.startsWith("<EXT") || word.startsWith("<EXCL"))) {
         timeHighest = timeStart;
         if (!isConsec
         System.out.println(fileName + "," + talkerNumber + "," + 
         timeLowest = 50000;
      } else {
        isConsecutive = false;
      }
