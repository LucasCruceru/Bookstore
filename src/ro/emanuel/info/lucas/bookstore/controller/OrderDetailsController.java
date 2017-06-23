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
public class OrderDetailsController {
	


		//show function
				@RequestMapping(value = "orderDetails.htm")
				public ModelAndView showorderDetails() throws SQLException {
					ModelMap model = new ModelMap();

					ArrayList<OrderDetails> orderDetails = OrderDetailsDAO.getOrderDetails();
					model.addAttribute("orderDetailsList", orderDetails);

					return new ModelAndView("/orderDetails/list", "model", model);

				}
				//details function
				@RequestMapping(value = "/orderDetails/details/{orderDetailsID}")
				public ModelAndView getDetails(@PathVariable String orderDetailsID, Model model)
						throws NumberFormatException, SQLException {

					OrderDetails p = OrderDetailsDAO.getOrderDetailsById(Integer.parseInt(orderDetailsID));
					model.addAttribute("orderDetails", p);

					return new ModelAndView("/orderDetails/details", "model", model);
				}

				//edit function
				@RequestMapping(value = "/orderDetails/edit/{orderDetailsID}")
				public ModelAndView editDetalii(@PathVariable String orderDetailsID, Model model)
						throws NumberFormatException, SQLException {

					OrderDetails p = OrderDetailsDAO.getOrderDetailsById(Integer.parseInt(orderDetailsID));
					model.addAttribute("orderDetailsForm", p);

					return new ModelAndView("/orderDetails/edit", "model", model);
				}

				@RequestMapping(value = "/orderDetails/save", method = RequestMethod.POST)
				public ModelAndView saveorderDetails(@ModelAttribute("orderDetailsForm") OrderDetails orderDetails, ModelMap model, BindingResult result) {

					OrderDetails orderDetailsObj;
					try {
						orderDetailsObj = OrderDetailsDAO.getOrderDetailsById(Integer.valueOf(orderDetails.getID()));
						orderDetailsObj.setOrderID(orderDetails.getOrderID());
						orderDetailsObj.setProductID(orderDetails.getProductID());
						OrderDetailsDAO.updateOrderDetails(orderDetails);
						model.put("orderDetailsForm", orderDetails);
					} catch (NumberFormatException e) {
						e.printStackTrace();
					} catch (SQLException e) {
						e.printStackTrace();
					}

					return new ModelAndView("/orderDetails/edit", "command", orderDetails);
				}
				
				//delete function
				@RequestMapping(value = "/orderDetails/delete/{orderDetailsID}")
				public ModelAndView deleteorderDetails(@PathVariable String orderDetailsID, Model model)
						throws NumberFormatException, SQLException {

					OrderDetailsDAO.deleteOrderDetails(OrderDetailsDAO.getOrderDetailsById(Integer.parseInt(orderDetailsID)));
					ArrayList<OrderDetails> orderDetails = OrderDetailsDAO.getOrderDetails();
					model.addAttribute("orderDetailsList", orderDetails);

					return new ModelAndView("/orderDetails/list", "model", model);
				}
				
				
				//add function
				@RequestMapping(value = "/orderDetails/add")
				public ModelAndView adaugaorderDetails(Model model) throws NumberFormatException, SQLException {

					OrderDetails p = new OrderDetails();
					model.addAttribute("orderDetailsForm", p);

					return new ModelAndView("/orderDetails/add", "model", model);
				}

				@RequestMapping(value = "/orderDetails/addOrderDetails", method = RequestMethod.POST)
				public ModelAndView addorderDetails(@ModelAttribute("orderDetailsForm") OrderDetails orderDetails, ModelMap model, BindingResult result) {

					try {
						OrderDetailsDAO.createOrderDetails(orderDetails);
						model.put("orderDetailsForm", orderDetails);
					} catch (NumberFormatException e) {
					
						e.printStackTrace();
					} catch (SQLException e) {
						e.printStackTrace();
					}

					// return new ModelAndView("/orderDetails/edit", "command", user);
					return new ModelAndView("redirect:/orderDetails.htm");
				}
	}



