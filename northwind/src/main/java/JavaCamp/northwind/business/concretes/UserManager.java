package JavaCamp.northwind.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import JavaCamp.northwind.business.abstracts.UserService;
import JavaCamp.northwind.core.dataAccess.UserDao;
import JavaCamp.northwind.core.entities.User;
import JavaCamp.northwind.core.utilities.result.DataResult;
import JavaCamp.northwind.core.utilities.result.Result;
import JavaCamp.northwind.core.utilities.result.SuccessDataResult;
import JavaCamp.northwind.core.utilities.result.SuccessResult;

@Service
public class UserManager implements UserService {

	
	private UserDao userdao;
	
	@Autowired
	public UserManager(UserDao userdao) {
		super();
		this.userdao = userdao;
	}

	@Override
	public Result add(User user) {
		this.userdao.save(user);
		return new SuccessResult("User added");
	}

	@Override
	public DataResult<User> findByEmail(String email) {
		return new SuccessDataResult<User>("Find user",this.userdao.findByEmail(email));
	}

}
