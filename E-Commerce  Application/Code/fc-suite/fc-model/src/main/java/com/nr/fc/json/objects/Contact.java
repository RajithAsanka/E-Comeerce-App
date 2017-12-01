/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nr.fc.json.objects;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author Amith Fernando
 */
@XmlRootElement
public class Contact {

    @JsonProperty
    private String id;
    @JsonProperty
    private String contactCategory;
    @JsonProperty
    private String contactType;
    @JsonProperty
    private String contact;

    public Contact() {
        super();
    }

    public Contact(String id, String contactCategory, String contactType, String contact) {

        super();
        this.id = id;
        this.contactCategory = contactCategory;
        this.contactType = contactType;
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "Contact{" + "id=" + id + ", contactCategory=" + contactCategory + ", contactType=" + contactType + ", contact=" + contact + '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContactCategory() {
        return contactCategory;
    }

    public void setContactCategory(String contactCategory) {
        this.contactCategory = contactCategory;
    }

    public String getContactType() {
        return contactType;
    }

    public void setContactType(String contactType) {
        this.contactType = contactType;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

}
