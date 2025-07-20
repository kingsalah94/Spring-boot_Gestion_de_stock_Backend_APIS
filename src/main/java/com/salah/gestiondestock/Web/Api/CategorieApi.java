package com.salah.gestiondestock.Web.Api;

import com.salah.gestiondestock.Dtos.CategoryDto;
import com.salah.gestiondestock.Exceptions.EntityNotFoundException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.salah.gestiondestock.Utils.Constants.APP_ROOT;

public interface CategorieApi {

    @PostMapping(value = APP_ROOT + "/category/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    CategoryDto addCategory(@RequestBody CategoryDto categoryDto);

//    @PutMapping(value =APP_ROOT + "category/updateCategory", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//    CategoryDto updateCategory(@RequestBody CategoryDto categoryDto);


    @DeleteMapping(value = APP_ROOT + "/category/delete/{idCategory}")
    void deleteCategory(@PathVariable("idCategory") Integer id);

//    @GetMapping(value = APP_ROOT + "/category/{idCategory}", produces = MediaType.APPLICATION_JSON_VALUE)
//    CategoryDto getOneCategory(@PathVariable("idCategory") Integer id) throws EntityNotFoundException;

//    @GetMapping(value = APP_ROOT + "/category/{code}", produces = MediaType.APPLICATION_JSON_VALUE)
//    CategoryDto getArticleByCodeCategory(@PathVariable("code") String code) throws EntityNotFoundException;

    @GetMapping(value = APP_ROOT + "/category/AllCategories",produces = MediaType.APPLICATION_JSON_VALUE)
    List<CategoryDto> getAllCategories();

}
