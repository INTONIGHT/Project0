package com.revature.repos;

import java.util.List;

import com.revature.models.User;
import com.revature.utils.MockDB;

public class UserRepository implements GenericRepository<User>{

	@Override
	public User add(User u) {
		//i want to first check if the list contains that user.
		if(MockDB.userList.contains(u)) {
			System.out.println("Please enter a different username. We have a user with that name");
			return null;
		}
		//I know my formatting might look a little ugly but I can read it
		//which matters and helps me keep track
		User user = MockDB.userList.stream()
				.max((u1, u2) -> u1.getId().compareTo(u2.getId()))
				.orElse(null);
		Integer id = (user != null)
				? user.getId() + 1 : 1; 
		u.setId(id);
		MockDB.userList.add(u);
		return u;
 	}
	
	@Override
	public User getById(Integer id) {
		User u = MockDB.userList.stream()
				.filter((user) -> user.getId() == id)	
				.findFirst().orElse(null);
		return u;
	}

	@Override
	public List<User> getAll() {
		return MockDB.userList;
	}

	@Override
	public void update(User change) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(User u) {
		//for now we will allow user delete ideally
		//only an employee should be able to do this.
		MockDB.userList.remove(u);
	}

	
	
}
