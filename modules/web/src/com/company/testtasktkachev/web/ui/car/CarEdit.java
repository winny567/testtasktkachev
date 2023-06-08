package com.company.testtasktkachev.web.ui.car;

import com.haulmont.cuba.gui.screen.*;
import com.company.testtasktkachev.entity.Car;

@UiController("testtasktkachev$Car.edit")
@UiDescriptor("car-edit.xml")
@EditedEntityContainer("carDc")
@LoadDataBeforeShow
public class CarEdit extends StandardEditor<Car> {
}