import java.util.*;
class dualQ {
    int q1[]; int q2[]; int q3[]; // q1 n q2 -> active lobby; q3-> waiting lobby
    int f1;int f2;int f3;
    int r1;int r2;int r3;
    int N1;int N2;int N3;
    Scanner y = new Scanner(System.in);
    dualQ() {
        q1=new int[10];
        q2=new int[10];
        q3=new int[20];
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
                    q1[r1]=y.nextInt();
                    r1++;
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
                    q2[r2]=y.nextInt();
                    r2++;
                    if(r2==10)
                    two();
                }
            }
        } else {
            for(int i=0 ; i<n; i++){
                if(r3==20){
                    System.out.println("OVERFLOW");
                }
                else{
                    q3[r3]=y.nextInt();
                    r3++;
                }
            }
        }
        System.out.println(Arrays.toString(q1));
        System.out.println(Arrays.toString(q2));
        System.out.println(Arrays.toString(q3));
    }
    void one(){
        for(int i=0; i<10; i++){
            q1[i]=q2[i];
        }
        r1=r2;
        r2=0;
        Arrays.fill(q2,0);
    }
    void two(){
        r2=0;
        System.out.println(Arrays.toString(q1));
        Arrays.fill(q2,0);
    }    
}
