package de.schattennarr.kanjisheetwriter.generator;

import de.schattennarr.kanjisheetwriter.data.KanjiDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class SheetGenerator
{
	private static final Logger logger = LoggerFactory.getLogger(SheetGenerator.class);
	Path copyDestination = Paths.get("/frontend/output/kanji.svg");

	public void copyKanjiToOutput(KanjiDTO kanjiDTO) throws IOException
	{
		logger.debug("CopyDest: "+ copyDestination+" Kanjipath: "+kanjiDTO.getKanjiPath().toString());
		Files.copy(kanjiDTO.getKanjiPath(), copyDestination, StandardCopyOption.REPLACE_EXISTING);
	}

}
