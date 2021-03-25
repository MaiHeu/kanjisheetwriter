package de.schattennarr.kanjisheetwriter.rest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;

@RestController
public class SheetResource {

    private final String bigTemplate;
    private final String smallTemplate;
    public SheetResource() throws IOException, URISyntaxException {
        bigTemplate = Files.readString(Path.of(getClass().getResource("/genkouyoshi_big.html").toURI()));
        smallTemplate = Files.readString(Path.of(getClass().getResource("/genkouyoshi_small.html").toURI()));

    }


    @GetMapping(path="/download")
    public ResponseEntity<String> getSheet(@RequestParam("kanji") String kanjiname, @RequestParam("big") boolean big)
    {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "filename=\"KanjiSheet.html\"");
        ResponseEntity<String> response = new ResponseEntity<>(((big)? bigTemplate: smallTemplate).replace("{PLACEHOLDER}", "kanji/0" + kanjiname + ".svg"), headers, HttpStatus.ACCEPTED);
        return response;
    }
}
