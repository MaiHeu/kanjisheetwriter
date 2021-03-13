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
import de.schattennarr.kanjisheetwriter.generator.SheetGenerator;
import de.schattennarr.kanjisheetwriter.views.about.AboutView.AboutViewModel;
import de.schattennarr.kanjisheetwriter.views.main.MainView;

@JsModule("./views/about/about-view.js")
@CssImport("./views/about/about-view.css")
@Tag("about-view")
@Route(value = "about", layout = MainView.class)
@PageTitle("About")
public class AboutView extends PolymerTemplate<AboutViewModel> {
    @Id("buttonGenerateSheet")
    private Button buttonGenerateSheet;
    @Id("kanjiSearchTextField")
    private TextField kanjiSearchTextField;
    @Id("radioGroupGridSelect")
    private RadioButtonGroup<String> radioGroupGridSelect;
    @Id("downloadLink")
    private Span downloadLink;

    Binder<KanjiDTO> binder = new Binder<>(KanjiDTO.class);
    // This is the Java companion file of a design
    // You can find the design file in /frontend/views/views/about/about-view.js
    // The design can be easily edited by using Vaadin Designer
    // (vaadin.com/designer)

    public static interface AboutViewModel extends TemplateModel {
    }

    public AboutView() {
        buttonGenerateSheet.addClickListener(e -> generateKanjiSheet());
    }

    private void generateKanjiSheet() {
        SheetGenerator generator = new SheetGenerator();

        downloadLink.getElement().setProperty("innerHTML", "<a target=_blank href=\"/download?kanji=" + kanjiSearchTextField.getValue() + "&big=" + "radioButtonBigGrid".equals(radioGroupGridSelect.getValue()) + "\">Hier clicken um das Sheet anzuzeigen</a>");
    }


}
