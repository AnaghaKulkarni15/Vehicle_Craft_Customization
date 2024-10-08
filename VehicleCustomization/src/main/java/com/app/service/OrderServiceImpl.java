package com.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.OrderRepository;
import com.app.dao.UserRepository;
import com.app.dto.OrderDTO;
import com.app.entities.Category;
import com.app.entities.ConfigurationModel;
import com.app.entities.Order;
import com.app.entities.PaymentStatus;
import com.app.entities.Role;
import com.app.entities.User;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private UserServiceI userservice;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private ConfigurationModelService configurationModelService;

	@Autowired
	private ModelMapper mapper;

	@Override
	public Order addOrder(OrderDTO orderDto) {
		Order order = new Order();
		double amount = 0;

		Long userId = orderDto.getUserId();
		Long categoryId = orderDto.getCategoryId();
		Set<Long> configureModelList = orderDto.getConfigurationModelId();

		User user = userservice.getById(userId);
		order.setUser(user);

		Category category = categoryService.getByCategoryId(categoryId);
		order.setCategory(category);
		// using getConfigurationModels we reuse already ctreated set which is in
		// configModele class
		// we also use newly created set instead of this
		for (Long configModelId : configureModelList) {

			ConfigurationModel configurationModel = configurationModelService.getById(configModelId);
			amount = amount + configurationModel.getModelPrice();
			order.getConfigurationModels().add(configurationModel);
		}
		order.setTotalAmount(amount+category.getPrice());
		order.setStatus(PaymentStatus.PENDING);
		orderRepository.save(order);

		return order;
	}

	@Override
	public Order updatePaymentStatusById(Long order_id) {

		//Order order=orderRepository.findById(order_id).orElseThrow(
		//()->new com.app.custom_exception.InvalidCredentialsException("Payment Status is not Changed!!!"));
		Order order=orderRepository.findById(order_id).orElseThrow();	
		order.setStatus(PaymentStatus.DONE);
		orderRepository.save(order);
		return order;
	}

	@Override
	public List<Order> orderByUserId(Long user_id) {
		User user=userservice.getById(user_id);
		Role role=user.getRole();
		List<Order> orders=new ArrayList<Order>();
		if(role==Role.ADMIN)
		{
			 return orders=orderRepository.findAll();
		}
		else if(role==Role.CUSTOMER)
		{
			return orderRepository.findByUserId(user_id);	
		}
		return orders;
	
	}

}
