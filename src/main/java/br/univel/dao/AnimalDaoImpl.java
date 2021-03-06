package br.univel.dao;

import java.util.ArrayList;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.univel.model.Animal;

@Stateless
@Remote(AnimalDao.class)
public class AnimalDaoImpl implements AnimalDao {

	@PersistenceContext(unitName = "QuatroPatasServer-persistence-unit")
	EntityManager em;

	@Override
	public Animal create(Animal animal) {

		em.persist(animal);

		return animal;
	}

	@Override
	public Animal getById(int id) {

		Animal animal = em.find(Animal.class, id);

		return animal;
	}

	@Override
	public void delete(Animal animal) {

		
		Animal an = em.find(Animal.class, animal.getId());
		
		em.remove(an);

	}

	@Override
	public Animal edit(Animal animal) {

		em.merge(animal);

		return animal;
	}

	@Override
	public ArrayList<Animal> getAll() {

		Query q = em.createQuery("from Animal");

		ArrayList<Animal> animais = (ArrayList<Animal>) q.getResultList();

		return animais;

	}

}
