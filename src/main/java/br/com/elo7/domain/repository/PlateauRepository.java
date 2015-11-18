package br.com.elo7.domain.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.elo7.domain.Plateau;
import br.com.elo7.domain.to.Coordinates;

@Repository
public class PlateauRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public Plateau save(Plateau plateau) {
		return entityManager.merge(plateau);
	}
	
	public Plateau find(Long id) {
		return entityManager.find(Plateau.class, id);
	}
	
	public Plateau findByCoordinates(Coordinates coordinates) {
		TypedQuery<Plateau> query = entityManager.createQuery("SELECT p FROM PLATEAU P WHERE p.coodinates.latitude = :latitude and p.coodinates.longitude = :longitude", Plateau.class);
		query.setParameter(":latitude", coordinates.getLatitude());
		query.setParameter(":longitude", coordinates.getLongitude());
		return query.getSingleResult();
	}

}
