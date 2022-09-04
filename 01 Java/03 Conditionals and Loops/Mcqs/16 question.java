// Whichof the following codes gives same output:

1
   int i=1;
   while(i<5)
   {
       System.out.print(2*i);
       i=i+1;
   }




2
   int i=2;
   while(i<10)
   {
       System.out.print(i);
       i=i+2;
   }




3
   int i=2;
   while(i<10)
   {
       System.out.print(i);
       i*=2;
   }




4
   int i=10;
   while(i>0)
   {
       if(i%2==0)
       {
           System.out.print(10-i);
       }
       i--;
   }
