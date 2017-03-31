package Project1;
public class demo{
 public static long localsTotNum(FBList list, int numPrefix){
  ListIterator iter = list.iterator();
  long hasPrefix = 0l;
  while (iter.hasNext()){
    Person p = iter.next();
    long num = p.getPhoneNum();
    if (Integer.parseInt((""+num).substring(0, 3)) == numPrefix){
      hasPrefix+=1;
    }
  }
  return hasPrefix;
 }
 public static void main(String[] arg) {
   int[] prefix = new int[arg.length];
   //System.out.println(arg[0]);
   for (int i = 0; i < arg.length;i++){
       // System.out.println(i);
     prefix[i] = Integer.parseInt((""+arg[i]));
   } 

   System.out.println("arraylist");
   FBarrayList arraylist = new FBarrayList(3);
   arraylist.insert(0,new Person("haroon", 2484102642L));
   arraylist.insert(1,new Person("dev", 216999312L));
   arraylist.insert(2,new Person("red", 2481039210L));
   arraylist.insert(3, new Person("setsun", 2163922003L));
   arraylist.insert(6, new Person("seth", 2169219031L));
   arraylist.insert(2, new Person("himari", 5489939999L));
   arraylist.insert(3, new Person("dave", 2483922333L));
   for (int i = 0; i< arg.length; i++){
     System.out.print(demo.localsTotNum(arraylist, prefix[i]));
     System.out.println(" people with " + prefix[i] + " prefix");
   }

   
   System.out.println("linkedlist");
   FBLinkedList linkedlist = new FBLinkedList();
   linkedlist.insert(0,new Person("haroon", 2484102642L));
   linkedlist.insert(1,new Person("dev", 216999312L));
   linkedlist.insert(2,new Person("red", 2481039210L));
   linkedlist.insert(3, new Person("setsun", 2163922003L));
   linkedlist.insert(6, new Person("seth", 2169219031L));
   linkedlist.insert(2, new Person("himari", 5489939999L));
   linkedlist.insert(3, new Person("dave", 2483922333L));
   for (int i = 0; i< arg.length; i++){
     System.out.print(demo.localsTotNum(linkedlist, prefix[i]));
     System.out.println(" people with " + prefix[i] + " prefix");
   }
 }
}