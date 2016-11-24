# Code file created by Pascal2016 compiler 2016-11-24 12:01:30
        .globl  main                    
main:
        call    prog$gcd_5              # Start program
        movl    $0,%eax                 # Set status 0 and
        ret                             # terminate the program
        movl    -4(%ebp),%edx           
        movl    %eax,-32(%edx)          
        pushl   %eax                    # Push value from expr to stack
        call    func$gcd_28             # Function call
        addl    $8,%esp                 # Remove stuff from stack
        movl    -4(%ebp),%edx           
        movl    %eax,-32(%edx)          
        pushl   %eax                    # Push value from expr to stack
        call    func$gcd_28             # Function call
        addl    $8,%esp                 # Remove stuff from stack
        movl    0(%ebp),%edx            # Var?
        movl    %eax,0(%edx)            # ?
