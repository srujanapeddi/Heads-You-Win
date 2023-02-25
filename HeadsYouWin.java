import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Collectors;
public class HeadsYouWin{
    public static void main(String[] args) throws FileNotFoundException {
        PrintWriter out = new PrintWriter(new File("output.csv"));
        StringBuilder sb = new StringBuilder();
        int count=0;
        int count1=0;
        ArrayList<ArrayList<String>> li = new ArrayList<>();
        Random r = new Random();
        for (int j = 0; j < 3; j++) 
        {
            sb.append("\r\n");
            sb.append("Team1");
            sb.append(",");
            sb.append("Team2");
            sb.append("\r\n");
            ArrayList<String> team1 = new ArrayList<>();
            ArrayList<String> team2 = new ArrayList<>();
            for (int i = 0; i < 10; i++) 
            {
                int res = r.nextInt(2);
                if (res == 0) 
                {
                    team1.add("head");
                    team2.add("tail");
                } 
                else 
                {
                    team1.add("tail");
                    team2.add("head");
                }
            }
            int l1 = team1.stream().filter(x -> x.equals("head")).collect(Collectors.toList()).size();
            int l2 = team2.stream().filter(x -> x.equals("head")).collect(Collectors.toList()).size();
            for (int i = 0; i <= 9; i++) 
            {
                sb.append("Round " + (i + 1));
                sb.append(",");
                sb.append(team1.get(i));
                sb.append(",");
                sb.append(team2.get(i));
                sb.append("\r\n");
            }
            String winner="";
            if (l1 != l2) 
            {
                winner = (l1 > l2) ? "Team1" : "Team2";
                sb.append(winner);
            } 
            else 
            {
                sb.append("draw");
            }
            if(winner.equals("Team1"))
            {
                count++;
            }
            else
            {
                count1++;
            }
            li.add(team1);
            li.add(team2);
        }
        if(count>count1)
        {
            out.append("Team1 winner");
        }
        else
        {
            out.append("Team2 winner");
        }
        out.write(sb.toString());
        out.close();
    }
}
