import java.util.*;
public class srtf{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number of process:");
        int n=sc.nextInt();
        int pid[]=new int[n];
        int at[]=new int[n];
        int bt[]=new int[n];
        int ct[]=new int[n];
        int wt[]=new int[n];
        int tat[]=new int[n];
        int f[]=new int[n];
        int k[]=new int[n];
        int i=0,st=0,tot=0;
        float avgwt=0,avgtat=0;
        for(i=0;i<n;i++)
        {
            pid[i]=i+1;
            System.out.println("Enter process: "+(i+1)+" arrival time");
            at[i]=sc.nextInt();
            System.out.println("Enter process: "+(i+1)+" burst time");
            bt[i]=sc.nextInt();
            k[i]=bt[i];
            f[i]=0;
        }
        while(true)
        {
            int min=99,c=n;
            if(tot==n)
            {
                break;
            }
            for(i=0;i<n;i++)
            {
                if((at[i]<st)&&(f[i]==0)&&(bt[i]<min))
                {
                    min=bt[i];
                    c=i;
                }
            }
            if(c==n)
            {
                st++;
            }
            else
            {
                bt[c]--;
                st++;
                if(bt[c]==0)
                {
                    ct[c]=st;
                    f[c]=1;
                    tot++;
                }
            }

        }
        for(i=0;i<n;i++)
        {
            tat[i]=ct[i]-at[i];
            wt[i]=tat[i]-k[i];
            avgwt+=wt[i];
            avgtat+=tat[i];
        }
        System.out.println("\n PID\t Arrival Time\t Burst time\t Completion time\t TurnAround time\t Waiting time\n");
        for(i=0;i<n;i++)
        {
            System.out.println(pid +"\t "+at[i]+"\t "+bt[i]+"\t "+ct[i]+"\t "+tat[i]+"\t "+wt[i]);
        }
        System.out.println("Average waiting time: "+(float)(avgwt/n));
        System.out.println("Average turnaround time "+(float)(avgtat/n));
        sc.close();
    }
}
