# Code file created by Pascal2016 compiler 2016-11-25 11:08:29
        .globl  main                    
main:
        call    prog$mini_1             # Start program
        movl    $0,%eax                 # Set status 0 and
        ret                             # terminate the program
prog$mini_1:
        enter   $32,$1                  # Start of mini
proc$write_6:
        enter   $32,$1                  # Start of write
        call    proc$write_6            
        addl    $4,%esp                 # Pop param.
        leave                           # End of mini
        ret                             
