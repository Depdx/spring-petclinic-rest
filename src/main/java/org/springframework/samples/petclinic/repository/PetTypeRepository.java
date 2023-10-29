/*
 * Copyright 2016-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.samples.petclinic.repository;

import java.util.Collection;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.model.PetType;

/**
 * @author Vitaliy Fedoriv
 *
 */

public interface PetTypeRepository {

    @Cacheable(value = "pet_types")
	PetType findById(int id) throws DataAccessException;

    @Cacheable(value = "pet_types")
	Collection<PetType> findAll() throws DataAccessException;

    @CachePut(value = "pet_types", key = "#petType.id")
	void save(PetType petType) throws DataAccessException;

    @CacheEvict(value = "pet_types")
	void delete(PetType petType) throws DataAccessException;

}
