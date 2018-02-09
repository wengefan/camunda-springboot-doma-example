package com.example.service;

import java.util.logging.Logger;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.seasar.doma.jdbc.tx.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.AppConfig;
import com.example.Category;
import com.example.Reservation;
import com.example.ReservationDao;

//@Component
public class ExpenseRecorder implements JavaDelegate {
    private final Logger LOGGER = Logger.getLogger(ExpenseRecorder2.class.getName());

    @Autowired
	private ReservationDao dao;

    @Override
    public void execute(DelegateExecution execution) throws Exception {
    	//dao = SbDemoApplication.getInstance().reservationDao;


        LOGGER.info("内容: " + execution.getVariable("detail"));
        LOGGER.info("金額（円）: " + execution.getVariable("amount"));
        LOGGER.info("経費種別: " + Category.valueOf((String)execution.getVariable("expenseCategory")));
        LOGGER.info("承認済み？: " + (((Boolean)execution.getVariable("approved")).booleanValue() ? "はい" : "いいえ"));
        Reservation data = new Reservation();
        data.amount = (Double)execution.getVariable("amount");
        data.approved = (Boolean)execution.getVariable("approved");
        data.expenseCategory =(String)execution.getVariable("expenseCategory");
        TransactionManager tm = AppConfig.singleton().getTransactionManager();
        tm.required(() -> {
        	dao.insert(data);
        });

    }

}
