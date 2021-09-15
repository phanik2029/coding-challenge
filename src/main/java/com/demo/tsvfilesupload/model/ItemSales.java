package com.demo.tsvfilesupload.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "itemsales")
public class ItemSales {

	@Id
	@Column(name = "item")
	private String item;

	@Column(name = "itemdescription")
	private String itemdescription;

	@Column(name = "itemprice")
	private Float itemprice;

	@Column(name = "itemcount")
	private Integer itemcount;

	@Column(name = "vendor")
	private String vendor;
	
	@Column(name = "vendoraddress")
	private String vendoraddress;

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getItemdescription() {
		return itemdescription;
	}

	public void setItemdescription(String itemdescription) {
		this.itemdescription = itemdescription;
	}

	public Float getItemprice() {
		return itemprice;
	}

	public void setItemprice(Float itemprice) {
		this.itemprice = itemprice;
	}

	public Integer getItemcount() {
		return itemcount;
	}

	public void setItemcount(Integer itemcount) {
		this.itemcount = itemcount;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public String getVendoraddress() {
		return vendoraddress;
	}

	public void setVendoraddress(String vendoraddress) {
		this.vendoraddress = vendoraddress;
	}

	public ItemSales(String item, String itemdescription, Float itemprice, Integer itemcount, String vendor,
			String vendoraddress) {
		super();
		this.item = item;
		this.itemdescription = itemdescription;
		this.itemprice = itemprice;
		this.itemcount = itemcount;
		this.vendor = vendor;
		this.vendoraddress = vendoraddress;
	}


	public ItemSales() {};
}
