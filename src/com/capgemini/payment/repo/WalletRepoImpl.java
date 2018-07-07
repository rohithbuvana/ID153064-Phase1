package com.capgemini.payment.repo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.capgemini.payment.bean.Customer;


public class WalletRepoImpl implements WalletRepo {
	private Map<String, Customer> data; 
	{
		data=new HashMap<String, Customer>();
	}

	public WalletRepoImpl(Map<String, Customer> data) {
		super();
		this.data = data;
	}

	public WalletRepoImpl() {
		
	}

	public boolean save(Customer customer) {
		if(findOne(customer.getMobileNo())==null)
		{
			if(customer!=null)
			{
			data.put(customer.getMobileNo(), customer);
			return true;
			
			}
			else
			{
				return false;
			}
		}
		else 
			{
			data.replace(customer.getMobileNo(),customer);
			return true;
	}
	}

	public Customer findOne(String mobileNo) {
		Set set = data.entrySet();
		Iterator i = set.iterator();
		int flag = 0;
		Customer customer= new Customer();
		while (i.hasNext()) {
			Map.Entry me = (Map.Entry) i.next();
			if (me.getKey().equals(mobileNo)) {
				customer = (Customer) me.getValue();
				flag = 1;
				break;
			}
		}
			if (flag == 0) {
				return null;
			}
		
			return customer;
		
	}
}

