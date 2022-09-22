package com.example.arjun.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.arjun.entity.Payment;
import com.example.arjun.exception.PaymentNotFoundException;
import com.example.arjun.repository.PaymentRepository;



@Service
public class IPaymentServiceImpl implements IPaymentService {
	
@Autowired
private PaymentRepository paymentRepo;


@Override
public Payment addPayment(Payment payment) {
	return this.paymentRepo.save(payment);
	
}

@Override
public Payment removePayment(long id) throws PaymentNotFoundException{
	
  return null;
}

@Override
public Payment updatePayment(Payment payment) throws PaymentNotFoundException {
	
	
	Optional<Payment> paymentOpt=this.paymentRepo.findById(payment.getPaymentId());
	if(paymentOpt.isEmpty()) {
		throw new PaymentNotFoundException("Payment id not found");
	}
	Payment updatePayment=paymentOpt.get();
	updatePayment.setCardNumber(payment.getCardNumber());
	updatePayment.setCardName(payment.getCardName());
	updatePayment.setCardExpiry(payment.getCardExpiry());
	updatePayment.setBankName(payment.getBankName());
	updatePayment.setStatus(payment.getStatus());
	return this.paymentRepo.save(updatePayment);
	

}

@Override
public boolean deletePaymentById(Integer paymentId) {
	this.paymentRepo.deleteById(paymentId);
	return true;
}


@Override
public Payment getPaymentById(Integer paymentId) throws PaymentNotFoundException {
	Optional<Payment> paymentOpt= this.paymentRepo.findById(paymentId);
	if(paymentOpt.isEmpty())
		throw new PaymentNotFoundException("Id Not Found");
	
	return paymentOpt.get();
}


@Override
public List<Payment> getAllPaymentDetails() {
	return this.paymentRepo.findAll();
}


}


