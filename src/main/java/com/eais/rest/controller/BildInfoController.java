package com.eais.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.eais.rest.model.BildInfo;
import com.eais.rest.service.BildInfoService;


/*
 * @Controller 기존 MVC 컨트롤레는 view기술 사용해 jsp 화면 보여줌
 * 스프링 4.0부터 @RestController 객체반환만하면 직접 데이터(HTTP Response Body생성) 리턴 
 */
@RestController
public class BildInfoController {
	
	/*
	 * @Autowired 기존의 get/set접근메서드 역할
	 * bean의 요구사항과 매칭되는 다른 bean은 찾아 bean간의 의존성 자동만족
	 * 
	 */
	@Autowired
	private BildInfoService bildInfoService;
	
	/**
	 * 건축물대장 리스트 검색
	 * 
	 * @return ResponseEntity<List<BildInfo>>
	 */
	/*
	 * @RequestMapping 컨트롤러로 넘어오는 다양한 URL을 각기 다른 뷰로 보여줌 / HTTP요청방식에 따라 필터링해 보여주기가능(GET,POST,PUT/DELETE)  
	 * 축약형 @GetMapping @PostMapping @PutMapping @DeleteMapping
	 */
	@RequestMapping(value = "/bildInfo", method = RequestMethod.GET) 
	public ResponseEntity<List<BildInfo>> listAllBildInfo() {
		final List<BildInfo> allBildInfo = bildInfoService.findAllBildInfo();
		if (allBildInfo.isEmpty()) {
			return new ResponseEntity<List<BildInfo>>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<BildInfo>>(allBildInfo, HttpStatus.OK);
	}
 
	/**
	 * 건축물대장 번호 검색
	 * 
	 * @param bildNo BildInfo BildNo
	 * @return ResponseEntity<BildInfo>
	 */
	@RequestMapping(value = "/bildInfo/{bildNo}", method = RequestMethod.GET)
	public ResponseEntity<BildInfo> getBildInfo(@PathVariable("bildNo") final Long bildNo) {
		final BildInfo fetchedBildInfo = bildInfoService.findById(bildNo); 
		
		if (fetchedBildInfo == null) {
			return new ResponseEntity<BildInfo>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<BildInfo>(fetchedBildInfo, HttpStatus.OK);
	}

	/**
	 * 건축물대장 생성
	 * 
	 * @param bildInfo object to be created
	 * @param ucBuilder UriComponentBuilder
	 * @return ResponseEntity<Void>
	 */
	@RequestMapping(value = "/bildInfo", method = RequestMethod.POST)
	public ResponseEntity<Void> createBildInfo(@RequestBody final BildInfo bildInfo,
			final UriComponentsBuilder ucBuilder) {
		
		if (bildInfoService.isBildInfoExist(bildInfo)) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		final BildInfo savedBildInfo = bildInfoService.saveBildInfo(bildInfo);
		
		final HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/bildInfo/{bildNo}").buildAndExpand(savedBildInfo.getBildNo()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
 
	/**
	 * 건축물대장 수정
	 * 
	 * @param bildNo bildInfo BildNo to be updated
	 * @param bildInfo source BildInfo object to be updated
	 * @return ResponseEntity<BildInfo>
	 */
	@RequestMapping(value = "/bildInfo/{bildNo}", method = RequestMethod.PUT)
	public ResponseEntity<BildInfo> updateBildInfo(@PathVariable("bildNo") final Long bildNo,
			@RequestBody final BildInfo bildInfo) {
		final BildInfo updatedBildInfo = bildInfoService.updateBildInfo(bildNo, bildInfo);
		
		if (updatedBildInfo == null) {
			return new ResponseEntity<BildInfo>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<BildInfo>(updatedBildInfo, HttpStatus.OK);
	}
 

	/**
	 * 건축물대장 삭제
	 * 
	 * @param bildNo BildInfo BildNo to be deleted
	 * @return ResponseEntity<Void>
	 */
	@RequestMapping(value = "/bildInfo/{bildNo}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteBildInfo(@PathVariable("bildNo") final Long bildNo) {
		Boolean deleteResult = bildInfoService.deleteBildInfo(bildNo);
		
		if (deleteResult == null || !deleteResult) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
