package info.yong98.demo.service.domain;

import java.io.Serializable;
import java.util.List;

public class WordsDto implements Serializable {
	private Integer counts;
	private Integer pageId;
	private List<String> words;
	
	public Integer getCounts() {
		return counts;
	}
	public void setCounts(Integer counts) {
		this.counts = counts;
	}
	public List<String> getWords() {
		return words;
	}
	public void setWords(List<String> words) {
		this.words = words;
	}
	public Integer getPageId() {
		return pageId;
	}
	public void setPageId(Integer pageId) {
		this.pageId = pageId;
	}
	

}
