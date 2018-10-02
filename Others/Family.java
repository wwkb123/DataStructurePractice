import java.lang.Math;

public class Family{
  public int boy;
  public int girl;

  public Family(){
    boy = 0;
    girl = 0;
  }

  public void giveBirth(){
    int boyOrGirl = ((int)(Math.random()*100)) % 2; //generate a number between 0-99, and mod it by 2. Odd indicates a boy, even indicates a girl
    while(boyOrGirl == 0){   //0 means girl
      girl++;
      //System.out.println(boyOrGirl);
      boyOrGirl = ((int)(Math.random()*100)) % 2;  //give birth again
    }
    boy++;  //finally get a boy
  }

  public int getBoy(){
    return boy;
  }

  public int getGirl(){
    return girl;
  }
}