package com.example.categoryservice.core.mapper;

import com.example.components.categorycontract.CategoryFindByNameRequest;
import com.example.components.categorycontract.CategoryRequest;
import com.example.categoryservice.core.dao.Category;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {
    @NotNull
    public Category applyRequest(Category prototype, @NotNull CategoryRequest req) {
        prototype.setId(req.id());
        prototype.setName(req.name());
        return prototype;
    }

    @NotNull
    public Category applyFindByIdRequest(Category prototype, @NotNull CategoryFindByNameRequest req) {
        prototype.setName(req.name());
        return prototype;
    }
}
