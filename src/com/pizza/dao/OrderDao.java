package com.pizza.dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.pizza.entity.PizzaOrders;
import com.pizza.utility.DBUtils;

public class OrderDao implements AutoCloseable {
	
	Connection connection;
	List<PizzaOrders> poList;
	public OrderDao() throws SQLException {
		connection = DBUtils.getConnection();
		poList = new ArrayList<>();
	}
	
	public void iOrder(int cId , String status) throws SQLException {
		
		String query = "INSERT INTO PIZZA_ORDERS (CustomerId , OrderTime , Status ) values ( ? , 'now()' , ?)";
		
		try(PreparedStatement iOrdr = connection.prepareStatement(query)){
			iOrdr.setInt(1,cId );
			iOrdr.setString(2, status );
			int c  = iOrdr.executeUpdate();
			if(c==1) {
				System.out.println("---------------");
				System.out.println("Order Added !");
				System.out.println("---------------");
			}else {
				System.out.println("-----------------");
				System.out.println("Order Not Added !");
				System.out.println("-----------------");
			}
		}
	}
	
	public void fetchAllOrdersInDesc() throws SQLException {
		String query = "SELECT * FROM PIZZA_ORDERS order by OrderTime desc";
		
		try(PreparedStatement fOrdrs = connection.prepareStatement(query)){
			ResultSet rs = fOrdrs.executeQuery();
			
			while(rs.next()) {
				poList.add(new PizzaOrders(rs.getInt(1), rs.getInt(2), rs.getTimestamp(3), rs.getString(4) ));
			}
			for(PizzaOrders po : poList) {
				System.out.println(po.toString());
			}
			
		}
	}
	
	public void fetchOrderById(int oId) throws SQLException {
		String query = "select pc.name \"customer name\" , pc.mobile , pi.name \"pizza name\" , pi.type , pi.category , pi.description , pp.sizes , pp.price , po.status from pizza_orders po, pizza_customers pc , pizza_orderdetails pod , pizza_pricing pp , pizza_items pi where po.customerId = pc.id and pod.orderid = po.id and pod.priceid = pp.id and pp.itemid = pi.id and po.id = ?";
		try(PreparedStatement fOrdrsById = connection.prepareStatement(query)){
			fOrdrsById.setInt(1, oId);
			ResultSet rs = fOrdrsById.executeQuery();
			while(rs.next()) {
			System.out.println("Customer Name : " + rs.getString(1) + " Mobile : " + rs.getString(2) + 
					" Pizza name : " + rs.getString(3) + " Type : " + rs.getString(4) + " Category : " + rs.getString(5) + " Description : " + rs.getString(6) + " Size : " + rs.getString(7) + " Price : " + rs.getDouble(8) + " Status : " + rs.getString(9));
			}
		}
	}

	@Override
	public void close() throws Exception {
		connection.close();
		
	}
	
	

}
