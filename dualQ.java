import java.util.*;
class dualQ {
    int q1[]; int q2[]; int q3[][]; // q1 n q2 -> active lobby; q3-> waiting lobby
    int f1;int f2;int f3;
    int r1;int r2;int r3;
    int N1;int N2;int N3;
    Scanner y = new Scanner(System.in);
    dualQ() {
        q1=new int[10];
        q2=new int[10];
        q3=new int[20][6];
        N1=0;
        N2=0;
        N3=0;
        f1=0;f2=0;f3=0;
        r1=0;r2=0;r3=0;
    }
    void main() {
    }
    
    void push(int n){
        if(n+r1<=10){
            for(int i=0 ; i<n; i++){
                if(r1==10){
                    System.out.println("OVERFLOW");
                }
                else{
                    q1[r1++]=y.nextInt();
                    if(r1==10)
                    one();
                }
            }
        } else if(n+r2<=10){
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
        r2=0;
        Arrays.fill(q2,0);
        check();
    }
    void two(){
        r2=0;
        //System.out.println(Arrays.toString(q1));
        Arrays.fill(q2,0);
        check();
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
            int counter=0;
            while(true){
                System.out.println(counter);
                if(q3[counter][0]==0){
                    counter=0;
                    break;
                }
                if(q3[counter][0]+r1<=10){
                    for(int i=1; i<=q3[counter][0];i++){
                        q1[r1++]=q3[counter][i];
                        if(r1==10)
                        one();
                    }
                    q3 = removeRow(q3,counter);
                    counter++;
                }
                if(q3[counter][0]+r2<=10){
                    for(int i=1; i<=q3[counter][0];i++){
                        q2[r2++]=q3[counter][i];
                        if(r2==10)
                        two();
                    }
                    q3 = removeRow(q3,counter);
                    counter++;
                }
                else {
                    counter=0;
                    break;
                }
            }
        }
    }
}
