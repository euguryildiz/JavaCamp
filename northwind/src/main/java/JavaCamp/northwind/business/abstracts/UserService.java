package JavaCamp.northwind.business.abstracts;

import JavaCamp.northwind.core.entities.User;
import JavaCamp.northwind.core.utilities.result.DataResult;
import JavaCamp.northwind.core.utilities.result.Result;

public interface UserService {
	
	Result add(User user);
	DataResult<User> findByEmail(String email);
	

}
