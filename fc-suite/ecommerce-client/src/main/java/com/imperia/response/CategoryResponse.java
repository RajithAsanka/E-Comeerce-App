package com.imperia.response;

import com.imperia.requests.CategoryDto;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by Kithmal on 2/5/18.
 */
@XmlRootElement
public class CategoryResponse {

    private List<CategoryDto> dtos;

    public List<CategoryDto> getDtos() {
        return dtos;
    }

    public void setDtos(List<CategoryDto> dtos) {
        this.dtos = dtos;
    }
}
