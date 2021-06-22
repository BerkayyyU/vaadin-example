package com.example.application.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route
public class MainView extends VerticalLayout { //MainView ana sayfa
    public MainView(){
        TextField txtMessage = new TextField();
        txtMessage.setLabel("Write Your Message");
        Button button = new Button("Click me");
        button.addClickListener(buttonClickEvent -> {
            Notification.show(txtMessage.getValue());
        });
        add(txtMessage,button);
    }
}
