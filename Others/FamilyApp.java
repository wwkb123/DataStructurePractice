
public class Main {
  public static void main(String[] args) {
 

    int numOfFamily = 100000; //assume initially there are 100000 families in the country, every family consists of 1 male and 1 female, with no child 

    //so totally 100000 male, and 100000 female initially
    int male = numOfFamily;
    int female = numOfFamily;


    Family[] familyArr = new Family[numOfFamily];

    for(int i = 0; i < numOfFamily; i++){
      familyArr[i] = new Family();
      familyArr[i].giveBirth();  //every family gives birth, i.e. keep getting girls until getting a boy
      male += familyArr[i].getBoy();  //add the number of boy
      female += familyArr[i].getGirl(); //add the number of girl(s)

      //System.out.println("Family "+ (i+1)+" gets "+familyArr[i].getBoy()+" boy and "+familyArr[i].getGirl()+ " girl(s)");
    }

    System.out.println("There are "+male+" males and "+female+" females.");
    System.out.println("The ratio of Male:Female is: "+(male*1.0) / (female*1.0));
  }
}