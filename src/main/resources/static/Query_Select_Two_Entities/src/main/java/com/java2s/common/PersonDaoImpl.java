package com.java2s.common;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public class PersonDaoImpl {
  public void test(){
    prepareData();
    List l = em.createQuery("SELECT d, m  FROM Department d, Professor m WHERE d = m.department").getResultList();
    for(Object p:l){
      System.out.println(p);
    }
  }
  
  private void prepareData(){
    Professor p = new Professor();
    p.setId(0);
    p.setName("TOM");
    
    Department d = new Department();
    d.setId(1);
    d.setName("Design");
    
    p.setDepartment(d);
    d.getProfessors().add(p);
    
    em.persist(p);
    em.persist(d);
  }
	@PersistenceContext
	private EntityManager em;
}
