package co.kr.ex3.service.impl;

import java.util.List;

import co.kr.ex3.vo.Ex3VO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper("ex3Mapper")
public interface ex3Mapper {
	List<Ex3VO> getList(Ex3VO vo);
	
	Object getDetail(int id);
	
	void insert(Ex3VO vo);

	void getUpdate(Ex3VO vo);
	
	void getDelete(int id);
	
	void getCnt(int id);
	
	int ex3Cnt(Ex3VO vo);
	
	void fileUpload(Ex3VO vo);
	
	List<Ex3VO> ex3DtCnt();
	
}
