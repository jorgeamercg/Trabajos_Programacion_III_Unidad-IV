package controllers;

import java.util.ArrayList;

import models.User;
import models.UserModel;

import views.UserView;

public class UserController {
	
	private UserView view;

	public UserController() {
		
		view = new UserView();
		
	}
	
	public void users() {
		
		UserModel um = new UserModel();
 		
 		ArrayList<User> data = um.get();
		
		view.showUsers(data);
		
	}

}
