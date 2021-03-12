package de.schattennarr.kanjisheetwriter.data;
import com.fasterxml.jackson.annotation.JsonProperty;
import javassist.NotFoundException;
import lombok.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.net.URL;
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

	public KanjiDTO(@NonNull String kanji, short grade, @NonNull short strokeCount, ArrayList<String> meanings, ArrayList<String> kunReadings, ArrayList<String> onReadings, @NonNull String unicode)
	{
		this.kanji = kanji;
		this.grade = grade;
		this.strokeCount = strokeCount;
		this.meanings = meanings;
		this.kunReadings = kunReadings;
		this.onReadings = onReadings;
		this.unicode = unicode;

		try
		{
			setKanjiUri();
		}
		catch (NotFoundException e)
		{
			e.printStackTrace();
		}
	}

	/**
	* This method is to be called to find the Kanji svg data
	* */



	private void setKanjiUri() throws NotFoundException, NullPointerException
	{
		kanjiUri = this.getClass().getResource("/kanji/0"+unicode+".svg");

		if(kanjiUri.getPath() != null){
			logger.debug(kanjiUri.toString());
			return;
		}
		throw new NotFoundException("SVG not found! :(");

	}

}
