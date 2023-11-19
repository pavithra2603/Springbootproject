package com.tns.user;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="usertable")
public class User {
	
    public User()
	      {
			super();
		  }
	        private int id;
			private String name;
			private String type;
			private String Password;

	public User(int id, String name, String type, String password)
		   {
			super();
			this.id = id;
			this.name = name;
			this.type = type;
			Password = password;
		   }
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() 
	       {
			return id;
		   }

	public void setId(int id)
		   {
			this.id = id;
		   }

	public String getName() 
		   {
			return name;
		   }

	public void setName(String name)
		   {
			this.name = name;
		   }

	public String getType() 
		   {
			return type;
		   }

	public void setType(String type) 
		   {
			this.type = type;
		   }

	public String getPassword() 
		   {
			return Password;
		   }

	public void setPassword(String password) 
		   {
			Password = password;
		   }
	@Override
	public String toString() 
		   {
			return "User [id=" + id + ", name=" + name + ", type=" + type + ", Password=" + Password + "]";
		   }
	}

