package pizza;

import javax.persistence.EntityManager;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import pizza.util.ProjectConfig;

public class testMain {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext
				(ProjectConfig.class);
				EntityManager p = context.getBean(EntityManager.class);
				System.out.println("Hello");
				context.close();
	}

	}
