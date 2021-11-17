package linkedlists;

import java.util.LinkedList;

public class linkedLists {
	
	/**
	 * Represents the Character of list
	 */
	LinkedList<Character> cha = new LinkedList<Character>();
	
	/**
	 * Represents the checker, False if no braces are found else true
	 */
	protected boolean check;

	/**This method check a set of strings that contains braces if balance or not
	 * 
	 * @param expression represents the strings to be check if balance
	 * @return true if linked list is empty
	 */
	public boolean isBalanced(String expression) {
		//Set check to false
		check = false;
		
		//Check every single character in the string
		for(int i = 0; i < expression.length(); i++) {
			//If character is '{' or '(', we add them to the list
			if(expression.charAt(i) == '{' || expression.charAt(i) == '(') {
				cha.addFirst(expression.charAt(i));
				check = true; //Check is true if the strings contains braces
				continue;
			}else if (expression.charAt(i) == '}' || expression.charAt(i) == ')') { //If character is  '}' or  ')' we do the following cases
				//if the list is empty, return false
				if (cha.isEmpty())
					return false;
				switch(expression.charAt(i)) { //Switch case, to find the pair of the braces
				case '}':
					//If the character that we remove isn't the pair of the current character, there is a mismatch, so return false
					if(cha.pop() != '{')
						return false;
					break;
				case ')':
					//If the character that we remove isn't the pair of the current character, there is a mismatch, so return false
					if(cha.pop() != '(')
						return false;
					break;
				default:
					break;
				}
			}

		}
		
		//If the list of character is empty we return true, else false
		return (cha.isEmpty());
		
	}
	

	
}


