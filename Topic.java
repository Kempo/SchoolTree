import java.util.ArrayList;

public class Topic{
	/**
	 * TRANSITION OVER TO AN ARRAYLIST RATHER THAN A STRING OF TEXT FOR INFO
	 */
	   private String name;
	   private ArrayList<String> info;
	   
	   public Topic(String n, ArrayList<String> i){
	      name = n;
	      info = i;
	   }
	   
	   public ArrayList<String> getInfo(){
	      return info;
	   }
	   
	   public String getName(){
	      return name;
	   }
	   
	   public void setInfo(ArrayList<String> i){ info = (ArrayList<String>)i.clone(); }
	   
	   public String toString(){
	      return getName();
	   }
	}
