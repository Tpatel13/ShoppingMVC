package dao;

import controllers.admin.Search;
import dao.customer.SearchCustomertByNameLike;
import dao.merchant.SearchMerchantByNameLike;
import dao.product.SearchProductByNameLike;
import models.Merchant;
import models.SearchModel;

import java.util.ArrayList;

public class SearchDao {

    public SearchModel search(String name) {

        SearchProductByNameLike products = new SearchProductByNameLike();
        SearchCustomertByNameLike customers = new SearchCustomertByNameLike();
        SearchMerchantByNameLike merchants = new SearchMerchantByNameLike();

        SearchModel s = new SearchModel(customers.getProductLike(name), merchants.getProductLike(name), products.getProductLike(name));


        return s;


    }


}
