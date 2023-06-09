package steve.code.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Student implements Serializable {
	@Id
	@GeneratedValue
 private Long id;
	@Column(name="NOM",length=30)
 private String nom;
 private Date dateNaissance;
 private String email;
 private String photo;
 
 // For Me
public Student( String nom, Date dateNaissance, String email, String photo) {
	super();
	this.nom = nom;
	this.dateNaissance = dateNaissance;
	this.email = email;
	this.photo = photo;
}
// For JPA and Me 
public Student() {
	super();
	// TODO Auto-generated constructor stub
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public Date getDateNaissance() {
	return dateNaissance;
}
public void setDateNaissance(Date dateNaissance) {
	this.dateNaissance = dateNaissance;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPhoto() {
	return photo;
}
public void setPhoto(String photo) {
	this.photo = photo;
}
 
}
