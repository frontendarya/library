package com.example.categoryservice.core.handler;

import com.example.components.categorycontract.CategoryFindByNameRequest;
import com.example.components.categorycontract.CategoryRequest;
import com.example.components.categorycontract.CategoryView;
import com.example.components.categorycontract.CategoryViewWithBooks;
import org.springframework.stereotype.Component;

@Component
public class CategoryControllerHandler {
    private final DeleteCategoryByIdHandler deleteCategoryByIdHandler;
    private final FindByCategoryNameHandler findByCategoryNameHandler;
    private final FindCategoryByIdHandler findCategoryByIdHandler;
    private final SaveCategoryHandler saveCategoryHandler;

    public CategoryControllerHandler(DeleteCategoryByIdHandler deleteCategoryByIdHandler,
                                     FindByCategoryNameHandler findByCategoryNameHandler,
                                     FindCategoryByIdHandler findCategoryByIdHandler,
                                     SaveCategoryHandler saveCategoryHandler){
        this.deleteCategoryByIdHandler = deleteCategoryByIdHandler;
        this.findByCategoryNameHandler = findByCategoryNameHandler;
        this.findCategoryByIdHandler = findCategoryByIdHandler;
        this.saveCategoryHandler = saveCategoryHandler;
    }
    public CategoryView save(CategoryRequest req) {
        return saveCategoryHandler.handle(req);
    }

    public CategoryView updateById(CategoryRequest req) {
        return saveCategoryHandler.handle(req);
    }
    public CategoryView findById(Integer id) {
        return findCategoryByIdHandler.handle(id);
    }

    public CategoryViewWithBooks findAllByCategoryName(CategoryFindByNameRequest req) {
        return findByCategoryNameHandler.handle(req);
    }

    public void deleteById(Integer categoryId) {
        deleteCategoryByIdHandler.handle(categoryId);
    }
}
