package org.trueFanBoutique.model;

import javax.persistence.*;


@Entity
@Table(name="User")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id",unique = true, nullable = false)
	private Long id;
	@Column(nullable = false)
	private String firstName;
	@Column(nullable = false)
	private String lastName;
	@Column(nullable = false)
	private Long phone;
	@Column(nullable = false, unique =true)
	private String email;
	@Column(nullable = false)
	private String password;
	private String date; //TODO poner bien la fecha
	
	public Usuario(String firstName, String lastName, Long phone, String email, String password, String date) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.email = email;
		this.password = password;
		this.date = date;

	}//constructor 1


	public Usuario() {

	}//constructor2

	
	//Getters & Setters
	
	public Long getId() {
		return id;
	}//getId

	public void setId(Long id) {
		this.id = id;
	}//setId

	public String getFirstName() {
		return firstName;
	}//getFirstName

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}//setFirstName

	public String getLastName() {
		return lastName;
	}//getLastName

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}//setLastName

	public String getPassword() {
		return password;
	}//getPassword

	public void setPassword(String password) {
		this.password = password;
	}//setPassword

	public Long getPhone() {
		return phone;
	}//getPhone

	public void setPhone(Long phone) {
		this.phone = phone;
	}//setPhone

	public String getEmail() {
		return email;
	}//getEmail

	public void setEmail(String email) {
		this.email = email;
	}//setEmail

	public String getDate() {
		return date;
	}//getDate

	public void setDate(String date) {
		this.date = date;
	}//setDate

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", password=" + password
				+ ", phone=" + phone + ", email=" + email + ", date=" + date + "]";
	}//toString
	
}//class Usuario 
