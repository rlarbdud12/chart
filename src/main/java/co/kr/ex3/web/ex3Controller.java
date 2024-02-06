package co.kr.ex3.web;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/*import java.util.List;*/

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import co.kr.ex3.service.ex3Service;
import co.kr.ex3.vo.Ex3VO;

@Controller
public class ex3Controller {
	@Resource(name = "ex3Service")
	private ex3Service service;
	
	@RequestMapping(value = "main.do", method=RequestMethod.GET)
	public String main(Model md){
/*		List<Ex3VO> ex3List = service.getList();
		md.addAttribute("data", ex3List);*/
		return "main";
	}
	
	@RequestMapping(value = "/detail.do")
	public String detail(Model md, int id){
		md.addAttribute("data", service.getDetail(id));
		return "detail";
	}
	
	@RequestMapping(value = "insertPage.do")
	public String insertPage(){
		return "insert";
	}

	@RequestMapping(value = "insert.do", method=RequestMethod.POST)
	public String insert(Ex3VO vo, @RequestParam("file") MultipartFile file) throws IOException{
		
		if(file.getOriginalFilename() != ""){
			String uuid = UUID.randomUUID().toString();
			vo.setfId(uuid);
			vo.setOrgNm(file.getOriginalFilename());
			vo.setfPath("F:/workspace/upload");
			vo.setSize(file.getSize());
			vo.setExt(file.getContentType());

			File newFile = new File("F:/workspace/upload/"+uuid+"_"+file.getOriginalFilename());
			file.transferTo(newFile);
			
			service.fileUpload(vo);
		}else{
			System.out.println("파일 없음");
		}
		service.insert(vo);
        
		return "redirect:/main.do";
	}
	
	@RequestMapping(value = "updatePage.do")
	public String updatePage(Model md, int id){
		md.addAttribute("data", service.getDetail(id));
		return "update";
	}
	
	@RequestMapping(value = "update.do", method=RequestMethod.POST)
	public String update(Ex3VO vo){
		service.getUpdate(vo);
		return "redirect:/main.do";
	}
	
	@RequestMapping(value = "delete.do")
	public String delete(int id){
		service.getDelete(id);
		return "redirect:/main.do";
	}
	
	@RequestMapping(value = "/chart.do")
	public String chart(){
		return "chart";
	}
	
	@RequestMapping(value = "/getChart.do")
	public ModelAndView getChart(){
		ModelAndView mav = new ModelAndView("jsonView");
		List<Ex3VO> ex3List = service.ex3DtCnt();
		mav.addObject("data", ex3List);
		System.out.println(mav);
		return mav;
	}

	
	
	@RequestMapping(value = "/paging.do")
/*	public ModelAndView paging(Ex3VO vo){
		ModelAndView mav = new ModelAndView("jsonView");
		
		List<Ex3VO> ex3List = service.getList();
		mav.addObject("data", ex3List);
		return mav;*/
		
/*	public ModelAndView paging(Ex3VO vo){
		ModelAndView mav = new ModelAndView("jsonView");
		
		
//		HashMap<String, Object> paging = new HashMap<String, Object>();
		
//		int page = Integer.parseInt(vo.get("page").toString());
//		int offset = (page-1) * 10;
//		vo.put("offset", offset);
		vo.setOffset((vo.getPage()-1)*10);
		
//		List<Ex3VO> ex3List = service.getList(vo);
		vo.setList(service.getList(vo));
		
//		vo.setPage(vo.getCnt());
//		int cnt = (int)Math.ceil(service.ex4Cnt(vo)/10.0);		//페이지수
		vo.setListCnt((int)Math.ceil(service.ex3Cnt(vo)/10.0));
//		int startBlock = (((int)Math.ceil(page/5.0)-1) * 5) + 1; //블록시작번호
		vo.setStartBlock(((  (int)Math.ceil (vo.getPage()/5.0)   -1)*5)+1);
//		paging.put("cnt", cnt);
//		paging.put("startBlock", startBlock);
		
		mav.addObject("list", ex3List);
		mav.addObject("paging", vo);
		return mav;
	}*/
	
	
	public ModelAndView paging(Ex3VO vo){
		ModelAndView mav = new ModelAndView("jsonView");
		vo = service.paging(vo);
		mav.addObject("paging", vo);
		return mav;
	}
	
}
