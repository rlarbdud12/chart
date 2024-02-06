package co.kr.ex3.service;

import java.util.List;

import co.kr.ex3.vo.Ex3VO;

public interface ex3Service {

	List<Ex3VO> getList(Ex3VO vo);

	Object getDetail(int id);
	
	void insert(Ex3VO vo);

	void getUpdate(Ex3VO vo);

	void getDelete(int id);

	int ex3Cnt(Ex3VO vo);
	
	Ex3VO paging(Ex3VO vo);

	void fileUpload(Ex3VO vo);

	List<Ex3VO> ex3DtCnt();

}
