import java.util.HashSet;

//***** Extra Credit method is located at the bottom *****//

public class StringLinkedList {

  //fields for LinkedList
  StringNode head; //pointer to first node
  int size; //number of elements (counter)

  public StringLinkedList() {
    //create an empty LinkedList
    head = null;
    size = 0;
  }

  public void append(String s) {
    StringNode n = new StringNode(s);
    //putting node n to the end of list
    if (size == 0) {
      head = n;
      size++;
      return;
    }
    StringNode temp = head; //set a pointer to head
    while (temp.next != null) {
      temp = temp.next; //keep moving back
    }
    //now temp.next is null, i.e. temp is pointing at tail
    temp.next = n;
    size++;
  }


  //get a node
  public StringNode getNode(String s){
    if(head == null) return null;

    StringNode temp = head; //set a pointer to head
    while (temp.next != null) {
      if(temp.data.equals(s)){
        return temp;
      }
      temp = temp.next; //keep moving back
    }
    if(temp.data.equals(s)){
      return temp;
    }
    return null;
  }

  public void insert(int index, String s) {
      StringNode n = new StringNode(s);
    //inserting node n into the list
    if (index > size) return; //out of bound
    if (index == size) append(s); //we don't want this    
    if (index == 0) {
      //n becomes new head if index == 0
      n.next = head;
      head = n;
      size++;
      return;
    }
    //end of special cases

    //now find real insertion position
    StringNode temp = head;
    for (int i = 0; i < index - 1; i++) {
      temp = temp.next;
    }
    //now temp has moved "index - 1" steps back
    /**
      This should look like
      ...[index-2]>temp[index-1]>temp.next[index]>...
      and we want
      ...[index-2]>temp[index-1]>newNode[index]>temp.next[index+1]>...
    */
    n.next = temp.next;
    temp.next = n;
    size++;
  }

  /**
   * For you to implement
   * public void removeFront();
   * public void removeBack();
   * public void removeAt(int index);
   * public void replaceNode(int index, String newString);
   */    

   public void removeFront(){
     if(head==null) return;
     StringNode curr = head;
     head = curr.next;
     curr = null;
     size--;
   }

   public void removeBack(){
     if(head==null) return;
     StringNode prev = head;
     StringNode curr = head;
     while(curr.next != null){
       prev = curr;
       curr = curr.next;
     }
     prev.next = null;
     size--;
   }

   public void removeAt(int index){
     if(head != null && index >= 0 && index < size){
       StringNode prev = head;
       StringNode curr = head;
       for(int i = 0; i < index ;i++){
         prev = curr;
        curr = curr.next;
       }
        prev.next = curr.next;
        size--;
     }else{
       System.out.println("Invalid index");
     }
   }

   public void replaceNode(int index, String newString){
     if(index >= 0 && index < size){
      StringNode temp = new StringNode(newString);
      StringNode prev = head;
      StringNode curr = head;

      for(int i = 0;i<index;i++){
        prev = curr;
        curr = curr.next;
      }
      
      temp.next = curr.next;
      if(index > 0){
        prev.next = temp;
      }
      else{ //no prev
        head = temp;
      }
     }
     else{
       System.out.println("Invalid index");
     }
   }

  //-----------------------------------------------------//



  //*** Extra Credit ***//

  //detect a loop, take the head of a linked list as a parameter, return the bad node if any
  public StringNode findBadNode(StringNode n){
    if(head == null || n == null) return null;
    HashSet<StringNode> hs = new HashSet<StringNode>();  //make a set of nodes' references
    StringNode temp = head;
    StringNode prev = head; //previous node, a bad node will be the previous node of the first repeated node
    while(temp.next != null){
      if(hs.contains(temp)){
        return prev;  //found the repeated node, return the previous node which is the bad node
      }
      hs.add(temp); // add to the set
      prev = temp;
      temp = temp.next;
    }
    return null;  //not found
  }


  //------------------------------------------------//
  
  
  public void printAll() {
    //System.out.println("----");
    // System.out.print("head>");
    // StringNode temp = head;
    // for (int i = 0; i < size; i++) {
    //   System.out.print(temp.data.toString());
    //   System.out.print(">");
    //   temp = temp.next;
    // }
    // System.out.println("null");
    // System.out.println("----");
    if(head == null) return;
    StringNode temp = head;

    int count = 0;
    while(temp.next != null){
      System.out.print(temp.data + " > ");
      temp = temp.next;
      count++;
      if(count > size*1.5 ){
        System.out.print("... > ");
        break;
        }  //prevent loop kills the memory
    }
    System.out.print(temp.data+"\n");
  }
}
