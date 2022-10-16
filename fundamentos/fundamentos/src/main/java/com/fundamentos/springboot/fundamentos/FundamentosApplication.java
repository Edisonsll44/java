package com.fundamentos.springboot.fundamentos;

import com.fundamentos.springboot.fundamentos.bean.IMyBean;
import com.fundamentos.springboot.fundamentos.bean.IMyBeanWithDependency;
import com.fundamentos.springboot.fundamentos.bean.IMyBeanWithProperties;
import com.fundamentos.springboot.fundamentos.component.IComponentDependency;
import com.fundamentos.springboot.fundamentos.entity.User;
import com.fundamentos.springboot.fundamentos.pojo.UserPojo;
import com.fundamentos.springboot.fundamentos.repository.IUserRepository;
import com.fundamentos.springboot.fundamentos.service.UserService;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hibernate.tool.schema.SchemaToolingLogging.LOGGER;


@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {
	private IComponentDependency _componentDependency;
	private IMyBean _myBean;
	private IMyBeanWithDependency _myBeanWhitDependency;
	private IMyBeanWithProperties _myBeanWithProperties;
	private UserPojo _userPojo;
	private IUserRepository _userRepository;
	private UserService _userService;
	public FundamentosApplication(@Qualifier("componentImplementTwo") IComponentDependency componentDependency,
								  IMyBean myBean,
								  IMyBeanWithDependency myBeanWithDependency,
								  IMyBeanWithProperties myBeanWithProperties,
								  UserPojo userPojo,
								  IUserRepository userRepository,
								  UserService userService)
	{
		_componentDependency = componentDependency;
		_myBean = myBean;
		_myBeanWhitDependency = myBeanWithDependency;
		_myBeanWithProperties = myBeanWithProperties;
		_userPojo = userPojo;
		_userRepository =userRepository;
		_userService = userService;
	}
	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//EjemplosAnteriores();
		SaveUserInDataBase();
		GetInformationJpqlFromUser();
		SaveWithErrorTransactional();
	}
private void GetInformationJpqlFromUser(){
		LOGGER.info("El usuario con el método findUserEmail " +	_userRepository.FindUserEmail("anita1@aaa.com")
				.orElseThrow(()-> new RuntimeException("No se encontro el usuario")));

		_userRepository.FindAndSort("Ma", Sort.by("id").descending())
				.stream()
				.forEach(user -> LOGGER.info("Usuario con método sort "+ user));

		_userRepository.findByName("Ca")
				.stream()
				.forEach(u-> LOGGER.info("Usuario con query method " + u));

		_userRepository.findByEmailAndName("josue1@aaa.com","Josue")
				.orElseThrow(()-> new RuntimeException("Usuario no encontrado"));

		_userRepository.findByNameLike("%M%")
				.stream()
				.forEach(u-> LOGGER.info("Usuario con findByNamelike" + u));

	_userRepository.findByNameOrEmail("Monica", null)
			.stream()
			.forEach(u-> LOGGER.info("Usuario con findByNameOrEmail" + u));

	_userRepository.findByBirthDateBetween(LocalDate.of(2017,1,1),LocalDate.of(2021,12,30))
			.stream()
			.forEach(u-> LOGGER.info("Usuarios entre rangos de fechas" + u));

	_userRepository.findByNameLikeOrderByIdDesc("%Ca%")
			.stream()
			.forEach(u-> LOGGER.info("Usuarios con findByNameLikeOrderByIdDesc" + u));

	_userRepository.findByNameContainsOrderByIdDesc("Mo")
			.stream()
			.forEach(u-> LOGGER.info("Usuarios con findByNameContainsOrderByIdDesc" + u));

	LOGGER.info("getAllByBirthDateAndEmail"+ _userRepository.getAllByBirthDateAndEmail(LocalDate.of(2019,12,14),"carmen1@aaa.com")
			.orElseThrow(()-> new RuntimeException("No se encontro usuarios a partir de parámetros nombrados")));


}

private void SaveWithErrorTransactional(){
	User user1 = new User("Transaccction 1","transacction@aaa.com", LocalDate.of(2021,3,10));
	User user2 = new User("Transaccction 2","transacction1@aaa.com", LocalDate.of(2021,3,10));
	User user3 = new User("Transaccction 3","transacction2@aaa.com", LocalDate.of(2021,3,10));
	User user4 = new User("Transaccction 4","transacction3@aaa.com", LocalDate.of(2021,3,10));
	User user5 = new User("Transaccction 5","transacction4@aaa.com", LocalDate.of(2021,3,10));
	User user6 = new User("Transaccction 6","transacction@aaa.com", LocalDate.of(2021,3,10));
	List<User> users = Arrays.asList(user1,user2,user3,user4,user5,user6);
	try	{
		_userService.SaveTransactional(users);
	}catch (Exception e){
		LOGGER.error("Esto es una excepcion dentro del metodo transaccional " + e);
	}

	_userService.getAllUsers()
			.stream()
			.forEach(u-> LOGGER.info("Este es el usuario dentro del metodo transaccional " + u));

}
	private void SaveUserInDataBase(){
		User user1 = new User("Jhon","prueba1@aaa.com", LocalDate.of(2021,3,10));
		User user2 = new User("Carlos","charlie1@aaa.com", LocalDate.of(2020,1,12));
		User user3 = new User("Carmen","carmen1@aaa.com", LocalDate.of(2019,12,14));
		User user4 = new User("Gabriel","gabo1@aaa.com", LocalDate.of(2018,8,15));
		User user6 = new User("Maria","mary1@aaa.com", LocalDate.of(2016,4,20));
		User user7 = new User("Marco","marco1@aaa.com", LocalDate.of(2015,4,21));
		User user8 = new User("Monica","moni1@aaa.com", LocalDate.of(2014,2,23));
		User user9 = new User("Anita","anita1@aaa.com", LocalDate.of(2012,11,28));
		User user10 = new User("Anderson","ander1@aaa.com", LocalDate.of(2012,10,14));
		User user5 = new User("Esteban","estebitan1@aaa.com", LocalDate.of(2017,9,18));
		User user11 = new User("Carlos","charles1@aaa.com", LocalDate.of(2011,12,4));
		User user12 = new User("Camila","camila1@aaa.com", LocalDate.of(2010,11,9));
		User user13 = new User("Josue","josue1@aaa.com", LocalDate.of(2010,11,1));
		List<User> list = Arrays.asList(user1,user2,user3,user4,user5,user6,user7,user8,user9,user10,user11,user12, user13);
		_userRepository.saveAll(list);
	}
	private void EjemplosAnteriores(){
		_componentDependency.Saludar();
		_myBean.Print();
		_myBeanWhitDependency.PrintWhitDependency();
		System.out.println(_myBeanWithProperties.Function());
		System.out.println(_userPojo.get_name() + " - "+ _userPojo.get_password() + " - " + _userPojo.get_age());
	}
}
