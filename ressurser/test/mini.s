# Code file created by Pascal2016 compiler 2016-11-25 11:04:04
        enter   $32,$1                  # Start of BLANK
        leave                           # End of BLANK
        ret                             
        .globl  main                    
main:
        call    prog$mini_3             # Start program
        movl    $0,%eax                 # Set status 0 and
        ret                             # terminate the program
prog$mini_3:
        enter   $32,$1                  # Start of BLANK
        call    null                    # Proc call
        addl    $4,%esp                 # Remove stuff from stack
        leave                           # End of BLANK
        ret                             
