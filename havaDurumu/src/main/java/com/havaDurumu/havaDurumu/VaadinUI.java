package com.havaDurumu.havaDurumu;

import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button.ClickListener;

@SpringUI
@Theme("valo")
public class VaadinUI extends UI {

    @Autowired
    private HavaServis service;
    private HavaD weather;

    @Override
    protected void init(VaadinRequest request) {

        Window pencere = new Window("Hava Durumu Uygulaması");
        VerticalLayout layout = new VerticalLayout();
        final TextField name = new TextField("Eklemek istediğiniz illeri giriniz:");
        final Button button = new Button("Ekle");
        final Button button2 = new Button("temizle");

        button.addClickListener(new ClickListener(){
            private static final long serialVersionUID = -8424487726640573041L;

            public void buttonClick(com.vaadin.ui.Button.ClickEvent event) {
                weather = service.getWeather(name.getValue());
                Label label = new Label(weather.getName()+ "  " +String.valueOf(weather.getMain().toString()) + "°C");
                //label.setValue( weather.getName()+ "  " +String.valueOf(weather.getMain().toString()) + "°C");
                layout.addComponent(label);
            }
        });
        button2.addClickListener(clickEvent ->
                layout.removeAllComponents());

        setContent(new VerticalLayout(name, button,layout,button2));
        //HorizontalLayout main = new HorizontalLayout(name,label, button);
        //main.setSpacing(true);
        //main.setMargin(true);

        //setContent(main);
        //final TextField ad = new TextField("Name");
        //final Button greetButton = new Button("Greet");
        //greetButton.addClickListener(
        //        e -> Notification.show("Hi " + ad.getValue())
        //);
        //setContent(new VerticalLayout(ad, greetButton));

    }

}