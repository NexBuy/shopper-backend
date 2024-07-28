package com.project.shopper.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.shopper.model.ProductUser;
import com.project.shopper.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<ProductUser> getAllUsers(){
		return userRepository.findAll();
	}
	
	public ProductUser getUserById(Long Id) {
		return userRepository.findById(Id).orElse(null);
	}
	
	public ProductUser saveUser(ProductUser user) {
        return userRepository.save(user);
    }

	public ProductUser updateUser(ProductUser user){
		return userRepository.save(user);
//		return getUserById(user.getUserId());
	}
	
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}

}
