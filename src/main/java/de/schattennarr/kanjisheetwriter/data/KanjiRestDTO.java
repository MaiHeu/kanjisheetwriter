package de.schattennarr.kanjisheetwriter.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KanjiRestDTO
{
	private static final Logger logger = LoggerFactory.getLogger(KanjiRestDTO.class);

	String kanji;
	short grade;
	@JsonProperty("stroke_count")
	short strokeCount;
	ArrayList<String> meanings;
	@JsonProperty("kun_readings")
	ArrayList<String> kunReadings;
	@JsonProperty("on_readings")
	ArrayList<String> onReadings;
	String unicode;
}
