# Code file created by Pascal2016 compiler 2016-11-24 11:51:49
        .globl  main                    
main:
        call    prog$gcd_5              # Start program
        movl    $0,%eax                 # Set status 0 and
        ret                             # terminate the program
        pushl   %eax                    # Push value from expr to stack
        call    func$gcd_28             # Function call
        addl    $8,%esp                 # Remove stuff from stack
        pushl   %eax                    # Push value from expr to stack
        call    func$gcd_28             # Function call
        addl    $8,%esp                 # Remove stuff from stack
