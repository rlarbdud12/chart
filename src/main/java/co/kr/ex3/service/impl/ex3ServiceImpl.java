package co.kr.ex3.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import co.kr.ex3.service.ex3Service;
import co.kr.ex3.vo.Ex3VO;

@Service("ex3Service")
public class ex3ServiceImpl implements ex3Service{
	@Resource(name = "ex3Mapper")
	private ex3Mapper mapper;

	@Override
	public List<Ex3VO> getList(Ex3VO vo) {
		return mapper.getList(vo);
	}

	@Override
	public Object getDetail(int id) {
		mapper.getCnt(id);
		return mapper.getDetail(id);
	}

	@Override
	public void insert(Ex3VO vo) {
		mapper.insert(vo);
	}

	@Override
	public void getUpdate(Ex3VO vo) {
		mapper.getUpdate(vo);
	}

	@Override
	public void getDelete(int id) {
		mapper.getDelete(id);
	}

	@Override
	public int ex3Cnt(Ex3VO vo) {
		return mapper.ex3Cnt(vo);
	}

	@Override
	public Ex3VO paging(Ex3VO vo) {
		vo.setListCnt(mapper.ex3Cnt(vo));
		vo.test();
		vo.setList(mapper.getList(vo));
		return vo;
	}

	@Override
	public void fileUpload(Ex3VO vo) {
		mapper.fileUpload(vo);
	}

	@Override
	public List<Ex3VO> ex3DtCnt() {
		return mapper.ex3DtCnt();
	}


}
