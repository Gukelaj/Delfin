public class Member
{
    private String name;
    private int age;
    private String disciplines;

    private int crawlCompTime;
    private int crawlPracTime;
    private String crawlComp;
    private String crawlPlacement;

    private int butterflyCompTime;
    private int butterflyPracTime;
    private String butterflyComp;
    private String butterflyPlacement;

    private int breastCompTime;
    private int breastPracTime;
    private String breastComp;
    private String breastPlacement;

    private String membershipStatus; // aktiv eller passiv
    private String level; // konkurrence eller motionist
    private String memberType; // junior, adult og senior
    private String balance; // penge

    public Member(String name, int age, String disciplines, int crawlCompTime, int crawlPracTime,
    String crawlComp, String crawlPlacement, int butterflyCompTime, int butterflyPracTime, String butterflyComp,
    String butterflyPlacement, int breastCompTime, int breastPracTime, String breastComp, String breastPlacement,
    String membershipStatus, String level, String memberType, String balance)
    {
        this.name = name;
        this.age = age;
        this.disciplines = disciplines;

        this.crawlCompTime = crawlCompTime;
        this.crawlPracTime = crawlPracTime;
        this.crawlComp = crawlComp;
        this.crawlPlacement = crawlPlacement;

        this.butterflyCompTime = butterflyCompTime;
        this.butterflyPracTime = butterflyPracTime;
        this.butterflyComp = butterflyComp;
        this.butterflyPlacement = butterflyPlacement;

        this.breastCompTime = breastCompTime;
        this.breastPracTime = breastPracTime;
        this.breastComp = breastComp;
        this.breastPlacement = breastPlacement;

        this.membershipStatus = membershipStatus;
        this.level = level;
        this.memberType = memberType;
        this.balance = balance;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public String getDisciplines()
    {
        return disciplines;
    }

    public void setDisciplines(String disciplines)
    {
        this.disciplines = disciplines;
    }    

    public String getMembershipStatus()
    {
        return membershipStatus;
    }

    public void setMembershipStatus(String membershipStatus)
    {
        this.membershipStatus = membershipStatus;
    }

    public String getLevel()
    {
        return level;
    }

    public void setLevel(String level)
    {
        this.level = level;
    }

    public String getMemberType()
    {
        if(this.age < 18)
        {
            return "Junior";
        }

        else if (this.age > 17 && this.age < 60)
        {
            return "Adult";
        }
        
        else
        {
            return "Senior";
        }
        
    }

    public void setMemberType(String memberType)
    {
        this.memberType = memberType;
    }

    public String getBalance()
    {
        return balance;
    }

    public void setCrawlCompTime(int crawlCompTime)
    {
        this.crawlCompTime = crawlCompTime;
    }

    public int getCrawlCompTime()
    {
        return crawlCompTime;
    }

    public void setCrawlPracTime(int crawlPracTime)
    {
        this.crawlPracTime = crawlPracTime;
    }

    public int getCrawlPracTime()
    {
        return crawlPracTime;
    }

    public void setCrawlComp(String crawlComp)
    {
        this.crawlComp = crawlComp;
    }

    public String getCrawlComp()
    {
        return crawlComp;
    }

    public void setCrawlPlacement(String crawlPlacement)
    {
        this.crawlPlacement = crawlPlacement;
    }

    public String getCrawlPlacement()
    {
        return crawlPlacement;
    }

    public void setBrestCompTime (int breastCompTime)
    {
        this.breastCompTime = breastCompTime;
    }

    public int getBreastCompTime()
    {
        return breastCompTime;
    }

    public void setBrestPracTime (int breastPracTime)
    {
        this.breastPracTime = breastPracTime;
    }

    public int getBreastPracTime()
    {
        return breastPracTime;
    }

    public void setBrestComp (String breastComp)
    {
        this.breastComp = breastComp;
    }

    public String getBreastComp()
    {
        return breastComp;
    }

    public void setBrestPlacement (String breastPlacement)
    {
        this.breastPlacement = breastPlacement;
    }

    public String getBreastPlacement()
    {
        return breastPlacement;
    }

    public void setButterflyCompTime (int butterflyCompTime)
    {
        this.butterflyCompTime = butterflyCompTime;
    }

    public int getButterflyCompTime()
    {
        return butterflyCompTime;
    }

    public void setButterflyPracTime (int butterflyPracTime)
    {
        this.butterflyPracTime = butterflyPracTime;
    }

    public int getButterflyPracTime()
    {
        return butterflyPracTime;
    }

    public void setButterflyComp (String butterflyComp)
    {
        this.butterflyComp = butterflyComp;
    }

    public String getButterflyComp()
    {
        return butterflyComp;
    }

    public void setButterflyPlacement (String butterflyPlacement)
    {
        this.butterflyPlacement = butterflyPlacement;
    }

    public String getButterflyPlacement()
    {
        return butterflyPlacement;
    }

    public String toString()
    {
        return name + " " + age + " " + disciplines + " " + membershipStatus + " " + level + " " + memberType + " " + balance; 
    }
}