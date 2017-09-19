
import java.util.*;
import java.io.*;

public class Writer{
   private String subject;
   private String topic;
   private ArrayList<String> text;
   private File info;

   
   public Writer(File i, String s, String top, ArrayList<String> text){
      subject = s;
      topic = top;
      this.text = (ArrayList<String>)text.clone();
      info = i;
      parseLines(text);
   }

   // to test how many lines each note has
   private void parseLines(ArrayList<String> text) {
	  for(String s : text) {
	     System.out.println(s);
      }
   }

   public ArrayList<Subject> write() throws FileNotFoundException {
      boolean create = true;
      Scanner s = new Scanner(info);
      Reader r = new Reader(s);
      ArrayList<Subject> subjects = r.getList();
      for(int i = 0; i < subjects.size(); i++){
         if(subjects.get(i).getName().equalsIgnoreCase(subject)){
            for(Topic t : subjects.get(i).getList()){
               if(t.getName().equalsIgnoreCase(topic)){
                  create = false;
                  t.setInfo(text); //replace later to rewrite text file
               }
            }
            if(create){
               subjects.get(i).add(new Topic(topic, text)); //replace later to rewrite text file
               create = false;
            }
         }
      }
      if(create){
         subjects.add(new Subject(subject));
         subjects.get(subjects.size()-1).add(new Topic(topic, text)); //replace these two lines of code to rewrite the text file
      }
      return subjects;
   }
   
   public void saveData(ArrayList<Subject> categories) throws FileNotFoundException {

      PrintStream print = new PrintStream(info);
      for(Subject s : categories){
         print.println("<" + s.getName() + ">");
         for(Topic t : s.getList()){
            print.println("*" + t.getName() + "*");
            for(String line : t.getInfo()) {
               print.println(line);
            }
         }
      }
      print.close();
   }
}
