# Code file created by Pascal2016 compiler 2016-11-24 10:49:00
        .globl  main                    
main:
        call    prog$primes_5           # Start program
        movl    $0,%eax                 # Set status 0 and
        ret                             # terminate the program
.L0063:
                                        # Start while-statement
        cmpl    $0,%eax                 
        je      .L0064                  
.L0101:
                                        # Start while-statement
        cmpl    $0,%eax                 
        je      .L0102                  
        jmp     .L0101                  
.L0102:
                                        # End while-statement
        jmp     .L0063                  
.L0064:
                                        # End while-statement
.L0325:
                                        # Start while-statement
        cmpl    $0,%eax                 
        je      .L0326                  
        jmp     .L0325                  
.L0326:
                                        # End while-statement
.L0503:
                                        # Start while-statement
        cmpl    $0,%eax                 
        je      .L0504                  
        jmp     .L0503                  
.L0504:
                                        # End while-statement
