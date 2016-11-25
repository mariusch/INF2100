# Code file created by Pascal2016 compiler 2016-11-25 11:25:03
        .globl  main                    
main:
        call    prog$mini_1             # Start program
        movl    $0,%eax                 # Set status 0 and
        ret                             # terminate the program
prog$mini_1:
        enter   $32,$1                  # Start of BLANK
        pushl   %eax                    
        call    write_char              
        addl    $4,%esp                 
        leave                           # End of BLANK
        ret                             
