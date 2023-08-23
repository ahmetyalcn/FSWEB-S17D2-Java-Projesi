package com.workintech.dependency.model;

import com.workintech.dependency.tax.Taxable;

public class DeveloperFactory {
    public static Developer checkExperience(Developer developer, Taxable taxable){
        Developer savedDev;
        if(developer.getExperience().name().equalsIgnoreCase("junior")){
            savedDev = new JuniorDeveloper(developer.getId(),developer.getName(),developer.getSalary()-developer.getSalary()*taxable.getSimpleTaxRate(), developer.getExperience());
        }else if(developer.getExperience().name().equalsIgnoreCase("mid")){
            savedDev = new MidDeveloper(developer.getId(),developer.getName(),developer.getSalary()-developer.getSalary()*taxable.getMiddleTaxRate(), developer.getExperience());
        }else if(developer.getExperience().name().equalsIgnoreCase("senior")){
            savedDev = new SeniorDeveloper(developer.getId(),developer.getName(),developer.getSalary()-developer.getSalary()*taxable.getUpperTaxRate(), developer.getExperience());
        }else{
            savedDev = null;
        }
        return savedDev;
    }
}
