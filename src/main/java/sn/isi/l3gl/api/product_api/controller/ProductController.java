package sn.isi.l3gl.api.product_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sn.isi.l3gl.core.product_core.entite.Product;
import sn.isi.l3gl.core.product_core.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {


    @Autowired
    private ProductService productService;


    //POST	/api/products	createProduct()	Ajouter un produit
    @PostMapping
    public Product create(@RequestBody Product p){
        return productService.createProduct(p);
    }

    //GET	/api/products	listProducts()	Lister les produits
    @GetMapping
    public List<Product> liste(){
        return productService.listProducts();
    }

    //PUT	/api/products/{id}	updateQuantity()	Modifier le stock
    @PutMapping("/{id}")
    public void updateQuantity(@PathVariable Integer id, @RequestParam int quantity){
        productService.updateQuantity(id, quantity);
    }


    //GET	/api/products/low-stock/count	countLowStockProducts()	Nombre de produits en stock faible
    @GetMapping("/low-stock/count")
    public int countLowStockProducts(){
        return productService.countLowStockProducts();
    }
}
