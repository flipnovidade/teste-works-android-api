package br.com.teste.call.utils;

import java.util.ArrayList;
import java.util.List;

import br.com.teste.call.model.Shots;

public class FakeObjectsRepository {

    public static List<Shots> getListShots(){

        Shots shots = new Shots();
        shots.setId(1);
        shots.setTitle("It is a title");
//        shots.setDate("2016-08-08");
        shots.setDescription("It is a description");
        shots.setCommentCount(10);
        shots.setLikesCount(11);
        shots.setViewsCount(12);
//        shots.setCommentUrl("");
//        shots.setImageUrl("https://s3-sa-east-1.amazonaws.com/adatinatab/thumbuser/16082016012441_daniel_.png");

        Shots shots1 = new Shots();
        shots1.setId(1);
        shots1.setTitle("It is a title");
//        shots1.setDate("2016-08-08");
        shots1.setDescription("It is a description");
        shots1.setCommentCount(10);
        shots1.setLikesCount(11);
        shots1.setViewsCount(12);
//        shots1.setCommentUrl("");
//        shots1.setImageUrl("https://s3-sa-east-1.amazonaws.com/adatinatab/thumbuser/16082016012441_daniel_.png");


        List<Shots> shotsList = new ArrayList<>();
        shotsList.add(shots);
        shotsList.add(shots1);

        return shotsList;


    }

}
