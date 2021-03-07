package de.schattennarr.kanjisheetwriter.data;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.web.client.RestTemplate;

import java.io.Serializable;
import java.util.ArrayList;

@Data
@NoArgsConstructor
public class KanjiDTO implements Serializable
{
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

}
