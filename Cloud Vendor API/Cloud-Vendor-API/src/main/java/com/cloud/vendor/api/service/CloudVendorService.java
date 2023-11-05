package com.cloud.vendor.api.service;

import java.util.List;

import com.cloud.vendor.api.model.CloudVendor;

public interface CloudVendorService {
	
	public List<CloudVendor> getAllCloudVendors();
	public CloudVendor getCloudVendor(String vendorId);
	public String createCloudVendor(CloudVendor cloudVendor);
	public String updateCloudVendor(CloudVendor cloudVendor);
	public String deleteCloudVendor(String vendorId);
	
}
