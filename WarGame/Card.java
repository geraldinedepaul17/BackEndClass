package WarGame;

public class Card {
	private int _value; 
	 private String _name; 
	 
	 public Card() {
		 _name = ""; 
		 _value = 0; 
		 		 
	}
	public Card(int value, String name) { 
		 _value = value; 
		 _name = name; 
	 }
	 
	public String getName() {
		 return _name; 
	 }
	 public Integer getValue() { 
		 return _value; 
	 }
	 
	 public void setName(String newName) {
		 _name = newName; 
	 }
	 
	 public void setValue(int newValue) {
		 _value = newValue; 
	 }
	 
	  
	 public void describe() {
		 System.out.println(_name + " and the value is: " + _value); 
	 }
	}

