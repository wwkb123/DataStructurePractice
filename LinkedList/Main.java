

public class Main {
  public static void main(String[] args) {
    StringLinkedList loopList = new StringLinkedList();
    // demoList.printAll();
    // for (int i = 0; i < 10; i++) {
    //   String charToAdd = "" + (char) ('A' + i);
    //   System.out.println("i = " + i);
    //   if (i % 2 == 0) {
    //     System.out.println("Appending " + charToAdd + " to last");
    //     demoList.append(charToAdd);
    //   } else if (i % 3 == 0) {
    //     System.out.println("Inserting " + charToAdd + " to position " + i / 2);
    //     demoList.insert(i / 2, charToAdd);
    //   } else {
    //     System.out.println("Inserting " + charToAdd + " as new head");
    //     demoList.insert(0, charToAdd);
    //   }
    //   demoList.printAll();
    // }
    

    loopList.append("a");
    loopList.append("b");
    loopList.append("c");
    loopList.append("d");
    loopList.append("e");

    loopList.getNode("e").setNext(loopList.getNode("c")); //make a loop

    System.out.println("A loop list:");
    loopList.printAll();

    System.out.print("Loop detection method result: ");
    StringNode sn = loopList.findBadNode(loopList.getNode("a"));
    if( sn != null){
      System.out.print("True. The bad node is: " + sn.data + "\n\n");
    }else{
      System.out.print("False. \n\n"); //no bad node means no loop
    }

    


    StringLinkedList nonLoopList = new StringLinkedList();

    nonLoopList.append("q");
    nonLoopList.append("w");
    nonLoopList.append("e");
    nonLoopList.append("r");
    nonLoopList.append("t");

    System.out.println("A non-loop list:");
    nonLoopList.printAll();

    System.out.print("Loop detection method result: ");
    sn = nonLoopList.findBadNode(nonLoopList.getNode("q"));
    if( sn != null){
      System.out.print("True. The bad node is: " + sn.data + "\n\n");
    }else{
      System.out.print("False. \n\n"); //no bad node means no loop
    }


    //debugging remove methods
    // demoList.removeBack();
    // demoList.removeFront();
    // demoList.removeAt(5);
    // demoList.printAll();
    // demoList.replaceNode(0, "ASD");


    
  }
}
