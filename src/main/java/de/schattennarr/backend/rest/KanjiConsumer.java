package de.schattennarr.backend.rest;
import de.schattennarr.kanjisheetwriter.Application;
import de.schattennarr.kanjisheetwriter.data.KanjiDTO;
import de.schattennarr.kanjisheetwriter.data.KanjiRestDTO;
import javassist.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

/*
* This class returns a KanjiDTO Object for any Kanji given
* */
public class KanjiConsumer
{
	private static final Logger logger = LoggerFactory.getLogger(KanjiConsumer.class);

	public KanjiDTO getKanjiDTO(String kanji) throws NotFoundException
	{
		String resourceUrl = "https://kanjiapi.dev/v1/kanji/";
		RestTemplate restTemplate = new RestTemplate();
		KanjiRestDTO kanjiRestDTO = restTemplate.getForObject(resourceUrl + kanji, KanjiRestDTO.class);

		KanjiDTO kanjiDTO = new KanjiDTO(kanjiRestDTO.getKanji(), kanjiRestDTO.getGrade(),
				kanjiRestDTO.getStrokeCount(), kanjiRestDTO.getMeanings(), kanjiRestDTO.getKunReadings(),
				kanjiRestDTO.getOnReadings(),kanjiRestDTO.getUnicode());
		logger.debug(kanjiDTO.toString());

		if(!(kanjiDTO.getKanji().equals(kanji)))
		{
			throw new NotFoundException("The requested Kanji was not found or the API is down!");
		}

		logger.debug("Object created:"+kanjiDTO.toString());
		return kanjiDTO;
	}
}
