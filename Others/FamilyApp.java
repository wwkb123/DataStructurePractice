
public class FamilyApp {
  public static void main(String[] args) {
 

    int numOfFamily = 100000; //assume initially there are 100000 families in the country, every family consists of 1 male and 1 female, with no child 

    //so totally 100000 male, and 100000 female initially
    int totalMale = numOfFamily;
    int totalFemale = numOfFamily;
    int generation = 0;

    int singleMale = 0;
    int singleFemale = 0;

    Family[] familyArr;

    while(generation < 1000){
      familyArr = new Family[numOfFamily];
      int newMale = 0;
      int newFemale = 0;
      for(int i = 0; i < numOfFamily; i++){
        familyArr[i] = new Family();
        familyArr[i].giveBirth();  //every family gives birth, i.e. keep getting girls until getting a boy

        totalMale += familyArr[i].getBoy();  //add the number of boy
        totalFemale += familyArr[i].getGirl(); //add the number of girl(s)

        newMale += familyArr[i].getBoy();
        newFemale += familyArr[i].getGirl();
        //System.out.println("Family "+ (i+1)+" gets "+familyArr[i].getBoy()+" boy and "+familyArr[i].getGirl()+ " girl(s)");

      }

      System.out.println("There are "+totalMale+" males and "+totalFemale+" females in generation " + generation+ ".");
      System.out.println("The ratio of Male:Female is: "+(totalMale*1.0) / (totalFemale*1.0)+"\n");

      
      if(newMale > newFemale){
        singleMale += newMale - newFemale; //how many males left
        numOfFamily = newFemale; // male is more than female, and since 1 male is match with 1 female, so there are at most "newFemale" new families
      }else if(newMale < newFemale){
        singleFemale += newFemale - newMale;
        numOfFamily = newMale;
      }else{
        numOfFamily = newMale;  // newMale == newFemale
      }

      //hadnling single people
      if(singleMale > singleFemale){
        numOfFamily += singleFemale;
        singleMale = singleMale - singleFemale;
      }else if(singleMale < singleFemale) {
        numOfFamily += singleMale;
        singleFemale = singleFemale - singleMale;
      }else{ //both are equal
        numOfFamily += singleMale;
        singleMale = 0; //no more single
        singleFemale = 0;
      }
      
      generation++; //next generation
    }

    System.out.println("Single men: "+singleMale +" Single women: "+singleFemale);

    

    System.out.println("There are "+totalMale+" males and "+totalFemale+".");
    
    System.out.println("The ratio of Male:Female is: "+(totalMale*1.0) / (totalFemale*1.0)+"\n");
    
  }
}
