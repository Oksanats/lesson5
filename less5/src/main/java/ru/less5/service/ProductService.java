package ru.less5.service;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;
import ru.less5.dto.Product;

import java.util.ArrayList;

public interface ProductService {

    @GET("products")
    Call<ArrayList<Product>> getProducts();

    @GET("products/{id}")
    Call<Product>getProduct(@Path("id") int id);


    @POST("products")
    Call<Product> createProduct(@Body Product createProductRequest);

    @DELETE("products/{id}")
    Call<ResponseBody> deleteProduct(@Path("id") int id);

    @PUT("product")
    Call<Product>putProduct(@Body Product putProductRequest);

}
