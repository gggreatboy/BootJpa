package com.example.demo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

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
	public List<User> findUserByUsername(String name,String sortColumn) {
		// TODO Auto-generated method stub
		return userRepository.findUserByUsername(name,Sort.by(Sort.Direction.ASC,sortColumn));
	}
	
	@Override
	public String findAllUserByPage(Integer page,Model model) {
		if(page==null) {
		  page=1;
		}
		int size=5;
		Page<User>pageData=
	userRepository.findAll(PageRequest.of(page-1, size,Sort.by(Sort.Direction.ASC,"id")));
		List<User>allUser=pageData.getContent();
		HashMap<Integer, String> places = new HashMap<Integer, String>();

		for(User user:allUser) {
			
		}
		model.addAttribute("allUser",allUser);
		model.addAttribute("places", places);
		model.addAttribute("totalCount", pageData.getTotalElements());
		model.addAttribute("totalPage", pageData.getTotalPages());
		model.addAttribute("page", page);
		return "usermain";
		}
	
	@Override
	public NativePlace findNativePlaceByNativeplace(String Nativeplace) {
		return nativePlaceRepository.findNativePlaceByNativeplace(Nativeplace);
	}
	
	@Override
	public String findNativeplaceById(Integer id) {
		return nativePlaceRepository.findNativeplaceById(id);		
	}

}
