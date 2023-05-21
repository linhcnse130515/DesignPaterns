package com.example.DesignPaterns;

import com.example.DesignPaterns.behavior_patterns.strategy_pattern.MergeSort;
import com.example.DesignPaterns.behavior_patterns.strategy_pattern.QuickSort;
import com.example.DesignPaterns.behavior_patterns.strategy_pattern.SortedList;
import com.example.DesignPaterns.behavior_patterns.template_method_pattern.ContactPage;
import com.example.DesignPaterns.behavior_patterns.template_method_pattern.DetailPage;
import com.example.DesignPaterns.behavior_patterns.template_method_pattern.HomePage;
import com.example.DesignPaterns.behavior_patterns.template_method_pattern.PageTemplate;
import com.example.DesignPaterns.creational_patterns.abstract_factory_pattern.*;
import com.example.DesignPaterns.creational_patterns.factory_pattern.Bank;
import com.example.DesignPaterns.creational_patterns.factory_pattern.BankFactory;
import com.example.DesignPaterns.creational_patterns.factory_pattern.BankType;
import com.example.DesignPaterns.creational_patterns.prototype_pattern.Computer;
import com.example.DesignPaterns.structural_patterns.adapter_pattern.JapaneseAdaptee;
import com.example.DesignPaterns.structural_patterns.adapter_pattern.TranslatorAdapter;
import com.example.DesignPaterns.structural_patterns.adapter_pattern.VietnameseTarget;
import com.example.DesignPaterns.structural_patterns.decorator_pattern.EmployeeComponent;
import com.example.DesignPaterns.structural_patterns.decorator_pattern.EmployeeConcreteComponent;
import com.example.DesignPaterns.structural_patterns.decorator_pattern.Manager;
import com.example.DesignPaterns.structural_patterns.decorator_pattern.TeamLeader;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication()
public class DesignPaternsApplication implements ApplicationRunner {

	public static void main(String[] args) {
		SpringApplication.run(DesignPaternsApplication.class, args);

	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		runFactoryPattern();
		runAbstractFactoryPattern();
		runStrategyPattern();
		runTemplateMethodPattern();
		runAdapterPattern();
		runDecoratorPattern();
	}

	private void runAbstractFactoryPattern() {
		FurnitureAbstractFactory factory = FurnitureFactory.getFactory(MaterialType.PLASTIC);

		Chair chair = factory.createChair();
		chair.create(); // Create plastic chair

		Table table = factory.createTable();
		table.create(); // Create plastic table
	}

	private void runFactoryPattern() {
		Bank bank = BankFactory.getBank(BankType.TPBANK);
		System.out.println(bank.getBankName()); // TPBank
	}

	private void runStrategyPattern() {
		SortedList sortedList = new SortedList();
		sortedList.add("Java Core");
		sortedList.add("Java Design Pattern");
		sortedList.add("Java Library");
		sortedList.add("Java Framework");

		sortedList.setSortStrategy(new QuickSort());
		sortedList.sort();

		sortedList.setSortStrategy(new MergeSort());
		sortedList.sort();
	}

	private void runTemplateMethodPattern() {
		PageTemplate homePage = new HomePage();
		homePage.showPage();

		System.out.println();
		PageTemplate detailPage = new DetailPage();
		detailPage.showPage();

		System.out.println();
		PageTemplate contactPage = new ContactPage();
		contactPage.showPage();
	}

	private void runAdapterPattern() {
		VietnameseTarget client = new TranslatorAdapter(new JapaneseAdaptee());
		client.send("Xin chào");
	}

	private void runDecoratorPattern() {
		System.out.println("NORMAL EMPLOYEE: ");
		EmployeeComponent employee = new EmployeeConcreteComponent("GPCoder");
		employee.showBasicInformation();
		employee.doTask();

		System.out.println("\nTEAM LEADER: ");
		EmployeeComponent teamLeader = new TeamLeader(employee);
		teamLeader.showBasicInformation();
		teamLeader.doTask();

		System.out.println("\nMANAGER: ");
		EmployeeComponent manager = new Manager(employee);
		manager.showBasicInformation();
		manager.doTask();

		System.out.println("\nTEAM LEADER AND MANAGER: ");
		EmployeeComponent teamLeaderAndManager = new Manager(teamLeader);
		teamLeaderAndManager.showBasicInformation();
		teamLeaderAndManager.doTask();
	}

	private void runPrototypePattern() {
		Computer computer1 = new Computer("Window 10", "Word 2013", "BKAV", "Chrome v69", "Skype");
		Computer computer2 = computer1.clone();
		computer2.setOthers("Skype, Teamviewer, FileZilla Client");

		System.out.println(computer1);
		System.out.println(computer2);
	}
}
