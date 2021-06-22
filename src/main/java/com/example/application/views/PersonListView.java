package com.example.application.views;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("person")
public class PersonListView extends VerticalLayout {
    public PersonListView(){
        add(new H1("Person List"));
    }
}
