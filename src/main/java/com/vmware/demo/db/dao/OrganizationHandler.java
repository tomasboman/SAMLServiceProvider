/*****************************************************************
 * Copyright (c) 2013 VMware, Inc. All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * 
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
