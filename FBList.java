package Project1;
public interface FBList{
 void insert(int i, Person person);
 Person remove(int i);
 Person lookup(int i);
 int getSize();
 ListIterator iterator();
}