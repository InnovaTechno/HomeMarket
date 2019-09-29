package com.InnovaTechno.homemarket.Markets_Details;

import com.parse.ParseClassName;
import com.parse.ParseObject;


@ParseClassName("MarketDetails")
public class MarketDetails extends ParseObject {

    public static final String KEY_DESCRIPTION =  "description";
    public static final String KEY_ADRESSE =  "adresse";
    public static final String KEY_TELEPHONE = "telephone";
    public static final String KEY_SERVICES = "services";

    public String getDescription(){
        return getString(KEY_DESCRIPTION);
    }

    public void setDescripion(String description) {
        put(KEY_DESCRIPTION, description);
    }

    public String getAdresse(){
        return getString(KEY_ADRESSE);
    }

    public void setAdresse(String adresse) {
        put(KEY_ADRESSE, adresse);
    }

    public String getTelephone(){
        return getString(KEY_TELEPHONE);
    }

    public void setTelephone(String telephone) {
        put(KEY_TELEPHONE, telephone);
    }

    public String getServices(){
        return getString(KEY_SERVICES);
    }

    public void setServices(String services) {
        put(KEY_SERVICES, services);
    }





}
