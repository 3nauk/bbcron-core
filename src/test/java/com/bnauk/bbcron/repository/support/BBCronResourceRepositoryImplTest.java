package com.bnauk.bbcron.repository.support;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.bnauk.bbcron.repository.BBCronResourceRepository;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.query.MongoEntityInformation;

@ExtendWith(MockitoExtension.class)
//@RunWith(JUnitPlatform.class)
class BBCronResourceRepositoryImplTest {

  @Mock
  private MongoOperations mongoOperations;
  @Mock
  private MongoEntityInformation entityInformation;

  @InjectMocks
  private BBCronResourceRepositoryImpl<BBCronTestDomain, String> bbCronResourceRepository;

  @BeforeEach
  void init() {
    bbCronResourceRepository = new BBCronResourceRepositoryImpl(entityInformation, mongoOperations);
  }

  @Test
  void find_all_by_query_and_page() {
    assertNotNull(bbCronResourceRepository.findAll(new Query(), new Pageable() {
      @Override
      public int getPageNumber() {
        return 0;
      }

      @Override
      public int getPageSize() {
        return 0;
      }

      @Override
      public long getOffset() {
        return 0;
      }

      @Override
      public Sort getSort() {
        return Sort.by("testId").ascending();
      }

      @Override
      public Pageable next() {
        return null;
      }

      @Override
      public Pageable previousOrFirst() {
        return null;
      }

      @Override
      public Pageable first() {
        return null;
      }

      @Override
      public Pageable withPage(int pageNumber) {
        return null;
      }

      @Override
      public boolean hasPrevious() {
        return false;
      }
    }));
  }

  @Test
  void find_all_by_query() {
    assertNotNull(bbCronResourceRepository.findAll(new Query()));
  }
}

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "tests")
@JsonPropertyOrder(value = {"testId", "testName"})
class BBCronTestDomain {

  /**
   * Test Id
   */
  @Id
  private String testId;

  /**
   * Test name
   */
  private String testName;


}