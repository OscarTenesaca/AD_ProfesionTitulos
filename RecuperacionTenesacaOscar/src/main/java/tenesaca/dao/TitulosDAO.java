package tenesaca.dao;


import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import tenesaca.modelo.Profecional;
import tenesaca.modelo.Titulos;

@Stateless
public class TitulosDAO {
	
	
	@Inject
	private EntityManager em;
	
	
	public void insertarProfecional(Profecional p) {
		em.persist(p);
		
	}
	
	
	public void insertarTitulos(Titulos t) {
		em.persist(t);
		
	}
	
	
	public Profecional readProfecional(String cedula) {
		return em.find(Profecional.class, cedula);
	}
	
	
	
	public List<Titulos> getTitulos(String cedula){
		
		Profecional profecionales= readProfecional(cedula);
		String jpql ="SELECT t FROM Titulos t WHERE t.profesional =: profecionales ORDER BY t.codigo";
		Query q = em.createQuery(jpql, Titulos.class);
		q.setParameter("profecionales", profecionales);
		List<Titulos> titulos = q.getResultList();
		System.out.println(titulos+"dao");

		return titulos;
		
		
	}
	
	
	public List<Profecional> getProfecionales(){
		String jpql = "SELECT p FROM Profecional p";
		Query q = em.createQuery(jpql, Profecional.class);
		
		List< Profecional> profesionales = q.getResultList();
		System.out.println("");
		System.out.println(profesionales);
		return profesionales;
		
		
	}
	
	
	//// agegado
	public List<Titulos> getTodosTitulos(){
		String jpql = "SELECT t FROM Titulos t";
		Query q = em.createQuery(jpql, Titulos.class);
		
		List< Titulos> titulos = q.getResultList();
		System.out.println("");
		System.out.println(titulos);
		return titulos;
		
		
	}
	
	
	
	

	
	/////// prueba
//		
//	public List<Titulos> getTitulosxCedula(String cedula){
//		
//		Profecional profecionales= readProfecional(cedula);
//		String jpql ="SELECT t FROM Titulos t WHERE t.profesional =: profecionales ORDER BY t.codigo";
//		Query q = em.createQuery(jpql, Titulos.class);
//		q.setParameter("profecionales", profecionales);
//		List<Titulos> titulos = q.getResultList();
//		System.out.println(titulos+"dao");
//
//		return titulos;
//		
//		
//	}
	
	

}
