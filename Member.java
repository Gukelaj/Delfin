public class Member
{
    private String name;
    private int age;
    private String disciplines;

    private double crawlCompTime;
    private double crawlPracTime;
    private String crawlComp;
    private String crawlPlacement;

    private double butterflyCompTime;
    private double butterflyPracTime;
    private String butterflyComp;
    private String butterflyPlacement;

    private double breastCompTime;
    private double breastPracTime;
    private String breastComp;
    private String breastPlacement;

    private String membershipStatus;
    private String level;
    private String memberType;
    private String balance;

    public Member(String name, int age, String disciplines, double crawlCompTime, double crawlPracTime,
    String crawlComp, String crawlPlacement, double butterflyCompTime, double butterflyPracTime, String butterflyComp,
    String butterflyPlacement, double breastCompTime, double breastPracTime, String breastComp, String breastPlacement,
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
        return memberType;
    }

    public void setMemberType(String memberType)
    {
        this.memberType = memberType;
    }

    public String getBalance()
    {
        return balance;
    }

    public  void setCrawlCompTime(double crawlCompTime)
    {
        this.crawlCompTime = crawlCompTime;
    }
    public double getCrawlCompTime()
    {
        return crawlCompTime;
    }

    public void setCrawlPracTime(double crawlPracTime)
    {
        this.crawlPracTime = crawlPracTime;
    }
    public double getCrawlPracTime()
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

    public void setBrestCompTime (double breastCompTime)
    {
        this.breastCompTime = breastCompTime;
    }
    public double getBreastCompTime()
    {
        return breastCompTime;
    }

    public void setBrestPracTime (double breastPracTime)
    {
        this.breastPracTime = breastPracTime;
    }
    public double getBreastPracTime()
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

    public void setButterflyCompTime (double butterflyCompTime)
    {
        this.butterflyCompTime = butterflyCompTime;
    }
    public double getButterflyCompTime()
    {
        return butterflyCompTime;
    }

    public void setButterflyPracTime (double butterflyPracTime)
    {
        this.butterflyPracTime = butterflyPracTime;
    }
    public double getButterflyPracTime()
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