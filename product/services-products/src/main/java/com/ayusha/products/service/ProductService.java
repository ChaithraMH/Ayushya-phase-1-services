package com.ayusha.products.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ayusha.products.data.models.ProductDataModel;
import com.ayusha.products.data.models.ProductsDataModel;
import com.ayusha.products.service.entity.CategoryEntity;
import com.ayusha.products.service.entity.MakeEntity;
import com.ayusha.products.service.entity.ModelEntity;
import com.ayusha.products.service.entity.ProductEntity;
import com.ayusha.products.service.entity.SubCategoryEntity;
import com.ayusha.products.service.repository.ICategoryRepository;
import com.ayusha.products.service.repository.IMakeRepository;
import com.ayusha.products.service.repository.IModelRepository;
import com.ayusha.products.service.repository.IProductRepository;
import com.ayusha.products.service.repository.ISubCategoryRepository;
import com.ayusha.services.common.exceptions.DataPersistenceOperationException;
import com.ayusha.services.common.exceptions.InvalidServiceRequestException;
import com.ayusha.services.common.exceptions.ResourceNotFoundException;
import com.custom.logger.logging.Logger;
import com.custom.logger.manager.LogManager;

/**
 * 
 * @author Finch Date : 01-Aug-2019 Product Service Methods
 */
@Service
public class ProductService implements IProductService {

	/** LOGGER **/
	private static Logger LOG = LogManager.getLogger(ProductService.class);

	/** iProductRepository **/
	@Autowired
	private IProductRepository iProductRepository;

	/** iCategoryRepository **/
	@Autowired
	private ICategoryRepository iCategoryRepository;

	/** iSubCategoryRepository **/
	@Autowired
	private ISubCategoryRepository iSubCategoryRepository;

	/** iMakeRepository **/
	@Autowired
	private IMakeRepository iMakeRepository;

	/** iModelRepository **/
	@Autowired
	private IModelRepository iModelRepository;

	/**
	 * default constructor
	 */
	public ProductService() {

	}

	/**
	 * service call to get product by Id,
	 * no other service dependency
	 */
	public ProductDataModel getProductById(String productId)
			throws DataPersistenceOperationException, InvalidServiceRequestException {
		ProductDataModel productDataModel = new ProductDataModel();
		ProductEntity productEntity = iProductRepository.findProductByProductId(productId);

		productDataModel.setId(Integer.parseInt("" + productEntity.getId()));
		productDataModel.setCategoryId(productEntity.getCategoryId());
		productDataModel.setSubCategoryId(productEntity.getSubCategoryId());
		productDataModel.setMakeId(productEntity.getMake_id());
		productDataModel.setProductId(productId);
		productDataModel.setModelId(productEntity.getModelId());
		productDataModel.setMakeId(productEntity.getMake_id());// 134.209.147.111:8062
		populateProductData(productDataModel);
		return productDataModel;
	}

	/**
	* populate product data
	 */
	private void populateProductData(ProductDataModel productDataModel)
			throws DataPersistenceOperationException, InvalidServiceRequestException {

		String categoryId = productDataModel.getCategoryId();
		CategoryEntity categoryEntity = iCategoryRepository.findCategoryByCategoryId(categoryId);
		productDataModel.setCategoryName(categoryEntity.getName());

		String subCategoryId = productDataModel.getSubCategoryId();
		SubCategoryEntity subCategoryEntity = iSubCategoryRepository.findSubCategoryBySubCatId(subCategoryId);
		productDataModel.setSubCategoryName(subCategoryEntity.getName());

		String makeId = productDataModel.getMakeId();
		MakeEntity makeEntity = iMakeRepository.findMakeByMakeId(makeId);
		productDataModel.setMakeName(makeEntity.getName());

		String modelId = productDataModel.getModelId();
		ModelEntity modelEntity = iModelRepository.findModelByModelId(modelId);
		productDataModel.setModelName(modelEntity.getName());

	}

