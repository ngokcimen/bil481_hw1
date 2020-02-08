package com.mycompany.app;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;

/**
 * Hello world!
 *
 */
public class App
{
    public static ArrayList<String> generate(ArrayList<String> wordL, ArrayList<String> numL, int wQuantity, int nQuantity) {
      if (wQuantity <= 0 || nQuantity <= 0 || wQuantity > wordL.size() || nQuantity > numL.size() || wordL == null || numL == null) {
        return null;
      }
      ArrayList<String> password = new ArrayList<>();
      ArrayList<String> tmpList = new ArrayList<>();

      ArrayList<Integer> wordIndexList = App.generateRandIndexArr(wordL, wQuantity);
      for (Integer integer : wordIndexList) {
        tmpList.add(wordL.get(integer));
      }
      ArrayList<Integer> numIndexList = App.generateRandIndexArr(numL, nQuantity);
      for (Integer integer : numIndexList) {
        tmpList.add(numL.get(integer));
      }

      ArrayList<Integer> shuffledIndexList = App.generateRandIndexArr(tmpList, tmpList.size());
      for (Integer integer : shuffledIndexList) {
        password.add(tmpList.get(integer));
      }

      return password;
    }
    public static boolean containsNonNumeric(ArrayList<String> array){
      for (String string : array) {
        if (!string.matches("^[0-9]+$")) {
          return true;
        }
      }
      return false;
    }
    public static ArrayList<Integer> generateRandIndexArr(ArrayList<String> list, int quantity) {
      Random rand = new Random();
      ArrayList<Integer> indexes = new ArrayList<>();
      for (int i = 0; i < quantity; i++) {
        int rand_int = rand.nextInt(list.size());
        while(App.search(indexes, rand_int)){
          rand_int = rand.nextInt(list.size());
        }
        indexes.add(rand_int);
      }
      return indexes;
    }

    public static boolean search(ArrayList<Integer> array, int e) {
      //System.out.println("inside search");
      if (array == null) return false;

      for (int elt : array) {
        if (elt == e) return true;
      }
      return false;
    }

    public static void main(String[] args) {
        port(getHerokuAssignedPort());

        get("/", (req, res) -> "Hello, World");

        post("/compute", (req, res) -> {
          //System.out.println(req.queryParams("input1"));
          //System.out.println(req.queryParams("input2"));

          String words = req.queryParams("wordlist");
          java.util.Scanner scWord = new java.util.Scanner(words);
          scWord.useDelimiter("[;\r\n]+");
          java.util.ArrayList<String> wordList = new java.util.ArrayList<>();
          while (scWord.hasNext())
          {
            String value = (scWord.next().replaceAll("\\s",""));
            wordList.add(value);
          }
          System.out.println(wordList);


          String nums = req.queryParams("numlist");
          java.util.Scanner scNum = new java.util.Scanner(nums);
          scNum.useDelimiter("[;\r\n]+");
          java.util.ArrayList<String> numList = new java.util.ArrayList<>();
          while (scNum.hasNext())
          {
            String value = (scNum.next().replaceAll("\\s",""));
            numList.add(value);
          }
          System.out.println(numList);
          
          int wQuantity = Integer.parseInt(req.queryParams("wordQuantity"));
          int nQuantity = Integer.parseInt(req.queryParams("numberQuantity"));
          
          ArrayList<String> password = App.generate(wordList, numList, wQuantity, nQuantity);
          
          String result = App.toStringArr(password);
          if (App.containsNonNumeric(numList)) {
            result = "Wrong number list input";
          }
         Map map = new HashMap();
          map.put("result", result);
          return new ModelAndView(map, "compute.mustache");
        }, new MustacheTemplateEngine());


        get("/compute",
            (rq, rs) -> {
              Map map = new HashMap();
              map.put("result", "not computed yet!");
              return new ModelAndView(map, "compute.mustache");
            },
            new MustacheTemplateEngine());
    }

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }

    static String toStringArr(ArrayList<String> list){
      String res = "";
      for (String string : list) {
        res += string;
      }
      return res;
    }
}

