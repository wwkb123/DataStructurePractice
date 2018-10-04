  public class StringNode { // node class
    //fields for Node
    public String data; //hold a data element
    public StringNode next; //pointer to next node

    public StringNode() { 
      //default constructor, empty node
      data = null;
      next = null;
    }

    public StringNode(String s) {
      //constructor with given element
      data = s;
      next = null;
    }

    public void setNext(StringNode n) {
      //a set method, but this doesn't matter because "next" is public
      this.next = n;
    }
  } //end of node class
