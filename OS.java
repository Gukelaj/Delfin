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

        public void updateCoach()
        {
             try
        {
        
            ArrayList<MMember> members = new ArrayList<Member>();    
        
            Scanner input = new Scanner(System.in);
            Scanner scan = new Scanner(f).useDelimiter("\\s*,\\s*");

           
            searchMember();

             while(scan.hasNextLine())
            {
                members.add(new Member(scan.next(), scan.nextInt(), scan.next(), scan.nextInt(), scan.nextInt(),
                scan.next(), scan.next(), scan.nextInt(), scan.nextInt(), scan.next(), scan.next(),
                scan.nextInt(), scan.nextInt(), scan.next(), scan.next(), scan.next(), scan.next(), scan.next(),
                scan.next())); 
            }

            boolean edit = true;

            
            System.out.print("What number do you want to update?: ");
            int number = input.nextInt();
            System.out.println("============================== ");
    
            while(edit)
            {
                System.out.println("");
                System.out.println("########################################");
                System.out.println("1: your chosen disciplines       " + members.get(number).getDisciplines());
                System.out.println("");
                System.out.println("2: Your crawl competetion time:      " + members.get(number).getCrawlCompTime());
                System.out.println("3: Your crawl practice time:       " + members.get(number).getCrawlPracTime());
                System.out.println("4: What competetion you participated in:   " + members.get(number).getCrawlComp());
                System.out.println("5: Your placement in the competetion       " + members.get(number).getCrawlPlacement());
                System.out.println("");
                System.out.println("6: Your butterfly competetion time:      " + members.get(number).getButterflyCompTime());
                System.out.println("7: Your butterfly practice time:       " + members.get(number).getButterflyPracTime());
                System.out.println("8: What competetion you participated in:   " + members.get(number).getButterflyComp());
                System.out.println("9: Your placement in the competetion       " + members.get(number).getButterflyPlacement());
                System.out.println("");
                System.out.println("10: Your breast competetion time:      " + members.get(number).getBreastCompTime());
                System.out.println("11: Your breast practice time:       " + members.get(number).getBreastPracTime());
                System.out.println("12: What competetion you participated in:   " + members.get(number).getBreastComp());
                System.out.println("13: Your placement in the competetion       " + members.get(number).getBreastPlacement());
                System.out.println("########################################"); 
                System.out.println(""); 
                
                System.out.print("Press (1/2/3/4/5/6/7/8/9/10/11/12/13/14): ");
                String option = System.console().readLine();
                System.out.println("============================== ");

                if (option.equals ("1"))
                {
                    System.out.print("Disciplines: ");
                    String discipline = System.console().readLine();
                    System.out.println("============================== ");
                    members.get(number).setDisciplines(discipline);
                    System.out.println(members.get(number).getDisciplines());

                
                    PrintStream file = new PrintStream(f);
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
                        
                        if(i != movies.size() -1)
                        {
                            file.println();
                        }
                        
                    }
                }

                else if(option.equals("2"))
                {
                    System.out.print("Crawl competetion time: ");
                    String crawlCompTime = System.console().readLine();
                    int crawlCompTime1 = Integer.parseInt(crawlCompTime);
                    System.out.println("============================== ");
                    members.get(number).setCrawlCompTime(crawlCompTime1);

                    PrintStream file = new PrintStream(f1);
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
                        
                        if(i != movies.size() -1)
                        {
                            file.println();
                        }
                    }
                }

                else if(option.equals("3"))
                {
                    System.out.print("Director: ");
                    String director = System.console().readLine();
                    // String director = input.next();
                    System.out.println("============================== ");
                    movies.get(number).setDirector(director);

                    PrintStream file = new PrintStream(f1);
                    for(int i = 0; i < movies.size(); i++)
                    {
                        file.print(", " + movies.get(i).getTitle() + " , " + movies.get(i).getYear()
                        + " , " + movies.get(i).getDirector() + " , " + movies.get(i).getActor1()
                        + " , " + movies.get(i).getActor2() + " , " + movies.get(i).getActor3());
                        
                        if(i != movies.size() -1)
                        {
                            file.println();
                        }
                    }
                }

                else if(option.equals("4"))
                {
                    System.out.println("Actor 1: ");
                    String actor1 = System.console().readLine();
                    // String actor1 = input.next();
                    System.out.println("============================== ");
                    movies.get(number).setActor1(actor1);

                    PrintStream file = new PrintStream(f1);
                    for(int i = 0; i < movies.size(); i++)
                    {
                        file.print(", " + movies.get(i).getTitle() + " , " + movies.get(i).getYear()
                        + " , " + movies.get(i).getDirector() + " , " + movies.get(i).getActor1()
                        + " , " + movies.get(i).getActor2() + " , " + movies.get(i).getActor3());
                        
                        if(i != movies.size() -1)
                        {
                            file.println();
                        }
                    }
                }

                else if (option.equals("5"))
                {
                    System.out.println("Actor 2: ");
                    String actor2 = System.console().readLine();
                    // String actor2 = input.next();
                    System.out.println("============================== ");
                    movies.get(number).setActor2(actor2);

                    PrintStream file = new PrintStream(f1);
                    for(int i = 0; i < movies.size(); i ++)
                    {
                        file.print(", " + movies.get(i).getTitle() + " , " + movies.get(i).getYear()
                        + " , " + movies.get(i).getDirector() + " , " + movies.get(i).getActor1()
                        + " , " + movies.get(i).getActor2() + " , " + movies.get(i).getActor3());
                        
                        if(i != movies.size() -1)
                        {
                            file.println();
                        }
                    }
                }
                
                else if (option.equals("6"))
                {
                    System.out.println("Actor 3: ");
                    String actor3 = System.console().readLine();
                    // String actor3 = input.next();
                    System.out.println("============================== ");
                    movies.get(number).setActor3(actor3);

                    PrintStream file = new PrintStream(f1);
                    for(int i = 0; i < movies.size(); i++)
                    {
                        file.print(", " + movies.get(i).getTitle() + " , " + movies.get(i).getYear()
                        + " , " + movies.get(i).getDirector() + " , " + movies.get(i).getActor1()
                        + " , " + movies.get(i).getActor2() + " , " + movies.get(i).getActor3());
                        
                        if(i != movies.size() -1)
                        {
                            file.println();
                        }
                    }
                } 

                else if (option.equals("7"))
                {
                    edit = false;
                }    
            }
        }
        catch(Exception e) 
        {
            
        }
        }

}       