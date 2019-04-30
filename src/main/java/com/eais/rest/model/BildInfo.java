package com.eais.rest.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//@Entity Spring Data Jpa에서 엔티티클래스임을 지정하며 테이블과 매핑
@Entity
public class BildInfo{

	/*
	 * Spring Data Jpa에서
	 * @Id 기본키 할당
	 * @GeneratedValue = Auto_increment기능
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long bildNo;
	private String buldNm;
	private String buldAddr;
	
	protected BildInfo() {}
	
	public BildInfo(final String buldNm, final String buldAddr) {
		this.buldNm = buldNm;
		this.buldAddr = buldAddr;
	}
	
	public Long getBildNo() {
		return bildNo;
	}
	public void setBildNo(Long bildNo) {
		this.bildNo = bildNo;
	}
	public String getBuldNm() {
		return buldNm;
	}
	public void setBuldNm(String buldNm) {
		this.buldNm = buldNm;
	}
	public String getBuldAddr() {
		return buldAddr;
	}
	public void setBuldAddr(String buldAddr) {
		this.buldAddr = buldAddr;
	}
		
	
	@Override
	public String toString() {
		return "BildInfo [건축물대장번호=" + bildNo + ", 건물명=" + buldNm
				+ ", 건물주소=" + buldAddr + "]";
	}
}


