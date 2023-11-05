package com.cloud.vendor.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.vendor.api.exception.CloudVendorNotFoundException;
import com.cloud.vendor.api.model.CloudVendor;
import com.cloud.vendor.api.repository.CloudVendorRepository;

@Service
public class CloudVendorServiceImpl implements CloudVendorService {

	@Autowired
	private CloudVendorRepository cloudVendorRepository;

	@Override
	public List<CloudVendor> getAllCloudVendors() {
		return cloudVendorRepository.findAll();
	}

	@Override
	public CloudVendor getCloudVendor(String vendorId) {
		/* Handle Exception */
		if(cloudVendorRepository.findById(vendorId).isEmpty()) {
			throw new CloudVendorNotFoundException("Requested Cloud Vendor doesn't exists");
		}
		CloudVendor cv = cloudVendorRepository.findById(vendorId).get();
		return cv;
	}

	@Override
	public String createCloudVendor(CloudVendor cloudVendor) {
		cloudVendorRepository.save(cloudVendor);
		return "Data Saved";
	}

	@Override
	public String updateCloudVendor(CloudVendor cloudVendor) {
		cloudVendorRepository.save(cloudVendor);
		return "Data Updated";
	}

	@Override
	public String deleteCloudVendor(String vendorId) {
		cloudVendorRepository.deleteById(vendorId);
		return "Data Deleted";
	}

}
