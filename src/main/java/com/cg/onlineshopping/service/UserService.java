package com.cg.onlineshopping.service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlineshopping.entity.Roles;
import com.cg.onlineshopping.entity.ShoppingCart;
import com.cg.onlineshopping.entity.User;
import com.cg.onlineshopping.exception.WrongEmailException;
import com.cg.onlineshopping.exception.WrongPasswordException;
import com.cg.onlineshopping.repository.ProductRepository;
import com.cg.onlineshopping.repository.RoleRepository;
import com.cg.onlineshopping.repository.UserRepository;

@Service
public class UserService implements IUserService {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private RoleRepository roleRepo;

	@Autowired
	ProductRepository prodRepo;

	@Override
	public User register(User user) throws WrongPasswordException, WrongEmailException {
		String email = user.getEmail();
		String Password = user.getPassword();
		String regex_email = "^(.+)@(.+)$";
		Pattern pattern_email = Pattern.compile(regex_email);
		Matcher matcher_email = pattern_email.matcher(email);

		String regex_password = "^(?=.*[0-9])" + "(?=.*[a-z])(?=.*[A-Z])" + "(?=.*[@#$%^&+=])" + "(?=\\S+$).{8,20}$";
		Pattern pattern_password = Pattern.compile(regex_password);
		Matcher matcher_password = pattern_password.matcher(Password);

		if (matcher_email.matches()) {
			if (matcher_password.matches()) {
				Roles role = roleRepo.findById((long) 1).orElse(null);
				// roles.add(roleRepo.findById((long) 1).get()) ;
				user.getRoles().add(role);
				ShoppingCart cart = new ShoppingCart();
				cart.setUser(user);

				user.setCart(cart);
				return userRepo.save(user);
			} else
				throw new WrongPasswordException("Password Exception");
		} else {
			throw new WrongEmailException("Email Exception");
		}

	}

}
