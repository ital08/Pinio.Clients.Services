package com.pinio.services.Models.Dao;

import com.pinio.services.Models.Entity.Category;
import com.pinio.services.Models.Entity.SearchBrand;
import com.pinio.services.Models.Entity.SearchCategory;
import com.pinio.services.Models.Entity.SearchSubcategory;

public interface FiltersListDao {
    public abstract SearchBrand obtainBrands();
    public abstract SearchCategory obtainCategories();
    public abstract SearchSubcategory obtainSubcategories(Category category);
}
