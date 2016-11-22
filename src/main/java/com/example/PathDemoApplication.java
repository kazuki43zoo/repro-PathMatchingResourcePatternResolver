package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.stream.Stream;

@SpringBootApplication
public class PathDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PathDemoApplication.class, args);
	}

	@Autowired
	public void configureTestProperties(TestProperties properties) {
		System.out.println("------resources1---------");
		Stream.of(properties.getResources1()).forEach(resource -> {
			try {
				System.out.println(resource.getURL());
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		System.out.println("------resources2---------");
		Stream.of(properties.getResources2()).forEach(resource -> {
			try {
				System.out.println(resource.getURL());
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		System.out.println("------resources3---------");
		Stream.of(properties.getResources3()).forEach(resource -> {
			try {
				System.out.println(resource.getURL());
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
	}

	@Component
	@ConfigurationProperties(prefix = "my.app.test")
	public static class TestProperties {

		private Resource[] resources1;
		private Resource[] resources2;
		private Resource[] resources3;

		public Resource[] getResources1() {
			return resources1;
		}

		public void setResources1(Resource[] resources) {
			this.resources1 = resources;
		}

		public Resource[] getResources2() {
			return resources2;
		}

		public void setResources2(Resource[] resources2) {
			this.resources2 = resources2;
		}

		public Resource[] getResources3() {
			return resources3;
		}

		public void setResources3(Resource[] resources3) {
			this.resources3 = resources3;
		}
	}
}

