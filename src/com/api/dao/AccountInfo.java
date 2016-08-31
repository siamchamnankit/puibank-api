package com.api.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.api.bean.MasterAccount;

public class AccountInfo {

	public MasterAccount getAcc(String accNo) {
		MasterAccount result = new MasterAccount();

		Connection connect = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");

			connect = DriverManager
					.getConnection("jdbc:mysql://128.199.136.90/SomkiatBank"
							+ "?user=root&password=brucewayneisbatman");
			String acc = "";
			String name = "";
			Double amount = 0.00;
			if (connect != null) {
				System.out.println("Database Connected.");

				String sql = ("SELECT * FROM MasterAccount m where m.AccountNo = ?");
				PreparedStatement ps = connect.prepareStatement(sql);
				ps.setString(1, accNo);
				ResultSet rs = ps.executeQuery();
				try {
					if (rs.next()) {
						acc = rs.getString("AccountNo");
						name = rs.getString("Name");
						amount = rs.getDouble("Amount");
						
						result.setAccountNo(acc);
						result.setName(name);
						result.setAmount(amount);
					}
					System.out.println(acc);
				} catch (Exception e) {
					e.printStackTrace();
				}
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
		
		return result;
	}
}
