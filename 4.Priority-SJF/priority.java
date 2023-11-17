import java.util.*;
public class priority
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of processes: ");
        int n=sc.nextInt();
        
        int bt[]=new int[n];
        int pri[]=new int[n];
        int tat[]=new int[n];
        int wt[]=new int[n];
        int pID[]=new int[n];
        
        int temp;
        float avg_tat=0,avg_wt=0;
        
        for(int i=0;i<n;i++)
        {
            System.out.println("Enter the burst time of process "+(i+1)+" :");
            bt[i]=sc.nextInt();
            System.out.println("Enter the time priority of process "+(i+1)+" :");
            pri[i]=sc.nextInt();
            pID[i]=i+1;
        }
        
        for(int i=0;i<n-1;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(pri[i]>pri[j])
                {
                    temp=pri[i];
                    pri[i]=pri[j];
                    pri[j]=temp;
                    
                    temp=pID[i];
                    pID[i]=pID[j];
                    pID[j]=temp;
                    
                    temp=bt[i];
                    bt[i]=bt[j];
                    bt[j]=temp;
                }
            }
        }
        wt[0]=0;
        avg_wt=0;
        tat[0]=bt[0];
        avg_tat=tat[0];
        for(int i=1;i<n;i++)
        {
            wt[i]=tat[i-1];
            avg_wt+=wt[i];
            tat[i]=bt[i]+wt[i];
            avg_tat+=tat[i];
        }
        
        System.out.println("\nPID\tBurst\tPriority\tTAT\tWT\n");
        for(int i=0;i<n;i++)
        {
            System.out.println("\n"+(i+1)+"\t"+bt[i]+"\t"+pri[i]+"\t"+tat[i]+"\t"+wt[i]+"\n");
        }
        System.out.println("Average waiting time: "+(avg_wt/n));
        System.out.println("Average turn around time: "+(avg_tat/n));
        sc.close();
    }
}

