package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.NativePlace;
import com.example.demo.entity.User;
import com.example.demo.repository.NativePlaceRepository;
import com.example.demo.repository.UserRepository;
@Service
public class NpandUserServiceImpl implements NpandUserService {

	
	@Autowired
	UserRepository userRepository;
	@Autowired
	NativePlaceRepository nativePlaceRepository;
	
	@Override
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		userRepository.save(user);

	}
	
	@Override
	public void saveNativePlace(NativePlace nativeplace) {
		// TODO Auto-generated method stub
		nativePlaceRepository.save(nativeplace);

	}

	

	@Override
	public User findUserByusernameAnduserpwd(String name, String password) {
		// TODO Auto-generated method stub
		return userRepository.findUserByUsernameAndUserpwd(name,password);
	}

	@Override
	public List<User> findUserByusername(String name) {
		// TODO Auto-generated method stub
		return userRepository.findUserByUsername(name);
	}
	@Override
	public NativePlace findNativePlaceByNativeplace(String Nativeplace) {
		return nativePlaceRepository.findNativePlaceByNativeplace(Nativeplace);
	}

}
