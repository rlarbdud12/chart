package co.kr.ex3.vo;

import java.util.List;

public class Ex3VO {
	private int id;
	private String title;
	private String writer;
	private String contents;
	private String dt;
	private String tm;
	private int page;
	private int offset;
	private int cnt;
	private int listCnt;
	private List<Ex3VO> list;
	private int btnSu;
	private long size;
	private String fPath;
	private String ext;
	private String fId;
	private String orgNm;
	private int startBlock;
	private String fName;
	private int dtcnt;

	public final int getDtcnt() {
		return dtcnt;
	}
	public final void setDtcnt(int dtcnt) {
		this.dtcnt = dtcnt;
	}
	public final String getfName() {
		return fName;
	}
	public final void setfName(String fName) {
		this.fName = fName;
	}
	public final int getStartBlock() {
		return startBlock;
	}
	public final void setStartBlock(int startBlock) {
		this.startBlock = startBlock;
	}
	public final int getId() {
		return id;
	}
	public final void setId(int id) {
		this.id = id;
	}

	public final String getTitle() {
		return title;
	}
	public final void setTitle(String title) {
		this.title = title;
	}

	public final String getWriter() {
		return writer;
	}
	public final void setWriter(String writer) {
		this.writer = writer;
	}

	public final String getContents() {
		return contents;
	}
	public final void setContents(String contents) {
		this.contents = contents;
	}

	public final String getDt() {
		return dt;
	}
	public final void setDt(String dt) {
		this.dt = dt;
	}

	public final String getTm() {
		return tm;
	}
	public final void setTm(String tm) {
		this.tm = tm;
	}

	public final int getPage() {
		return page;
	}
	public final void setPage(int page) {
		this.page = page;
	}

	public final int getOffset() {
		return offset;
	}
	public final void setOffset(int offset) {
		this.offset = offset;
	}

	public final int getCnt() {
		return cnt;
	}
	public final void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public final int getListCnt() {
		return listCnt;
	}
	public final void setListCnt(int listCnt) {
		this.listCnt = listCnt;
	}

	public final List<Ex3VO> getList() {
		return list;
	}
	public final void setList(List<Ex3VO> list) {
		this.list = list;
	}

	public final int getBtnSu() {
		return btnSu;
	}
	public final void setBtnSu(int btnSu) {
		this.btnSu = btnSu;
	}

	public final long getSize() {
		return size;
	}
	public final void setSize(long size) {
		this.size = size;
	}

	public final String getfPath() {
		return fPath;
	}
	public final void setfPath(String fPath) {
		this.fPath = fPath;
	}

	public final String getExt() {
		return ext;
	}
	public final void setExt(String ext) {
		this.ext = ext;
	}

	public final String getfId() {
		return fId;
	}
	public final void setfId(String fId) {
		this.fId = fId;
	}

	public final String getOrgNm() {
		return orgNm;
	}
	public final void setOrgNm(String orgNm) {
		this.orgNm = orgNm;
	}
	
	
	
	@Override
	public String toString() {
		return "Ex3VO [id=" + id + ", title=" + title + ", writer=" + writer + ", contents=" + contents + ", dt=" + dt
				+ ", tm=" + tm + ", page=" + page + ", offset=" + offset + ", cnt=" + cnt + ", listCnt=" + listCnt
				+ ", list=" + list + ", btnSu=" + btnSu + ", size=" + size + ", fPath=" + fPath + ", ext=" + ext
				+ ", fId=" + fId + ", orgNm=" + orgNm + ", startBlock=" + startBlock + ", fName=" + fName + ", dtcnt="
				+ dtcnt + "]";
	}
	
	public void test(){
		this.offset = ((page-1)*10);
		this.startBlock = ((((int)Math.ceil(page/5.0)-1)*5)+1);
		this.btnSu = (int)Math.ceil(listCnt/10.0);
	}
	
/*	public void test(){
		this.offset = (this.page-1) * 10;
		this.startBlock = (((int)Math.ceil(this.page/5.0)-1) * 5) + 1;
	}*/

}
