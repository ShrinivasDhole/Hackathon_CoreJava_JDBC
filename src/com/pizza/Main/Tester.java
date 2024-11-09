package com.pizza.Main;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.pizza.dao.LoginDao;
import com.pizza.dao.MenuDao;
import com.pizza.dao.OrderDao;
import com.pizza.entity.Cart;
import com.pizza.entity.PizzaPricing;
import com.pizza.entity.Pizza_Customers;
import com.pizza.entity.Pizza_Items;

public class Tester {

	public static int menu1(Scanner sc) {
		System.out.println("0. EXIT");
		System.out.println("1. Sign In");
		System.out.println("2. Sign Up");
		System.out.print("Enter the choice : ");
		return sc.nextInt();
	}

	public static int menu2(Scanner sc) {
		System.out.println("0. EXIT");
		System.out.println("1. Show veg menu");
		System.out.println("2. Show non veg menu");
		System.out.println("3. Show available sizes");
		System.out.println("4. Add to cart");
		System.out.println("5. Show cart");
		System.out.println("6. Place order");
		System.out.println("7. Sign out");
		System.out.print("Enter the choice : ");
		return sc.nextInt();
	}

	public static int menu3(Scanner sc) {
		System.out.println("0. EXIT");
		System.out.println("1. Show all orders");
		System.out.println("2. Show order details");
		System.out.println("3. Sign out");
		System.out.print("Enter the choice : ");
		return sc.nextInt();
	}

	public static Pizza_Customers signInFun(Scanner sc) {
		try (LoginDao ld = new LoginDao()) {
			System.out.print("Enter the email : ");
			String email = sc.next();
			System.out.print("Enter the password : ");
			String password = sc.next();
			return ld.signIn(email, password);

		} catch (SQLException e) {
			System.out.println("-----------------------");
			System.out.println("Sign in failed...error");
			System.out.println("-----------------------");
			return null;
		} catch (Exception e) {
			System.out.println("-----------------------");
			System.out.println("Sign in failed...error");
			System.out.println("-----------------------");
			return null;
		}
	}

	public static void showVegMenuFun() {
		try (MenuDao mn = new MenuDao()) {
			mn.showVeg();
		} catch (SQLException e) {
			System.out.println("---------------------------");
			System.out.println("Error showing veg menu...");
			System.out.println("---------------------------");
		} catch (Exception e) {
			System.out.println("---------------------------");
			System.out.println("Error showing veg menu...");
			System.out.println("---------------------------");
		}
	}

	public static void showNonVegMenuFun() {
		try (MenuDao mn = new MenuDao()) {
			mn.showNonVeg();
		} catch (SQLException e) {
			System.out.println("---------------------------");
			System.out.println("Error showing non veg menu...");
			System.out.println("---------------------------");
		} catch (Exception e) {
			System.out.println("---------------------------");
			System.out.println("Error showing non veg menu...");
			System.out.println("---------------------------");
		}
	}

	public static void showAvailableSizesFun(Scanner sc) {
		try (MenuDao mn = new MenuDao()) {
			System.out.print("Enter the item id to see available sizes : ");
			int avs = sc.nextInt();
			mn.showAvailableSizes(avs);
		} catch (SQLException e) {
			System.out.println("----------------------------");
			System.out.println("Sizes not availble...error");
			System.out.println("----------------------------");
		} catch (Exception e) {
			System.out.println("----------------------------");
			System.out.println("Sizes not availble...error");
			System.out.println("----------------------------");
		}
	}

	public static void signUpFun(Scanner sc) {
		try (LoginDao ld = new LoginDao()) {
			System.out.print("Enter the name : ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Enter the password : ");
			String password = sc.next();
			System.out.print("Enter the mobile : ");
			String mobile = sc.next();
			System.out.print("Enter the address : ");
			sc.nextLine();
			String address = sc.nextLine();
			System.out.print("Enter the email : ");
			String email = sc.next();

			ld.signUp(name, password, mobile, address, email);
		} catch (SQLException e) {
			System.out.println("-----------------------");
			System.out.println("Sign up failed...error");
			System.out.println("-----------------------");
		} catch (Exception e) {
			System.out.println("-----------------------");
			System.out.println("Sign up failed...error");
			System.out.println("-----------------------");
		}
	}

