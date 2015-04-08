package ch05_forkjoinframework.e01_createforkjoinpool;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hank on 2015/4/8.
 */
public class ProductListGenerator {

    public List<Product> generate(int size){
        List<Product> ret = new ArrayList<Product>();
        for (int i = 0; i < size; i++) {
            Product product = new Product();
            product.setName("Product_"+ i);
            product.setPrice(10);
            ret.add(product);
        }

        return ret;
    }
}
