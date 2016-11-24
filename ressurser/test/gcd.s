# Code file created by Pascal2016 compiler 2016-11-24 12:28:34
        .globl  main                    
main:
        call    prog$gcd_5              # Start program
        movl    $0,%eax                 # Set status 0 and
        ret                             # terminate the program
        cmpl    $0,%eax                 # Is 0 = %eax?
        je      .L0045                  # Jump to .L0045
        movl    -4(%ebp),%edx           
        movl    %eax,-32(%edx)          
        jmp     .L0046                  # Jump to next label
.L0045:
                                        # ?
        pushl   %eax                    # Push value from expr to stack
        call    func$gcd_28             # Function call
        addl    $8,%esp                 # Remove stuff from stack
        movl    -4(%ebp),%edx           
        movl    %eax,-32(%edx)          
.L0046:
                                        # ??
        pushl   %eax                    # Push value from expr to stack
        call    func$gcd_28             # Function call
        addl    $8,%esp                 # Remove stuff from stack
        movl    0(%ebp),%edx            # Var?
        movl    %eax,0(%edx)            # ?
