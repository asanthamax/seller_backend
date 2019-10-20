package com.spring.demo.services;

import com.spring.demo.entity.*;
import com.spring.demo.errors.RestServiceException;
import com.spring.demo.model.response.*;
import com.spring.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class UsersService {

    private final SellerRepository sellerRepository;

    private final OrderRepository orderRepository;

    private final MessagesRepository messagesRepository;

    private final CustomerRepository customerRepository;

    private final WishListRepository wishListRepository;

    private final ProductsRepository productsRepository;

    private final ProductReviewsRepository productReviewsRepository;

    private final ProductImagesRepository productImagesRepository;

    private final ProductVariationRepository productVariationRepository;

    private final ProductService productService;

    public UsersService(SellerRepository sellerRepository, OrderRepository orderRepository, MessagesRepository messagesRepository, CustomerRepository customerRepository, WishListRepository wishListRepository, ProductsRepository productsRepository, ProductReviewsRepository productReviewsRepository, ProductImagesRepository productImagesRepository, ProductVariationRepository productVariationRepository,ProductService productService) {
        this.sellerRepository = sellerRepository;
        this.orderRepository = orderRepository;
        this.messagesRepository = messagesRepository;
        this.customerRepository = customerRepository;
        this.wishListRepository = wishListRepository;
        this.productsRepository = productsRepository;
        this.productReviewsRepository = productReviewsRepository;
        this.productImagesRepository = productImagesRepository;
        this.productVariationRepository = productVariationRepository;
        this.productService = productService;
    }


    public Page<UserResponse> getCustomers(){

        Iterable<Customer> customers = customerRepository.findAll();
        List<UserResponse> allCustomers = new ArrayList<>();
        for(Customer customer: customers){

            UserResponse userCustomer = new UserResponse();
            userCustomer.setId(customer.getId());
            userCustomer.setEmail(customer.getUser().getEmail());
            userCustomer.setFirstName(customer.getUser().getFirstName());
            userCustomer.setLastName(customer.getUser().getLastName());
            userCustomer.setUserName(customer.getUser().getUserName());
            allCustomers.add(userCustomer);
        }

        return new PageImpl<>(allCustomers);
    }

    public Page<UserResponse> getSellers(){

        Iterable<Seller> sellers = sellerRepository.findAll();
        List<UserResponse> allSellers = new ArrayList<>();
        for(Seller seller: sellers){

            UserResponse userSeller = new UserResponse();
            userSeller.setId(seller.getSellerID());
            userSeller.setUserName(seller.getUerID().getUserName());
            userSeller.setFirstName(seller.getUerID().getFirstName());
            userSeller.setLastName(seller.getUerID().getLastName());
            userSeller.setEmail(seller.getUerID().getEmail());
            allSellers.add(userSeller);
        }

        return new PageImpl<>(allSellers);
    }

    public SingleUserResponse getSingleUser(long userID, String type){

        SingleUserResponse singleUserResponse = new SingleUserResponse();
        if(type.equals("customer")) {

            Optional<Customer> user = customerRepository.findById(userID);
            if(user.isPresent()){

                Customer customerData = user.get();
                singleUserResponse.setId(customerData.getId());
                singleUserResponse.setFirstName(customerData.getUser().getFirstName());
                singleUserResponse.setLastName(customerData.getUser().getLastName());
                singleUserResponse.setEmail(customerData.getUser().getEmail());
                singleUserResponse.setFaxNo(customerData.getUser().getMobileNo());
                singleUserResponse.setTelephone(customerData.getUser().getMobileNo());
                singleUserResponse.setCity(customerData.getCity());
                singleUserResponse.setCountry(customerData.getCounty());
                singleUserResponse.setPostalCode(customerData.getPostalcode());
                singleUserResponse.setStreetAddress(customerData.getShippingAddress());
                return singleUserResponse;
            }else{

                throw new RestServiceException("No user found for given ID");
            }
        }else{

            Optional<Seller> user = sellerRepository.findById(userID);
            if(user.isPresent()){

                Seller seller = user.get();
                singleUserResponse.setId(seller.getSellerID());
                singleUserResponse.setFirstName(seller.getUerID().getFirstName());
                singleUserResponse.setLastName(seller.getUerID().getLastName());
                singleUserResponse.setEmail(seller.getUerID().getEmail());
                singleUserResponse.setFaxNo(seller.getUerID().getMobileNo());
                singleUserResponse.setTelephone(seller.getUerID().getMobileNo());
                singleUserResponse.setCity(seller.getCity());
                singleUserResponse.setCountry(seller.getCountry());
                singleUserResponse.setPostalCode(seller.getPostalCode());
                singleUserResponse.setStreetAddress(seller.getAddress());
                return singleUserResponse;
            }else{

                throw new RestServiceException("No user found for given ID");
            }
        }
    }

    public Page<OrderUserResponse> getAllUserOrders(long userID, String userType, Pageable pageable){

        List<OrderUserResponse> orderUserResponses = new ArrayList<>();
        if(userType.equals("seller")){

            Page<Order> orders = orderRepository.getOrdersBySeller(userID, pageable);
            for(Order order: orders){

                OrderUserResponse orderUserResponse = new OrderUserResponse();
                orderUserResponse.setOrderID(order.getOrderID());
                orderUserResponse.setCustomerName(order.getSeller().getUerID().getFirstName()+" "+order.getSeller().getUerID().getLastName());
                orderUserResponse.setEmail(order.getSeller().getUerID().getEmail());
                orderUserResponse.setOrderedDate(order.getOrderedDate());
                List<String> orderedProducts = new ArrayList<>();
                for(ProductVariations product: order.getProductVariation()){

                   String productName = product.getProduct().getProductName()+"-"+product.getVariationValue();
                   orderedProducts.add(productName);
                }
                orderUserResponse.setOrderdItems(orderedProducts);
                orderUserResponses.add(orderUserResponse);
            }
            return new PageImpl<>(orderUserResponses);
        }else{

            Page<Order> orders = orderRepository.gerOrdersByCustomer(userID, pageable);
            for(Order order: orders){

                OrderUserResponse orderUserResponse = new OrderUserResponse();
                orderUserResponse.setOrderID(order.getOrderID());
                orderUserResponse.setCustomerName(order.getCustomer().getUser().getFirstName()+" "+order.getCustomer().getUser().getLastName());
                orderUserResponse.setEmail(order.getCustomer().getUser().getEmail());
                orderUserResponse.setOrderedDate(order.getOrderedDate());
                List<String> orderedProducts = new ArrayList<>();
                for(ProductVariations product: order.getProductVariation()){

                    String productName = product.getProduct().getProductName()+"-"+product.getVariationValue();
                    orderedProducts.add(productName);
                }
                orderUserResponse.setOrderdItems(orderedProducts);
                orderUserResponses.add(orderUserResponse);
            }
            return new PageImpl<>(orderUserResponses);
        }
    }

    public Page<WishListResponse> getAllWishList(Long customerID,Pageable pageable){

        List<WishListResponse> wishListResponseList = new ArrayList<>();
        Page<WIshlist> wIshlists = wishListRepository.findByCustomerID(customerID, pageable);
        for(WIshlist wish: wIshlists){

            WishListResponse wishResponse = new WishListResponse();
            wishResponse.setAddedDate(wish.getAddedDate());
            wishResponse.setCustomerName(wish.getCustomer().getUser().getFirstName()+" "+wish.getCustomer().getUser().getLastName());
            wishResponse.setEmail(wish.getCustomer().getUser().getEmail());
            wishResponse.setId(wish.getId());
            wishResponse.setWishListItem(wish.getProductVariations().getProduct().getProductName()+" - "+wish.getProductVariations().getVariationValue());
            wishListResponseList.add(wishResponse);
        }
        return new PageImpl<>(wishListResponseList);
    }

    public Page<ProductResponse> getAllProductsByUser(long sellerId, Pageable pageable){

        Page<Products> products = productsRepository.findProductsBySeller(sellerId, pageable);
        return productService.getPageProducts(products, pageable);
    }


}
