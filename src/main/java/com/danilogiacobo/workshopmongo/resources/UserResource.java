package com.danilogiacobo.workshopmongo.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.danilogiacobo.workshopmongo.domain.User;
import com.danilogiacobo.workshopmongo.dto.UserDTO;
import com.danilogiacobo.workshopmongo.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	@Autowired
	private UserService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<UserDTO>> findAll() {
		// List<User> list = new ArrayList<>();
		//User maria = new User("1001", "Maria Brown", "maria@gmail.com");
		//User alex = new User("1002", "Alex Green", "alex@gmail.com");
		// list.addAll(Arrays.asList(maria, alex));
		//return ResponseEntity.ok().body(list);
		List<User> list = service.findAll();
		List<UserDTO> listDTO = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
}
