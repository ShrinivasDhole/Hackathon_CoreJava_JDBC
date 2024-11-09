package com.pizza.dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

import com.pizza.entity.Cart;
import com.pizza.entity.PizzaPricing;
import com.pizza.entity.Pizza_Items;
import com.pizza.utility.DBUtils;

public class MenuDao implements AutoCloseable {

	Connection connection;
	List<Pizza_Items> piListVeg;
	List<Pizza_Items> piListNonVeg;
	List<Cart> cartList;
	Cart cart;

	public MenuDao() throws SQLException {
		connection = DBUtils.getConnection();
		piListVeg = new ArrayList<>();
		piListNonVeg = new ArrayList<>();
		cartList = new ArrayList<>();
	}

	public void showVeg() throws SQLException {
		String query = "Select * from pizza_items where type = ? ";

		try (PreparedStatement sVeg = connection.prepareStatement(query)) {
			sVeg.setString(1, "veg");
			ResultSet rs = sVeg.executeQuery();
			while (rs.next()) {
				piListVeg.add(new Pizza_Items(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5)));

			}
//			System.out.println(piListVeg.size());
			for (Pizza_Items pi : piListVeg) {
				System.out.println(pi.toString());
			}

		}
	}

	public void showNonVeg() throws SQLException {
		String query = "Select * from pizza_items where type = 'NonVeg' ";

		try (PreparedStatement sNonVeg = connection.prepareStatement(query)) {
			ResultSet rs = sNonVeg.executeQuery();
			while (rs.next()) {
				piListNonVeg.add(new Pizza_Items(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5)));

			}
			for (Pizza_Items pi : piListNonVeg) {
				System.out.println(pi.toString());
			}
		}
	}

	public void showAvailableSizes(int itemId) throws SQLException {
		String query = " Select * from pizza_pricing where itemid = ? ";

		try (PreparedStatement svs = connection.prepareStatement(query)) {
			svs.setInt(1, itemId);

			ResultSet rs = svs.executeQuery();
			System.out.println("Available sizes are :-> ");
			while (rs.next()) {
				System.out.println("Pricing id : " + rs.getInt(1) + " Item id : " + rs.getInt(2) + " Sizes : "
						+ rs.getString(3) + " Price : " + rs.getDouble(4));

			}
		}
	}

	public Cart addToCart(int priceId) throws SQLException {
		String query = "Select pi.name , pp.id , pp.itemid , pp.sizes , pp.price  from pizza_pricing pp , pizza_items pi where pi.id = pp.itemid and pp.id = ?";

		try (PreparedStatement ps = connection.prepareStatement(query)) {
			ps.setInt(1, priceId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				 cart = new Cart(rs.getString(1) , rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getDouble(5));
				System.out.println("Added to cart !");
			}
			return cart;
		}

//		
	}

	public void addOrders(int cId) throws SQLException {

		String query = "INSERT INTO PIZZA_ORDERS (CustomerId , OrderTime , Status ) values ( ? , ? , ?)";

		try (PreparedStatement iOrdr = connection.prepareStatement(query)) {
			iOrdr.setInt(1, cId);
			iOrdr.setString(2, LocalDateTime.now().toString());
			iOrdr.setString(3, "pending");
			int c = iOrdr.executeUpdate();
			if (c == 1) {
				System.out.println("---------------");
				System.out.println("Order Added !");
				System.out.println("---------------");
			} else {
				System.out.println("-----------------");
				System.out.println("Order Not Added !");
				System.out.println("-----------------");
			}
		}
	}

	public void addOrderDetails(int cId, List<Cart> cart) throws SQLException {
		addOrders(cId);
		int id = findOrderID(cId);
		System.out.println(id);
		if (cart.isEmpty()) {
			System.out.println("Cart is Empty...");
		} else {
			for (Cart pp : cart) {
				System.out.println(pp.toString());
				String query = "Insert into pizza_orderdetails (OrderId , PRICEID) values ( ? , ? ) ";
				try (PreparedStatement ps = connection.prepareStatement(query)) {
					ps.setInt(1, id);
					ps.setInt(2, pp.getPpId());
					ps.executeUpdate();
			}
		}
			System.out.println("------------------------------");
			System.out.println("Orders added successfully...");
			System.out.println("------------------------------");
	}
}

	public int findOrderID(int cId) throws SQLException {
		String query = "Select id from pizza_orders where customerid = ? order by orderTime desc limit 1";
		int result = -1;
		try (PreparedStatement ps = connection.prepareStatement(query)) {
			ps.setInt(1, cId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				result = rs.getInt(1);
			}
			return result;
		}

	}
	


	@Override
	public void close() throws Exception {
		connection.close();

	}

//	public void placeOrders(int cId) {
//		String query = "Insert into pizza_orderdetails (orderid , priceid) values (select id from pizza_orders where customerId = ? , )"
//	}

}
