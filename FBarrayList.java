package Project1;
public class FBarrayList implements FBList {
 private int size;
 public int cap;
 private Person[] list;
 public FBarrayList(){
   list = new Person[10];
  this.size = 0;
  this.cap = 10;
 }
 public FBarrayList(int initialCap){
  list = new Person[initialCap] ;
  this.size = 0;
  this.cap = initialCap;
 }
 public void insert(int i, Person person){
   if (this.size < i && cap > i){
    //if place is larger than size but less than cap
     this.list[this.size] = person;
     this.size+=1;
   }
   else if (this.size == 0){
    //if array is empty
     this.list[0] = person;
     this.size+=1;
   }
   else if (this.size == cap){
    //if array is too small, and has reached its cap
     cap+=1;
     Person[] nlist = new Person[cap+1];
     for (int j = 0;j < list.length;j++){
       nlist[j] = list[j];
     }
     if (this.size < i){
       nlist[this.size] = person;
       this.list = nlist;
       this.size+=1;
     }
     else{
       for (int l = this.size;l >= i;l--){
         nlist[l] = nlist[l-1];
       }
       nlist[i-1] = person;
       this.list = nlist;
       this.size+=1;
     }
   }
   else{
    //if place is within array size
     for (int l = this.size;l >= i;l--){
         list[l] = list[l-1];
       }
       list[i-1] = person;
       this.size+=1;
   }
 }

 public Person remove(int i){
   if (this.size < i){
     //if calling out of the size, fewer than i components
     return null;
   }
   else{
    //if within size
     Person personToRemove = this.list[i];
     for (int j = i;j < list.length-1;j++) {
       this.list[j] = this.list[j+1];
     }
     this.size-=1;
     return personToRemove;
   }
 }
 public Person lookup(int i){
   if (this.size < i + 1){
    //if sequence has fewer than i components
    throw new IllegalArgumentException("i is out of bounds");
   }
   else{
    //return i-th component
   return list[i];
   }
 }
 public int getSize(){
  //return size of list
   return this.size;
 }
 @Override
 public ListIterator iterator() {
  ListIterator iter = new arrIterator();
  return iter;
 }
 private class arrIterator implements ListIterator{
   private Person[] ilist;
   private int index;
   private arrIterator(){
     ilist = list;
     index = 0;
   }
   public boolean hasNext(){
     try{
       if(ilist[index]== null)
         return false;
     }
     catch(ArrayIndexOutOfBoundsException e){
       return false;
     }
     return true;
   }
   public Person next(){
     Person data = null;
     try{
       if(ilist[index] != null){
         data = ilist[index];
         index+=1;
       }
     }
     catch(ArrayIndexOutOfBoundsException e){
       System.out.println("end of list");
     }
     if (data != null)
       return data;
     else
       throw new IllegalArgumentException("end of list");
   }
 }
 
}
