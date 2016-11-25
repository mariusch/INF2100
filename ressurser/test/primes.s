# Code file created by Pascal2016 compiler 2016-11-25 10:32:59
        .globl  main                    
main:
        call    prog$primes_1           # Start program
        movl    $0,%eax                 # Set status 0 and
        ret                             # terminate the program
prog$primes_1:
        enter   $32,$1                  # Start of BLANK
        enter   $32,$1                  # Start of BLANK
        movl    0(%ebp),%edx            # Var?
        movl    %eax,0(%edx)            # ?
.L0056:
                                        # Start while-statement
        cmpl    $0,%eax                 
        je      .L0057                  
        movl    0(%ebp),%edx            # Var?
        movl    %eax,0(%edx)            # ?
.L0092:
                                        # Start while-statement
        cmpl    $0,%eax                 
        je      .L0093                  
        movl    0(%ebp),%edx            # Var?
        movl    %eax,0(%edx)            # ?
        movl    0(%ebp),%edx            # Var?
        movl    %eax,0(%edx)            # ?
        jmp     .L0092                  
.L0093:
                                        # End while-statement
        movl    0(%ebp),%edx            # Var?
        movl    %eax,0(%edx)            # ?
        jmp     .L0056                  
.L0057:
                                        # End while-statement
        leave                           # End of BLANK
        ret                             
        enter   $32,$1                  # Start of BLANK
        cmpl    $0,%eax                 # Is 0 = %eax?
        je      .L0166                  # Jump to .L0166
proc$write_184:
        enter   $32,$1                  # Start of write
        call    proc$write_184          # Proc call
        addl    $4,%esp                 # Remove stuff from stack
.L0166:
                                        # ?
.L0167:
                                        # ??
        cmpl    $0,%eax                 # Is 0 = %eax?
        je      .L0185                  # Jump to .L0185
proc$write_203:
        enter   $32,$1                  # Start of write
        call    proc$write_203          # Proc call
        addl    $4,%esp                 # Remove stuff from stack
.L0185:
                                        # ?
.L0186:
                                        # ??
        cmpl    $0,%eax                 # Is 0 = %eax?
        je      .L0204                  # Jump to .L0204
proc$write_222:
        enter   $32,$1                  # Start of write
        call    proc$write_222          # Proc call
        addl    $4,%esp                 # Remove stuff from stack
.L0204:
                                        # ?
.L0205:
                                        # ??
proc$write_223:
        enter   $32,$1                  # Start of write
        call    proc$write_223          # Proc call
        addl    $4,%esp                 # Remove stuff from stack
        leave                           # End of BLANK
        ret                             
        enter   $32,$1                  # Start of BLANK
        movl    0(%ebp),%edx            # Var?
        movl    %eax,0(%edx)            # ?
        movl    0(%ebp),%edx            # Var?
        movl    %eax,0(%edx)            # ?
.L0258:
                                        # Start while-statement
        cmpl    $0,%eax                 
        je      .L0259                  
        cmpl    $0,%eax                 # Is 0 = %eax?
        je      .L0280                  # Jump to .L0280
        cmpl    $0,%eax                 # Is 0 = %eax?
        je      .L0302                  # Jump to .L0302
proc$write_352:
        enter   $32,$1                  # Start of write
        call    proc$write_352          # Proc call
        addl    $4,%esp                 # Remove stuff from stack
.L0302:
                                        # ?
.L0303:
                                        # ??
proc$p4_353:
        enter   $32,$1                  # Start of p4
        call    proc$p4_353             # Proc call
        addl    $4,%esp                 # Remove stuff from stack
        movl    0(%ebp),%edx            # Var?
        movl    %eax,0(%edx)            # ?
.L0280:
                                        # ?
.L0281:
                                        # ??
        movl    0(%ebp),%edx            # Var?
        movl    %eax,0(%edx)            # ?
        jmp     .L0258                  
.L0259:
                                        # End while-statement
proc$write_386:
        enter   $32,$1                  # Start of write
        call    proc$write_386          # Proc call
        addl    $4,%esp                 # Remove stuff from stack
        leave                           # End of BLANK
        ret                             
        movl    0(%ebp),%edx            # Var?
        movl    %eax,0(%edx)            # ?
.L0399:
                                        # Start while-statement
        cmpl    $0,%eax                 
        je      .L0400                  
        movl    0(%ebp),%edx            # Var?
        movl    %eax,0(%edx)            # ?
        movl    0(%ebp),%edx            # Var?
        movl    %eax,0(%edx)            # ?
        jmp     .L0399                  
.L0400:
                                        # End while-statement
proc$findprimes_447:
        enter   $32,$1                  # Start of findprimes
proc$printprimes_448:
        enter   $32,$1                  # Start of printprimes
        leave                           # End of BLANK
        ret                             
