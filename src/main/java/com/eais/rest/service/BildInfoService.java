package com.eais.rest.service;

import java.util.List;

import com.eais.rest.model.BildInfo;

public interface BildInfoService {
	
	/**
	 * 건축물대장번호 검색
	 * To return a bildInfo object fetched by bildNo
	 * 
	 * @param bildNo BildInfo BildNo
	 * @return BildInfo object
	 */
	BildInfo findById(Long bildNo);


	/**
	 * 건축물대장 리스트 검색
	 * @return the list of all BildNos
	 */
	List<BildInfo> findAllBildInfo();	

	/**
	 * 건축물대장 저장
	 * @param bildInfo BildInfo entity to be saved
	 */
	BildInfo saveBildInfo(BildInfo bildInfo);	
	
	/**
	 * 건축물대장 여부확인
	 * @param bildInfo BildInfo entity to check existence
	 * @return true if exist; otherwise, return false
	 */
	Boolean isBildInfoExist(BildInfo bildInfo);

	/**
	 * 건축물대장 수정
	 * @param bildNo BildInfo BildNo to be updated
	 * @param bildInfo updated BildInfo entity
	 * @return updated BildInfo entity
	 */
	BildInfo updateBildInfo(Long bildNo, BildInfo bildInfo);	

	/**
	 * 건축물대장 삭제
	 * @param bildNo BildInfo BildNo to be deleted
	 * @return true, if deleted; otherwise, return false
	 */
	Boolean deleteBildInfo(Long bildNo);
}
