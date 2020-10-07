package info.yong98.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import info.yong98.demo.service.IPhoneNumberService;
import info.yong98.demo.service.domain.WordsDto;
import info.yong98.util.PhoneNumber2WordConvertor;

@Service
public class PhoneNumberServiceImpl implements IPhoneNumberService {
	static int pageSize = 20;

	@Override
	public WordsDto put(String phoneNumber) {
		List<String> words =  PhoneNumber2WordConvertor.getWords(phoneNumber);
		if (null == words || words.isEmpty())
			return null;
		WordsDto dto = new WordsDto();
		dto.setCounts(words.size());
		dto.setPageId(1);
		dto.setWords(words.subList(0, pageSize));
		return dto;
	}

	@Override
	public WordsDto list(String phoneNumber, String pageId) {
		List<String> words = PhoneNumber2WordConvertor.getWords(phoneNumber);
		if (null == words || words.isEmpty())
			return null;
		try {
			int page = Integer.parseInt(pageId);
			WordsDto dto = new WordsDto();
			dto.setCounts(words.size());
			dto.setPageId(Integer.parseInt(pageId));
			int fromIndex = pageSize * (page - 1);
			int toIndex = pageSize * page;
			dto.setWords(words.subList(fromIndex, toIndex > words.size() ? words.size() : toIndex));
			return dto;
		} catch (NumberFormatException e) {
			return null;
		}
	}

}
