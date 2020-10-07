package info.yong98.demo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import info.yong98.demo.service.IPhoneNumberService;
import info.yong98.demo.service.domain.WordsDto;
import info.yong98.demo.service.impl.PhoneNumberServiceImpl;
import info.yong98.util.PhoneNumber2WordConvertor;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class)
public class UtilTest {

	private static final Logger logger = LoggerFactory.getLogger(UtilTest.class);
    @Autowired
    private IPhoneNumberService service;

	// setup
	@Configuration
	static class ContextConfiguration {
		@Bean
		IPhoneNumberService util() {
			return new PhoneNumberServiceImpl();
		}
	}

	@Test
	public final void convertTest() {
		List<String> words = PhoneNumber2WordConvertor.getWords("{\"phoneNumber\":\"4102300156\"}");
		assertTrue(words.size() > 0);
		for (String s : words)
			logger.info(s);
		logger.info(words.size() + " words possible");
	}

	@Test
	public final void servicePutTest() {
		Integer count = service.put("8273425").getCounts();
		assertTrue(count > 0);
		logger.info(count + " words possible");
	}

	@Test
	public final void serviceListTest() {
		WordsDto words = service.list("8273425", "3");
		assertTrue(words.getWords().size() == 20);
		for (String s : words.getWords())
			logger.info(s);
		logger.info(words.getCounts() + " words possible");
	}

}
