package Project1;
public class Node{
 private Person data;
 private Node next;

 public Node(){
  next = null;
  data = null;
 }
 public Node(Person person, Node n){
  data = person;
  next = n;
 }
 public void setNext(Node n){
  next = n;
 }
 public void setData(Person person){

 }
 public Node getNext(){
  return next;
 }
 public Person getData(){
  return data;
 }
}