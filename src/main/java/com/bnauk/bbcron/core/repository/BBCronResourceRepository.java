package com.bnauk.bbcron.core.repository;

import java.io.Serializable;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BBCronResourceRepository<T, I extends Serializable> extends MongoRepository<T, I> {

  /**
   * Find All items paginated
   *
   * @param query as {@link Query}
   * @param pageable as {@link Pageable}
   * @return result as {@link Page}
   */
  Page<T> findAll(Query query, Pageable pageable);

  /**
   * Find All items
   *
   * @param query as {@link Query}
   * @return result as {@link List<T>}
   */
  List<T> findAll(Query query);
}
