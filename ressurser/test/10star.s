# Code file created by Pascal2016 compiler 2016-11-25 13:06:02
        .globl  main                    
main:
        call    prog$tenstars_1         # Start program
        movl    $0,%eax                 # Set status 0 and
        ret                             # terminate the program
prog$tenstars_1:
        enter   $32,$1                  # Start of tenstars
        movl    $10,%eax                #   10
        movl    $0,%eax                 #   0
        movl    0(%ebp),%edx            
        movl    %eax,0(%edx)            
.L0028:
                                        # Start while-statement
        cmpl    $0,%eax                 
        je      .L0029                  
        movl    $42,%eax                #   '*'
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        movl    $1,%eax                 #   1
        movl    0(%ebp),%edx            
        movl    %eax,0(%edx)            
        jmp     .L0028                  
.L0029:
                                        # End while-statement
        pushl   %eax                    # Push next param.
        call    write_char              
        addl    $4,%esp                 # Pop param.
        leave                           # End of tenstars
        ret                             
