package com.api.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="transfer", urlPatterns="/transfer")
public class Transfer extends HttpServlet {
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2720244577882784292L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}



	public void updateTransfer(String accFrom, String accTo, double amount, double fee){
		
		Connection connect = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");

			connect = DriverManager
					.getConnection("jdbc:mysql://128.199.136.90/SomkiatBank"
							+ "?user=root&password=brucewayneisbatman");

			if (connect != null) {
				System.out.println("Database Connected.");
				
				//Update Acc To
				String sql = ("update MasterAccount m set m.amount = ?" +
						" where m.AccountNo=?");
				PreparedStatement ps = connect.prepareStatement(sql);
				ps.setDouble(1, amount);
				ps.setString(2, accTo);
				ps.executeUpdate();
				connect.commit();
				
				//Update Acc From
//				String sql2 = ("update MasterAccount m set m.amount = m.amount-?" +
//						" where m.AccountNo=?");
//				PreparedStatement ps2 = connect.prepareStatement(sql);
//				ps2.setDouble(1, amount+fee);
//				ps2.setString(2, accFrom);
//				ps2.executeUpdate();
				
			} else {
				System.out.println("Database Connect Failed.");
			}

			// Close
			try {
				if (connect != null) {
					connect.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
