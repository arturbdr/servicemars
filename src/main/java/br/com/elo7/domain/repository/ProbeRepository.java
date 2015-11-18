package br.com.elo7.domain.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.elo7.domain.Probe;
import br.com.elo7.domain.to.Coordinates;

@Repository
public class ProbeRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	public Probe save(Probe probe) {
		return entityManager.merge(probe);
	}

	public Probe find(Long id) {
		return entityManager.find(Probe.class, id);
	}
	
	public void delete(Probe probe) {
		entityManager.remove(probe);
	}

	public Probe findByCoordinates(Coordinates coordinates) {
		TypedQuery<Probe> query = entityManager.createQuery("SELECT p FROM PROBE P WHERE p.coodinates.latitude = :latitude and p.coodinates.longitude = :longitude", Probe.class);
		query.setParameter(":latitude", coordinates.getLatitude());
		query.setParameter(":longitude", coordinates.getLongitude());
		return query.getSingleResult();
	}
}

