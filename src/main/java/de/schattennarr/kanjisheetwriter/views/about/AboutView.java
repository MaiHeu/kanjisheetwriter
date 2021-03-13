package de.schattennarr.kanjisheetwriter.views.about;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.templatemodel.TemplateModel;
import de.schattennarr.backend.rest.KanjiConsumer;
import de.schattennarr.kanjisheetwriter.data.KanjiDTO;
import de.schattennarr.kanjisheetwriter.generator.SheetGenerator;
import de.schattennarr.kanjisheetwriter.views.about.AboutView.AboutViewModel;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.PageTitle;
import de.schattennarr.kanjisheetwriter.views.main.MainView;
import javassist.NotFoundException;

import java.io.IOException;

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

    Binder<KanjiDTO> binder = new Binder<>(KanjiDTO.class);
    // This is the Java companion file of a design
    // You can find the design file in /frontend/views/views/about/about-view.js
    // The design can be easily edited by using Vaadin Designer
    // (vaadin.com/designer)

    public static interface AboutViewModel extends TemplateModel {
    }

    public AboutView() {
        buttonGenerateSheet.addClickListener(e->generateKanjiSheet());
    }

    private void generateKanjiSheet(){
        System.out.println("HELLO!");
        SheetGenerator generator = new SheetGenerator();

        try
        {
            generator.copyKanjiToOutput(new KanjiConsumer().getKanjiDTO(kanjiSearchTextField.getValue()));
        }
        catch (NotFoundException e)
        {
            e.printStackTrace();
            Notification.show("Kanji nicht gefunden!",60, Notification.Position.TOP_CENTER);
            return;
        }
        catch (IOException e)
        {
            e.printStackTrace();
            Notification.show("Fehler beim Kopieren!", 60, Notification.Position.TOP_CENTER);
            return;
        }


    }


}