	/**
	 * service call to get product by category id, subcategory id, make id and model id
	 * no other service dependency
	 */
	public ProductDataModel getProductFor(String categoryId, String subCategoryId, String makeId, String modelId)
			throws DataPersistenceOperationException, InvalidServiceRequestException, ResourceNotFoundException {
		ProductDataModel productDataModel = new ProductDataModel();
		ProductEntity productEntity = iProductRepository.findProducts(categoryId, subCategoryId, makeId, modelId);
		LOG.info(" GGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGG " + productEntity + ":" + categoryId + ":" + subCategoryId
				+ ":" + makeId + ":" + modelId);
		if (productEntity != null) {
			productDataModel.setId(Integer.parseInt("" + productEntity.getId()));
			productDataModel.setCategoryId(productEntity.getCategoryId());
			productDataModel.setSubCategoryId(productEntity.getSubCategoryId());
			productDataModel.setMakeId(productEntity.getMake_id());
			productDataModel.setProductId(productEntity.getProductId());
			productDataModel.setModelId(productEntity.getModelId());
			productDataModel.setMakeId(productEntity.getMake_id());
			// populateProductData(productDataModel);
			return productDataModel;
		} else {
			throw new ResourceNotFoundException("product not available!!!!");

		}
	}

	/**
	 * service call to get product data by category id, sub category id and make id,
	 * no other service dependency
	 */
	public ProductsDataModel getProductFor(String categoryId, String subCategoryId, String makeId)
			throws DataPersistenceOperationException, InvalidServiceRequestException {
		ProductDataModel productDataModel = new ProductDataModel();
		List<ProductEntity> lstMakeEntity = iProductRepository.findProduct(categoryId, subCategoryId, makeId);
		List<ProductDataModel> lstProductDataModel = new ArrayList();
		ProductEntity productEntity = null;
		int size = 0;

		size = lstMakeEntity.size();
		for (int index = 0; index < size; index++) {
			productDataModel = new ProductDataModel();
			productEntity = lstMakeEntity.get(index);
			productDataModel.setId(Integer.parseInt("" + productEntity.getId()));
			productDataModel.setCategoryId(productEntity.getCategoryId());
			productDataModel.setSubCategoryId(productEntity.getSubCategoryId());
			productDataModel.setMakeId(productEntity.getMake_id());
			productDataModel.setModelId(productEntity.getModelId());
			populateProductData(productDataModel);
			lstProductDataModel.add(productDataModel);
		}
		ProductsDataModel productsDataModel = new ProductsDataModel();
		productsDataModel.setLstProductDataModel(lstProductDataModel);
		return productsDataModel;
	}

	/**
	 * service call to update product,
	 * no other service dependency
	 */
	public ProductDataModel updateProduct(ProductDataModel productDataModel)
			throws DataPersistenceOperationException, InvalidServiceRequestException {
		ProductEntity productEntity = new ProductEntity();

		productEntity.setId(productDataModel.getId());
		productEntity.setProductId(productDataModel.getProductId());
		productEntity.setMake_id(productDataModel.getMakeId());
		productEntity.setModelId(productDataModel.getModelId());
		productEntity.setCategoryId(productDataModel.getCategoryId());
		productEntity.setSubCategoryId(productDataModel.getSubCategoryId());
		iProductRepository.save(productEntity);
		return productDataModel;
	}

	/**
	 * service call to add product,
	 * no other service dependency
	 */
	public ProductDataModel add(ProductDataModel productDataModel)
			throws DataPersistenceOperationException, InvalidServiceRequestException {

		ProductEntity productEntity = new ProductEntity();

		productEntity.setId(productDataModel.getId());
		productEntity.setProductId(productDataModel.getProductId());
		productEntity.setMake_id(productDataModel.getMakeId());
		productEntity.setModelId(productDataModel.getModelId());
		productEntity.setCategoryId(productDataModel.getCategoryId());
		productEntity.setSubCategoryId(productDataModel.getSubCategoryId());
		iProductRepository.save(productEntity);
		return productDataModel;
	}

	/**
	 * service call to get product by product id,
	 * no other service dependency
	 */
	@Override
	public ProductEntity getProduct(String productId) throws DataPersistenceOperationException,
			InvalidServiceRequestException, ResourceNotFoundException, Exception {
		ProductEntity productEntity = iProductRepository.findProductByProductId(productId);
		return productEntity;
	}

}
