package info.yong98.demo.service;

import java.util.List;

import info.yong98.demo.service.domain.WordsDto;

public interface IPhoneNumberService {
	WordsDto put(String phoneNumber);
	WordsDto list(String phoneNumber, String pageId);

}
