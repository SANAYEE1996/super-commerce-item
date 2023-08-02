package com.item.util;

import com.item.document.Image;
import com.item.document.Product;
import com.item.document.Quantity;
import com.item.document.Size;
import com.item.dto.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Converter {

    @Value("${product.id}")
    private String productId;

    public Product toProduct(ProductDetailDto productDetailDto){
        ProductInfoDto productInfoDto = productDetailDto.getProductInfoDto();
        return new Product(productId+productInfoDto.getId(),
                            productInfoDto.getProductName(),
                            productInfoDto.getProductCode(),
                            productInfoDto.getProductPrice(),
                            productInfoDto.getProductInfo(),
                            productInfoDto.getProductThumbnail(),
                            productInfoDto.getBrandId(),
                            productInfoDto.getBrandName(),
                            productInfoDto.getBrandLogoImage(),
                            toQuantityList(productDetailDto.getQuantityDtoList()),
                            toSizeList(productDetailDto.getSizeDtoList()),
                            toImageList(productDetailDto.getProductImageDtoList()));
    }


    private List<Quantity> toQuantityList(List<QuantityDto> quantityDtoList){
        List<Quantity> quantityList = new ArrayList<>();
        for(QuantityDto quantityDto : quantityDtoList){
            quantityList.add(toQuantity(quantityDto));
        }
        return quantityList;
    }

    private Quantity toQuantity(QuantityDto quantityDto){
        return new Quantity(quantityDto.getQuantityId(), quantityDto.getQuantityName(), quantityDto.getQuantity());
    }

    private List<Image> toImageList(List<ProductImageDto> productImageDtoList){
        List<Image> imageList = new ArrayList<>();
        for(ProductImageDto productImageDto : productImageDtoList){
            imageList.add(toImage(productImageDto));
        }
        return imageList;
    }

    private Image toImage(ProductImageDto productImageDto){
        return new Image(productImageDto.getImageId(), productImageDto.getType(), productImageDto.getImage(), productImageDto.getOdr());
    }

    private List<Size> toSizeList(List<SizeDto> sizeDtoList){
        List<Size> sizeList = new ArrayList<>();
        for(SizeDto sizeDto : sizeDtoList){
            sizeList.add(toSize(sizeDto));
        }
        return sizeList;
    }

    private Size toSize(SizeDto sizeDto){
        return new Size(sizeDto.getSizeId(), sizeDto.getMeasureName(), sizeDto.getBodyName(), sizeDto.getSizeValue());
    }
}
