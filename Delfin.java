import java.io.IOException;

public class Delfin
{
    public static void main(String[] args) throws IOException, InterruptedException
    {

        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        
        OS os = new OS();
        os.startMenu();
    }
}