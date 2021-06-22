package com.example.application.views;

import com.example.application.models.Person;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

import java.util.ArrayList;
import java.util.List;

@Route
public class MainView extends VerticalLayout { //MainView ana sayfa
    public MainView(){

        Button btnNew = new Button("Add", VaadinIcon.INSERT.create());
        Dialog dialog = new Dialog();
        dialog.setModal(true);

        TextField txtName = new TextField("Name","Enter your name");
        TextField txtSurname = new TextField("Surname","Enter your surname");
        TextField txtPhoneNumber = new TextField("Phone Number","Enter your phone number");

        FormLayout formLayout = new FormLayout();
        formLayout.add(txtName,txtSurname,txtPhoneNumber);

        HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.setSpacing(true);


        Button btnSave = new Button("Save");
        Button btnCancel = new Button("Cancel");
        btnCancel.addClickListener(buttonClickEvent -> {
            dialog.close();
        });

        horizontalLayout.add(btnCancel,btnSave);

        dialog.add(new H2("New Person"), formLayout,horizontalLayout);

        btnNew.addClickListener(buttonClickEvent -> {
            dialog.open();
        });

        List<Person> personList = new ArrayList<>();
        personList.add(new Person(1L,"Ali","Duru","444555"));
        personList.add(new Person(2L,"Aliye","Duru","2222"));
        personList.add(new Person(3L,"Test","Test","333"));

        Grid<Person> grid = new Grid<>(Person.class);
        grid.setItems(personList);

        grid.removeColumnByKey("id");
        grid.setSelectionMode(Grid.SelectionMode.NONE);

        grid.setColumns("name", "surname","phoneNumber");

        grid.addComponentColumn(item -> createRemoveButton(grid, item))
                .setHeader("Actions");

        /*grid.addItemClickListener(personItemClickEvent -> {
            Notification.show("Item Clicked" + personItemClickEvent.getItem());
        });*/

        add(grid);
        add(new H3("Person List"),btnNew, grid);


    }

    private HorizontalLayout createRemoveButton(Grid<Person> grid, Person item){
        @SuppressWarnings("unchecked")
        Button btnDelete = new Button("Delete");
        btnDelete.addClickListener(buttonClickEvent -> {
            Notification.show("Delte item clicked on: " +  item.getName());
        });

        Button btnUpdate = new Button("Update");
        btnUpdate.addClickListener(buttonClickEvent -> {
            Notification.show("Update item clicked on " +  item.getName());
        });

        HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.add(btnUpdate,btnDelete);

        return horizontalLayout;
    }
}
