# Code file created by Pascal2016 compiler 2016-11-24 13:23:10
        enter   $32,$1                  # Start of BLANK
        leave                           # End of BLANK
        ret                             
        .globl  main                    
main:
        call    prog$primes_5           # Start program
        movl    $0,%eax                 # Set status 0 and
        ret                             # terminate the program
prog$primes_5:
        enter   $32,$1                  # Start of BLANK
        enter   $32,$1                  # Start of BLANK
        movl    0(%ebp),%edx            # Var?
        movl    %eax,0(%edx)            # ?
.L0061:
                                        # Start while-statement
        cmpl    $0,%eax                 
        je      .L0062                  
        movl    0(%ebp),%edx            # Var?
        movl    %eax,0(%edx)            # ?
.L0097:
                                        # Start while-statement
        cmpl    $0,%eax                 
        je      .L0098                  
        movl    0(%ebp),%edx            # Var?
        movl    %eax,0(%edx)            # ?
        movl    0(%ebp),%edx            # Var?
        movl    %eax,0(%edx)            # ?
        jmp     .L0097                  
.L0098:
                                        # End while-statement
        movl    0(%ebp),%edx            # Var?
        movl    %eax,0(%edx)            # ?
        jmp     .L0061                  
.L0062:
                                        # End while-statement
        leave                           # End of BLANK
        ret                             
        enter   $32,$1                  # Start of BLANK
        cmpl    $0,%eax                 # Is 0 = %eax?
        je      .L0172                  # Jump to .L0172
.L0172:
                                        # ?
.L0173:
                                        # ??
        cmpl    $0,%eax                 # Is 0 = %eax?
        je      .L0200                  # Jump to .L0200
.L0200:
                                        # ?
.L0201:
                                        # ??
        cmpl    $0,%eax                 # Is 0 = %eax?
        je      .L0228                  # Jump to .L0228
.L0228:
                                        # ?
.L0229:
                                        # ??
        leave                           # End of BLANK
        ret                             
        enter   $32,$1                  # Start of BLANK
        movl    0(%ebp),%edx            # Var?
        movl    %eax,0(%edx)            # ?
        movl    0(%ebp),%edx            # Var?
        movl    %eax,0(%edx)            # ?
.L0301:
                                        # Start while-statement
        cmpl    $0,%eax                 
        je      .L0302                  
        cmpl    $0,%eax                 # Is 0 = %eax?
        je      .L0323                  # Jump to .L0323
        cmpl    $0,%eax                 # Is 0 = %eax?
        je      .L0345                  # Jump to .L0345
.L0345:
                                        # ?
.L0346:
                                        # ??
        movl    0(%ebp),%edx            # Var?
        movl    %eax,0(%edx)            # ?
.L0323:
                                        # ?
.L0324:
                                        # ??
        movl    0(%ebp),%edx            # Var?
        movl    %eax,0(%edx)            # ?
        jmp     .L0301                  
.L0302:
                                        # End while-statement
        leave                           # End of BLANK
        ret                             
        movl    0(%ebp),%edx            # Var?
        movl    %eax,0(%edx)            # ?
.L0469:
                                        # Start while-statement
        cmpl    $0,%eax                 
        je      .L0470                  
        movl    0(%ebp),%edx            # Var?
        movl    %eax,0(%edx)            # ?
        movl    0(%ebp),%edx            # Var?
        movl    %eax,0(%edx)            # ?
        jmp     .L0469                  
.L0470:
                                        # End while-statement
        leave                           # End of BLANK
        ret                             
