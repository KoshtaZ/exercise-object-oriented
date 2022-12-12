package pratice.ex0002.application;

import pratice.ex0002.entities.Comment;
import pratice.ex0002.entities.Post;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {


        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        Locale.setDefault(Locale.US);
        Scanner scan = new Scanner(System.in);

        Comment c1 = new Comment("Have a nice trip! ");
        Comment c2 = new Comment("Wow that's awesome!");

        Post post = new Post(
          sdf.parse("21/06/2018 13:05:44"),
                "Traveling to New Zealand",
                "I'm going to visit this wonderful country!",
                12);

        post.addComment(c1);
        post.addComment(c2);

        Comment c3 = new Comment("Good night");
        Comment c4 = new Comment("May the Force be with you");
        Post p2 = new Post(
                sdf.parse("28/07/2018 23:14:19"),
                "Good night guys",
                "See you tomorrow",
                5);
        p2.addComment(c3);
        p2.addComment(c4);


        System.out.println(post);
        System.out.println(p2);
        scan.close();
    }
}
