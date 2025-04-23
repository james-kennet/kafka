package com.demo.kafka.dao;

import com.demo.kafka.entity.AddressTransaction;
import com.demo.kafka.entity.BaseAddress;
import com.demo.kafka.repository.AddressRepositoryFactory;
import com.demo.kafka.repository.AddressTransactionRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class AddressDao {

	private final AddressRepositoryFactory repositoryFactory;
	private final AddressTransactionRepository transactionRepository;

	public AddressDao(AddressRepositoryFactory repositoryFactory,
			AddressTransactionRepository transactionRepository) {
		this.repositoryFactory = repositoryFactory;
		this.transactionRepository = transactionRepository;
	}

	public void saveClientAddress(BaseAddress entity) {
		JpaRepository repository = repositoryFactory.getRepository(entity.getClass());
		saveToRepository(entity, repository);
	}

	@SuppressWarnings("unchecked")
	private void saveToRepository(BaseAddress entity, JpaRepository repository) {
		repository.save(entity);
	}

	public void saveTransaction(AddressTransaction transaction) {
		transactionRepository.save(transaction);
	}
}
