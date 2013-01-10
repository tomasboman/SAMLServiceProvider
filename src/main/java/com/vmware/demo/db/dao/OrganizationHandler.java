package com.vmware.demo.db.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.vmware.demo.db.entity.IdentityProvider;

@Component
public class OrganizationHandler {
	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public void save(IdentityProvider idp) {
		if (idp.getId()==0) {
			entityManager.persist(idp);
		} else {
			entityManager.merge(idp);
		}
	}

	@Transactional
	public List<IdentityProvider> getAllIdentityProviders() {
		TypedQuery<IdentityProvider> query = entityManager.createQuery("SELECT idp FROM IdentityProvider idp ORDER BY idp.id", IdentityProvider.class);
		return query.getResultList();
	}
	
	@Transactional
	public IdentityProvider load(Integer id) {
		IdentityProvider idp = entityManager.find(IdentityProvider.class, id);
		return idp;
	}

	@Transactional
	public void delete(Integer id) {
		IdentityProvider idp = load(id);
		if (null!=idp) {
			entityManager.remove(entityManager.find(IdentityProvider.class, id));
		}
	}
}
