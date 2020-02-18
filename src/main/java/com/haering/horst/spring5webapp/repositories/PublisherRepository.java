package com.haering.horst.spring5webapp.repositories;

import com.haering.horst.spring5webapp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
