package com.JJ.Code.ecommerce.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;

import com.JJ.Code.ecommerce.Entity.Product;
import com.JJ.Code.ecommerce.Entity.ProductCategory;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer  {

	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {

		HttpMethod[] theUnsupportedMethod = {HttpMethod.POST,HttpMethod.PUT,HttpMethod.DELETE};
		
		// display HTTP method for Product : Put, Post, Delete
		config.getExposureConfiguration().forDomainType(Product.class).
		withItemExposure((metadata,httpMethod)->httpMethod.disable(theUnsupportedMethod)).
		withCollectionExposure((metadata,httpMethod)->httpMethod.disable(theUnsupportedMethod));
		
		// display HTTP method for ProductCategory : Put, Post, Delete
		config.getExposureConfiguration().forDomainType(ProductCategory.class).
		withItemExposure((metadata,httpMethod)->httpMethod.disable(theUnsupportedMethod)).
		withCollectionExposure((metadata,httpMethod)->httpMethod.disable(theUnsupportedMethod));
		
	}

}
