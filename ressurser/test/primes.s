# Code file created by Pascal2016 compiler 2016-11-25 13:14:28
        .globl  main                    
main:
        call    prog$primes_1           # Start program
        movl    $0,%eax                 # Set status 0 and
        ret                             # terminate the program
prog$primes_1:
        enter   $32,$1                  # Start of primes
        movl    $1000,%eax              #   1000
        movl    $2,%eax                 #   2
        movl    $1000,%eax              #   'limit'
        enter   $32,$1                  # Start of BLANK
        movl    $2,%eax                 #   2
        movl    0(%ebp),%edx            
        movl    %eax,0(%edx)            
.L0054:
                                        # Start while-statement
        cmpl    $0,%eax                 
        je      .L0055                  
        movl    $2,%eax                 #   2
        movl    0(%ebp),%edx            
        movl    %eax,0(%edx)            
.L0086:
                                        # Start while-statement
        cmpl    $0,%eax                 
        je      .L0087                  
        movl    0(%ebp),%edx            
        movl    %eax,0(%edx)            
        movl    0(%ebp),%edx            
        movl    %eax,0(%edx)            
        jmp     .L0086                  
.L0087:
                                        # End while-statement
        movl    $1,%eax                 #   1
        movl    0(%ebp),%edx            
        movl    %eax,0(%edx)            
        jmp     .L0054                  
.L0055:
                                        # End while-statement
        leave                           # End of BLANK
        ret                             
        enter   $32,$1                  # Start of BLANK
        movl    $1000,%eax              #   1000
        cmpl    $0,%eax                 # Is 0 = %eax?
        je      .L0152                  # Jump to .L0152
        movl    $32,%eax                #   ' '
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
.L0152:
                                        # ?
.L0153:
                                        # ??
        movl    $100,%eax               #   100
        cmpl    $0,%eax                 # Is 0 = %eax?
        je      .L0175                  # Jump to .L0175
        movl    $32,%eax                #   ' '
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
.L0175:
                                        # ?
.L0176:
                                        # ??
        movl    $10,%eax                #   10
        cmpl    $0,%eax                 # Is 0 = %eax?
        je      .L0198                  # Jump to .L0198
        movl    $32,%eax                #   ' '
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
.L0198:
                                        # ?
.L0199:
                                        # ??
        pushl   %eax                    # Push next param.
        call    write_int               
        addl    $4,%esp                 # Pop param.
        leave                           # End of BLANK
        ret                             
        enter   $32,$1                  # Start of BLANK
        movl    $2,%eax                 #   2
        movl    0(%ebp),%edx            
        movl    %eax,0(%edx)            
        movl    $0,%eax                 #   0
        movl    0(%ebp),%edx            
        movl    %eax,0(%edx)            
.L0258:
                                        # Start while-statement
        cmpl    $0,%eax                 
        je      .L0259                  
        cmpl    $0,%eax                 # Is 0 = %eax?
        je      .L0278                  # Jump to .L0278
        movl    $0,%eax                 #   0
        movl    $10,%eax                #   10
        movl    $0,%eax                 #   0
        cmpl    $0,%eax                 # Is 0 = %eax?
        je      .L0296                  # Jump to .L0296
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
.L0296:
                                        # ?
.L0297:
                                        # ??
proc$p4_347:
        enter   $32,$1                  # Start of p4
        pushl   %eax                    # Push next param.
        call    proc$p4_347             # Proc call
        addl    $4,%esp                 # Pop param.
        movl    $1,%eax                 #   1
        movl    0(%ebp),%edx            
        movl    %eax,0(%edx)            
.L0278:
                                        # ?
.L0279:
                                        # ??
        movl    $1,%eax                 #   1
        movl    0(%ebp),%edx            
        movl    %eax,0(%edx)            
        jmp     .L0258                  
.L0259:
                                        # End while-statement
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        leave                           # End of BLANK
        ret                             
        movl    $2,%eax                 #   2
        movl    0(%ebp),%edx            
        movl    %eax,0(%edx)            
.L0399:
                                        # Start while-statement
        cmpl    $0,%eax                 
        je      .L0400                  
        movl    0(%ebp),%edx            
        movl    %eax,0(%edx)            
        movl    $1,%eax                 #   1
        movl    0(%ebp),%edx            
        movl    %eax,0(%edx)            
        jmp     .L0399                  
.L0400:
                                        # End while-statement
proc$findprimes_441:
        enter   $32,$1                  # Start of findprimes
proc$printprimes_442:
        enter   $32,$1                  # Start of printprimes
        leave                           # End of primes
        ret                             
