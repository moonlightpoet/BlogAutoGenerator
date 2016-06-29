package com.moonlit.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.moonlit.model.Article;

public class GenerateBlogsService {
	
	private static final String ROOT_DIR = System.getProperty("user.home") + "/Documents/moonlightpoet.github.io";
	private static final String BLOGER_NAME = "moonlightpoet";
			
	
	public static void generate() {
		List<Article> articleList = ArticleService.queryAll();
		if (articleList == null)
			articleList = new ArrayList<Article>();
		File dir = new File(ROOT_DIR);
		if (dir.exists() == false)
			dir.mkdirs();
		// generate index.html
		String content = "";
		content += "<html><head><title>" + BLOGER_NAME + "</title></head><body><h1>moonlightpoet</h1>";
		for (Article article : articleList) {
			content += "<a href=\"" + article.getId() + ".html\">" + article.getTitle() + "</a><br>";
		}
		content += "</body></html>";
		String outputPath = ROOT_DIR + "/" + "index.html";
		try {
			FileHelper.writeFile(content, outputPath);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// generate blog pages
		for (Article article : articleList) {
			int id = article.getId();
			String title = article.getTitle();
			content = article.getContent();
			content = "<html><head><title>" + title + "</title></head><body><h1>" +
					title + "</h1><pre>" + content + "</pre></body></html>";
			outputPath = ROOT_DIR + "/" + id + ".html";
			try {
				FileHelper.writeFile(content, outputPath);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
