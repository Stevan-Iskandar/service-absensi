package com.example.Ujian4.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.example.Ujian4.model.Group;
import com.example.Ujian4.model.Personnel;
import com.example.Ujian4.model.Position;
import com.example.Ujian4.model.User;

public class Controller {
	User user;
	Personnel  personnel;
	Position position;
	Group group;

	EntityManager em;

	private Controller() {
		em = Service.getInstance().getEntityManager().createEntityManager();
	}

	public static Controller getInstance() {
		return ControllerHolder.INSTANCE;
	}

	public static class ControllerHolder {
		private static final Controller INSTANCE = new Controller();
	}
	
//	
	
	public void addUser() {
		user = new User();
		personnel = new Personnel();
		position = new Position();
		group = new Group();
		
		user.setId(2);
		user.setUsername("Aldi");
		user.setEmail("aldi@klien1.co.id");
		user.setPersonnel(personnel);
		
		personnel.setId(2);
		personnel.setCode("PERSONNEL/PROGRAMMER1");
		personnel.setUserId(user.getId());
		personnel.setPhotoUrl("http://localhost/storage/JN1/programmer/profile/D0JH0sJ1X2Kf0D7nqlPPhM4oNw0oKOTS9cwZqhI2.jpeg");
		personnel.setFirstName("Johar");
		personnel.setMiddleName("Adi");
		personnel.setLastName("Budi1");
		personnel.setCompleteName(personnel.getFirstName() + " " + personnel.getMiddleName() + " " + personnel.getLastName());
		personnel.setGender("pria");
		personnel.setHeight("176cm");
		personnel.setWeight("80kg");
		personnel.setDob("17 November 1995");
		personnel.setPob("Jakarta");
		personnel.setHp("085712345667");
		personnel.setAddress("Jl. Klien 1");
		personnel.setFirebaseToken(null);
		personnel.setDeviceId("Nomor IMEI");
		personnel.setPosition(position);
		
		position.setId(3);
		position.setCode("PROGRAMMER");
		position.setName("programmer");
		position.setDescription("programmer");
		position.setStatus(1);
		position.setCreatedByUserId(1);
		position.setCreatedAt("2019-04-23 05:38:50");
		position.setUpdatedByUserId(null);
		position.setUpdatedAt(null);
		position.setDeletedByUserId(null);
		position.setDeletedAt(null);
		
		group.setId(1);
		group.setCode("RGU1-PJK1-KLN1-KCB1-JN1");
		group.setName("Regu 1 (PJK1-KLN1-KCB1-JN1)");
		group.setProjectId(1);
		group.setMinimumPersonnel(5);
		group.setDescription("Regu 1 - PJK1 - KLN1 - KCB1 - JN1");
		group.setAttendanceQrCode("abcdefghijklmnopqrstuvwxyz");
		group.setStatus(1);
		
		em.getTransaction().begin();
		em.merge(user);
		em.merge(personnel);
		em.merge(position);
		em.merge(group);

		em.getTransaction().commit();
		
		System.out.println("coba");
	}
	
	public List<User> getAllUser() {
		TypedQuery<User> query = em.createQuery("select a from User a", User.class);
		return query.getResultList();
	}
	
	public List<User> searchNameUser(String name) {
		TypedQuery<User> query = em.createQuery("select a from User a where a.complete_name like '%"+name+"%'", User.class);
		return query.getResultList();
	}
}
