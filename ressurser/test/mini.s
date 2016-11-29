# Code file created by Pascal2016 compiler 2016-11-29 12:37:06
        .globl  _main                   
_main:
        call    prog$mini_1             # Start program
        movl    $0,%eax                 # Set status 0 and
        ret                             # terminate the program
prog$mini_1:
        enter   $32,$1                  # Start of mini
        movl    $120,%eax               #   'x' Skrevet ut i: <char literal> on line 5
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        leave                           # End of mini
        ret                             
