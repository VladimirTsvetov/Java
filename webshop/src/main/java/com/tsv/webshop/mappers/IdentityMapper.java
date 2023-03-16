package com.tsv.webshop.mappers;
import com.tsv.webshop.entities.Product;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class IdentityMapper {
    private Long id;
    private List<Long> idList;
    private ConcurrentHashMap<Long, Product> productHashMap;

    public IdentityMapper(){
        id = 0L;
        idList = new ArrayList<>();
        productHashMap = new ConcurrentHashMap<>();
    }

    public boolean getId(Long id){
        if(!idList.contains(id)) {
            idList.add(id);
            return false;
        }
        else{
            return true;
        }
    }

    public Product getProductById(Long id){
        return productHashMap.get(id);
    }

    public void setProductById(Long id, Product product){
        productHashMap.put(id,product);
    }
}