	public static boolean signOutFun() {
		try (LoginDao ld = new LoginDao()) {
			return ld.signOut();
		} catch (SQLException e) {
			System.out.println("-------------------");
			System.out.println("Sign out failed...");
			System.out.println("-------------------");
			return false;
		} catch (Exception e) {
			System.out.println("-------------------");
			System.out.println("Sign out failed...");
			System.out.println("-------------------");
			return false;
		}
	}

	public static void showAllOrdersFun() {
		try (OrderDao od = new OrderDao()) {
			od.fetchAllOrdersInDesc();
		} catch (SQLException e) {
			System.out.println("-------------------------------");
			System.out.println("Show all orders failed..error");
			System.out.println("-------------------------------");
		} catch (Exception e) {
			System.out.println("-------------------------------");
			System.out.println("Show all orders failed..error");
			System.out.println("-------------------------------");
		}
	}

	public static void showAllOrdersById(Scanner sc) {
		try (OrderDao od = new OrderDao()) {
			System.out.print("Enter the order id : ");
			int orderId = sc.nextInt();
			od.fetchOrderById(orderId);
		} catch (SQLException e) {
			System.out.println("--------------------------");
			System.out.println("Show all orders failed...");
			System.out.println("--------------------------");
		} catch (Exception e) {
			System.out.println("--------------------------");
			System.out.println("Show all orders failed...");
			System.out.println("--------------------------");
		}
	}
	
	public static Cart addToCartFun(Scanner sc) {
		try(MenuDao md = new MenuDao()){
			System.out.println("Enter the pricing id : ");
			int id = sc.nextInt();
			return md.addToCart(id);
		} catch (SQLException e) {
			System.out.println("---------------------------");
			System.out.println("Add to card failed..error");
			System.out.println("---------------------------");
			return null;
		} catch (Exception e) {
			System.out.println("---------------------------");
			System.out.println("Add to card failed..error");
			System.out.println("---------------------------");
			return null;
		}
	}
	
	public static void addOrderDetails(int cId, List<Cart> cart) {
		try(MenuDao mn = new MenuDao()){
			mn.addOrderDetails(cId, cart);
		} catch (SQLException e) {
			System.out.println("---------------------------------");
			System.out.println("Add order details failed...error");
			System.out.println("---------------------------------");
		} catch (Exception e) {
			System.out.println("---------------------------------");
			System.out.println("Add order details failed...error");
			System.out.println("---------------------------------");
		}
	}
	
	public static double displayBill(List<Cart> cart) {
		double bill = 0;
		for(Cart pp : cart ) {
			bill += pp.getPrice();
		}
		return bill;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choice1;
		
		
		List<Cart> cart = new ArrayList<>();
		
		while((choice1 = menu1(sc))!=0 ) {
			switch (choice1) {
			case 1:
				Pizza_Customers pc = signInFun(sc);
				if(pc!=null && pc.getcId()!=1 ) {
					System.out.println("----------------------------");
					System.out.println("Logged in Customer : " + pc.getName());
					System.out.println("----------------------------");
					int choice2;
					boolean flag = true;
					while(flag && (choice2=menu2(sc))!=0 ) {
						switch (choice2) {
						case 1:
							showVegMenuFun();
							break;
						case 2:
							showNonVegMenuFun();
							break;
						case 3:
							showAvailableSizesFun(sc);
							break;
						case 4:
							cart.add(addToCartFun(sc));
							break;
						case 5:
							cart.stream().forEach(System.out::println);
							System.out.println("Total Bill : " + displayBill(cart));
							break;
						case 6:
							addOrderDetails(pc.getcId() , cart);
							break;
						case 7:
							if(signOutFun()) {
								flag = false;
							}
							break;
						default:
							System.out.println("---------------");
							System.out.println("Invalid input...");
							System.out.println("---------------");
							break;
						}
					}
				}else if(pc!=null && pc.getcId()==1) {
					System.out.println("---------------------");
					System.out.println("Logged in as admin");
					System.out.println("---------------------");
					int choice3;
					boolean flag = true;
					while(flag && (choice3 = menu3(sc))!=0) {
						switch(choice3) {
						case 1:
							showAllOrdersFun();
							break;
						case 2:
							showAllOrdersById(sc);
							break;
						case 3:
							if(signOutFun()) {
								flag = false;
							}
							break;
						default :
							System.out.println("------------------");
							System.out.println("Invalid Input...");
							System.out.println("------------------");
							break;
						}
					}
				}
				break;
			case 2:
				signUpFun(sc);
				
				break;
			default:
				System.out.println("------------------");
				System.out.println("Invalid input...");
				System.out.println("------------------");
				break;
			}
		}
		
	}

}
