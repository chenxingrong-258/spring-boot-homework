package com.xzit;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xzit.generate.entity.Article;
import com.xzit.generate.service.ArticleService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class Day09ApplicationTests {
	@Resource
	private ArticleService service;

	@Test
	void contextLoads() {
	}
	@Test
	public void test() {
		Page<Article> page = new Page<>(1, 5);
		service.page(page);
		page.getRecords().forEach(System.out::println);

	}
	@Test
	public void test1() {
		List<Article> list = service.list();
		list.forEach(System.out::println);
	}

}
