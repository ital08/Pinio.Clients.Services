package com.pinio.services.Service;

import com.pinio.services.Models.Dao.FiltersListDao;
import com.pinio.services.Models.Entity.Category;
import com.pinio.services.Models.Entity.SearchBrand;
import com.pinio.services.Models.Entity.SearchCategory;
import com.pinio.services.Models.Entity.SearchSubcategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("FiltersListService")
@Transactional
public class FiltersListServiceImpl implements FiltersListService{
    @Autowired
    private FiltersListDao dao;
    public SearchBrand obtainBrands(){return dao.obtainBrands();}
    public SearchCategory obtainCategories(){return dao.obtainCategories();}
    public SearchSubcategory obtainSubcategories(Category category){return dao.obtainSubcategories(category);};
}
