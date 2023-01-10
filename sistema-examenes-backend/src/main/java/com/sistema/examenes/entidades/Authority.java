<<<<<<< HEAD
package com.sistema.examenes.entidades;

import org.springframework.security.core.GrantedAuthority;

public class Authority implements GrantedAuthority {

	private String authoriry;
	
	public Authority() {
		super();
	}
	
	public Authority(String authoriry) {
		super();
		this.authoriry = authoriry;
	}


	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return this.authoriry;
	}

}
=======
package com.sistema.examenes.entidades;

import org.springframework.security.core.GrantedAuthority;

public class Authority implements GrantedAuthority {

	private String authoriry;
	
	public Authority() {
		super();
	}
	
	public Authority(String authoriry) {
		super();
		this.authoriry = authoriry;
	}


	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return this.authoriry;
	}

}
>>>>>>> bcf4f66556863e567b479d84164c3e110563edeb
