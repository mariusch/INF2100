# Code file created by Pascal2016 compiler 2016-11-24 13:38:53
        enter   $32,$1                  # Start of BLANK
        leave                           # End of BLANK
        ret                             
        .globl  main                    
main:
        call    prog$primes_3           # Start program
        movl    $0,%eax                 # Set status 0 and
        ret                             # terminate the program
prog$primes_3:
        enter   $32,$1                  # Start of BLANK
        enter   $32,$1                  # Start of BLANK
        movl    0(%ebp),%edx            # Var?
        movl    %eax,0(%edx)            # ?
.L0059:
                                        # Start while-statement
        cmpl    $0,%eax                 
        je      .L0060                  
        movl    0(%ebp),%edx            # Var?
        movl    %eax,0(%edx)            # ?
.L0095:
                                        # Start while-statement
        cmpl    $0,%eax                 
        je      .L0096                  
        movl    0(%ebp),%edx            # Var?
        movl    %eax,0(%edx)            # ?
        movl    0(%ebp),%edx            # Var?
        movl    %eax,0(%edx)            # ?
        jmp     .L0095                  
.L0096:
                                        # End while-statement
        movl    0(%ebp),%edx            # Var?
        movl    %eax,0(%edx)            # ?
        jmp     .L0059                  
.L0060:
                                        # End while-statement
        leave                           # End of BLANK
        ret                             
        enter   $32,$1                  # Start of BLANK
        cmpl    $0,%eax                 # Is 0 = %eax?
        je      .L0170                  # Jump to .L0170
        call    null                    # Proc call
        addl    $4,%esp                 # Remove stuff from stack
.L0170:
                                        # ?
.L0171:
                                        # ??
        cmpl    $0,%eax                 # Is 0 = %eax?
        je      .L0188                  # Jump to .L0188
        call    null                    # Proc call
        addl    $4,%esp                 # Remove stuff from stack
.L0188:
                                        # ?
.L0189:
                                        # ??
        cmpl    $0,%eax                 # Is 0 = %eax?
        je      .L0206                  # Jump to .L0206
        call    null                    # Proc call
        addl    $4,%esp                 # Remove stuff from stack
.L0206:
                                        # ?
.L0207:
                                        # ??
        call    null                    # Proc call
        addl    $4,%esp                 # Remove stuff from stack
        leave                           # End of BLANK
        ret                             
        enter   $32,$1                  # Start of BLANK
        movl    0(%ebp),%edx            # Var?
        movl    %eax,0(%edx)            # ?
        movl    0(%ebp),%edx            # Var?
        movl    %eax,0(%edx)            # ?
.L0259:
                                        # Start while-statement
        cmpl    $0,%eax                 
        je      .L0260                  
        cmpl    $0,%eax                 # Is 0 = %eax?
        je      .L0281                  # Jump to .L0281
        cmpl    $0,%eax                 # Is 0 = %eax?
        je      .L0303                  # Jump to .L0303
        call    null                    # Proc call
        addl    $4,%esp                 # Remove stuff from stack
.L0303:
                                        # ?
.L0304:
                                        # ??
        call    proc$p4_159             # Proc call
        addl    $4,%esp                 # Remove stuff from stack
        movl    0(%ebp),%edx            # Var?
        movl    %eax,0(%edx)            # ?
.L0281:
                                        # ?
.L0282:
                                        # ??
        movl    0(%ebp),%edx            # Var?
        movl    %eax,0(%edx)            # ?
        jmp     .L0259                  
.L0260:
                                        # End while-statement
        call    null                    # Proc call
        addl    $4,%esp                 # Remove stuff from stack
        leave                           # End of BLANK
        ret                             
        movl    0(%ebp),%edx            # Var?
        movl    %eax,0(%edx)            # ?
.L0397:
                                        # Start while-statement
        cmpl    $0,%eax                 
        je      .L0398                  
        movl    0(%ebp),%edx            # Var?
        movl    %eax,0(%edx)            # ?
        movl    0(%ebp),%edx            # Var?
        movl    %eax,0(%edx)            # ?
        jmp     .L0397                  
.L0398:
                                        # End while-statement
        leave                           # End of BLANK
        ret                             
