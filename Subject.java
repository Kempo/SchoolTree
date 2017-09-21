
import java.util.*;

public class Subject{
   private String name;
   private ArrayList<Topic> topics = new ArrayList<Topic>();
   
   public Subject(String n){
      name = n;
   }
   
   public void add(Topic t){
      topics.add(t);
   }
   
   public String getName() {
	   return name;
   }

   public int getSize(){
      return topics.size();
   }

   public Topic getTopic(int i ) { return topics.get(i); }

   public ArrayList<Topic> getList(){
      return topics;
   }

   public void remove(int i) {
	   topics.remove(i);
   }
   
   public String toString(){
      return name;
   }
}
