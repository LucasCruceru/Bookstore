package ro.emanuel.info.lucas.bookstore.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ro.emanuel.info.lucas.bookstore.dao.*;
import ro.emanuel.info.lucas.bookstore.pojo.*;

@Controller
public class ProductController {

	//show function
			@RequestMapping(value = "product.htm")
			public ModelAndView showproduct() throws SQLException {
				ModelMap model = new ModelMap();

				ArrayList<Product> product = ProductDAO.getProduct();
				model.addAttribute("productList", product);

				return new ModelAndView("/product/list", "model", model);

			}
			//details function
			@RequestMapping(value = "/product/details/{productID}")
			public ModelAndView getDetails(@PathVariable String productID, Model model)
					throws NumberFormatException, SQLException {

				Product p = ProductDAO.getProductById(Integer.parseInt(productID));
				model.addAttribute("product", p);

				return new ModelAndView("/product/details", "model", model);
			}

			//edit function
			@RequestMapping(value = "/product/edit/{productID}")
			public ModelAndView editDetalii(@PathVariable String productID, Model model)
					throws NumberFormatException, SQLException {

				Product p = ProductDAO.getProductById(Integer.parseInt(productID));
				model.addAttribute("productForm", p);

				return new ModelAndView("/product/edit", "model", model);
			}

			@RequestMapping(value = "/product/save", method = RequestMethod.POST)
			public ModelAndView saveproduct(@ModelAttribute("productForm") Product product, ModelMap model, BindingResult result) {

				Product productObj;
				try {
					productObj = ProductDAO.getProductById(Integer.valueOf(product.getID()));
					productObj.setName((product.getName()));
					productObj.setPrice(product.getPrice());
					productObj.setNrInStore(product.getNrInStore());
					productObj.setDescription(product.getDescription());
					ProductDAO.updateProduct(product);
					model.put("productForm", product);
				} catch (NumberFormatException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}

				return new ModelAndView("/product/edit", "command", product);
			}
			
			//delete function
			@RequestMapping(value = "/product/delete/{productID}")
			public ModelAndView deleteproduct(@PathVariable String productID, Model model)
					throws NumberFormatException, SQLException {

				ProductDAO.deleteProduct(ProductDAO.getProductById(Integer.parseInt(productID)));
				ArrayList<Product> product = ProductDAO.getProduct();
				model.addAttribute("productList", product);

				return new ModelAndView("/product/list", "model", model);
			}
			
			
			//add function
			@RequestMapping(value = "/product/add")
			public ModelAndView adaugaproduct(Model model) throws NumberFormatException, SQLException {

				Product p = new Product();
				model.addAttribute("productForm", p);

				return new ModelAndView("/product/add", "model", model);
			}

			@RequestMapping(value = "/product/addProduct", method = RequestMethod.POST)
			public ModelAndView addproduct(@ModelAttribute("productForm") Product product, ModelMap model, BindingResult result) {

				try {
					ProductDAO.createProduct(product);
					model.put("productForm", product);
				} catch (NumberFormatException e) {
				
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}

				// return new ModelAndView("/product/edit", "command", user);
				return new ModelAndView("redirect:/product.htm");
			}
}
