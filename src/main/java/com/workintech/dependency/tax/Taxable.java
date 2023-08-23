package com.workintech.dependency.tax;

import org.springframework.stereotype.Component;


public interface Taxable {
    double getSimpleTaxRate();
    double getMiddleTaxRate();
    double getUpperTaxRate();
}
