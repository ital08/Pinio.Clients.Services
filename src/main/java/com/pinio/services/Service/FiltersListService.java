package com.pinio.services.Service;

import com.pinio.services.Models.Entity.*;

public interface FiltersListService {
    public abstract SearchBrand obtainBrands();
    public abstract SearchCategory obtainCategories();
    public abstract SearchSubcategory obtainSubcategories(Category category);

}
