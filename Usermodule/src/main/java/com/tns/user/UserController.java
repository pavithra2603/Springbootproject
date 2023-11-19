package com.tns.user;

import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	

		
	@Autowired
	private UserService service;

	//Method to perform Retrieval Operation
	@GetMapping("/usertable")
	public List<User> list()
		{
			return service.listAll();
		}

	@RequestMapping(value="/usertable/{id}", method=RequestMethod.GET)
	public ResponseEntity<User>get(@PathVariable Integer id)
		{
		 try
		    {
			  User user=service.get(id);
			  return new ResponseEntity<User>(user, HttpStatus.OK);
		    }
		 catch(NoSuchElementException e)
		    {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		    }
		}

	//Method to perform Create Operation
	@PostMapping("/usertable")
	public void add(@RequestBody User user)
		{
			service.save(user);
		}

	//Method to perform Update Operation
	@PutMapping("/usertable/{id}")
	public ResponseEntity<?>update(@RequestBody User user,@PathVariable Integer id)
		{
		 try
		   {
			User userexist=service.get(id);
			service.save(user);
			return new ResponseEntity<>(HttpStatus.OK);
		   }
		catch(NoSuchElementException e)
		   {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		   }
		}

	//Method to perform Delete Operation
	@DeleteMapping("/usertable/{id}")
	public void delete(@PathVariable Integer id)
		{
			service.delete(id);
		}
	}





