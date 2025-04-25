package com.xzit.generate.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xzit.generate.entity.Article;
import com.xzit.generate.service.ArticleService;
import com.xzit.generate.service.ArticleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Controller
@RequestMapping("/article")
public class ArticleController {
    @Resource
    private ArticleService articleService;
    @GetMapping("/list")
    public String list(@RequestParam(required = false,defaultValue = "1",value = "current")Integer current, Model model) {
        Page<Article> page = new Page<>(current,5);
        articleService.page(page);
        model.addAttribute("path","/member/list?current=");
        model.addAttribute("page",page);
        return "/list";
    }
    @GetMapping("/save")
    public String save(){
        return "/save";
    }
    @PostMapping("/save_commit")
    public String saveCommit(Article article){
        articleService.save(article);
        return "redirect:/article/list";
    }
    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") Integer id, Model model){
        Article article = articleService.getById(id);
        model.addAttribute("article",article);
        return "/update";
    }
    @PostMapping("/update_commit")
    public String updateCommit(Article article){
        articleService.updateById(article);
        return "redirect:/article/list";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        articleService.removeById(id);
        return "redirect:/article/list";
    }

}
