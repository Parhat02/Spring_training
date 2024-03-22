package org.cydeo;


import org.cydeo.config.AppConfigData;
import org.cydeo.model.Comment;
import org.cydeo.service.CommentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class cydeoApplication {

    public static void main(String[] args) {

        Comment comment = new Comment();
        comment.setAuthor("Johnson");
        comment.setText("Spring Framework");

       ApplicationContext container = SpringApplication.run(cydeoApplication.class, args);

        CommentService commentService = container.getBean(CommentService.class);
        commentService.publishComment(comment);

        commentService.printConfigData();
        commentService.printDBConfigData();

    }

}
