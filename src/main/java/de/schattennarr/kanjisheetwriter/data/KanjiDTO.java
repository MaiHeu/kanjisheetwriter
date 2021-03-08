package de.schattennarr.kanjisheetwriter.data;
import com.fasterxml.jackson.annotation.JsonProperty;
import de.schattennarr.backend.rest.KanjiConsumer;
import javassist.NotFoundException;
import lombok.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

import java.io.Serializable;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

@Data
@NoArgsConstructor
public class KanjiDTO implements Serializable
{
	private static final Logger logger = LoggerFactory.getLogger(KanjiDTO.class);
	@NonNull String kanji;
	short grade;

	@JsonProperty("stroke_count")
	@NonNull short strokeCount;

	ArrayList<String> meanings;
	@JsonProperty("kun_readings")
	ArrayList<String> kunReadings;
	@JsonProperty("on_readings")
	ArrayList<String> onReadings;
	@NonNull String unicode;
	@Setter(AccessLevel.NONE)URL kanjiUri;

	/**
	* This method is to be called to find the Kanji svg data
	*
	* */
	public void setKanjiUri() throws NotFoundException, NullPointerException
	{
		if (unicode.isEmpty())
		{
			throw new NullPointerException("No Unicode-Data was given!");
		}

		URL kanjipath = this.getClass().getResource("/kanji/0"+unicode+".svg");

		if(kanjipath.getPath() != null){
			kanjiUri = kanjipath;
			logger.debug(kanjiUri.toString());
			return;
		}
		throw new NotFoundException("SVG not found! :(");

	}

}
