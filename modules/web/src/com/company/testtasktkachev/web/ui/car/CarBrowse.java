package com.company.testtasktkachev.web.ui.car;

import com.haulmont.cuba.gui.screen.*;
import com.company.testtasktkachev.entity.Car;

@UiController("testtasktkachev$Car.browse")
@UiDescriptor("car-browse.xml")
@LookupComponent("carsTable")
@LoadDataBeforeShow
public class CarBrowse extends StandardLookup<Car> {
}