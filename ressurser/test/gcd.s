# Code file created by Pascal2016 compiler 2016-11-24 13:54:37
        .globl  main                    
main:
        call    prog$gcd_1              # Start program
        movl    $0,%eax                 # Set status 0 and
        ret                             # terminate the program
prog$gcd_1:
        enter   $32,$1                  # Start of BLANK
        enter   $32,$1                  # Start of BLANK
        cmpl    $0,%eax                 # Is 0 = %eax?
        je      .L0041                  # Jump to .L0041
        movl    -4(%ebp),%edx           
        movl    %eax,-32(%edx)          
        jmp     .L0042                  # Jump to next label
.L0041:
                                        # ?
func$gcd_24:
        enter   $32,$1                  # Start of gcd
        pushl   %eax                    # Push value from expr to stack
        call    func$gcd_24             # Function call
        addl    $8,%esp                 # Remove stuff from stack
        movl    -4(%ebp),%edx           
        movl    %eax,-32(%edx)          
.L0042:
                                        # ??
        leave                           # End of BLANK
        ret                             
func$gcd_24:
        enter   $32,$1                  # Start of gcd
        pushl   %eax                    # Push value from expr to stack
        call    func$gcd_24             # Function call
        addl    $8,%esp                 # Remove stuff from stack
        movl    0(%ebp),%edx            # Var?
        movl    %eax,0(%edx)            # ?
proc$write_107:
        enter   $32,$1                  # Start of write
        pushl   %eax                    # Push value from expr to stack
        pushl   %eax                    # Push value from expr to stack
        pushl   %eax                    # Push value from expr to stack
        pushl   %eax                    # Push value from expr to stack
        pushl   %eax                    # Push value from expr to stack
        pushl   %eax                    # Push value from expr to stack
        pushl   %eax                    # Push value from expr to stack
        pushl   %eax                    # Push value from expr to stack
        pushl   %eax                    # Push value from expr to stack
        pushl   %eax                    # Push value from expr to stack
        call    proc$write_107          # Proc call
        addl    $44,%esp                # Remove stuff from stack
        leave                           # End of BLANK
        ret                             
