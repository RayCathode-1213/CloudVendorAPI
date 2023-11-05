package com.cloud.vendor.api.model.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.vendor.api.model.CloudVendor;
import com.cloud.vendor.api.response.ResponseHandler;
import com.cloud.vendor.api.service.CloudVendorService;

@RestController
@RequestMapping("/cloudVendor")
public class CloudVendorAPIService {

	@Autowired
	private CloudVendorService cloudVendorService;

	@GetMapping("{vendorId}")
	public ResponseEntity<Object> getCloudVendorDetails(@PathVariable("vendorId") String vendorId) {
		return ResponseHandler.responseBuilder("Requested Vendor Details are given here", HttpStatus.OK,
				this.cloudVendorService.getCloudVendor(vendorId));
//		return this.cloudVendorService.getCloudVendor(vendorId);
	}

	@GetMapping()
	public List<CloudVendor> getAllCloudVendors() {
		return this.cloudVendorService.getAllCloudVendors();
	}

	@PostMapping()
	public String createCloudVendor(@RequestBody CloudVendor cloudVendor) {
		return this.cloudVendorService.createCloudVendor(cloudVendor);
	}

	@PutMapping()
	public String updateCloudVendorDetails(@RequestBody CloudVendor cloudVendor) {
		this.cloudVendorService.updateCloudVendor(cloudVendor);
		return "Cloud Vendor Updated Successfully";
	}

	@DeleteMapping("{vendorId}")
	public String deleteCloudVendorDetails(@PathVariable("vendorId") String vendorId) {
		this.cloudVendorService.deleteCloudVendor(vendorId);
		return "Cloud Vendor Deleted Successfully";
	}

}
