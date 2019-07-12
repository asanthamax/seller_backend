package com.spring.demo.services;

import com.spring.demo.entity.*;
import com.spring.demo.errors.RestServiceException;
import com.spring.demo.model.response.ProductResponse;
import com.spring.demo.model.response.VariationsAndImages;
import com.spring.demo.repository.ProductReviewsRepository;
import com.spring.demo.repository.ProductImagesRepository;
import com.spring.demo.repository.ProductVariationRepository;
import com.spring.demo.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductsRepository productsRepository;

    private final ProductReviewsRepository productReviewsRepository;

    private final ProductImagesRepository productImagesRepository;

    private final ProductVariationRepository productVariationRepository;


    @Autowired
    public ProductService(ProductsRepository prodRepository, ProductReviewsRepository reviewsRepository, ProductImagesRepository imagesRepository, ProductVariationRepository variationRepository){

        this.productsRepository = prodRepository;
        this.productReviewsRepository = reviewsRepository;
        this.productImagesRepository = imagesRepository;
        this.productVariationRepository = variationRepository;
    }

    public Page<ProductResponse> getAllProducts(Pageable pageable){

        Page<Products> products = productsRepository.findAll(pageable);
        List<ProductResponse> productResponses = new ArrayList<>();
        for(Products prod: products){

            ProductResponse response = new ProductResponse();
            List<ProductReviews> productReviews = productReviewsRepository.findByProductId(prod.getProductId());
            List<ProductVariations> productVariations = productVariationRepository.findByProductID(prod.getProductId());
            List<ProductImages> productImages = productImagesRepository.findByProductID(prod.getProductId());
            List<VariationsAndImages> productVariationsImages = variationsAndImages(productVariations, productImages);
            response.setBarcode(prod.getBarcode());
            response.setCategory(prod.getCategory());
            response.setCreatedDate(prod.getCreatedDate());
            response.setIsActive(prod.getIsActive());
            response.setIsSample(prod.getIsSample());
            response.setModifiedDate(prod.getModifiedDate());
            response.setProductDescription(prod.getProductDescription());
            response.setProductId(prod.getProductId());
            response.setProductName(prod.getProductName());
            response.setProductReviews(productReviews);
            response.setProductSlug(prod.getProductSlug());
            response.setProductType(prod.getProductType());
            response.setProductVariations(productVariationsImages);
            response.setRegularPrice(prod.getRegularPrice());
            response.setSalePrice(prod.getSalePrice());
            response.setSamplePrice(prod.getSamplePrice());
            response.setSku(prod.getSku());
            response.setStock(prod.getStock());
            response.setStockStatus(prod.getStockStatus());
            response.setUser(prod.getUser());
            response.setWeight(prod.getWeight());
            response.setWeightUnit(prod.getWeightUnit());
            response.setProductTags(new ArrayList<>(prod.getTags()));
            productResponses.add(response);
        }
        return new PageImpl<>(productResponses, pageable, productResponses.size());
    }

    public ProductResponse getSingleProduct(Long productID){

        Optional<Products> product = productsRepository.findById(productID);
        if(product.isPresent()){

            Products realProduct = product.get();
            ProductResponse response = new ProductResponse();
            List<ProductReviews> productReviews = productReviewsRepository.findByProductId(realProduct.getProductId());
            List<ProductVariations> productVariations = productVariationRepository.findByProductID(realProduct.getProductId());
            List<ProductImages> productImages = productImagesRepository.findByProductID(realProduct.getProductId());
            List<VariationsAndImages> productVariationsImages = variationsAndImages(productVariations, productImages);
            response.setBarcode(realProduct.getBarcode());
            response.setCategory(realProduct.getCategory());
            response.setCreatedDate(realProduct.getCreatedDate());
            response.setIsActive(realProduct.getIsActive());
            response.setIsSample(realProduct.getIsSample());
            response.setModifiedDate(realProduct.getModifiedDate());
            response.setProductDescription(realProduct.getProductDescription());
            response.setProductId(realProduct.getProductId());
            response.setProductName(realProduct.getProductName());
            response.setProductReviews(productReviews);
            response.setProductSlug(realProduct.getProductSlug());
            response.setProductType(realProduct.getProductType());
            response.setProductVariations(productVariationsImages);
            response.setRegularPrice(realProduct.getRegularPrice());
            response.setSalePrice(realProduct.getSalePrice());
            response.setSamplePrice(realProduct.getSamplePrice());
            response.setSku(realProduct.getSku());
            response.setStock(realProduct.getStock());
            response.setStockStatus(realProduct.getStockStatus());
            response.setUser(realProduct.getUser());
            response.setWeight(realProduct.getWeight());
            response.setWeightUnit(realProduct.getWeightUnit());
            response.setProductTags(new ArrayList<>(realProduct.getTags()));
            return response;
        }else{

            throw new RestServiceException("Invalid product id, product not found");
        }
    }

    private List<VariationsAndImages> variationsAndImages(List<ProductVariations> variations, List<ProductImages> images){

        List<VariationsAndImages> variationsAndImagesList = new ArrayList<>();
        for(ProductVariations variation: variations){

            VariationsAndImages variationsAndImages = new VariationsAndImages();
            variationsAndImages.setVarriationAttribute(variation.getVarriationAttribute());
            variationsAndImages.setVariationValue(variation.getVariationValue());
            variationsAndImages.setVariationSku(variation.getVariationSku());
            variationsAndImages.setVariationRegularPrice(variation.getVariationRegularPrice());
            variationsAndImages.setVariationSalePrice(variation.getVariationSalePrice());
            List<ProductImages> variationImages = new ArrayList<>();
            for(ProductImages variationImage: images){

                if(variationImage.getVariation().getId().equals(variation.getId())){

                    variationImages.add(variationImage);
                }
            }
            variationsAndImages.setProductImages(variationImages);
            variationsAndImagesList.add(variationsAndImages);
        }
        return variationsAndImagesList;
    }

    public boolean saveProduct(ProductResponse product){

        Optional<Products> products = productsRepository.findById(product.getProductId());
        if(products.isPresent()){

            Products prodToSave = products.get();
            prodToSave.setIsActive(product.getIsActive());
            productsRepository.save(prodToSave);
            return true;
        }else{

            throw new RestServiceException("Product not found for update");
        }
    }

    public void deleteProduct(Long productId){

        Optional<Products> products = productsRepository.findById(productId);
        if(products.isPresent()){

            productsRepository.delete(products.get());
        }else{

            throw new RestServiceException("Product not exists in database");
        }
    }
}
