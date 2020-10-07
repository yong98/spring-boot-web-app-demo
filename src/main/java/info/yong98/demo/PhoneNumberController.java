package info.yong98.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import info.yong98.demo.service.IPhoneNumberService;
import info.yong98.demo.service.domain.WordsDto;

@RestController
public class PhoneNumberController {
	private static final Logger logger = LoggerFactory.getLogger(PhoneNumberController.class);

	@Autowired
	private IPhoneNumberService service;
	
	@PutMapping("/api")
	public WordsDto put(@RequestBody String phoneNumber) {
		logger.info("finding words for " + phoneNumber);
		return service.put(phoneNumber);
	}

	@GetMapping("/api/list/{phoneNumber}/{pageId}")
	public WordsDto list(@PathVariable("phoneNumber") String phoneNumber, @PathVariable("pageId") String pageId) {
		logger.info("getting words for " + phoneNumber + " for page# " + pageId);
		return service.list(phoneNumber, pageId);
	}
}
