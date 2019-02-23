package com.examples.crazy.simpleboard.service.impl;

import com.examples.crazy.simpleboard.domain.Category;
import com.examples.crazy.simpleboard.repository.CategoryRepository;
import com.examples.crazy.simpleboard.service.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }
}
