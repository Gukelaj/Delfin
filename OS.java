import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;
import java.io.*;
import java.util.NoSuchElementException;

public class OS
{
        Coach coach1 = new Coach("Henrik");
        File f = new File("Members.txt");

        public void startMenu()
        {       
        boolean running = true;
        while(running)
        {
            System.out.println("Swimming Club");
            System.out.println("1. Create new member");
            System.out.println("2. Search member");
            String login = System.console().readLine();
            System.out.println("==========");

                        
            if(login.equals ("1"))
            {
                createMember(); 
            }
            else if(login.equals ("2"))
            {
                searchMember();
            }
             else
            {
                System.out.println("Invalid option");
                break;             
            } 
        }
    }

        public void createMember()
        {
            try 
            {
            ArrayList<Member> members = new ArrayList<Member>();
            Scanner input = new Scanner(System.in);
            Scanner scan = new Scanner(f);
            scan.useDelimiter("\\s*,\\s*");
       
            while(scan.hasNextLine())
            {
                members.add(new Member(scan.next(), scan.nextInt(), scan.next(), scan.nextInt(), scan.nextInt(),
                scan.next(), scan.next(), scan.nextInt(), scan.nextInt(), scan.next(), scan.next(), scan.nextInt(), 
                scan.nextInt(), scan.next(), scan.next(), scan.next(), scan.next(), scan.next(), scan.next()));
            }

            System.out.println("Enter name");
            String name = System.console().readLine();

            System.out.println("Enter age");
            String age = System.console().readLine();
            int age1 = Integer.parseInt(age);

            System.out.println("Enter swim discipline");
            String disciplines = System.console().readLine();

            System.out.println("Enter membership status");
            String membershipStatus = System.console().readLine();

            System.out.println("Enter level");
            String level = System.console().readLine();

            // System.out.println("Enter Junior or Senior");
            // String memberType = System.console().readLine();

            System.out.println("Enter which balance you want to add");
            String balance = System.console().readLine();

            PrintStream file = new PrintStream(f);
            members.add(new Member(name, age1, disciplines, 0, 0, "minus", "minus", 0, 0, "minus", "minus", 0, 0, "minus", "minus",
            membershipStatus, level, "Senior", balance));

            for(int i = 0; i < members.size(); i++)
            {
                file.print(", " + members.get(i).getName() + " , " + members.get(i).getAge() + " , " + 
                members.get(i).getDisciplines() + " , " + members.get(i).getCrawlCompTime() + " , " + 
                members.get(i).getCrawlPracTime() + " , " + members.get(i).getCrawlComp() + " , " +  
                members.get(i).getCrawlPlacement() + " , " + members.get(i).getButterflyCompTime() + " , " + 
                members.get(i).getButterflyPracTime() + " , " + members.get(i).getButterflyComp() + " , " +
                members.get(i).getButterflyPlacement() + " , " + members.get(i).getBreastCompTime() + " , " +
                members.get(i).getBreastPracTime() + " , " + members.get(i).getBreastComp() + " , " +
                members.get(i).getBreastPlacement() + " , " + members.get(i).getMembershipStatus() + " , " +
                members.get(i).getLevel() + " , " + members.get(i).getMemberType() + " , " +
                members.get(i).getBalance());

                if (i !=members.size()-1)
                {
                    file.println();   
                }
            }
        }
        catch (Exception e)
        {
        System.out.println(e);
        }   
    }
        public void searchMember()
        {
        try 
        { 
            ArrayList<Member> members = new ArrayList<Member>();
            Scanner input = new Scanner(System.in);
            Scanner scan = new Scanner(f);
            scan.useDelimiter("\\s*,\\s*");


            while(scan.hasNextLine())
            {
                members.add(new Member(scan.next(), scan.nextInt(), scan.next(), scan.nextInt(), scan.nextInt(),
                scan.next(), scan.next(), scan.nextInt(), scan.nextInt(), scan.next(), scan.next(),
                scan.nextInt(), scan.nextInt(), scan.next(), scan.next(), scan.next(), scan.next(), scan.next(),
                scan.next()));
            }

            System.out.println("What do you want to search for?");
            String result = input.nextLine();

            for(int i = 0; i < members.size(); i++)
            {
                if(members.get(i).toString().toLowerCase().contains(result.toLowerCase()))
                {
                    System.out.println(i + " " + members.get(i));
                }               
            }
        }
        catch(Exception e) 
        {
            System.out.println(e);
        }
    }
}       