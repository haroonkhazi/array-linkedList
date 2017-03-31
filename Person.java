package Project1;
public class Person<S, l> {
 private String personID;
 private long phonNum;
 public Person(String personID, long phonNum){
  this.personID = personID;
  this.phonNum = phonNum;
 }
 public String toString(){
  return personID + " " + phonNum; 
 }
 public long getPhoneNum(){
   return this.phonNum;
 }
}