package com.revature.repos;

import java.util.List;

import com.revature.models.User;
import com.revature.utils.MockDB;

public class EmployeeRepository implements GenericRepository<User>{
//while this might seem like it adds duplication of code it might
	//be better to have a seperate repo for employees in case I need to 
	//add more functions here
	//plus it will operate on the employee List so I feel better about sticking
	//it here
	//Again lots of duplicate code however I feel it is necessary
	@Override
	public User add(User e) {
		if(MockDB.userList.contains(e)) {
			System.out.println("Please enter a different username. We have a user with that name");
			return null;
		}
		//I know my formatting might look a little ugly but I can read it
		//which matters and helps me keep track
		User user = MockDB.employeeList.stream()
				.max((e1, e2) -> e1.getId().compareTo(e2.getId()))
				.orElse(null);
		Integer id = (user != null)
				? user.getId() + 1 : 1; 
		e.setId(id);
		MockDB.employeeList.add(e);
		return e;
	}
	//this is meant to look almost identical just operate on the
	//empoyee list also means I dont have to override anything.
	@Override
	public User getById(Integer id) {
		User e = MockDB.employeeList.stream()
				.filter((employee) -> employee.getId() == id)	
				.findFirst().orElse(null);
		return e;
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return MockDB.employeeList;
	}

	@Override
	public void update(User change) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(User e) {
		MockDB.employeeList.remove(e);
		
	}

}
