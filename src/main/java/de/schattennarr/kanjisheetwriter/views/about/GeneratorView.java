package de.schattennarr.kanjisheetwriter.views.about;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.templatemodel.TemplateModel;
import de.schattennarr.kanjisheetwriter.data.KanjiDTO;
import de.schattennarr.kanjisheetwriter.rest.KanjiConsumer;
import de.schattennarr.kanjisheetwriter.views.about.GeneratorView.AboutViewModel;
import de.schattennarr.kanjisheetwriter.views.main.MainView;
import javassist.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@JsModule("./views/about/about-view.js")
@CssImport("./views/about/about-view.css")
@Tag("about-view")
@Route(value = "about", layout = MainView.class)
@PageTitle("About")
public class GeneratorView extends PolymerTemplate<AboutViewModel> {
    private static final Logger logger = LoggerFactory.getLogger(GeneratorView.class);
    @Id("buttonGenerateSheet")
    private Button buttonGenerateSheet;
    @Id("kanjiSearchTextField")
    private TextField kanjiSearchTextField;
    @Id("downloadLink")
    private Span downloadLink;
    @Id("radioGroupGridSelect")
    private RadioButtonGroup<String> radioGroupGridSelect;
    private KanjiConsumer consumer;
    private boolean bigGrid;

    // This is the Java companion file of a design
    // You can find the design file in /frontend/views/views/about/about-vi ew.js
    // The design can be easily edited by using Vaadin Designer
    // (vaadin.com/designer)
    public interface AboutViewModel extends TemplateModel {
    }

    @Autowired
    public GeneratorView(KanjiConsumer consumer) {
        radioGroupGridSelect.setItems("Großes Sheet", "Kleines Sheet");
        this.consumer = consumer;
        buttonGenerateSheet.addClickListener(e -> generateKanjiSheet());
        radioGroupGridSelect.addValueChangeListener( e -> {
            bigGrid = e.getValue().startsWith("Gr");
        });
    }

    private void generateKanjiSheet() {
        try {
            KanjiDTO dto = consumer.getKanjiDTO(kanjiSearchTextField.getValue().stripTrailing());
            downloadLink.getElement().setProperty("innerHTML",
                    "<a target=_blank href=\"/download?kanji=" + dto.getUnicode() + "&big=" + bigGrid + "\">Hier " +
                            "klicken um das Sheet anzuzeigen</a>");
            logger.debug(radioGroupGridSelect.toString());
        } catch (NotFoundException e) {
            downloadLink.setText("Das eingegebene Kanji konnte leider nicht gefunden werden.");
        }

    }


}
