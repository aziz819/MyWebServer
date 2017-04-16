package jp.co.topgate.asada.web;

import java.io.IOException;
import java.util.Scanner;

/*
 * This Java source file was generated by the Gradle 'init' task.
 */
public class App {
    public static void main(String[] args) {
        try {
            Server server = new Server();
            String choices;
            Scanner scan = new Scanner(System.in);
            do{
                System.out.println("--------------------");
                System.out.println("1: START");
                System.out.println("2: STOP");
                System.out.println("3: END");
                do{
                    System.out.print("please select :");
                    choices = scan.next();
                }while(!(choices.equals("1") || choices.equals("2") || choices.equals("3")));
                switch(choices){
                    case "1":
                        switch (server.getState()){
                            case TERMINATED:
                                server = new Server();
                            case NEW:
                                server.serverStart();
                                System.out.println("start up http server..");
                                break;
                            case RUNNABLE:
                                System.out.println("http server is already running..");
                        }
                        break;
                    case "2":
                        switch (server.getState()){
                            case NEW:
                            case TERMINATED:
                                System.out.println("http server is not running..");
                                break;
                            case RUNNABLE:
                                if(server.serverStop()){
                                    System.out.println("http server stops..");
                                }else{
                                    System.out.println("wait a second, http server is returning a response..");
                                }
                                break;
                        }
                        break;
                    case "3":
                        if(server.serverEnd()){
                            System.out.println("bye..");
                        }else{
                            System.out.println("wait a second, http server is returning a response..");
                            choices = "";
                        }
                        break;
                    default:
                        //ここにくるはずがないが、用意だけはしておく
                        scan.close();
                        scan = new Scanner(System.in);
                        break;
                }
            }while(!choices.equals("3"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
