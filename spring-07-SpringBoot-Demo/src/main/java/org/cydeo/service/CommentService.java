package org.cydeo.service;


import org.cydeo.config.AppConfigData;
import org.cydeo.config.DBConfigData;
import org.cydeo.model.Comment;
import org.cydeo.proxy.CommentNotificationProxy;
import org.cydeo.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CommentService {

    private final CommentRepository commentRepository;
    private final CommentNotificationProxy commentNotificationProxy;

    private final AppConfigData appConfigData;
    private final DBConfigData dbConfigData;

    public CommentService(CommentRepository commentRepository, @Qualifier("EMAIL") CommentNotificationProxy commentNotificationProxy,
                          AppConfigData appConfigData, DBConfigData dbConfigData) {
        this.commentRepository = commentRepository;
        this.commentNotificationProxy = commentNotificationProxy;
        this.appConfigData = appConfigData;
        this.dbConfigData = dbConfigData;
    }

    public void publishComment(Comment comment){

        //save in the DB
        commentRepository.storeComment(comment);
        //send email
        commentNotificationProxy.sendComment(comment);

    }

    public void printConfigData(){

        //print username
        System.out.println(appConfigData.getUserName());

        //print password
        System.out.println(appConfigData.getPassword());

        //print url
        System.out.println(appConfigData.getUrl());

    }

    public void printDBConfigData(){

        //print username
        System.out.println(dbConfigData.getUserName());

        //print password
        System.out.println(dbConfigData.getPassword());

        //print url
        System.out.println(dbConfigData.getType());

    }



}
