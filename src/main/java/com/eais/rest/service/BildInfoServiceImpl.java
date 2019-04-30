package com.eais.rest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eais.rest.model.BildInfo;
import com.eais.rest.repository.BildInfoRepository;


/*
 * @Service 해당클래스가 Service라는것을 알리기위한 annotation
 */
@Service("bildInfoService")
public class BildInfoServiceImpl implements BildInfoService {
	
	@Autowired
	private BildInfoRepository bildInfoRepository;
 
	@Override
	public BildInfo findById(final Long bildNo) {
		return bildInfoRepository.findOne(bildNo);
	}
	
 
	@Override
	public List<BildInfo> findAllBildInfo() {
		return (List<BildInfo>) bildInfoRepository.findAll();
	}
 
	@Override
	public BildInfo saveBildInfo(final BildInfo bildInfo) {
		return bildInfoRepository.save(bildInfo);
	}
 
	@Override
	public Boolean isBildInfoExist(final BildInfo bildInfo) {
		if (bildInfo.getBildNo() != null) {
			final BildInfo existingBildInfo = bildInfoRepository.findOne(bildInfo.getBildNo());
			if (existingBildInfo == null) {
				return false;
			} else {
				return true;
			}
		} else {
			return false;
		}
	}
 
	@Override
	public BildInfo updateBildInfo(final Long bildNo, final BildInfo bildInfo) {
		
		final BildInfo fetchedBildInfo = bildInfoRepository.findOne(bildNo);
		if (fetchedBildInfo == null) {
			return null;
		}
		fetchedBildInfo.setBuldNm(bildInfo.getBuldNm());
		fetchedBildInfo.setBuldAddr(bildInfo.getBuldAddr());
		
		bildInfoRepository.save(fetchedBildInfo);
		
		return fetchedBildInfo;
	}
 
	 
	@Override
	public Boolean deleteBildInfo(final Long bildNo) {
		final BildInfo fetchedBildInfo = bildInfoRepository.findOne(bildNo);
		if (fetchedBildInfo == null) {
			return false;
		} else {
			bildInfoRepository.delete(fetchedBildInfo);
			return true;
		}
	}
 
}