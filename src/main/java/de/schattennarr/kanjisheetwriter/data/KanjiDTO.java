package de.schattennarr.kanjisheetwriter.data;
import com.fasterxml.jackson.annotation.JsonProperty;
import javassist.NotFoundException;
import lombok.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
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
	@Setter(AccessLevel.NONE) Path kanjiPath;

	public KanjiDTO(@NonNull String kanji, short grade, @NonNull short strokeCount, ArrayList<String> meanings, ArrayList<String> kunReadings, ArrayList<String> onReadings, @NonNull String unicode)
	{
		this.kanji = kanji;
		this.grade = grade;
		this.strokeCount = strokeCount;
		this.meanings = meanings;
		this.kunReadings = kunReadings;
		this.onReadings = onReadings;
		this.unicode = unicode;
	}
}
