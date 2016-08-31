package Test_Connection;

import com.api.dao.AccountInfo;
import com.api.dao.Transfer;

public class Test_Connection {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		AccountInfo acc = new AccountInfo();
//		acc.getAcc("1234567890");
		
		Transfer t = new Transfer();
		t.updateTransfer("1234567890", "8472122435", 20000.00, 0.00);
	}

}
