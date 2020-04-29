import java.util.*;
class dualQQ {
    int q1[]; int q2[]; int q3[][]; 
    int f1;int f2;int f3;
    int r1;int r2;int r3;
    int N1;int N2;int N3;
    int ct1; int ct2;
    int t1; int t2;
    int counter;
    Scanner y = new Scanner(System.in);
    dualQQ() {
        q1=new int[10];
        q2=new int[10];
        q3=new int[20][6];
        N1=0;
        N2=0;
        N3=0;
        f1=0;f2=0;f3=0;
        r1=0;r2=0;r3=0;
        ct1=0;ct2=0;
        t1=0;t2=0;
        counter=0;
    }
    void push(int n){
        if(n+r1<=10 && (n+ct1<=5 || n+t1<=5)){
            for(int i=0 ; i<n; i++){
                if(r1==10){
                    System.out.println("OVERFLOW");
                }
                else{
                    q1[r1++]=y.nextInt();
                }
            }
            if(r1==10){
                one();
            } else {
                if(n+ct1<=5)
                ct1+=n;
                else if(n+t1<=5)
                t1+=n;
            }
        } else if(n+r2<=10 && (n+ct2<=5 || n+t2<=5)){
            for(int i=0 ; i<n; i++){
                if(r2==10){
                    System.out.println("OVERFLOW");
                }
                else{
                    q2[r2++]=y.nextInt();
                    if(r2==10)
                    two();
                }
            }
            if(n+ct2<=5)
            ct2+=n;
            else if(n+t2<=5)
            t2=n;
        } else {
            q3[r3][0]=n;
            for(int i=1 ; i<=n; i++){
                q3[r3][i]=y.nextInt();
            }
            r3++;
        }
    }
    void display(){
        System.out.println(Arrays.toString(q1));
        System.out.println(Arrays.toString(q2));
        System.out.println(Arrays.deepToString(q3));
    }
    void one(){
        for(int i=0; i<10; i++){
            q1[i]=q2[i];
        }
        r1=r2;
        ct1=ct2;
        t1=t2;
        ct2=0;
        t2=0;
        r2=0;
        Arrays.fill(q2,0);
        check();
    }
    void oneW(){
        for(int i=0; i<10; i++){
            q1[i]=q2[i];
        }
        r1=r2;
        ct1=ct2;
        t1=t2;
        ct2=0;
        t2=0;
        r2=0;
        Arrays.fill(q2,0);
    }
    void two(){
        ct2=0;
        t2=0;
        r2=0;
        Arrays.fill(q2,0);
        check();
    }
    void twoW(){
        ct2=0;
        t2=0;
        r2=0;
        Arrays.fill(q2,0);
    }
    
    public static int[][] removeRow(int[][] mat, int row)
    {
        int[][] realCopy = new int[mat.length-1][mat[0].length];
        int count = 0;
        if(row==mat.length-1)
        {
            for(int r=0; r<mat.length-1; r++)
            { 
                for(int c=0; c<mat[0].length; c++)
                {    
                    if(row==r)
                        r++;            
                    realCopy[count][c]= mat[r][c];
                }
                count++;
            }
        }
        else
        {
            for(int r=0; r<mat.length; r++)
            { 
                for(int c=0; c<mat[0].length; c++)
                {    
                    if(row==r)
                        r++;            
                    realCopy[count][c]= mat[r][c];
                }
                count++;
            }  
        }
        return realCopy; 
    }
    
    void check(){
        if(q3[0][0]!=0){
            while(true){
                if(q3[counter][0]==0){
                    counter=0;
                    break;
                }
                else if(q3[counter][0]+r1<=10 && (q3[counter][0]+ct1<=5 || q3[counter][0]+t1<=5)){
                    for(int i=1; i<=q3[counter][0];i++){
                        q1[r1++]=q3[counter][i];
                    }
                    if(r1==10){
                        oneW();
                    } else {
                        if(q3[counter][0]+ct1<=5)
                        ct1+=q3[counter][0];
                        else if(q3[counter][0]+t1<=5)
                        t1+=q3[counter][0];
                    }
                    q3 = removeRow(q3,counter);
                    counter=0;
                    r3--;
                }
                else if(q3[counter][0]+r2<=10 && (q3[counter][0]+ct2<=5 || q3[counter][0]+t2<=5)){
                    for(int i=1; i<=q3[counter][0];i++){
                        q2[r2++]=q3[counter][i];
                    }
                    if(r2==10){
                        twoW();
                    } else {
                        if(q3[counter][0]+ct2<=5)
                        ct2+=q3[counter][0];
                        else if(q3[counter][0]+t2<=5)
                        t2+=q3[counter][0];
                    }
                    q3 = removeRow(q3,counter);
                    counter=0;
                    r3--;
                }
                else {
                    counter++;
                }
            }
        }
    }
    void sensitive(){
        System.out.println("Value of ct1: "+ ct1);
        System.out.println("Value of t1: "+ t1);
        System.out.println("Value of r1: "+ r1);
        System.out.println("Value of ct2: "+ ct2);
        System.out.println("Value of t2: "+ t2);
        System.out.println("Value of r2: "+ r2);
        System.out.println("Value of r3: "+ r3);
        System.out.println("Value of counter: "+ counter);
    }
}
