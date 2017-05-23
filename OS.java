import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;
import java.io.*;
import java.util.NoSuchElementException;
import java.io.IOException;

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
            System.out.println("3. Update (Coach)");
            System.out.println("4. Update (Admin)");
            System.out.println("5. top 5");
            System.out.println("6. Log out");
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
            else if(login.equals ("3"))
            {
                updateCoach();
            }
            else if(login.equals ("4"))
            {
                updateAdmin();
            }
            else if(login.equals ("5"))
            {
                topFive();
            }
             else if(login.equals ("6"))
            {
                System.out.println("Bye bye");
                break;    
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
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
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

        public void topFive ()
        {
            try
            {
            ArrayList<Member> members = new ArrayList<Member>();    
        
            Scanner input = new Scanner(System.in);
            Scanner scan = new Scanner(f).useDelimiter("\\s*,\\s*");


            System.out.print("type elite: ");
            String result = input.nextLine();
            System.out.println("============================== ");

            while(scan.hasNextLine())
            {
                members.add(new Member(scan.next(), scan.nextInt(), scan.next(), scan.nextInt(), scan.nextInt(),
                scan.next(), scan.next(), scan.nextInt(), scan.nextInt(), scan.next(), scan.next(),
                scan.nextInt(), scan.nextInt(), scan.next(), scan.next(), scan.next(), scan.next(), scan.next(),
                scan.next())); 
            }
            boolean edit = true;
 
                for(int i = 0; i < members.size(); i++)
            {
                if(members.get(i).toString().toLowerCase().contains(result.toLowerCase()))
                {
                    System.out.println(i + " Swimmer name: " + members.get(i).getName()); 
                    System.out.println(i + " Swimmer Discipline(s): " + members.get(i).getDisciplines()); 
                    System.out.println(i + " Swimmer crawl competetion time: " + members.get(i).getCrawlCompTime()); 
                    System.out.println(i + " Swimmer crawl practice time: " + members.get(i).getCrawlPracTime()); 
                    System.out.println(i + " Swimmer breast competetion time: " + members.get(i).getBreastCompTime()); 
                    System.out.println(i + " Swimmer breast practice time: " + members.get(i).getBreastPracTime());
                    System.out.println(i + " Swimmer butterfly competetion time: " + members.get(i).getButterflyCompTime()); 
                    System.out.println(i + " Swimmer butterfly practice time: " + members.get(i).getButterflyPracTime());
                    System.out.println("============================== ");
                }               
            }  
        }
        catch(Exception e) 
        {
            
        }                  
    }

        public void updateCoach()
        {
             try
        {
        
            ArrayList<Member> members = new ArrayList<Member>();    
        
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
                System.out.println("14: Cancel       ");

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
                        
                        if(i != members.size() -1)
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
                        
                        if(i != members.size() -1)
                        {
                            file.println();
                        }
                    }
                }

                else if(option.equals("3"))
                {
                    System.out.print("Crawl practice time: ");
                    String crawlPracTime = System.console().readLine();
                    int crawlPracTime1 = Integer.parseInt(crawlPracTime);
                    System.out.println("============================== ");
                    members.get(number).setCrawlPracTime(crawlPracTime1);

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
                        
                        if(i != members.size() -1)
                        {
                            file.println();
                        }
                    }
                }

                else if(option.equals("4"))
                {
                    System.out.println("Competetion you swam crawl in: ");
                    String crawlComp1 = System.console().readLine();
                    System.out.println("============================== ");
                    members.get(number).setCrawlComp(crawlComp1);

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
                        
                        if(i != members.size() -1)
                        {
                            file.println();
                        }
                    }
                }

                else if (option.equals("5"))
                {
                    System.out.println("Placement in the competetion: ");
                    String crawlPlacement1 = System.console().readLine();
                    System.out.println("============================== ");
                    members.get(number).setCrawlPlacement(crawlPlacement1);

                    PrintStream file = new PrintStream(f);
                    for(int i = 0; i < members.size(); i ++)
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
                        
                        if(i != members.size() -1)
                        {
                            file.println();
                        }
                    }
                }
                
                else if (option.equals("6"))
                {
                    System.out.println("Butterfly competetion time: ");
                    String butterflyCompTime = System.console().readLine();
                    int butterflyCompTime1 = Integer.parseInt(butterflyCompTime);
                    System.out.println("============================== ");
                    members.get(number).setButterflyCompTime(butterflyCompTime1);

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
                        
                        if(i != members.size() -1)
                        {
                            file.println();
                        }
                    }
                } 

                else if (option.equals("7"))
                {
                    System.out.println("Butterfly practice time: ");
                    String butterflyPracTime = System.console().readLine();
                    int butterflyPracTime1 = Integer.parseInt(butterflyPracTime);
                    System.out.println("============================== ");
                    members.get(number).setButterflyPracTime(butterflyPracTime1);

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
                        
                        if(i != members.size() -1)
                        {
                            file.println();
                        }
                    }
                } 

                 else if (option.equals("8"))
                {
                    System.out.println("Competetion you swam butterfly in: ");
                    String butterflyComp1 = System.console().readLine();
                    System.out.println("============================== ");
                    members.get(number).setButterflyComp(butterflyComp1);

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
                        
                        if(i != members.size() -1)
                        {
                            file.println();
                        }
                    }
                }

                 else if (option.equals("9"))
                {
                    System.out.println("Placement in the competetion: ");
                    String butterflyPlacement1 = System.console().readLine();
                    System.out.println("============================== ");
                    members.get(number).setButterflyPlacement(butterflyPlacement1);

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
                        
                        if(i != members.size() -1)
                        {
                            file.println();
                        }
                    }
                } 

                 else if (option.equals("10"))
                {
                    System.out.println("Breast competetion time: ");
                    String breastCompTime = System.console().readLine();
                    int breastCompTime1 = Integer.parseInt(breastCompTime);
                    System.out.println("============================== ");
                    members.get(number).setBreastCompTime(breastCompTime1);

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
                        
                        if(i != members.size() -1)
                        {
                            file.println();
                        }
                    }
                } 

                 else if (option.equals("11"))
                {
                    System.out.println("Breast practice time: ");
                    String breastPracTime = System.console().readLine();
                    int breastPracTime1 = Integer.parseInt(breastPracTime);
                    System.out.println("============================== ");
                    members.get(number).setBreastPracTime(breastPracTime1);

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
                        
                        if(i != members.size() -1)
                        {
                            file.println();
                        }
                    }
                } 

                 else if (option.equals("12"))
                {
                    System.out.println("Competetion you swam breast in: ");
                    String breastComp1 = System.console().readLine();
                    System.out.println("============================== ");
                    members.get(number).setBreastComp(breastComp1);

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
                        
                        if(i != members.size() -1)
                        {
                            file.println();
                        }
                    }
                }  

                 else if (option.equals("13"))
                {
                    System.out.println("Placement in the competetion: ");
                    String breastPlacement1 = System.console().readLine();
                    System.out.println("============================== ");
                    members.get(number).setBreastPlacement(breastPlacement1);

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
                        
                        if(i != members.size() -1)
                        {
                            file.println();
                        }
                    }
                } 

                else if (option.equals("14"))
                {
                    edit = false;
                }    
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }
        }
        catch(Exception e) 
        {
            
        }
    }

    public void updateAdmin()
        {
            try
        {
        
            ArrayList<Member> members = new ArrayList<Member>();    
        
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
                System.out.println("1: Change name:       " + members.get(number).getName());
                System.out.println("2: Change age:       " + members.get(number).getAge());
                System.out.println("3: Change membership status:       " + members.get(number).getMembershipStatus());
                System.out.println("4: Change level:       " + members.get(number).getLevel());
                System.out.println("5: Change balance:       " + members.get(number).getBalance());
                System.out.println("6: Cancel");

                System.out.println("########################################"); 
                System.out.println(""); 
                
                System.out.print("Press (1/2/3/4/5/6): ");
                String option = System.console().readLine();
                System.out.println("============================== ");

                if (option.equals ("1"))
                {
                    System.out.print("Name: ");
                    String name = System.console().readLine();
                    System.out.println("============================== ");
                    members.get(number).setName(name);
                    System.out.println(members.get(number).getName());

                
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
                        
                        if(i != members.size() -1)
                        {
                            file.println();
                        }
                        
                    }
                }

                else if(option.equals("2"))
                {
                    System.out.print("Age: ");
                    String age = System.console().readLine();
                    int age1= Integer.parseInt(age);
                    System.out.println("============================== ");
                    members.get(number).setAge(age1);

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
                        
                        if(i != members.size() -1)
                        {
                            file.println();
                        }
                    }
                }

                else if(option.equals("3"))
                {
                    System.out.print("Membership status: ");
                    String membershipStatus = System.console().readLine();
                    System.out.println("============================== ");
                    members.get(number).setMembershipStatus(membershipStatus);

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
                        
                        if(i != members.size() -1)
                        {
                            file.println();
                        }
                    }
                }

                else if(option.equals("4"))
                {
                    System.out.println("Level: ");
                    String level = System.console().readLine();
                    System.out.println("============================== ");
                    members.get(number).setLevel(level);

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
                        
                        if(i != members.size() -1)
                        {
                            file.println();
                        }
                    }
                }

                else if (option.equals("5"))
                {
                    System.out.println("Balance: ");
                    String balance = System.console().readLine();
                    System.out.println("============================== ");
                    members.get(number).setBalance(balance);

                    PrintStream file = new PrintStream(f);
                    for(int i = 0; i < members.size(); i ++)
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
                        
                        if(i != members.size() -1)
                        {
                            file.println();
                        }
                    }
                }
                
                  else if (option.equals("6"))
                {
                    edit = false;
                }   
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); 
            }
        }
        catch(Exception e) 
        {
            
        }
    }
}