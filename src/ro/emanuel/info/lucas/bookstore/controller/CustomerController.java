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
	public class CustomerController {
		
		
		//show function
		@RequestMapping(value = "customer.htm")
		public ModelAndView showCustomer() throws SQLException {
			ModelMap model = new ModelMap();

			ArrayList<Customer> customer = CustomerDAO.getCustomer();
			model.addAttribute("customerList", customer);

			return new ModelAndView("/customer/list", "model", model);

		}
		//details function
		@RequestMapping(value = "/customer/details/{customerID}")
		public ModelAndView getDetails(@PathVariable String customerID, Model model)
				throws NumberFormatException, SQLException {

			Customer c = CustomerDAO.getCustomerById(Integer.parseInt(customerID));
			model.addAttribute("customer", c);

			return new ModelAndView("/customer/details", "model", model);
		}

		//edit function
		@RequestMapping(value = "/customer/edit/{customerID}")
		public ModelAndView editDetalii(@PathVariable String customerID, Model model)
				throws NumberFormatException, SQLException {

			Customer c = CustomerDAO.getCustomerById(Integer.parseInt(customerID));
			model.addAttribute("customerForm", c);

			return new ModelAndView("/customer/edit", "model", model);
		}

		@RequestMapping(value = "/customer/save", method = RequestMethod.POST)
		public ModelAndView saveCustomer(@ModelAttribute("customerForm") Customer customer, ModelMap model, BindingResult result) {

			Customer customerObj;
			try {
				customerObj = CustomerDAO.getCustomerById(Integer.valueOf(customer.getID()));
				customerObj.setFirstName((customer.getFirstName()));
				customerObj.setLastName(customer.getLastName());
				customerObj.setEmail(customer.getEmail());
				customerObj.setAddress(customer.getAddress());
				customerObj.setCity(customer.getCity());
				customerObj.setDistrict(customer.getDistrict());
				customerObj.setCountry(customer.getCountry());
				CustomerDAO.updateCustomer(customer);
				model.put("customerForm", customer);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}

			return new ModelAndView("/customer/edit", "command", customer);
		}
		
		//delete function
		@RequestMapping(value = "/customer/delete/{customerID}")
		public ModelAndView deleteCustomer(@PathVariable String customerID, Model model)
				throws NumberFormatException, SQLException {

			CustomerDAO.deleteCustomer(CustomerDAO.getCustomerById(Integer.parseInt(customerID)));
			ArrayList<Customer> customer = CustomerDAO.getCustomer();
			model.addAttribute("customerList", customer);

			return new ModelAndView("/customer/list", "model", model);
		}
		
		
		//add function
		@RequestMapping(value = "/customer/add")
		public ModelAndView adaugaCustomer(Model model) throws NumberFormatException, SQLException {

			Customer c = new Customer();
			model.addAttribute("customerForm", c);

			return new ModelAndView("/customer/add", "model", model);
		}

		@RequestMapping(value = "/customer/addCustomer", method = RequestMethod.POST)
		public ModelAndView addCustomer(@ModelAttribute("customerForm") Customer customer, ModelMap model, BindingResult result) {

			try {
				CustomerDAO.createCustomer(customer);
				model.put("customerForm", customer);
			} catch (NumberFormatException e) {
			
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}

			// return new ModelAndView("/customer/edit", "command", user);
			return new ModelAndView("redirect:/customer.htm");
		}
	}
