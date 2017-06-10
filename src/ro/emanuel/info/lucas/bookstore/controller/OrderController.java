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
public class OrderController {


		//show function
				@RequestMapping(value = "order.htm")
				public ModelAndView showorder() throws SQLException {
					ModelMap model = new ModelMap();

					ArrayList<Order> order = OrderDAO.getOrder();
					model.addAttribute("orderList", order);

					return new ModelAndView("/order/list", "model", model);

				}
				//details function
				@RequestMapping(value = "/order/details/{orderID}")
				public ModelAndView getDetails(@PathVariable String orderID, Model model)
						throws NumberFormatException, SQLException {

					Order p = OrderDAO.getOrderById(Integer.parseInt(orderID));
					model.addAttribute("order", p);

					return new ModelAndView("/order/details", "model", model);
				}

				//edit function
				@RequestMapping(value = "/order/edit/{orderID}")
				public ModelAndView editDetalii(@PathVariable String orderID, Model model)
						throws NumberFormatException, SQLException {

					Order p = OrderDAO.getOrderById(Integer.parseInt(orderID));
					model.addAttribute("orderForm", p);

					return new ModelAndView("/order/edit", "model", model);
				}

				@RequestMapping(value = "/order/save", method = RequestMethod.POST)
				public ModelAndView saveorder(@ModelAttribute("orderForm") Order order, ModelMap model, BindingResult result) {

					Order orderObj;
					try {
						orderObj = OrderDAO.getOrderById(Integer.valueOf(order.getID()));
						orderObj.setDateOrder((order.getDateOrder()));
						orderObj.setTotalPrice(order.getTotalPrice());
						orderObj.setCustomerID(order.getCustomerID());
						OrderDAO.updateOrder(order);
						model.put("orderForm", order);
					} catch (NumberFormatException e) {
						e.printStackTrace();
					} catch (SQLException e) {
						e.printStackTrace();
					}

					return new ModelAndView("/order/edit", "command", order);
				}
				
				//delete function
				@RequestMapping(value = "/order/delete/{orderID}")
				public ModelAndView deleteorder(@PathVariable String orderID, Model model)
						throws NumberFormatException, SQLException {

					OrderDAO.deleteOrder(OrderDAO.getOrderById(Integer.parseInt(orderID)));
					ArrayList<Order> order = OrderDAO.getOrder();
					model.addAttribute("orderList", order);

					return new ModelAndView("/order/list", "model", model);
				}
				
				
				//add function
				@RequestMapping(value = "/order/add")
				public ModelAndView adaugaorder(Model model) throws NumberFormatException, SQLException {

					Order p = new Order();
					model.addAttribute("orderForm", p);

					return new ModelAndView("/order/add", "model", model);
				}

				@RequestMapping(value = "/order/addOrder", method = RequestMethod.POST)
				public ModelAndView addorder(@ModelAttribute("orderForm") Order order, ModelMap model, BindingResult result) {

					try {
						OrderDAO.createOrder(order);
						model.put("orderForm", order);
					} catch (NumberFormatException e) {
					
						e.printStackTrace();
					} catch (SQLException e) {
						e.printStackTrace();
					}

					// return new ModelAndView("/order/edit", "command", user);
					return new ModelAndView("redirect:/order.htm");
				}
	}

