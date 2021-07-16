package com.bnauk.bbcron.repository.support;

import com.bnauk.bbcron.repository.BBCronResourceRepository;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.query.MongoEntityInformation;
import org.springframework.data.mongodb.repository.support.SimpleMongoRepository;
import org.springframework.util.Assert;

public class BBCronResourceRepositoryImpl<T, I extends Serializable>
    extends SimpleMongoRepository<T, I> implements BBCronResourceRepository<T, I> {

  private MongoOperations mongoOperations;
  private MongoEntityInformation entityInformation;

  public BBCronResourceRepositoryImpl(final MongoEntityInformation entityInformation,
      final MongoOperations mongoOperations) {
    super(entityInformation, mongoOperations);

    this.entityInformation = entityInformation;
    this.mongoOperations = mongoOperations;
  }

  @Override
  public Page<T> findAll(final Query query, final Pageable pageable) {
    Assert.notNull(query, "Query must not be null!");

    long total = mongoOperations.count(query, entityInformation.getJavaType(),
        entityInformation.getCollectionName());
    List<T> content = mongoOperations.find(query.with(pageable), entityInformation.getJavaType(),
        entityInformation.getCollectionName());

    return new PageImpl<T>(content, pageable, total);
  }

  @Override
  public List<T> findAll(Query query) {
    Assert.notNull(query, "Query must not be null!");
    return mongoOperations.find(query, entityInformation.getJavaType(),
        entityInformation.getCollectionName());
  }
}
