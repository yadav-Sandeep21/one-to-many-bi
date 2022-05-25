package com.ty.HospitalBranch;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSaveHospitalBranch {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Hospital hospital=new Hospital();
		hospital.setName("Fortis");
		hospital.setGstNumber(3);
		hospital.setWebsite("www.fortis.com");
		
		Branch branch1=new Branch();
		branch1.setName("Fortis Bangalore");
		branch1.setAddress("BTM Layout, Bangalore");
		branch1.setPhone(987655432l);
		
		Branch branch2=new Branch();
		branch2.setName("Fortis Uttar Pradesh");
		branch2.setAddress("MahuaBag, Ghazipur");
		branch2.setPhone(887655432l);
		
		Branch branch3=new Branch();
		branch3.setName("Fortis Hydrabad");
		branch3.setAddress("Abc, hydrabad");
		branch3.setPhone(687655432l);
		
		List<Branch> branch=new ArrayList<Branch>();
		branch.add(branch1);
		branch.add(branch2);
		branch.add(branch3);
		
		hospital.setBranch(branch);
		branch1.setHospital(hospital);
		branch2.setHospital(hospital);
		branch3.setHospital(hospital);
		
		entityTransaction.begin();
		entityManager.persist(hospital);
		entityManager.persist(branch1);
		entityManager.persist(branch2);
		entityManager.persist(branch3);
		entityTransaction.commit();
		
	}

}
