package ru.gb.spring_data_gpa.cards;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import ru.gb.spring_data_gpa.model.ProductDto;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@Component

public class Card {
    private List<ProductDto> productDtoList = new ArrayList<>();
    private Long quantity;
    public void addToCard(ProductDto productDto){
        productDtoList.add(productDto);
    }

}
