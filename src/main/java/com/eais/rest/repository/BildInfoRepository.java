package com.eais.rest.repository;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.eais.rest.model.BildInfo;

/*
 * @Repository DB Exception Translation을 자동으로 해준다 
 * 흔히 알려진 DAO단 구성 / 테스트를위해 CrudRepository로대체
 */
@Repository
public interface BildInfoRepository extends CrudRepository<BildInfo, Long> {
	

}


