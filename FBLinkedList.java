package Project1;
public class FBLinkedList implements FBList{
 private Node start;
 private Node end;
 private int size;
 public FBLinkedList(){
  start = null;
  end = null;
  size = 0;
 }
  public int getSize(){
  return size;
 }
 public void insert(int i, Person person){
  if (size < i){
    Node nptr = new Node(person,null);    
    size++ ;
    end.setNext(nptr);
    end = nptr;
  }
  else if(start == null){
    Node nptr = new Node(person,null);    
    start = nptr;
    end = start;
    size++;
  }
  else{
    Node nptr = new Node(person, null);                
    Node ptr = start;
    Node pptr = null;;
    i = i - 1 ;
    for (int l = 0; l < size; l++){
      if (l == i){   
        Node tmp = ptr.getNext();
        nptr.setNext(ptr);
        if (i == 0){
          start = nptr;
          break;
        }
        pptr.setNext(nptr);
        break;
      }
      pptr = ptr;
      ptr = ptr.getNext();
    }
    size++;
  }
 }
public Person remove(int i){
  Node temp = null;
  if (i == 1){
    temp = start;
    start = start.getNext();
    size--; 
    return temp.getData();
  }
  if (i == size){
    Node s = start;
    Node t = start;
    temp = end;
    while (s != end){
      t = s;
      s = s.getNext();
    }
    end = t;
    end.setNext(null);   
    return temp.getData();
  }else{
    Node ptr = start;
    i = i - 1 ;
    for (int l = 1; l < size - 1; l++){
      if (l == i){
        temp = ptr;
        Node tmp = ptr.getNext();
        tmp = tmp.getNext();
        ptr.setNext(tmp);
        return temp.getData();
      }
      ptr = ptr.getNext();
    }
     size--;
   }
  return temp.getData();
}
 public Person lookup(int i){
  if (size < i+1){
   throw new IllegalArgumentException("Sequence has fewer than " + i + " components");
  }
  Node tmp = null;
  Node nodptr = start;
  if (i != 0){
    for (int l = 0; l < i; l++){
      nodptr = nodptr.getNext();
    }
  }
  return nodptr.getData();
 }
 @Override
 public ListIterator iterator(){
  ListIterator iter = new LLiterator();
  return iter;
 }
 private class LLiterator implements ListIterator{
  private Node nextNode;
  private LLiterator(){
    nextNode = start;
  }
  public boolean hasNext(){
    return (nextNode != null);
  }
  public Person next(){
    if (nextNode == null)
      throw new IllegalArgumentException("end of list");
    Person data = nextNode.getData();
    nextNode = nextNode.getNext();
    return data;
  }
 }

}
