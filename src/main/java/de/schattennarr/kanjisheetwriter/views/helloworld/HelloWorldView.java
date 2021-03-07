package de.schattennarr.kanjisheetwriter.views.helloworld;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.PageTitle;
import de.schattennarr.kanjisheetwriter.views.main.MainView;
import com.vaadin.flow.router.RouteAlias;

@JsModule("./views/helloworld/hello-world-view.js")
@CssImport("./views/helloworld/hello-world-view.css")
@Tag("hello-world-view")
@Route(value = "hello", layout = MainView.class)
@RouteAlias(value = "", layout = MainView.class)
@PageTitle("Hello World")
public class HelloWorldView extends PolymerTemplate<TemplateModel> {

    @Id
    private TextField name;

    @Id
    private Button sayHello;

    public HelloWorldView() {
        sayHello.addClickListener(e -> {
            Notification.show("Hello " + name.getValue());
        });
    }
}
