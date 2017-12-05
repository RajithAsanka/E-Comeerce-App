package com.nr.fc.common;

/**
 * To find gender with title such as Mr Mrs and Ms
 * @author Sayyaff
 *
 */
public class Gender {
	String title;
	
	public Gender(String title) {
		super();
		this.title = title;
	}
	
	public int find(){
		if(title.equalsIgnoreCase("Mr"))
			return 1;
		else if(title.equalsIgnoreCase("Mrs"))
			return 0;
		else if(title.equalsIgnoreCase("Ms"))
			return 0;
		else
			return 0;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	
}
