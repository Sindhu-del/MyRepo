package com.tyss.quizeap.dao;

import java.util.Date;

import com.tyss.quizapp.dto.Questions;
import com.tyss.quizapp.dto.Register;
import com.tyss.quizapp.dto.Results;


interface Quiz {
	Register login(String username,String Password);

	abstract  Register register(Register register);
	
	abstract Questions questions(int id);
	
	abstract void results(Results results);
	
	abstract Results getResults(Date date);

}

