
import java.util.*;

public class Reader{
   private Scanner s;
   public ArrayList<Subject> categories = new ArrayList<Subject>();
   
   public Reader(Scanner input){
      s = input;
      while(s.hasNext()){
         String temp = s.nextLine();
         if(temp.length() > 1 && temp.substring(0,1).equals("<") && temp.substring(temp.length()-1).equals(">")){ // if the line indicates subject
            Subject s = new Subject(temp.substring(1,temp.length()-1));
            categories.add(s); // adds subject
            System.out.println("added subj");
         } else {
            if(temp.length() > 1 && temp.substring(0,1).equals("*") && temp.substring(temp.length()-1).equals("*")){ // if the line indicates topic
               Topic t = new Topic(temp.substring(1,temp.length()-1), null); // creates a new topic with no text yet
               categories.get(categories.size()-1).add(t); // adds topic
               System.out.println("added topic");
            } else { // if the line isn't a subject or topic, then it is used for setting the information
               if (!temp.isEmpty()) {
                  Subject subj = categories.get(categories.size() - 1); // gets the most recent subject created
                  System.out.println("adding '" + temp + "' to " + subj.getTopic(subj.getSize() - 1).getName() + " of " + subj.getName());
                  if (subj.getTopic(subj.getSize() - 1).getInfo() != null) {
                     subj.getTopic(subj.getSize() - 1).getInfo().add(temp);
                  }
               }
            }
               // subj.setInfo(l.getSize()-1,temp); // sets the information to the latest topic created in the subject
            }
         }
      }
   
   public ArrayList<Subject> getList(){
      return categories;
   }
}


