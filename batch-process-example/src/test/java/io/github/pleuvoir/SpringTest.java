package io.github.pleuvoir;

import io.github.pleuvoir.config.BatchConfiguration;
import io.github.pleuvoir.config.DatasourceConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringTest extends BaseTest{


	public void test(){}

	public static void main(String[] args) {
		AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext();
		app.register(BatchConfiguration.class);
		app.register(DatasourceConfiguration.class);


		SimpleFetch fetch = app.getBean(SimpleFetch.class);

		Object o = fetch.fetch();

		System.out.println(o);
	}

}
