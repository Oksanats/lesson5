import com.github.javafaker.Faker;
import lombok.SneakyThrows;
import okhttp3.ResponseBody;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import retrofit2.Response;
import retrofit2.Retrofit;

import ru.less5.dto.Product;
import ru.less5.enums.CategoryType;
import ru.less5.service.CategoryService;
import ru.less5.service.ProductService;
import ru.less5.utils.RetrofitUtils;

import java.io.IOException;
import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ProductTest {
    static Retrofit client;
    static ProductService productService;
    static CategoryService categoryService;
    Faker faker = new Faker();
    Product product;
    static int id;






    @BeforeAll
    static void beforeAll() {
        client = RetrofitUtils.getRetrofit();
        productService =client.create(ProductService.class);
        categoryService = client.create(CategoryService.class);
    }






   @BeforeEach
   void setUp(){
        product = new Product()
                .withTitle(faker.food().ingredient())
                .withPrice((int) ((Math.random()+1)*100))
                .withCategoryTitle(CategoryType.FOOD.getTitle());


   }




    @Test
    void postProductTest() throws IOException {
        Response<Product> response = productService.createProduct(product)
                .execute();
        id =  response.body().getId();
        System.out.println(id);
        assertThat(response.isSuccessful(), CoreMatchers.is(true));

    }
    @AfterEach
    void deleteProductTest()  throws IOException{
        Response<ResponseBody> response = productService.deleteProduct(id).execute();
        assertThat(response.code(),equalTo(200 ));
        assertThat(response.isSuccessful(), CoreMatchers.is(true));
    }
    @Test
    void getProductTest()  throws IOException{
        Response<Product> response = productService.getProduct(1).execute();
        assertThat(response.code(),equalTo(200 ));
        assertThat(response.body().getTitle(),equalTo(product.getTitle()));

        assertThat(response.isSuccessful(), CoreMatchers.is(true));
    }





    @Test
    void getProductsTest() throws IOException{
        Response<ArrayList<Product>> response = productService.getProducts().execute();
        assertThat(response.code(),equalTo(200 ));
    }
}
