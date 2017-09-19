
import java.util.*;
import java.io.*;

public class Remover{
   private String subject;
   private String topic;
   private File info;
   
   public Remover(File i, String s, String top){
      subject = s.toUpperCase();
      topic = top.toUpperCase();
      info = i;
   }


   public ArrayList<Subject> remove() throws FileNotFoundException {
      boolean removed = false;
      Scanner s = new Scanner(info);
      Reader r = new Reader(s);
      ArrayList<Subject> subjects = r.getList();
      for(int i = 0; i < subjects.size(); i++){
         Subject sub = subjects.get(i);
         if(sub.getName().equalsIgnoreCase(subject)){
            if(this.topic.equals("")){
               subjects.remove(i);
               break;
            }
            ArrayList<Topic> topics = sub.getList();
            for(int t = 0; t < topics.size(); t++){
               if(topics.get(t).getName().equalsIgnoreCase(topic)){
                  removed = true;
                  sub.remove(t);
                  if(sub.getSize() == 0){
                     subjects.remove(sub);
                  }
               }
            }
            if(!removed){
               System.out.println("Topic not found"); //replace later to throw an error of topic not found
            }
         }
      }
      //throw an error if the subject is not found
      return subjects;
   }

   /**
    * change fix fix fix convert to array
    */
   public void saveData(ArrayList<Subject> categories) throws FileNotFoundException {
	   
      PrintStream print = new PrintStream(info);
      for(Subject s : categories){
         print.println("<" + s.getName() + ">");
         for(Topic t : s.getList()){
            print.println("*" + t.getName() + "*");
            print.println(t.getInfo());
         }
      }
      print.close();
   }
}